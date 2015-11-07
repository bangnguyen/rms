package utils

import play.api.mvc.{Results, RequestHeader, EssentialAction, EssentialFilter}
import play.api.libs.iteratee.Iteratee
import db.TitanDatabase
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global


/**
 * Created by Marco Chu on 4/10/14.
 */
object IndexFilter extends EssentialFilter {

  var whiteList: List[String] = Storage.WHITE_LIST_INDEXING.split(" ").filter(s => s.trim.length > 0).map(s => s.toLowerCase).toList

  def apply(next: EssentialAction) = new EssentialAction {
    def apply(request: RequestHeader) = {
      val action = String.format("%s:%s", request.method.toLowerCase, request.path.toLowerCase)
      if (!whiteList.contains(action) && TitanDatabase.isIndexing)
        Iteratee.ignore[Array[Byte]].map(_ => Results.ServiceUnavailable("Reindexing ES Backend-Server, Please try again later"))
      else
        next(request)
    }
  }

}
