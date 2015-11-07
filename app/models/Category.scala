package models

import java.util.Date
import javax.persistence.{ Entity, Column, Id}
import scala.annotation.meta.field

import utils.Constant._

/**
 * Created by Marco Chu on 3/11/14.
 */
case class Category(
                     @(Id@field) id: String,
                     @(Column@field) name: String,
                     @(Column@field) uri: String,
                     @(Column@field) desc: String,
                     @(Column@field)(name = "entity_status") entityStatus: String = ENTITY_STATUS_DEFAULT,
                     @(Column@field)(name = "curation_status") curationStatus: String = CURATION_STATUS_DEFAULT,
                     @(Column@field)(name="posted_date") postedDate: Date = new Date,
                     @(Column@field) modifyAt: Date = new Date)
                     extends BaseEntity(id, name, uri, desc, entityStatus, curationStatus, postedDate, modifyAt)

trait ICategory extends AbstractDbObject[String,Category]

object GCategory extends GraphDbImpl[Category] with ICategory



