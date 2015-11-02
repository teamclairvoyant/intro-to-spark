package com.clairvoyant.spark_workshop.exercise3.scala

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by robertsanders on 10/30/15.
 */
object Exercise3ScalaSparkApp {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Exercise3ScalaSparkApp").setMaster("yarn-client")
    val sc = new SparkContext(conf)

  }

}