package models

import java.util.Date
import javax.persistence.{ Entity, Column, Id}
import scala.annotation.meta.field

import utils.Constant._


case class Course(@(Id@field) id: String,
                  @(Column@field) name: String,
                  @(Column@field) uri: String,
                  @(Column@field) desc: String,
                  @(Column@field)(name="entity_status") entityStatus: String = ENTITY_STATUS_DEFAULT,
                  @(Column@field)(name="curation_status") curationStatus: String = CURATION_STATUS_DEFAULT,
                  @(Column@field)(name="posted_date") postedDate: Date = new Date,
                  @(Column@field) modifyAt: Date = new Date)
                  extends BaseEntity(id, name, uri, desc, entityStatus, curationStatus, postedDate, modifyAt)
with HasCategories with HasSkills

trait ICourse extends AbstractDbObject[String,Course]

object GCourse extends GraphDbImpl[Course] with ICourse
