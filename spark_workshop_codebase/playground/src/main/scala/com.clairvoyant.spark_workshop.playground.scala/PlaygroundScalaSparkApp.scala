package com.clairvoyant.spark_workshop.playground.scala

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by robertsanders on 11/1/15.
 */
object PlaygroundScalaSparkApp {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("PlaygroundScalaSparkApp").setMaster("yarn-client")
    val sc = new SparkContext(conf)

  }

}
