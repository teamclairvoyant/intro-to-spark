__author__ = 'robertsanders'

from pyspark import SparkConf, SparkContext

conf = SparkConf().setAppName("Exercise4PythonSparkApp").setMaster("yarn-client")
sc = SparkContext(conf = conf)


