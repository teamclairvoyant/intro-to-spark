package com.clairvoyant.spark_workshop.exercise1.scala

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by robertsanders on 10/30/15.
 */
object Exercise1ScalaSparkApp {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("Exercise1ScalaSparkApp").setMaster("yarn-client")
    val sc = new SparkContext(conf)

    val list = args
    val data = sc.parallelize(list)
    val wData = data.filter(_.startsWith("w"))
    val outputList = wData.collect()
    println(outputList.mkString(" "))

  }

}