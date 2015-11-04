#Word Count Module

##Description
Word Count example

##Running Code
###Runnnig Java
$ spark-submit --class com.clairvoyant.spark_workshop.wordcount.java.WordCountJavaSparkApp com.clairvoyant.spark_workshop.wordcount-jar-with-dependencies.jar /path/to/input/file /path/to/output/file

###Running Python
$ spark-submit WordCountPythonSparkApp.py /path/to/input/file /path/to/output/file

###Running Scala
$ spark-submit --class com.clairvoyant.spark_workshop.wordcount.scala.WordCountScalaSparkApp com.clairvoyant.spark_workshop.wordcount-jar-with-dependencies.jar /path/to/input/file /path/to/output/file