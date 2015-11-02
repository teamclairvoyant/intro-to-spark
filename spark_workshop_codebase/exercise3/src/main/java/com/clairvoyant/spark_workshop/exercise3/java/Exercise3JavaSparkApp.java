package com.clairvoyant.spark_workshop.exercise3.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by robertsanders on 11/1/15.
 */
public class Exercise3JavaSparkApp {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("Exercise3JavaSparkApp").setMaster("yarn-client");
        JavaSparkContext sc = new JavaSparkContext(conf);


    }

}
