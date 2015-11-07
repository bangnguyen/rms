package exception

case class NeedImplement(msg:String)  extends Exception
case class NotFoundException(msg:String) extends  Exception
case class CassandraException(msg:String) extends  Exception
case class ElasticException(msg:String) extends  Exception
case class BackendException(msg:String) extends  Exception
