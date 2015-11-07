package controllers

import java.io.File
import java.util.Date
import java.util.NoSuchElementException

import scala.Some

import play.api.mvc._
import play.api.libs.json._
import play.api.libs.Files
import play.api.Play
import play.api.Play.current
import play.api.libs.json.JsObject
import play.api.libs.json.JsString
import play.api.libs.json.JsArray

import db.{TitanWrapper, Database}
import models._
import utils._
import utils.Constant._
import utils.FuncResult._
import utils.HttpHeaderNames._
import utils.JsonHelper._
import utils.Storage._
import exception.NotFoundException

object Application extends Controller with ActionLoggable {
  var db: Database = null

  val default404Message = Json.obj("message" -> "The request was invalid or cannot be otherwise served. Things like missing requried fields, wrong category and wrong entity status. An accompanying error message will explain further.")

  def updateSettings = LoggableAction(parse.json) { implicit request =>
    val callResult = settingReads.reads(request.body).fold(
      invalid = { errors =>
        CALL_FAIL
      },
      valid = { data =>
      // get current settings
        val file= new File(Play.application.path.getPath.concat(CONFIG_FILE_PATH))
        val contents = Files.readFile(file)
        var settings = Json.parse(contents).as[JsObject]
        data._1.map { v => settings = settings.deepMerge(Json.obj("cassandra" -> Json.obj("storage" -> v)))}
        data._2.map { v => settings = settings.deepMerge(Json.obj("cassandra" -> Json.obj("local" -> Json.obj("dir" -> v))))}
        data._3.map { v => settings = settings.deepMerge(Json.obj("cassandra" -> Json.obj("network" -> Json.obj("hostname" -> v))))}
        data._4.map { v => settings = settings.deepMerge(Json.obj("cassandra" -> Json.obj("network" -> Json.obj("keyspace" -> v))))}
        data._5.map { v => settings = settings.deepMerge(Json.obj("es" -> Json.obj("storage" -> v)))}
        data._6.map { v => settings = settings.deepMerge(Json.obj("es" -> Json.obj("local" -> Json.obj("dir" -> v))))}
        data._7.map { v => settings = settings.deepMerge(Json.obj("es" -> Json.obj("network" -> Json.obj("hostname" -> v))))}
        data._8.map { v => settings = settings.deepMerge(Json.obj("es" -> Json.obj("network" -> Json.obj("cluster" -> v))))}
        data._9.map { v => settings = settings.deepMerge(Json.obj("es" -> Json.obj("network" -> Json.obj("index_name" -> v))))}
        Files.writeFile(file, Json.prettyPrint(settings))
        import _root_.db.TitanWrapper
        TitanWrapper.init
        CALL_SUCCESS
      }
    )
    val result = callResult match {
      case CALL_OTHER => BadRequest(Json.obj("message" -> "KO - unsupported entity type"))
      case CALL_SUCCESS => {
        val contents = Files.readFile(new File(Play.application.path.getPath.concat(CONFIG_FILE_PATH)))
        val settings = Json.parse(contents)
        Ok(settings)
      }
      case CALL_FAIL => BadRequest(default404Message)
      case CALL_EXISTED_FAIL => Conflict(Json.obj("message" -> "KO - id object existed"))
      case _ => BadRequest(Json.obj("message" -> "KO - can't find object")) //ToDo: review
    }
    result
  }

  def settings = LoggableAction  {  implicit request =>
    val contents = Files.readFile(new File(Play.application.path.getPath.concat(CONFIG_FILE_PATH)))
    val settings = Json.parse(contents)
    Ok(settings)
  }

  def index = LoggableAction {
    implicit request =>
      utils.Storage.STORAGE match {
        case "titan" => {
          val cassandraStatus = TitanWrapper.isCassandraAvailable
          val elasticStatus = TitanWrapper.isElasticAvailable
          if (cassandraStatus && elasticStatus && TitanWrapper.db == null)
            TitanWrapper.init
          val cStatusValue = if (cassandraStatus) "OK" else "DOWN"
          val eStatusValue = if (!cassandraStatus) "UNKNOWN" else if (elasticStatus) "OK" else "DOWN"
          val params: Map[String, Any] = Map(
            "info" -> String.format("Balloon-RMS. Release: ${VERSION} - ${BUILD} "),
            "cStatus" -> cStatusValue,
            "eStatus" -> eStatusValue
          )
          val page = 0
          val limit = 10
          var start: Long = System.currentTimeMillis()
          var results = List[Map[String, Any]]()
          def getLatency: Long = System.currentTimeMillis() - start
          def callApi(entity: String) = {
            start = System.currentTimeMillis()
            var url = ""
            var result: List[BaseEntity] = null
            try {
              entity match {
                case "Career" => {
                  url = "/careers?page=0&limit=10"
                  result = db.career.getAll()
                }
                case "Skill" => {
                  url = "/skills?page=0&limit=10"
                  result = db.skill.getAll()
                }
                case "Job" => {
                  url = "/jobs?page=0&limit=10"
                  result = db.job.getAll()
                }
                case "Course" => {
                  url = "/courses?page=0&limit=10"
                  result = db.course.getAll()
                }
                case "Category" => {
                  url = "/categories?page=0&limit=10"
                  result = db.category.getAll()
                }
              }
              results ::= Map("isSuccess" -> true, "data" -> result, "method" -> "GET", "entity" -> entity, "url" -> url, "code" -> "200", "time" -> getLatency)
            }
            catch {
              case ex: Exception => {
                results ::= Map("isSuccess" -> false, "cause" -> ex.getCause, "method" -> "GET", "entity" -> entity, "url" -> url,"code" -> "502", "time" -> getLatency)
              }
            }

          }
          List("Skill", "Job", "Category", "Course", "Career").foreach(it => callApi(it))

          Ok(views.html.healthPage(params, results))
        }
        case _ => {
          Ok(String.format("Balloon-RMS. Release: ${VERSION} - ${BUILD} "))
        }
      }
  }

  def list(entity: String) = LoggableAction {
    implicit request =>
      val modifySince = HeaderHelper.getModifySince(request)
      val page = HeaderHelper.getPage(request)
      val limit = HeaderHelper.getLimit(request)
      val orderBy : String =  HeaderHelper.getOrderBy(request)
      val sortOrder : String =  HeaderHelper.getSortOrder(request)
      val params: Map[String, Any] = HeaderHelper.getParams(request)
      var objs: List[BaseEntity] = List()

      entity match {
        case "career" => objs = db.career.getAll(params, orderBy, sortOrder, page, limit)
        case "category" => objs = db.category.getAll(params, orderBy, sortOrder, page, limit)
        case "course" => objs = db.course.getAll(params, orderBy, sortOrder, page, limit)
        case "skill" => objs = db.skill.getAll(params, orderBy, sortOrder, page, limit)
        case "job" => objs = db.job.getAll(params, orderBy, sortOrder, page, limit)
        case _ => BadRequest(Json.obj("status" -> "KO - unsupported entity type"))
      }


      val isModify: Boolean = modifySince.map {
        since =>
          if(objs.size>0){
            val maxTime = objs.reduceLeft{ (b, a) =>
              if(b.getModifyTime.after(a.getModifyTime)) b else a
            }.getModifyTime
            maxTime.after(since)
          } else
            false
      }.getOrElse(false)

      val result = if(isModify) {
        NotModified
      }
      else {
        Ok(
          JsObject("status" -> JsString("OK") :: Nil) ++
            JsObject(
              "data" -> objs.foldLeft(JsArray())((r, c) => r :+ c.toJson) :: Nil
            )
        )
      }

      result.withHeaders(LINK -> (HeaderHelper.getBaseUrl(request) + request.uri))
  }

  def get(entity: String, id: String) = LoggableAction {
    implicit request =>
      val modifySince = HeaderHelper.getModifySince(request)

      var obj: Option[BaseEntity] = None

      var result = Ok("OK")

      entity match {
        case "career" => obj = db.getCareer("id", id)
        case "category" => obj = db.getCategory("id", id)
        case "course" => obj = db.getCourse("id", id)
        case "job" => obj = db.getJob("id", id)
        case "skill" => obj = db.getSkill("id", id)
        case _ => result = BadRequest(Json.obj("message" -> "KO - unsupported entity type"))

      }

      try {
        val entity = obj.get
        modifySince.map {
          since =>
            if (entity.getModifyTime.after(since)) {
              result = Ok(Json.obj("message" -> "OK", "data" -> obj.get.toJson))
            }
            else {
              result = NotModified
            }
        }.getOrElse {
          result = Ok(Json.obj("message" -> "OK", "data" -> obj.get.toJson))
        }
      }
      catch {
        case ex: NoSuchElementException => result = NotFound(Json.obj("message" -> ("There is no " + entity + " found for provided id : " + id)))
        case ex: NullPointerException => result = BadRequest(Json.obj("message" -> "KO - can't find object"))
      }

      result.withHeaders(LINK -> (HeaderHelper.getBaseUrl(request) + request.uri))
  }

  def create(entity: String) = LoggableAction(parse.json) {
    implicit request =>
      val callResult = entity match {
        case "career" => {
          careerReads.reads(request.body).fold(
            invalid = {
              errors =>
                CALL_FAIL
            },
            valid = {
              data =>
                db.createCareer(ClassMeta.getMeta("Career").fromSeq[Career](data.productIterator.toSeq :+ (new Date)))
            }
          )
        }
        case "category" => {
          categoryReads.reads(request.body).fold(
            invalid = {
              errors =>
                CALL_FAIL
            },
            valid = {
              data =>
                db.createCategory(ClassMeta.getMeta("Category").fromSeq[Category](data.productIterator.toSeq :+ (new Date)))
            }
          )
        }
        case "course" => {
          courseReads.reads(request.body).fold(
            invalid = {
              errors =>
                CALL_FAIL
            },
            valid = {
              data =>
                db.createCourse(ClassMeta.getMeta("Course").fromSeq[Course](data.productIterator.toSeq :+ (new Date)))
            }
          )
        }
        case "job" => {
          jobReads.reads(request.body).fold(
            invalid = {
              errors =>
                CALL_FAIL
            },
            valid = {
              data =>
                db.createJob(ClassMeta.getMeta("Job").fromSeq[Job](data.productIterator.toSeq :+ (new Date)), true)
            }
          )
        }
        case "skill" => {
          skillReads.reads(request.body).fold(
            invalid = {
              errors =>
                CALL_FAIL
            },
            valid = {
              data =>
                val skill = ClassMeta.getMeta("Skill").fromSeq[Skill](data.productIterator.toSeq :+ (new Date))
                db.createSkill(ClassMeta.getMeta("Skill").fromSeq[Skill](data.productIterator.toSeq :+ (new Date)))
            }
          )
        }
        case _ => CALL_OTHER
      }
      val result = callResult match {
        case CALL_OTHER => BadRequest(Json.obj("message" -> "KO - unsupported entity type"))
        case CALL_SUCCESS => Created(mapToJson(Map("message" -> "OK", "data" -> request.body)))
        case CALL_FAIL => BadRequest(default404Message)
        case CALL_EXISTED_FAIL => Conflict(Json.obj("message" -> "KO - id object existed"))
        case _ => BadRequest(Json.obj("message" -> "KO - can't find object")) //ToDo: review
      }

      result.withHeaders(LINK -> (HeaderHelper.getBaseUrl(request) + request.uri))

  }

  def update(entity: String, id: String) = LoggableAction(parse.json) {
    implicit request =>
      var result = Ok("OK")
      updateReads.reads(request.body).fold(
        invalid = {
          errors =>
            result = BadRequest(default404Message)
        },
        valid = {
          submittedData =>
            val names: Seq[String] = Seq("name", "name_raw", "employer", "metro", "uri", "desc", "alternate_titles", "alternate_names", "entity_status", "curation_status", "posted_date")
            val keysUpdated = request.body.asInstanceOf[JsObject].fields.foldLeft(List[String]())((r, u) => r.::(u._1))
            val data: Map[String, Any] = (0 to (submittedData.productArity - 1)).foldLeft(Map[String, Any]()) {
              (r, u) => {
                val temp = submittedData.productElement(u)
                if (keysUpdated.contains((names(u)))) {
                  if (temp.isInstanceOf[Option[Any]]) {
                    r.+((names(u) -> temp.asInstanceOf[Option[Any]].get))
                  }
                  else r.+((names(u) -> temp))
                }
                else r
              }
            }
            val callResult: Option[BaseEntity] = entity match {
              case "career" => db.updateCareer(id, data)
              case "category" => db.updateCategory(id, data)
              case "course" => db.updateCourse(id, data)
              case "job" => db.updateJob(id, data)
              case "skill" => db.updateSkill(id, data)
              case _ => None
            }

            callResult.map { obj =>
              result = Ok(Json.obj("message" -> "OK", "data" -> obj.toJson))
            }.getOrElse { result = NotFound(mapToJson(Map("message" ->String.format("There is no %s found for the provided id : %s",entity(0).toUpper + entity.substring(1, entity.length),id)))) }
        }
      )

      result.withHeaders(LINK -> (HeaderHelper.getBaseUrl(request) + request.uri))
  }

  def delete(entity: String, id: String) = LoggableAction {
    implicit request =>
      val callResult = entity match {
        case "career" => db.deleteCareer(id)
        case "category" => db.deleteCategory(id)
        case "course" => db.deleteCourse(id)
        case "job" => db.deleteJob(id)
        case "skill" => db.deleteSkill(id)
        case _ => CALL_OTHER
      }

      val result = callResult match {
        case CALL_OTHER => BadRequest(Json.obj("status" -> "KO - unsupported entity type")) //ToDo: review
        case CALL_SUCCESS => NoContent
        case CALL_NOT_EXISTED_FAIL => NotFound(mapToJson(Map("message" ->String.format("There is no %s found for the provided id : %s",entity(0).toUpper + entity.substring(1, entity.length),id))))
        case _ => BadRequest(Json.obj("status" -> "KO - can't find object")) //ToDo: review
      }
      result.withHeaders(LINK -> (HeaderHelper.getBaseUrl(request) + request.uri))
  }

  def getRelated(entity1: String, entity2: String, entity1Id: String) = LoggableAction { implicit request =>
    val algo = request.getQueryString("algo").getOrElse("related")
    var data = List[Map[String, Any]]()
    val temp = List[Map[String, Any]]()
    var result:SimpleResult=Ok

    val page = HeaderHelper.getPage(request)
    val limit = HeaderHelper.getLimit(request)
    val withEntity = HeaderHelper.getWith(request)
    val filters =  HeaderHelper.getParams(request)
    val isWithSkill = withEntity.map(_ == "skill").getOrElse(false)

    try {
      result = (entity1, entity2) match {
        case ("career", "job") => {
          val relatedData = db.getJobsByCareerId(entity1Id, algo,filters, page, limit)
          data = if (isWithSkill) relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2, "skills" -> db.getSkillsByJobId(p._1.id, algo,filters, PAGE_DEFAULT, PAGE_SIZE_DEFAULT).map(k => Map("id" -> k._1.id, "weight" -> k._2)).toList.reverse)).toList.reverse
          else relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse

          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }
        case ("career", "skill") => {
          val relatedData = db.getSkillsByCareerId(entity1Id, algo,filters, page, limit)
          data = relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }
        case ("course", "skill") => {
          val relatedData = db.getSkillsByCourseId(entity1Id, algo,filters, page, limit)
          data = relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }

        case ("job", "career") => {
          val relatedData = db.getCareersByJobId(entity1Id, algo, filters, page, limit)
          data = if (isWithSkill) relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2, "skills" -> db.getSkillsByCareerId(p._1.id, algo,filters, PAGE_DEFAULT, PAGE_SIZE_DEFAULT).map(k => Map("id" -> k._1.id, "weight" -> k._2)).toList.reverse)).toList.reverse
          else relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }

        case ("job", "skill") => {
          val relatedData = db.getSkillsByJobId(entity1Id, algo, filters, page, limit)
          data = relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }

        case ("skill", "career") => {
          val relatedData = db.getCareersBySkillId(entity1Id, algo, filters, page, limit)
          data = if(isWithSkill) relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2, "skills" -> db.getSkillsByCareerId(p._1.id, algo, filters, PAGE_DEFAULT, PAGE_SIZE_DEFAULT).map(k => Map("id" -> k._1.id, "weight" -> k._2)).toList.reverse)).toList.reverse
          else relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }
        case ("skill", "job") => {
          val relatedData = db.getJobsBySkillId(entity1Id, algo, filters, page, limit)
          data = if(isWithSkill) relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2, "skills" -> db.getSkillsByJobId(p._1.id, algo, filters,  PAGE_DEFAULT, PAGE_SIZE_DEFAULT).map(k => Map("id" -> k._1.id, "weight" -> k._2)).toList.reverse)).toList.reverse
          else relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }
        case ("skill", "skill") => {
          val relatedData = db.getSkillBySkillId(entity1Id, algo, filters, page, limit)
          data = relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }
        case ("category", "career") => {
          val relatedData = db.getCareersByCategoryId(entity1Id, algo, filters, page, limit)
          data = if(isWithSkill) relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2, "skills" -> db.getSkillsByCareerId(p._1.id, algo, filters,  PAGE_DEFAULT, PAGE_SIZE_DEFAULT).map(k => Map("id" -> k._1.id, "weight" -> k._2)).toList.reverse)).toList.reverse
          else relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }
        case ("category", "course") => {
          val relatedData = db.getCoursesByCategoryId(entity1Id, algo, filters, page, limit)
          data = if(isWithSkill) relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2, "skills" -> db.getSkillsByCourseId(p._1.id, algo, filters,  PAGE_DEFAULT, PAGE_SIZE_DEFAULT).map(k => Map("id" -> k._1.id, "weight" -> k._2)).toList.reverse)).toList.reverse
          else relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }
        case ("category", "skill") => {
          val relatedData = db.getSkillsByCategoryId(entity1Id, algo, filters, page, limit)
          /*if(!relatedData.isEmpty) lastModify = relatedData.reduceLeft((b, a) => if(b._1.modifyAt.after(a._1.modifyAt)) b else a)._1.modifyAt*/
          data = relatedData.map(p => Map("id" -> p._1.id, "weight" -> p._2)).toList.reverse
          Ok(mapToJson(Map("message" -> "OK", "data" -> data)))
        }
        case _ => BadRequest(Json.obj("message" -> "KO - unsupported entity type"))
      }
    }
    catch {
      case e: NotFoundException => result = NotFound(mapToJson(Map("message" -> String.format("There is no %s found for the provided id : %s", entity1(0).toUpper + entity1.substring(1, entity1.length), entity1Id))))
      case e: Exception => throw e
    }
    /*val isModify = modifySince.map(_.before(lastModify)).getOrElse(true)
    if(!isModify) result = NotModified*/
    result.withHeaders(LINK -> (HeaderHelper.getBaseUrl(request) + request.uri))
  }


  def addRelated(entity1: String, entity2: String, id1: String) = LoggableAction(parse.json) {
    implicit request => {
      var result = Ok("")
      relatedReads.reads(request.body).fold(
        invalid = { errors =>
          result = BadRequest(default404Message)
        },
        valid = { dataSubmitted =>
          val algo = dataSubmitted._1.getOrElse("related")
          val data = dataSubmitted._2.map { item =>
            Map("id" -> item._1, "entity_type" -> entity2, "weight" -> item._2)
          }
          try {
            result= MultiStatus(mapToJson(Map("message" -> "Multi Body Response","data"->db.addMultiRelated(id1, entity1, algo, data))))
          }
          catch {
            case e:NotFoundException=>{
              result= NotFound(mapToJson(Map("message" -> e.msg)))
            }
            case _:Throwable => result=BadRequest(mapToJson(Map("message"->"unknown reason")))  //ToDo : review
          }
        })
      result.withHeaders(LINK -> (HeaderHelper.getBaseUrl(request) + request.uri))
    }
  }

  def reindex = LoggableAction(parse.json) {
    implicit request =>
      var result = Ok("")
      paramsIndexReads.reads(request.body).fold(
        invalid = {
          errors =>
            result = BadRequest(default404Message)
        },
        valid = {
          data =>
            val callResult = data._1 match {
              case AllEntity => db.index(AllEntity)
              case other: String => {
                data._2 match {
                  case Some(q) => {
                    db.index(other, false, q)
                  }
                  case None => db.index(other, true)
                }
              }
            }
            result = callResult match {
              case CALL_SUCCESS => Ok(Json.obj("message" -> "Indexing finished"))
              case CALL_FAIL => Ok(Json.obj("message" -> "Problem Indexing"))
            }
        })
      result.withHeaders(LINK -> (HeaderHelper.getBaseUrl(request) + "/admin/reindex"))
  }
}