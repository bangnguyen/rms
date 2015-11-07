import play.Project._

name := "balloon-rms"

version := "${VERSION}-build.${BUILD}"

scalaVersion := "2.10.2"

resolvers ++= Seq(
)

libraryDependencies ++= {
  val blueprintsVersion = "2.4.0"
  val titanVersion = "0.4.2"
  val gremlinVersion = "2.5.0"
  Seq(
    "com.tinkerpop.blueprints" % "blueprints-core" % blueprintsVersion,
    "com.thinkaurelius.titan" % "titan-core" % titanVersion,
    "com.thinkaurelius.titan" % "titan-cassandra" % titanVersion excludeAll(ExclusionRule(organization = "org.slf4j")),
    "com.thinkaurelius.titan" % "titan-berkeleyje" % titanVersion,
    "com.thinkaurelius.titan" % "titan-es" % titanVersion,
    "javax.persistence" % "persistence-api" % "1.0",
    "com.tinkerpop.gremlin" % "gremlin-java" % gremlinVersion
  )
}

playScalaSettings

Keys.fork in (Test) := false