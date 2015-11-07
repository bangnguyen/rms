package models

import java.util.Date
import play.api.libs.json.{JsNull, Json, JsObject}

import utils.Constant._
import utils.JsonHelper.simpleDateFormat

abstract class BaseEntity(id: String, name: String, uri: String, desc: String, entityStatus: String, curationStatus: String, postedDate: Date, modifyAt: Date) {
  def toJson: JsObject = Json.obj(
    ENTITY_ORIGIN_ID -> id,
    ENTITY_NAME -> name,
    ENTITY_URI -> uri,
    ENTITY_DECS -> desc,
    ENTITY_STATUS -> entityStatus,
    ENTITY_CURATION_STATUS -> curationStatus,
    ENTITY_POST_DATE -> (if (postedDate != null) simpleDateFormat.format(postedDate) else JsNull)
  )

  def getData:Map[String,Any]=Map("id"->id,ENTITY_NAME->name,ENTITY_URI->uri,ENTITY_DECS->desc,ENTITY_STATUS->entityStatus,ENTITY_CURATION_STATUS->curationStatus)

  def getId = id

  def getModifyTime = modifyAt
}






