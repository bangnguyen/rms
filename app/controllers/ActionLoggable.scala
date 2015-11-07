package controllers

import play.api.mvc._
import play.api.libs.json.{Json, JsValue}
import utils.Log._
import play.api.cache.Cache


import utils.RequestCache

/**
 * A request that adds the User for the current call
 */

trait ActionLoggable extends Controller {
  /**
   * A secured action.  If there is no user in the session the request is redirected
   * to the login page
   *
   * @param p the body parser to use
   * @param f the wrapped action to invoke
   * @tparam A
   * @return
   */
  def LoggableAction[A](p: BodyParser[A]) (f: Request[A] => Result) = Action(p) {
    implicit request => {
      request.getQueryString("_orgRequestId").map(_.toLong).map { orgId =>
        RequestCache.addRetryRequest(orgId, request.id, request)
      }.getOrElse(RequestCache.addRequest(request.id, request))

      val requestInfo = Json.obj(
        "uri" -> request.uri,
        "method" -> request.method,
        "body" -> request.body.asInstanceOf[JsValue],
        "remoteAddress" -> request.remoteAddress,
        "queryString" -> request.queryString
      )
      Cache.set("item.key", connectedUser)

      info("[info]:" + requestInfo.toString())

      f(request)
    }
  }

  def LoggableAction(f: Request[AnyContent] => Result): Action[AnyContent] = Action(parse.anyContent) {
    implicit request => {
      request.getQueryString("_orgRequestId").map(_.toLong).map { orgId =>
        RequestCache.addRetryRequest(orgId, request.id, request)
      }.getOrElse(RequestCache.addRequest(request.id, request))

      val requestInfo = Json.obj(
        "uri" -> request.uri,
        "method" -> request.method,
        "remoteAddress" -> request.remoteAddress,
        "queryString" -> request.queryString
      )

      info("[info]:" + requestInfo.toString())
      f(request)
    }
  }
}