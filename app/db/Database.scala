package db

import play.api.mvc.RequestHeader

import models._
import utils.Constant._


/**
 * Created by ha on 1/26/14.
 */
abstract class Database {

  def skill: ISkill

  def career: ICareer

  def category: ICategory

  def course: ICourse

  def job: IJob

  def getCareer(field: String, value: String)(implicit request: RequestHeader): Option[Career]

  def getCategory(field: String, value: String)(implicit request: RequestHeader): Option[Category]

  def getCourse(field: String, value: String)(implicit request: RequestHeader): Option[Course]

  def getJob(field: String, value: String)(implicit request: RequestHeader): Option[Job]

  def getSkill(field: String, value: String)(implicit request: RequestHeader): Option[Skill]


  def getSkillsByCareerId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Skill, Double)]

  def getJobsByCareerId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Job, Double)]

  def getJobsBySkillId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Job, Double)]

  def getCoursesByCategoryId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Course, Double)]

  def getSkillsByCategoryId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Skill, Double)]

  def getCareersByCategoryId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Career, Double)]

  def getSkillsByCourseId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Skill, Double)]

  def getCareersByJobId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Career, Double)]

  def getCareersBySkillId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Career, Double)]

  def getSkillsByJobId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Skill, Double)]


  def getSkillBySkillId(id: String, algo: String = defaultAlgo, filters: Map[String, Any], page: Int, limit: Int)(implicit request: RequestHeader): List[(Skill, Double)]


  def createCareer(c: Career)(implicit request: RequestHeader) = career.create(c)

  def createCategory(c: Category)(implicit request: RequestHeader) = category.create(c)

  def createCourse(c: Course)(implicit request: RequestHeader) = course.create(c)

  def createJob(j: Job, flush : Boolean = false)(implicit request: RequestHeader) = job.create(j, flush)

  def createSkill(s: Skill)(implicit request: RequestHeader) = skill.create(s)

  def updateCareer(id: String, data: Map[String, Any])(implicit request: RequestHeader) = career.update(id, data)

  def updateCategory(id: String, data: Map[String, Any])(implicit request: RequestHeader) = category.update(id, data)

  def updateCourse(id: String, data: Map[String, Any])(implicit request: RequestHeader) = course.update(id, data)

  def updateJob(id: String, data: Map[String, Any])(implicit request: RequestHeader) = job.update(id, data)

  def updateSkill(id: String, data: Map[String, Any])(implicit request: RequestHeader) = skill.update(id, data)

  def deleteCareer(id: String)(implicit request: RequestHeader) = career.delete(id)

  def deleteCategory(id: String)(implicit request: RequestHeader) = category.delete(id)

  def deleteCourse(id: String)(implicit request: RequestHeader) = course.delete(id)

  def deleteJob(id: String)(implicit request: RequestHeader) = job.delete(id)

  def deleteSkill(id: String)(implicit request: RequestHeader) = skill.delete(id)

  def addRelated(id1: String, entity_type1: String, id2: String, entity_type2: String, algo: String, data: Map[String, Any])(implicit request: RequestHeader):  Map[String,Any]

  def addMultiRelated(id: String, entity_type: String, algo: String, data: List[Map[String, Any]])(implicit request: RequestHeader): List[Map[String, Any]]

  def index(entity: String, indexAll: Boolean = false, ids: List[String] = List[String]())(implicit request: RequestHeader) : Int
}