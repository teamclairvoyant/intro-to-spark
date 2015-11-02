package com.clairvoyant.spark_workshop.playground.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by robertsanders on 11/1/15.
 */
public class PlaygroundJavaSparkApp {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("PlaygroundPythonSparkApp").setMaster("yarn-client");
        JavaSparkContext sc = new JavaSparkContext(conf);

    }

}
