package utils

import utils.Constant._
import com.tinkerpop.blueprints.Vertex
import java.util.Date
import com.thinkaurelius.titan.core.Order


object DataHelper {
  def getData(vertex: Vertex) = {
    val response = vertex.getPropertyKeys.toArray.foldLeft(Map[String, Any]("id" -> vertex.getId))((r, key) => r.+(key.toString -> getValue(vertex, key.toString)))
    response
  }

  def getValue(vertex: Vertex, key: String) = {
    var response: Any = null
    key match {
      case "id" | "name" | "uri" | "desc" | "entity_status" | "curation_status" | "alternate_titles" => response = vertex.getProperty[String](key)
      case _ => response = vertex.getProperty[String](key)
    }
    response
  }

  def removeProperty(vertex: Vertex, key: String): Vertex = {
    key match {
      case ENTITY_POST_DATE => vertex.removeProperty[java.util.Date](key)
      case _ => vertex.removeProperty[String](key)
    }
    vertex
  }

  def Any2AnyRef(in: Any): AnyRef = {
    if (in != null) {
      in match {
        case v: String => v
        case v: Boolean => Boolean.box(v)
        case v: Date => v
        //@todo: need to implement for more scala data type
        case other: Any => throw exception.NeedImplement(String.format("type %s is not supported ", other.toString))
      }
    } else null
  }

  def createGId(prefix: String, id: String) = {
    prefix.toLowerCase.concat(SEPARATOR_ID) concat (id)
  }


  def getBaseId(id: String) = {
    id.stripPrefix(id.substring(0, id.indexOf(SEPARATOR_ID)).concat(SEPARATOR_ID))
  }


  def createGId[T](id: String)(implicit m: Manifest[T]): String = {
    val simpleName = m.runtimeClass.getSimpleName
    createGId(simpleName, id)
  }

  def createEntityType[T1, T2]()(implicit m1: Manifest[T1], m2: Manifest[T2]): String = {
    createEntityType(m1.runtimeClass.getSimpleName, m2.runtimeClass.getSimpleName)
  }

  def createEntityType(type1: String, type2: String): String = {
    type1.toLowerCase().concat("_").concat(type2.toLowerCase)
  }

  def createEntityEntityId(vertexId1: String, vertexId2: String,label:String): String = {
    String.format("%s_%s_%s",vertexId1.toLowerCase(),label,vertexId2.toLowerCase)
  }

  def compare(vertex: Vertex, key: String, value: Any) :Boolean= {
    if (value.isInstanceOf[String])
      vertex.getProperty[String](key).equals(value.asInstanceOf[String])
    else if (value.isInstanceOf[Long])
      vertex.getProperty[Long](key).equals(value.asInstanceOf[Long])
    else if (value.isInstanceOf[Double])
      vertex.getProperty[Double](key).equals(value.asInstanceOf[Double])
    else if (value.isInstanceOf[Long])
      vertex.getProperty[Int](key).equals(value.asInstanceOf[Int])
    else if (value.isInstanceOf[Boolean])
      vertex.getProperty[Boolean](key).equals(value.asInstanceOf[Boolean])
    else
      throw new Exception(String.format("DataHelper.compare type for key %s value %s is not implemented ", key, value.toString))
  }

  def toEnum(sortOrder: String)  =
    if (sortOrder.trim.toLowerCase().equals("asc")) Order.ASC
    else Order.DESC


}
