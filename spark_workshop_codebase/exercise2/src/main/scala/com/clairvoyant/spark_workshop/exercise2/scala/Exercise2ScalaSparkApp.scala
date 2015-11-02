package com.clairvoyant.spark_workshop.exercise2.scala

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by robertsanders on 10/30/15.
 */
object Exercise2ScalaSparkApp {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Exercise2ScalaSparkApp").setMaster("yarn-client")
    val sc = new SparkContext(conf)

  }

}