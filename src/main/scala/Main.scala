package com.graphenedb.spring

import org.springframework.data.neo4j.rest.SpringRestGraphDatabase
import scala.collection.JavaConversions._

object Main {

  lazy val graphClient: SpringRestGraphDatabase = {
    val urlParts = "(https?://)(.*):(.*)@(.*)".r
    val dbURL = Option(System.getenv("GRAPHENEDB_URL")).getOrElse("http://localhost:7474")

    dbURL match {
      case urlParts(a, user, pw, b) => new SpringRestGraphDatabase(a + b + "/db/data/", user, pw)
      case _                        => ???
    }
  }

  def showode(nodeId: Long): String = {
    val node = graphClient.getNodeById(nodeId)
    val props = node.getPropertyKeys map { key => s"$key=${node.getProperty(key)}" } mkString ", "
    s"props[$props]"
  }

  def main(args: Array[String]): Unit = args match {

    case Array("node", nodeId) =>
      println(s"Node#$nodeId " + showode(nodeId.toLong))

    case Array("query", query) =>
      println("[Query] " + query)
      val result = graphClient.queryEngine.query(query, new java.util.HashMap)
      result.iterator.foreach(println)

    case _ =>
      System.err.println("Usage: node X|query 'cyper'")

  }

}
