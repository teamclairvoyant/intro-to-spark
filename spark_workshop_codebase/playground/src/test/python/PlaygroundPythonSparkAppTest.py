__author__ = 'robertsanders'

from pyspark import SparkConf, SparkContext
import unittest

class WordCountPythonSparkAppTest(unittest.TestCase):

    master = "local[2]"

    conf = SparkConf().setAppName(__name__).setMaster(master)

    sc = None

    @staticmethod
    def setUp():
        sc = SparkContext(conf = conf)

    @staticmethod
    def tearDown():
        if sc != None:
            sc.stop()
            sc = None

    def test_upper(self):
        self.assertNotEquals(None, sc)

if __name__ == '__main__':
    unittest.main()