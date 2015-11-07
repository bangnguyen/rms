package models

import java.lang.reflect.{Constructor, Field}
import javax.persistence.{Column, Id, Entity}
import utils.DataHelper

case class ClassMeta(name: String, entity: String, fields: List[(String, String, Field)], constructors: List[Constructor[_]]) {
  def toSeq(obj: Any) = {
    fields.filter(_._2 != ClassMeta.ID).flatMap { f =>
      Seq(f._1, f._3.get(obj))
    }.toSeq
  }

  def toMap(obj: Any) = {
    fields.filter(_._2 != ClassMeta.ID).map { f =>
      (f._1, f._3.get(obj))
    }.toMap
  }

  def createObject[T](data: Map[String, Any]) = {
    val constructor = constructors.head
    val args = fields.map(f => DataHelper.Any2AnyRef(data.get(f._1).getOrElse(null)))
    constructor.newInstance(args :_*).asInstanceOf[T]
  }

  def fromSeq[T](data: Seq[Any]) = {
    val constructor = constructors.head

    constructor.newInstance(data.map(DataHelper.Any2AnyRef(_)) :_*).asInstanceOf[T]
  }
}
object ClassMeta {
  val ID = "id"
  val COLUMN = "column"

  var allClasses: Map[String, ClassMeta] = Map()

  def getMeta(className: String) = {
    val name = getShortClass(className)
    if(!allClasses.isDefinedAt(name)) {
      val classOf = Class.forName("models." + name)

      var entity = classOf.getDeclaredAnnotations.find(_.isInstanceOf[Entity]).map { ann =>
        ann.asInstanceOf[Entity].name()
      }.getOrElse("")

      if(entity != "") entity = name

      val fields = classOf.getDeclaredFields.flatMap { f =>
        f.setAccessible(true)
        val annotations = f.getDeclaredAnnotations
        f.getDeclaredAnnotations.find(_.isInstanceOf[Id]).map { ann =>
          Some((f.getName, ID, f))
        }.getOrElse {
          annotations.find(_.isInstanceOf[Column]).map { ann =>
            var colName = ann.asInstanceOf[Column].name
            if(colName == "") colName = f.getName
            Some((colName, COLUMN, f))
          }.getOrElse(None)
        }
      }.toList

      allClasses = allClasses + (name -> ClassMeta(name, name, fields, classOf.getConstructors.toList))
    }

    allClasses(name)
  }

  def getShortClass(cls: String) = {
    val arrString = cls.split("\\.")
    if(arrString.length > 1) arrString(arrString.length - 1)
    else cls
  }
}
