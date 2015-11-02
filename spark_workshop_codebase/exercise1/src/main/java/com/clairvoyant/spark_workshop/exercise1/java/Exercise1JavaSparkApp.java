package com.clairvoyant.spark_workshop.exercise1.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by robertsanders on 11/1/15.
 */
public class Exercise1JavaSparkApp {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("Exercise1JavaSparkApp").setMaster("yarn-client");
        JavaSparkContext sc = new JavaSparkContext(conf);

        List list = Arrays.asList(args);
        JavaRDD data = sc.parallelize(list);
        JavaRDD wData = data.filter(new Function<String, Boolean>() {
            public Boolean call(String s) throws Exception {
                return s.startsWith("w");
            }
        });
        List outputList = wData.collect();
        System.out.println(outputList);

    }

}
