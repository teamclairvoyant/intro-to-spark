package com.clairvoyant.spark_workshop.sample.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by robertsanders on 11/1/15.
 */
public class SampleJavaSparkApp {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("SampleJavaSparkApp").setMaster("yarn-client");
        JavaSparkContext sc = new JavaSparkContext(conf);

    }

}
