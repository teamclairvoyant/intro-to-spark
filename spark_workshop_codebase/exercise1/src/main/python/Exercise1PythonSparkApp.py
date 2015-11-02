__author__ = 'robertsanders'

import sys
from pyspark import SparkConf, SparkContext

conf = SparkConf().setAppName("Exercise1PythonSparkApp").setMaster("yarn-client")
sc = SparkContext(conf = conf)

if __name__ == "__main__":
    list = sys.argv
    data = sc.parallelize(list)
    wData = data.filter(lambda x: x.startswith("w"))
    outputList = wData.collect()
    print(outputList)
