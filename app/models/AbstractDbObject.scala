package models

import play.api.mvc.RequestHeader

import db.{TitanWrapper}
import utils.Constant._
import utils.DataHelper._
import utils.Log._

/**
 * Created by Marco Chu on 3/11/14.
 */
trait AbstractDbObject[String, BaseEntity] {

  def get(id: String)(implicit request: RequestHeader): Option[BaseEntity]

  def create(entity: BaseEntity, flush : Boolean = false)(implicit request: RequestHeader): Int

  def delete(id: String)(implicit request: RequestHeader): Int

  def update(id: String, data: Map[String, Any])(implicit request: RequestHeader): Option[BaseEntity]

  def getAll(params: Map[String,Any] = Map[String,Any](), orderBy : String = ORDER_BY_DEFAULT.asInstanceOf[String], sortOrder : String = SORT_ORDER_DEFAULT.asInstanceOf[String], page: Int = PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[BaseEntity]

}


class GraphDbImpl[T <: BaseEntity](implicit m: Manifest[T]) extends AbstractDbObject[String, T] {
  //@todo: need to improvment performance
  val entityType = m.runtimeClass.getSimpleName

  def get(id: String)(implicit request: RequestHeader): Option[T] = {
    TitanWrapper.getVertex(id, entityType).map { data =>
      val id = data.get(ENTITY_ID)
      ClassMeta.getMeta(entityType).createObject[T](data.filter(_._1 != ENTITY_ID) + ("id" -> id.getOrElse("")))
    }
  }

  def update(id: String, data: Map[String, Any])(implicit request: RequestHeader): Option[T] = {
    val meta = ClassMeta.getMeta(entityType)
    val fields = meta.fields.map(p => (p._1, p._2)).toMap

    TitanWrapper.updateVertex(id, entityType, data.filter(p => fields.isDefinedAt(p._1))).map { data =>
      val id = data.get(ENTITY_ID)
      ClassMeta.getMeta(entityType).createObject[T](data.filter(_._1 != ENTITY_ID) + ("id" -> id.getOrElse("")))
    }
  }

  def delete(id: String)(implicit request: RequestHeader) = {
    TitanWrapper.delete(id, entityType)
  }

  def create(entity: T, flush: Boolean = false)(implicit request: RequestHeader): Int = {
    info("creating entity with data: " + entity)
    val result = TitanWrapper.addVertex(ClassMeta.getMeta(entityType).toMap(entity) + (ENTITY_TYPE -> entityType) + (ENTITY_ID -> entity.getId), flush)
    result
  }

  def getAll(params: Map[String,Any] = Map[String,Any](), orderBy : String = ORDER_BY_DEFAULT, sortOrder : String = SORT_ORDER_DEFAULT, page: Int = PAGE_DEFAULT, limit: Int = PAGE_SIZE_DEFAULT)(implicit request: RequestHeader): List[T] = {
    val meta = ClassMeta.getMeta(entityType)
    val filters = Map(ENTITY_TYPE -> entityType) ++ params
    TitanWrapper.getVertices(filters, orderBy, sortOrder, page, limit).map { vData =>
      meta.createObject[T](vData.filter(_._1 != ENTITY_ID) + ("id" -> vData.get(ENTITY_ID).getOrElse("")))
    }.toList
  }
}
