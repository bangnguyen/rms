package db

import com.tinkerpop.blueprints.Direction
import com.thinkaurelius.titan.graphdb.database.StandardTitanGraph
import play.api.Logger
import play.api.mvc.RequestHeader
import scala.Some

import db.TitanWrapper._
import models._
import exception.NotFoundException
import utils.FuncResult._
import utils.DataHelper._
import utils.Constant._
import exception.NotFoundException




/**
 * Created by Marco Chu on 3/12/14.
 */
object TitanDatabase extends Database {
  var isIndexing=false

  def addRelated(id1: String, entity_type1: String, id2: String, entity_type2: String, algo: String, data: Map[String, Any])(implicit request: RequestHeader): Map[String,Any] = {
    addEdge(id1, entity_type1, id2, entity_type2, algo, data) match {
      case CALL_SUCCESS => Map[String, Any]("id" -> id2, "error" -> false, "message" -> "OK")
      case CALL_NOT_EXISTED_FAIL => Map[String, Any]("id" -> id2, "error" -> true, "message" -> "id doesn't exist")
      case _ => Map[String, Any]("id" -> id2, "error" -> true, "message" -> "unknown error ") //todo search another error
    }
  }

  def addMultiRelated(id: String, entity_type: String, algo: String, data: List[Map[String, Any]])(implicit request: RequestHeader): List[Map[String, Any]] = {
    var results = List[Map[String, Any]]()
    val vContainer = TitanWrapper.findVertex(id, entity_type.capitalize)
    vContainer match {
      case Some(vertex) => {
        data.foreach {
          item =>
            val id2 = item.get("id").get.toString
            val entity_type2 = item.get("entity_type").get.toString
            results ::= addRelated(id, entity_type.capitalize, id2, entity_type2.capitalize, algo, item.filter(p => p._1 != "id" && p._1 != "entity_type"))
        }
      }
        case None =>
          throw NotFoundException(String.format("There is no %s found for the provided id : %s", entity_type, id))
    }
    results
  }



  def getAllRelated(id: String, algo: String)(implicit request: RequestHeader): List[Map[String, Any]] = {
    var response: List[Map[String, Any]] = List[Map[String, Any]]()
    val vertex = db.getVertex(id)
    if (vertex != null) {
      val iterator = vertex.query().labels(algo).vertices().iterator()
      while (iterator.hasNext) {
        val item = iterator.next()
        response ::= getData(item)
      }
    }
    response
  }


  override def job: IJob = GJob

  override def course: ICourse = GCourse

  override def category: ICategory = GCategory

  override def career: ICareer = GCareer

  override def skill: ISkill = GSkill


  override def getSkill(field: String, value: String)(implicit request: RequestHeader): Option[Skill] = skill.get(value)

  override def getJob(field: String, value: String)(implicit request: RequestHeader): Option[Job] = job.get(value)

  override def getCourse(field: String, value: String)(implicit request: RequestHeader): Option[Course] = course.get(value)

  override def getCategory(field: String, value: String)(implicit request: RequestHeader): Option[Category] = category.get(value)

  override def getCareer(field: String, value: String)(implicit request: RequestHeader): Option[Career] = career.get(value)


  override def getJobsByCareerId(id: String, algo: String = defaultAlgo, filters: Map[String,Any] = Map[String,Any](), page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Job, Double)] = {
    getVertex2ByVertex1[Career, Job](id, algo, filters, page, limit)
  }
  override def getJobsBySkillId(id: String, algo: String = defaultAlgo, filters: Map[String,Any] = Map[String,Any](), page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Job, Double)] = {
    getVertex2ByVertex1[Skill, Job](id, algo, filters, page, limit)
  }


  override def getSkillsByJobId(id: String, algo: String = defaultAlgo, filters: Map[String,Any] = Map[String,Any](),  page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Skill, Double)] = {
    getVertex2ByVertex1[Job, Skill](id, algo, filters, page, limit)
  }

  override def getSkillsByCourseId(id: String, algo: String = defaultAlgo, filters: Map[String,Any] = Map[String,Any](),  page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Skill, Double)] = {
    getVertex2ByVertex1[Course, Skill](id, algo, filters, page, limit)
  }

  override def getSkillsByCareerId(id: String, algo: String = defaultAlgo, filters: Map[String,Any] = Map[String,Any](),  page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Skill, Double)] = {
    getVertex2ByVertex1[Career, Skill](id, algo, filters, page, limit)
  }

  override def getCareersBySkillId(id: String, algo: String = defaultAlgo, filters: Map[String,Any] = Map[String,Any](),  page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Career, Double)] = {
    getVertex2ByVertex1[Skill, Career](id, algo, filters, page, limit)
  }

  override def getCareersByJobId(id: String, algo: String = defaultAlgo,  filters: Map[String,Any] = Map[String,Any](),  page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Career, Double)] = {
    getVertex2ByVertex1[Job, Career](id, algo, filters, page, limit)
  }

  override def getSkillBySkillId(id: String, algo: String = defaultAlgo,  filters: Map[String,Any] = Map[String,Any](),  page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Skill, Double)] = {
    getVertex2ByVertex1[Skill, Skill](id, algo, filters, page, limit)
  }

  override def getCareersByCategoryId(id: String, algo: String = defaultAlgo,  filters: Map[String,Any] = Map[String,Any](), page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Career, Double)] = {
    getVertex2ByVertex1[Category, Career](id, algo, filters, page, limit)
  }

  override def getSkillsByCategoryId(id: String, algo: String = defaultAlgo,  filters: Map[String,Any] = Map[String,Any](),  page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Skill, Double)] = {
    getVertex2ByVertex1[Category, Skill](id, algo, filters, page, limit)
  }

  override def getCoursesByCategoryId(id: String, algo: String = defaultAlgo,  filters: Map[String,Any] = Map[String,Any](),  page: Int= PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[(Course, Double)] = {
    getVertex2ByVertex1[Category, Course](id, algo, filters, page, limit)
  }

  override def index(entity: String, indexAll: Boolean = false, ids: List[String] = List[String]())(implicit request: RequestHeader): Int = {
    var result = CALL_SUCCESS
    try {
      isIndexing=true
      TitanWrapper.deleteExternalIndex
      Logger.info("INDEXING DATA ELASTICSEARCH STARTED")
      TitanWrapper.index(entity,indexAll,ids)
      Logger.info("INDEXING DATA ELASTICSEARCH FINISHED")
    }
    catch   {
      case e :Exception =>{
        Logger.error(String.format("TitanDatabase : could not index data ElasticSearch , cause origin %s", e.getMessage))
        result = CALL_FAIL
      }
    }
    isIndexing=false
    result
  }


  def createSeedData() = {
    implicit val request: RequestHeader = null

    val backend = TitanWrapper.db.asInstanceOf[StandardTitanGraph].getConfiguration.getBackend
    backend.clearStorage()
    TitanWrapper.init
    MockDatabase.jobs.foreach(GJob.create(_))
    MockDatabase.careers.foreach(GCareer.create(_))
    MockDatabase.courses.foreach(GCourse.create(_))
    MockDatabase.skills.foreach(GSkill.create(_))
    MockDatabase.category.getAll().foreach(GCategory.create(_))

    for (career <- MockDatabase.careers) {
      addMultiRelated(career.id, "Career", "related", career.getSkills().foldLeft(List[Map[String, Any]]())((r, e) => {
        r.::(Map("id" -> e._1.getId, "entity_type" -> "Skill", "weight" -> e._2))
      }))

      addMultiRelated(career.id, "Career", "related", career.getJobs().foldLeft(List[Map[String, Any]]())((r, e) => {
        r.::(Map("id" -> e._1.getId, "entity_type" -> "Job", "weight" -> e._2))
      }))
    }

    for (course <- MockDatabase.courses) {
      addMultiRelated(course.id, "Course", "related", course.getSkills().foldLeft(List[Map[String, Any]]())((r, e) => {
        r.::(Map("id" -> e._1.getId, "entity_type" -> "Skill", "weight" -> e._2))
      }))
    }

    for (job <- MockDatabase.jobs) {
      addMultiRelated(job.id, "Job", "related", job.getSkills().foldLeft(List[Map[String, Any]]())((r, e) => {
        r.::(Map("id" -> e._1.getId, "entity_type" -> "Skill", "weight" -> e._2))
      }))
    }
  }

}
