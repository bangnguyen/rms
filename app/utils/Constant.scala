package utils

import com.typesafe.config.ConfigFactory
import play.api.Logger


object Constant {

  val defaultAlgo="related"
  val Skill="Skill"
  val Career="Career"
  val Category="Category"
  val Course="Course"
  val Job="Job"
  val AllEntity="*"
  val ENTITY_ID="bid"
  val ENTITY_FULL_ID="full_id"
  val ENTITY_ORIGIN_ID="id"
  val ENTITY_NAME="name"
  val ENTITY_NAME_RAW="name_raw"
  val ENTITY_URI="uri"
  val ENTITY_DECS="desc"
  val ENTITY_EMPLOYER="employer"
  val ENTITY_METRO="metro"
  val ENTITY_STATUS="entity_status"
  val ENTITY_CURATION_STATUS="curation_status"
  val ENTITY_ALTERNATE_TITLES= "alternate_titles"
  val ENTITY_ALTERNATE_NAMES= "alternate_names"
  val ENTITY_TYPE="entity_type"
  val EDGE_WEIGHT_PROPERTY="weight"
  val ENTITY_ENTITY_ID="entity_entity_id"
  val ENTITY_POST_DATE : String = "posted_date"
  val ORDER_BY : String = "orderBy"
  val SORT_ORDER : String= "sortOrder"
  val ORDER_BY_NOTHING = ""
  val ORDER_BY_DEFAULT = ORDER_BY_NOTHING
  val SORT_ORDER_DEFAULT = "DESC"

  val ENTITY_STATUS_DEFAULT = "PUBLISHED"
  val CURATION_STATUS_DEFAULT = "New Curation"
  val SEPARATOR_ID="##"

  val ENTITY_STATUS_PUBLISHED = "PUBLISHED"
  val ENTITY_STATUS_UNPUBLISHED = "UNPUBLISHED"
  val ENTITY_STATUS_EXPIRED = "EXPIRED"

  val PAGE_DEFAULT = 0

  var PAGE_SIZE_DEFAULT = 10
  try {
     // must try catch this line to make test junit  work
     PAGE_SIZE_DEFAULT = ConfigFactory.load().getInt("PAGE_SIZE_DEFAULT")
  }
  catch {
    case e : Exception => Logger.warn(String.format("the PAGE_SIZE_DEFAULT  in  application.conf  must have a integer value"))
  }
}


object SystemConfig {
  val STORAGE_TYPE = "storage.type"
  val STORAGE_BACKEND = "storage.backend"
  val STORAGE_HOSTNAME = "storage.hostname"
  val STORAGE_PORT = "storage.port"
}

object Storage {
  lazy val STORAGE_LOCAL = "local"
  lazy val STORAGE_TITAN = "titan"
  lazy val INDEX_NAME = "balloon"

  val conf = ConfigFactory.load()
  lazy val STORAGE = conf.getString("storage")
  lazy val TITAN_STORAGE = conf.getString("titan.storage")

  // for titan local
  lazy val TITAN_LOCAL_CASSANDRA_DIRECTORY = conf.getString("titan.local.cassandra_dir")
  lazy val TITAN_LOCAL_ES_DIRECTORY = conf.getString("titan.local.es_dir")

  // for titan network
  lazy val TITAN_NETWORK_CASSANDRA_HOSTNAME = conf.getString("titan.network.cassandra_host")
  lazy val TITAN_NETWORK_ELASTIC_HOSTNAME = conf.getString("titan.network.elastic_host")
  lazy val TITAN_NETWORK_ELASTIC_CLUSTER = conf.getString("titan.network.elastic_cluster")

  lazy val CONFIG_FILE_PATH="/conf/settings.json"

  lazy val WHITE_LIST_INDEXING = conf.getString("white_list_indexing")
  lazy val CREATE_SEED_DATA =conf.getBoolean("create_seed_data")
}

object Titan {
  lazy val VERTEX_TYPE = "vertex"
  lazy val EDGE_TYPE = "edge"
  lazy val EDGE_AND_VERTEX_TYPE = "edge-vertex"
}

object Retry {
  val time = 3
}
// companion object for HttpHeaderNames trait
object HttpHeaderNames extends HttpHeaderNames

// this trait defines headers that aren't defined in play.api.http.HeaderNames
trait HttpHeaderNames {
  val LINK = "Link"
}

// companion object for RelationshipSkill2Skill
object RelationshipSkill2Skill extends RelationshipSkill2Skill

// defines getAll skill to skill relationships
trait RelationshipSkill2Skill {
  val NARROWER = "narrower"
  val RELATE = "relate"
  val SAME_AS = "same_as"
}

object FuncResult extends FuncResult

trait FuncResult {
  val CALL_SUCCESS = 0
  val CALL_FAIL = -1
  val CALL_EXISTED_FAIL = -2
  val CALL_NOT_EXISTED_FAIL = -3
  val CALL_OTHER = -4
  val CASSANDRA_SERVER_NOT_AVAILABLE = -5
  val ELASTIC_SERVER_NOT_AVAILABLE = -6
  val BACKEND_NOT_AVAILABLE = -6

}

object RelationshipLimits extends RelationshipLimits

trait RelationshipLimits {
  val SCORE_MAX = 1
  val SCORE_MIN = 0
}
