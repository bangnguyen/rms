import play.api.libs.json.{JsNull, JsValue, Json}
import play.api.libs.concurrent.Execution.Implicits.defaultContext
import play.api.{Logger, GlobalSettings}
import play.api.mvc._
import play.api.mvc.Results.BadGateway
import play.api.mvc.SimpleResult
import play.api.libs.ws.WS

import db.{TitanWrapper, MockDatabase, TitanDatabase}
import utils.{Retry, HeaderHelper, RequestCache, IndexFilter, Log}

import scala.concurrent.{Future}
import scala.collection.JavaConversions._

/**
 * Created by ha on 2/17/14.
 */


object Global extends WithFilters(IndexFilter) with GlobalSettings  {
  override def onStart(app: play.api.Application) {
    // Init titan
    utils.Storage.STORAGE match {
      case "titan" => {
        TitanWrapper.init
        controllers.Application.db = TitanDatabase
      }
      case "mock" => controllers.Application.db = MockDatabase
      case _ => {
        Log.error("Global : The validate value for storage in file application.conf" +
          " are 'mock ' | 'titan' ")
      }
    }

    if (utils.Storage.CREATE_SEED_DATA == true) {
      Log.info("CREATING SEED DATA STARTED ")
      try {
        TitanDatabase.createSeedData
      }
      catch {
        case ex: Exception => {
          Log.error(String.format("Global : Seed data can't be created, cause origin : %s", ex.getMessage))
        }
      }
      Log.info("CREATING SEED DATA FINISHED ")
    }

    //app.routes.map(p => println("routes is: " + p.documentation))
    //app.routes.map(p => println("routes function is :" + p.routes))

  }

  override def onRequestCompletion(request: RequestHeader) {
    if(!HeaderHelper.isAssets(request)) Log.info("request from: " + request.remoteAddress +", method:" + request.method +  ", uri:" + request.uri + " completed")(request)
    RequestCache._remove(request.id)
  }

  override def onError(request: RequestHeader, ex: Throwable): Future[SimpleResult] =  {
    val errorMessage = String.format("Global: Error %s %s, cause origin: %s ", request.method, request.uri, ex.getCause)

    if (ex.getCause.toString.contains("com.thinkaurelius.titan.core.TitanException") || ex.getCause.toString.contains("com.thinkaurelius.titan.diskstorage.es.ElasticSearchIndex")) {

      Log.info("trying to reset connection because: " + ex.getCause)(request)

      TitanWrapper.init

      var response: JsValue = JsNull
      var code: Int = 200
      var headers: Seq[(String, String)] = Seq()
      RequestCache.get(request.id).map { r =>
        val oldRequest = r("request").asInstanceOf[Request[_]]

        val retryTime = RequestCache.getRetryTime(request.id)
        if(retryTime < Retry.time) {
          Log.info("retry time is: " + retryTime)(oldRequest)

          val url = HeaderHelper.getBaseUrl(request) + oldRequest.uri
          val retry = oldRequest.getQueryString("_orgRequestId").map { orgId =>
            WS.url(url)
          }.getOrElse(WS.url(url).withQueryString(("_orgRequestId" -> request.id.toString)))

          val result = oldRequest.method.toLowerCase match {
            case "get" => retry.get()
            case "post" => retry.post(oldRequest.body.asInstanceOf[JsValue])
            case "put" => retry.put(oldRequest.body.asInstanceOf[JsValue])
            case "delete" => retry.delete()
          }

          result.map { resp =>
            code = resp.status
            response = resp.json

            val ahcResp = resp.ahcResponse
            headers = ahcResp.getHeaders.keySet().map { key =>
              (key, ahcResp.getHeader(key))
            }.toSeq

            new Results.Status(code)(response).withHeaders(headers:_*)
          }
        }
        else {
          Log.error(errorMessage)(oldRequest)
          Log.error(String.format("Global : StackTrace of cause %s", ex.getCause.getStackTraceString))(oldRequest)

          Future.successful(BadGateway(Json.obj(
            "message" -> errorMessage,
            "reason" -> ("retried " + Retry.time + " times to reset cassandara/elasticsearch connection but it's still fail")
          )))
        }
      }.getOrElse {
        Log.error(errorMessage)(request)
        Log.error(String.format("Global : StackTrace of cause %s", ex.getCause.getStackTraceString))(request)

        Future.successful(BadGateway(Json.obj(
          "message" -> errorMessage
        )))
      }
    }
    else {
      super.onError(request, ex)
    }
  }
}