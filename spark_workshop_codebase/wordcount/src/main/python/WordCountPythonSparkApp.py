__author__ = 'robertsanders'

from pyspark import SparkConf, SparkContext
import sys


def count(lines):
    return lines.flatMap(lambda line: line.split(" ")).map(lambda word: (word, 1)).reduceByKey(lambda a, b: a + b).filter(lambda a: not a._1.isEmpty())

if __name__ == "__main__":
    conf = SparkConf().setAppName("WordCountPythonSparkApp").setMaster("yarn-client")
    sc = SparkContext(conf = conf)

    pythonFile = None
    inputFile = None
    outputFile = None
    if len(sys.argv) == 3:
        pythonFile = sys.argv[0]
        inputFile = sys.argv[1]
        outputFile = sys.argv[2]
    else:
        print "Error: Invalid Arguments! Requires 2 arguments: <inputFile> <outputFile>"
        sys.exit(1)

    lines = sc.textFile(inputFile)
    counts = count(lines)

    counts.saveAsTextFile(outputFile)
