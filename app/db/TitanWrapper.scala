package db

import java.io.File

import scala.collection.JavaConversions._

import play.api.libs.Files
import play.api.libs.json.Json
import play.Logger
import play.api.Play.current
import play.api.Play

import org.apache.commons.configuration.BaseConfiguration

import com.thinkaurelius.titan.core._
import com.thinkaurelius.titan.core.attribute.Cmp._
import com.thinkaurelius.titan.graphdb.configuration.GraphDatabaseConfiguration
import com.tinkerpop.blueprints.{Edge, Vertex}
import com.tinkerpop.blueprints.util.ElementHelper
import com.thinkaurelius.titan.graphdb.database.StandardTitanGraph
import com.thinkaurelius.titan.diskstorage.es.ElasticSearchIndex

import com.tinkerpop.gremlin.java.GremlinPipeline
import com.tinkerpop.blueprints.Element

import models.ClassMeta
import utils.Constant._
import utils.FuncResult._
import utils.DataHelper._
import utils.DataHelper
import utils.Storage._
import com.thinkaurelius.titan.graphdb.relations.CacheEdge
import com.thinkaurelius.titan.graphdb.vertices.CacheVertex
import scala.Some
import exception.NotFoundException

object TitanWrapper {
  var db: TitanGraph = _
  var keys: Map[String, TitanKey] = Map()
  var labels: Map[String, TitanLabel] = Map()
  var keysIndexedOnVertex: Set[String] = Set()
  var keysIndexedOnEdge: Set[String] = Set()
  var elasticIndexName = ""


  def connect = {
    // if exists already  titan instance, try to shutdown it
    if (db != null) {
      try {
        db.shutdown()
      }
      catch {
        case e: Exception => {
          Logger.warn("An existing instance titan, can't shutdown " + e.getMessage)
        }
      }
    }
    // now, it's safe to create a new titan instance
    try {
      db = TitanFactory.open(getConfig)
    }
    catch {
      case e: java.lang.Exception => {
        Logger.error("TitanWrapper connect, Cassandra  Status :  " + isCassandraAvailable)
        Logger.error("Message Origin : " + e.getMessage)
      }
    }
  }



  def getConfig: BaseConfiguration = {
    val contents = Files.readFile(new File(Play.application.path.getPath.concat(CONFIG_FILE_PATH)))
    val config = new BaseConfiguration()
    val storage = config.subset(GraphDatabaseConfiguration.STORAGE_NAMESPACE)
    // load setting from content
    val settings = Json.parse(contents)
    // cassandra first
    val cassSettings = settings \ "cassandra"
    val cassStorage = (cassSettings \ "storage").asOpt[String].getOrElse("local")
    if (cassStorage == "local") {
      val dir = (cassSettings \ "local" \ "dir").asOpt[String].getOrElse("/tmp/cassandra")
      storage.setProperty(GraphDatabaseConfiguration.STORAGE_BACKEND_KEY, "local")
      storage.setProperty(GraphDatabaseConfiguration.STORAGE_DIRECTORY_KEY, dir)
    }
    else {
      val cassHostname = (cassSettings \ "network" \ "hostname").asOpt[String].getOrElse("localhost")
      val cassKeyspace = (cassSettings \ "network" \ "keyspace").asOpt[String].getOrElse("balloon")

      storage.setProperty(GraphDatabaseConfiguration.STORAGE_BACKEND_KEY, "cassandrathrift")
      storage.setProperty(GraphDatabaseConfiguration.HOSTNAME_KEY, cassHostname)
      storage.setProperty("keyspace", cassKeyspace)

      val cache = config.subset("cache")
      cache.setProperty("db-cache", true)
      cache.setProperty("db-cache-clean-wait", 20)
      cache.setProperty("db-cache-time", 180000)
      cache.setProperty("db-cache-size", 0.25)
    }

    // elastic
    val esSettings = settings \ "es"
    val esStorage = (esSettings \ "storage").asOpt[String].getOrElse("local")
    if (esStorage == "local") {
      //val esIndexName = (esSettings \ "local" \ "index_name").asOpt[String].getOrElse("balloon")
      val esDir = (esSettings \ "local" \ "dir").asOpt[String].getOrElse("/tmp/es")
      val index = storage.subset(GraphDatabaseConfiguration.INDEX_NAMESPACE).subset("search")

      index.setProperty(GraphDatabaseConfiguration.INDEX_BACKEND_KEY, "elasticsearch")
      index.setProperty("local-mode", true);
      index.setProperty("client-only", false);
      index.setProperty(GraphDatabaseConfiguration.STORAGE_DIRECTORY_KEY, esDir)
      elasticIndexName = "search"
    }
    else {
      val esIndexName = (esSettings \ "network" \ "index_name").asOpt[String].getOrElse("balloon")
      val esHostName = (esSettings \ "network" \ "hostname").asOpt[String].getOrElse("localhost")
      val esCluster = (esSettings \ "network" \ "cluster").asOpt[String].getOrElse("elasticsearch")

        val index = storage.subset(GraphDatabaseConfiguration.INDEX_NAMESPACE).subset(esIndexName)
        index.setProperty(GraphDatabaseConfiguration.INDEX_BACKEND_KEY, "elasticsearch")
        index.setProperty("hostname", esHostName)
        index.setProperty("cluster-name", esCluster)
        index.setProperty("index-name", esIndexName)
        index.setProperty("local-mode", true);
        index.setProperty("client-only", false);
        elasticIndexName=esIndexName
      }
    config
  }

  def isCassandraAvailable: Boolean = {
    var status = true
    try {
      val testDb = TitanFactory.open(getConfig)
      testDb.shutdown()
    }
    catch {
      case ex: java.lang.Exception => {
        if (ex.getMessage.contains("com.thinkaurelius.titan.diskstorage.cassandra.thrift.CassandraThriftStoreManager"))
          status = false
      }
    }
    status
  }

  def isElasticAvailable: Boolean = {
    var status = true
    try {
      val testDb = TitanFactory.open(getConfig)
      testDb.shutdown()
    }
    catch {
      case ex: java.lang.Exception => {
        if (ex.getMessage.contains("com.thinkaurelius.titan.diskstorage.es.ElasticSearchIndex"))
          status = false
      }
    }
    status
  }


  def init = {
    connect
    createIndexing
  }

  def createIndexing = {
    if(db != null) {
      loadAllKeyAndLabel
      addKeyIndexableIfNotExisted[String](ENTITY_FULL_ID, classOf[String], true, false, List("standard", elasticIndexName), Parameter.of(Mapping.MAPPING_PREFIX, Mapping.STRING))
      addKeyIndexableIfNotExisted[String](ENTITY_ID, classOf[String], true, false, List("standard", elasticIndexName), Parameter.of(Mapping.MAPPING_PREFIX, Mapping.STRING))
      addKeyIndexableIfNotExisted[String](ENTITY_TYPE, classOf[String], true, false, List("standard", elasticIndexName), Parameter.of(Mapping.MAPPING_PREFIX, Mapping.STRING))
      addKeyIndexableIfNotExisted[String](ENTITY_STATUS, classOf[String], true, false, List("standard", elasticIndexName), Parameter.of(Mapping.MAPPING_PREFIX, Mapping.STRING))
      addKeyIndexableIfNotExisted[String](ENTITY_CURATION_STATUS, classOf[String], true, false, List("standard", elasticIndexName), Parameter.of(Mapping.MAPPING_PREFIX, Mapping.STRING))
      val weight = addKeyIndexableIfNotExisted[java.lang.Double](EDGE_WEIGHT_PROPERTY, classOf[java.lang.Double], false, true, List("standard", elasticIndexName))
      if (weight != null) {
        db.makeLabel("related").sortKey(weight).make()
        db.commit()
      }
      if (!keys.isDefinedAt(ENTITY_POST_DATE)) {
        val titanKey = db.makeKey(ENTITY_POST_DATE).dataType(classOf[java.util.Date])
        titanKey.indexed(classOf[Vertex]).indexed(classOf[Vertex])
        titanKey.make()
        db.commit()
      }
    }
  }





  def getVertices(filters: Map[String,Any] = Map[String,Any](), orderBy : String = ORDER_BY_DEFAULT, sortOrder : String = SORT_ORDER_DEFAULT, page: Int = PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT) = {
    var vertices: Iterable[Vertex] = null
    if(orderBy != null && !orderBy.equals(ORDER_BY_NOTHING)){
      vertices =  filters.foldLeft(db.query())((B, p) => B.has(p._1, DataHelper.Any2AnyRef(p._2))).orderBy(orderBy, toEnum(sortOrder)).limit((page + 1) * limit).vertices().slice(page * limit, (page + 1) * limit)
    }
    else {
      vertices =  filters.foldLeft(db.query())((B, p) => B.has(p._1, DataHelper.Any2AnyRef(p._2))).limit((page + 1) * limit).vertices().slice(page * limit, (page + 1) * limit)
    }
    db.commit()
    vertices.map { vertex =>
      vertex.getPropertyKeys.map {
        p =>
          (p -> vertex.getProperty(p))
      }.toMap
    }
  }

  def toBaseEntity[T](vertex: Vertex)(implicit m: Manifest[T]): Option[T] = {
    val result = if (vertex != null) {
      val data = vertex.getPropertyKeys.map {
        p =>
          (p -> vertex.getProperty(p))
      }.toMap
      Some(ClassMeta.getMeta(m.toString()).createObject[T](data.filter(_._1 != ENTITY_ID) + ("id" -> data.get(ENTITY_ID).getOrElse(""))))
    }
    else None
    db.commit()
    result
  }

  def toBaseEntity[T](vertex: CacheVertex)(implicit m: Manifest[T]): Option[T] = {
    val result = if (vertex != null) {
      val data = vertex.getPropertyKeys.map {
        p =>
          (p -> vertex.getProperty(p))
      }.toMap
      Some(ClassMeta.getMeta(m.toString()).createObject[T](data.filter(_._1 != ENTITY_ID) + ("id" -> data.get(ENTITY_ID).getOrElse(""))))
    }
    else None
    db.commit()
    result
  }

  def toBaseEntity[T](e: Element)(implicit m: Manifest[T]): Option[T] = {
    val result = if (e != null) {
      val data = e.getPropertyKeys.map {
        p =>
          (p -> e.getProperty(p))
      }.toMap
      Some(ClassMeta.getMeta(m.toString()).createObject[T](data.filter(_._1 != ENTITY_ID) + ("id" -> data.get(ENTITY_ID).getOrElse(""))))
    }
    else None
    db.commit()
    result
  }

  def getVertex(id: String, entity_type: String) = {
    findVertex(id, entity_type).map { vertex =>
      vertex.getPropertyKeys.map {
        p =>
          (p -> vertex.getProperty(p))
      }.toMap
    }
  }

  def findVertex(id: String, entity_type: String) = {
    val vertices = db.query().has(ENTITY_FULL_ID, createGId(entity_type,id)).vertices()
    db.commit()
    vertices.collectFirst {
      case v => v
    }
  }


  def delete(id: String, entity_type: String): Int = {
    findVertex(id, entity_type).map { vertex =>
      db.removeVertex(vertex)
      db.commit()
      CALL_SUCCESS
    }.getOrElse(CALL_NOT_EXISTED_FAIL)
  }

  def addVertex(data: Map[String, Any], flush: Boolean = false): Int = {
    // try to find exits vertex
    val vSearch = findVertex(data.get(ENTITY_ID).get.toString, data.get(ENTITY_TYPE).get.toString)
    if (vSearch.isEmpty) {
      val vertex = db.addVertex()
      ElementHelper.setProperties(vertex, (data.filter(p=> p._2!=null) + (ENTITY_FULL_ID -> createGId(data.get(ENTITY_TYPE).get.toString,data.get(ENTITY_ID).get.toString))).flatMap {
        item => Seq(item._1, DataHelper.Any2AnyRef(item._2))
      }.toSeq: _*)
      db.commit()
      CALL_SUCCESS
    } else if (flush) {
      // update the vertex
      data.filter(p => p._2 == null).foreach(p => {
        DataHelper.removeProperty(vSearch.get, p._1)
      })
      ElementHelper.setProperties(vSearch.get, (data.filter(p=> p._2!=null) -- List(ENTITY_ID, ENTITY_TYPE)).flatMap {
        item => Seq(item._1, DataHelper.Any2AnyRef(item._2))
      }.toSeq: _*)
      db.commit()
      CALL_SUCCESS
    }
    else CALL_EXISTED_FAIL
  }


  def updateVertex(id: String, entity_type: String, data: Map[String, Any]) = {
    findVertex(id, entity_type).map {
      vertex =>
        data.filter(p => p._2 == null).foreach(p => {
          DataHelper.removeProperty(vertex, p._1)
        }
        )
        data.filter(p => p._2 != null).foreach(p => vertex.setProperty(p._1, DataHelper.Any2AnyRef(p._2)))
        db.commit()
        vertex.getPropertyKeys.map {
          p =>
            (p -> vertex.getProperty(p))
        }.toMap
    }
  }

  def addEdge(id1: String, entity_type1: String, id2: String, entity_type2: String, label: String, data: Map[String, Any]): Int = {
    val v1 = findVertex(id1, entity_type1)
    val v2 = findVertex(id2, entity_type2)
    if (v1.isDefined) {
      if(v2.isDefined){
        val vertex1 = v1.get
        val vertex2 = v2.get
        val entity_entity_id = createEntityEntityId(createGId(entity_type1, id1), createGId(entity_type2, id2), label)
        val entity_type = createEntityType(vertex1.getProperty[String](ENTITY_TYPE), vertex2.getProperty[String](ENTITY_TYPE))
        val edge = vertex1.query().has(ENTITY_ENTITY_ID, entity_entity_id).edges().collectFirst{ case e => e }
        edge.map { e =>
          data.foldLeft(e){(e, item) => e.setProperty(item._1, item._2); e}
          e.setProperty(ENTITY_ENTITY_ID, entity_entity_id)
          db.commit()
        }.getOrElse {
          val edge = data.foldLeft(db.addEdge(null, vertex1, vertex2, label)){(e, item) =>
            e.setProperty(item._1, item._2)
            e
          }
          edge.setProperty(ENTITY_TYPE, entity_type)
          edge.setProperty(ENTITY_ENTITY_ID, entity_entity_id)
          db.commit()
        }
        CALL_SUCCESS
      } else {
        CALL_NOT_EXISTED_FAIL
      }

    }
    else {
      throw NotFoundException(String.format("There is no %s found for the provided id : %s",entity_type1,id1))
    }
  }


  def getVertex2ByVertex1[T1, T2](id: String, label: String = defaultAlgo, filters : Map[String,Any] = Map[String,Any](), page: Int = PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit t1: Manifest[T1], t2: Manifest[T2]): List[(T2, Double)] = {

    findVertex(id, t1.runtimeClass.getSimpleName).map {
      vertex =>
        val pipe: GremlinPipeline[Vertex, Vertex] = new GremlinPipeline[Vertex, Vertex]()
        val result = pipe.start(vertex).bothE(label).bothV().has(ENTITY_TYPE, t2.runtimeClass.getSimpleName)
        filters.keySet.foreach(key => {
          result.has(key, filters.get(key).get)
        })

        if (t1.runtimeClass.getSimpleName.equals(t2.runtimeClass.getSimpleName)) {
          result.hasNot(ENTITY_ID, id)
        }

        val m2Meta = ClassMeta.getMeta(t2.toString())

        val fields = m2Meta.fields.flatMap { p => if(p._1 == "id") Some("bid") else Some(p._1) }

        val finalResult = result.range(page * limit , (page + 1) * limit -1).path().toList.map { e =>
          val weight = e(1).asInstanceOf[CacheEdge].getProperty[Double]("weight")
          val cv = e.last.asInstanceOf[CacheVertex]
          val data = fields.map { p =>
            (p -> cv.getProperty[String](p))
          }.toMap
          val entityRelated = m2Meta.createObject[T2](data.filter(_._1 != ENTITY_ID) + ("id" -> data.get(ENTITY_ID).getOrElse("")))
          (entityRelated, weight)
        }.toList.sortBy(-_._2)
        db.commit()
        finalResult
    }.getOrElse(throw NotFoundException(String.format("There is no  found for the provided %s ", id)))
  }

  def loadAllKeyAndLabel() = {
    keys = db.getTypes(classOf[TitanKey]).map {
      key =>
        (key.getName, key)
    }.toMap

    labels = db.getTypes(classOf[TitanLabel]).map {
      key =>
        (key.getName, key)
    }.toMap
    keysIndexedOnVertex = db.getIndexedKeys(classOf[Vertex]).toSet
    keysIndexedOnEdge = db.getIndexedKeys(classOf[Edge]).toSet
  }


  def index(entity: String, indexAll: Boolean = false, ids: List[String] = List[String]()) = {
    //  the connect method  will make sure the index data structure is created.
    connect
    var cpt=0
    entity match {
      case AllEntity => {
        val iterator=db.getVertices.iterator()
        while (iterator.hasNext){
          indexVertex(iterator.next())
          cpt +=1
          if(cpt % 100 == 0)
            db.commit()
        }
      }
      case _ => {
        if (!indexAll) {
          ids.foreach(id => {
            findVertex(id, entity).map {
              vertex =>
                if (vertex != null) {
                  indexVertex(vertex)
                  cpt +=1
                  if(cpt % 100 == 0)
                    db.commit()
                }
            }//.getOrElse(results ::= Map("id" -> id, "entity" -> entity, "message" -> "id not found"))
          }
          )
        } else {
          db.query().has(ENTITY_TYPE, EQUAL, entity).vertices().map {
            vertex =>
              indexVertex(vertex)
              cpt +=1
              if(cpt % 100 == 0)
                db.commit()
          }
        }
      }
    }
    if(cpt % 100 != 0)
      db.commit()
  }

  def indexVertex(vertex: Vertex): Map[String, Any] = {
    var result: Map[String, Any] = Map[String, Any]()
    val keys = vertex.getPropertyKeys
    keysIndexedOnVertex.foreach(
      key => {
        if (keys.contains(key))
          vertex.setProperty(key, vertex.getProperty(key))
      }
    )
    result +=("id" -> vertex.getProperty[String](ENTITY_ID), "entity" -> vertex.getProperty[String](ENTITY_TYPE))
    indexEdge(vertex)
    result
  }

  def indexEdge(vertex: Vertex) = {
    vertex.query().edges().toList.map {
      edge =>
        val keys = edge.getPropertyKeys
        keysIndexedOnEdge.foreach(
          key => {
            if (keys.contains(key))
              edge.setProperty(key, edge.getProperty(key))
          }
        )
    }
  }

  def addDualIndex[T](keyName: String, keyType: Class[T], forVertex: Boolean = true) = {
    val titanKey = if(forVertex) {
      val key = db.makeKey(keyName).dataType(keyType).indexed(classOf[Vertex])
      if(keyType.getSimpleName == "String") {
        key.indexed(elasticIndexName, classOf[Vertex], Parameter.of(Mapping.MAPPING_PREFIX, Mapping.STRING))
      } else {
        key.indexed(elasticIndexName, classOf[Vertex])
      }
      key.make()
    }
    else {
      val key = db.makeKey(keyName).dataType(keyType).indexed(classOf[Edge])
      if(keyType.getSimpleName == "String") {
        key.indexed(elasticIndexName, classOf[Edge], Parameter.of(Mapping.MAPPING_PREFIX, Mapping.STRING))
      } else {
        key.indexed(elasticIndexName, classOf[Edge])
      }
      key.make()
    }

    db.commit()

    loadAllKeyAndLabel

    titanKey
  }

  def addKeyIndexableIfNotExisted[T](key: String, keyType: Class[T], isVertex: Boolean, isEdge: Boolean, indexNames: List[String], indexParameters: Parameter[Mapping]*) = {
    var keyFinal: TitanKey = null
    if (!keys.isDefinedAt(key)) {
      val titanKey = db.makeKey(key).dataType(keyType)
      indexNames.foreach(indexName => {
        indexName match {
          case "standard" => {
            if (isVertex)
              titanKey.indexed(indexName, classOf[Vertex])
            if (isEdge)
              titanKey.indexed(indexName, classOf[Edge])
          }
          case other => {
            if (isVertex)
              titanKey.indexed(indexName, classOf[Vertex], indexParameters: _*)
            if (isEdge)
              titanKey.indexed(indexName, classOf[Edge], indexParameters: _*)
          }
        }


      }
      )
      keyFinal = titanKey.make()
      db.commit()
      loadAllKeyAndLabel
    }
    keyFinal
  }

  def addLabel(labelName: String, sortBy: TitanKey) = {
    db.makeLabel(labelName).sortKey(sortBy).make()
  }

  def deleteExternalIndex = {
    val backend = db.asInstanceOf[StandardTitanGraph].getConfiguration.getBackend
    val elastic = backend.getIndexInformation.get(elasticIndexName).asInstanceOf[ElasticSearchIndex]
    elastic.clearStorage()
    Logger.info(String.format(" Deleting  elasticSearch index  %s  : DONE",elasticIndexName))
  }
}
