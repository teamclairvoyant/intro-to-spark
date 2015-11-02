package com.clairvoyant.spark_workshop.sample.scala

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by robertsanders on 11/1/15.
 */
object SampleScalaSparkApp {

  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setAppName("SampleScalaSparkApp").setMaster("yarn-client")
    val sc = new SparkContext(conf)


  }

}