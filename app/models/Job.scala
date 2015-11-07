package models

import java.util.Date
import javax.persistence.{ Entity, Column, Id}
import scala.annotation.meta.field

import utils.JsonHelper._
import utils.Constant._
import play.api.libs.json.{JsNull, Json}

/**
 * Created by Marco Chu on 3/11/14.
 */
case class Job(
    @(Id@field) id: String,
    @(Column@field) name: String,
    @(Column@field) uri: String,
    @(Column@field) name_raw: String,
    @(Column@field) desc: String,
    @(Column@field) employer: String,
    @(Column@field) metro: String,
    @(Column@field)(name="entity_status") entityStatus: String = ENTITY_STATUS_DEFAULT,
    @(Column@field)(name="curation_status") curationStatus: String = CURATION_STATUS_DEFAULT,
    @(Column@field)(name="posted_date") postedDate: Date = new Date,
    @(Column@field) modifyAt: Date = new Date)
    extends BaseEntity(id, name, uri, desc, entityStatus, curationStatus, postedDate, modifyAt)
    with HasCategories with HasSkills {
  override def toJson = {
    Json.obj(
      ENTITY_ORIGIN_ID -> id,
      ENTITY_URI -> uri,
      ENTITY_NAME -> name,
      ENTITY_NAME_RAW -> name_raw,
      ENTITY_DECS -> desc,
      ENTITY_EMPLOYER -> employer,
      ENTITY_METRO -> metro,
      ENTITY_STATUS -> entityStatus,
      ENTITY_CURATION_STATUS -> curationStatus,
      ENTITY_POST_DATE -> (if (postedDate != null) simpleDateFormat.format(postedDate) else JsNull)
    )
  }
}


trait IJob extends  AbstractDbObject[String,Job]

object GJob extends  GraphDbImpl[Job] with IJob