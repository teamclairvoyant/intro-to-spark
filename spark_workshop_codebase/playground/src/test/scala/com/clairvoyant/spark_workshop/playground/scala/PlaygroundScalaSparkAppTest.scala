package com.clairvoyant.spark_workshop.playground.scala

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterAll, Matchers, GivenWhenThen, FlatSpec}

/**
 * Created by robertsanders on 1/8/16.
 */
class PlaygroundScalaSparkAppTest extends FlatSpec with GivenWhenThen with Matchers with BeforeAndAfterAll {

  private val master = "local[2]"
  private val appName = this.getClass.getSimpleName

  private var _sc: SparkContext = _

  def sc = _sc

  val conf: SparkConf = new SparkConf()
    .setMaster(master)
    .setAppName(appName)

  override def beforeAll(): Unit = {
    super.beforeAll()
    _sc = new SparkContext(conf)
  }

  override def afterAll(): Unit = {
    if (_sc != null) {
      _sc.stop()
      _sc = null
    }

    super.afterAll()
  }

  "Test" should "Test" in {
    //PlaygroundScalaSparkApp.{your_function}
  }

}
