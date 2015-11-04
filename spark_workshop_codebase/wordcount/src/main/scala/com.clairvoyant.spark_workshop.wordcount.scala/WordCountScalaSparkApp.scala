package com.clairvoyant.spark_workshop.wordcount.scala

import org.apache.spark.{SparkContext, SparkConf}

/**
 * Created by robertsanders on 11/1/15.
 */
object WordCountScalaSparkApp {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("WordCountScalaSparkApp").setMaster("yarn-client")
    val sc = new SparkContext(conf)

    var inputFile: String = null
    var outputFile: String = null

    if (args.length == 2) {
      inputFile = args(0)
      outputFile = args(1)
    }
    else {
      print("Error: Invalid Arguments! Requires 2 arguments: <inputFile> <outputFile>")
      return
    }

    val textFile = sc.textFile(inputFile)

    val counts = textFile.flatMap(line => line.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)

    counts.saveAsTextFile(outputFile)
  }

}
