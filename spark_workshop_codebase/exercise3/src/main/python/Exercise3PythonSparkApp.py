__author__ = 'robertsanders'

from pyspark import SparkConf, SparkContext

conf = SparkConf().setAppName("Exercise3PythonSparkApp").setMaster("yarn-client")
sc = SparkContext(conf = conf)


