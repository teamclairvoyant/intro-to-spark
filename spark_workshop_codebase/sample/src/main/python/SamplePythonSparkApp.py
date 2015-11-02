__author__ = 'robertsanders'

from pyspark import SparkConf, SparkContext

conf = SparkConf().setAppName("SamplePythonSparkApp").setMaster("yarn-client")
sc = SparkContext(conf = conf)


