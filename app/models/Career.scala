package models

import java.util.Date
import javax.persistence.{ Entity, Column, Id}
import scala.annotation.meta.field

import utils.Constant._
import utils.JsonHelper._
import play.api.libs.json.{JsNull, Json}

/**
 * Created by Marco Chu on 3/11/14.
 */
case class Career(
    @(Id@field) id: String,
    @(Column@field) name: String,
    @(Column@field) uri: String,
    @(Column@field) desc: String,
    @(Column@field)(name="alternate_names") alternateNames: String = "": String,
    @(Column@field)(name="entity_status") entityStatus: String = ENTITY_STATUS_DEFAULT,
    @(Column@field)(name="curation_status") curationStatus: String = CURATION_STATUS_DEFAULT,
    @(Column@field)(name="posted_date") postedDate: Date = new Date,
    @(Column@field) modifyAt: Date = new Date)
    extends BaseEntity(id, name, uri, desc, entityStatus, curationStatus, postedDate, modifyAt)
    with HasCategories with HasJobs with HasSkills {
  override def toJson = {
    Json.obj(
      ENTITY_ORIGIN_ID -> id,
      ENTITY_URI -> uri,
      ENTITY_NAME -> name,
      ENTITY_DECS -> desc,
      ENTITY_ALTERNATE_NAMES -> alternateNames,
      ENTITY_STATUS -> entityStatus,
      ENTITY_CURATION_STATUS -> curationStatus,
      ENTITY_POST_DATE -> (if (postedDate != null) simpleDateFormat.format(postedDate) else JsNull)
    )
  }
}


trait ICareer extends AbstractDbObject[String, Career]

object GCareer extends GraphDbImpl[Career] with ICareer



