__author__ = 'robertsanders'

from pyspark import SparkConf, SparkContext

if __name__ == "__main__":
    conf = SparkConf().setAppName("Exercise3PythonSparkApp").setMaster("yarn-client")
    sc = SparkContext(conf = conf)

