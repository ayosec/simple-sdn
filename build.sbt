packAutoSettings

scalaVersion := "2.10.4"

name := "simple-sdn"

version := "0.1"

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.1.2",
  "com.sun.jersey" % "jersey-core" % "1.18.1",
  "org.springframework.data" % "spring-data-neo4j-rest" % "3.2.0.RELEASE"
)
