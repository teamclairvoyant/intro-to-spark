#Playground Module

##Description
Module for developers to play around in and write throw away code

##Running Code
###Runnnig Java
$ spark-submit --class com.clairvoyant.spark_workshop.playground.java.PlaygroundJavaSparkApp com.clairvoyant.spark_workshop.playground-jar-with-dependencies.jar arg1 arg2 argn

###Running Python
$ spark-submit PlaygroundPythonSparkApp.py arg1 arg2 argn

###Running Scala
$ spark-submit --class com.clairvoyant.spark_workshop.playground.scala.PlaygroundScalaSparkApp com.clairvoyant.spark_workshop.playground-jar-with-dependencies.jar arg1 arg2 argn