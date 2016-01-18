package com.clairvoyant.spark_workshop.wordcount.scala

import org.apache.spark.{SparkConf, SparkContext}
import org.scalatest.{BeforeAndAfterAll, FlatSpec, GivenWhenThen, Matchers}

/**
 * Created by robertsanders on 12/3/15.
 */
class WordCountScalaSparkAppTest extends FlatSpec with GivenWhenThen with Matchers with BeforeAndAfterAll {

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

  "Empty set" should "be counted" in {
    Given("empty set")
    val lines = Array("")

    When("count words")
    val wordCounts = WordCountScalaSparkApp.count(sc.parallelize(lines)).collect()

    wordCounts.foreach(wordCount => print(wordCount))

    Then("empty count")
    wordCounts shouldBe empty
  }

  "Shakespeare most famous quote" should "be counted" in {
    Given("quote")
    val lines = Array("To be or not to be.", "That is the question.")

    When("count words")
    val wordCounts = WordCountScalaSparkApp.count(sc.parallelize(lines)).collect()

    wordCounts.foreach(wordCount => print(wordCount))

    Then("words counted")
    wordCounts should equal(Array(
      Tuple2("is", 1),
      Tuple2("question.", 1),
      Tuple2("not", 1),
      Tuple2("or", 1),
      Tuple2("be", 1),
      Tuple2("to", 1),
      Tuple2("To", 1),
      Tuple2("That", 1),
      Tuple2("be.", 1),
      Tuple2("the", 1)))
  }

}
