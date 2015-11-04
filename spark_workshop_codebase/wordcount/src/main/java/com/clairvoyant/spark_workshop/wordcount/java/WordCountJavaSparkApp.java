package com.clairvoyant.spark_workshop.wordcount.java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by robertsanders on 11/1/15.
 */
public class WordCountJavaSparkApp {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("WordCountJavaSparkApp").setMaster("yarn-client");
        JavaSparkContext sc = new JavaSparkContext(conf);

        String inputFile;
        String outputFile;

        if(args.length == 2) {
            inputFile = args[0];
            outputFile = args[1];
        } else {
            System.out.println("Error: Invalid Arguments! Requires 2 arguments: <inputFile> <outputFile>");
            return;
        }

        JavaRDD<String> textFile = sc.textFile(inputFile);

        JavaRDD<String> words = textFile.flatMap(new FlatMapFunction<String, String>() {
            public Iterable<String> call(String line) { return Arrays.asList(line.split(" ")); }
        });
        JavaPairRDD<String, Integer> pairs = words.mapToPair(new PairFunction<String, String, Integer>() {
            public Tuple2<String, Integer> call(String word) {
                return new Tuple2<String, Integer>(word, 1);
            }
        });
        JavaPairRDD<String, Integer> counts = pairs.reduceByKey(new Function2<Integer, Integer, Integer>() {
            public Integer call(Integer a, Integer b) { return a + b; }
        });

        counts.saveAsTextFile(outputFile);

    }

}
