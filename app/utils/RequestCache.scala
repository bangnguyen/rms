package utils

import play.api.libs.json.JsValue

object RequestCache {
  var separator = "-"

  var requested: Map[Long, Map[String, Any]] = Map()

  def addRequest(id: Long, request: Any) = {
    requested = requested + (id -> Map("request" -> request, "orgId" -> id, "id" -> uniqueId(id), "logId" -> uniqueId(id)))
  }

  def getRetryTime(id: Long) = {
    var result = 0
    requested.get(id).map(_.get("parentId").map { parentId =>
       requested.get(parentId.asInstanceOf[Long]).map(_.get("retry").map { retry =>
          result = retry.asInstanceOf[List[Long]].length
       })
    })

    result
  }

  def addRetryRequest(parentId: Long, id: Long, request: Any) = {
    val parent = requested(parentId)

    requested = requested + (id -> Map("request" -> request, "orgId" -> id, "id" -> uniqueId(id), "parentId" -> parentId, "logId" -> (parentId + separator + uniqueId(id))))

    val retry = parent.get("retry").map { ids =>
      ids.asInstanceOf[List[Long]] :+ id
    }.getOrElse(List(id))

    requested = requested + (parentId -> (parent + ("retry" -> retry)))
  }

  def get(id: Long) = requested.get(id)

  def getLogId(id: Long) = requested.get(id).map { p =>
    p("logId").asInstanceOf[String]
  }.getOrElse("id-not-found")

  def removeAll(id: Long) = {
    // get current item first
    requested.get(id).map { item =>
      item.get("parentId").map(parentId => removeParent(parentId.asInstanceOf[Long]))
    }
  }

  def removeParent(id: Long) = {
    requested.get(id).map { parent =>
      parent.get("retry").map { ids =>
        ids.asInstanceOf[List[Long]].map(_remove)
      }

      _remove(id)
    }
  }

  /**
   * remove item if this item does not contain children
   * @param id item id
   */
  def safeRemove(id: Long) = {
    requested.get(id).map { item =>
      if(!item.isDefinedAt("retry")) _remove(id)
    }
  }

  def _remove(id: Long) = {
    requested -= id
  }

  private def uniqueId(id: Long) = id + separator + System.currentTimeMillis()
}
