package utils

import java.util.Date
import play.api.mvc.RequestHeader
import org.joda.time.format.DateTimeFormat

import utils.Constant._

object HeaderHelper {
  def getModifySince(header: RequestHeader): Option[Date] = {
    header.headers.get("If-Modified-Since").map { since =>
      DateTimeFormat.forPattern("E, dd MMM yyyy H:m:s z").parseDateTime(since).toDate
    }
  }

  def getBaseUrl(header: RequestHeader) = {
    val url: String = controllers.routes.Application.index().absoluteURL()(header)
    url.stripSuffix("/")
  }

  def getPage(header: RequestHeader) = {
    try {
      header.getQueryString("page").map(_.toInt).getOrElse(PAGE_DEFAULT)
    } catch {
      case e: Exception => PAGE_DEFAULT
    }
  }

  def getLimit(header: RequestHeader) = try {
    header.getQueryString("limit").map(_.toInt).getOrElse(PAGE_SIZE_DEFAULT)
  } catch {
    case e: Exception => PAGE_SIZE_DEFAULT
  }

  def getParams(header: RequestHeader): Map[String, String] = {
    val params = header.getQueryString(ENTITY_STATUS).map(v => Map(ENTITY_STATUS -> v)).getOrElse(Map(ENTITY_STATUS -> ENTITY_STATUS_DEFAULT))
    header.getQueryString(ENTITY_CURATION_STATUS).foldLeft(params)((r, v) => r.+(ENTITY_CURATION_STATUS -> v))
  }

  def getWith(header: RequestHeader) = header.getQueryString("with")

  def isAssets(header: RequestHeader) = header.uri.startsWith("/assets")

  def getOrderBy(header : RequestHeader) : String = {
    header.getQueryString(ORDER_BY).getOrElse(ORDER_BY_DEFAULT)
  }
  def getSortOrder(header : RequestHeader) : String = {
    header.getQueryString(SORT_ORDER).getOrElse(SORT_ORDER_DEFAULT)
  }

}
