package com.clairvoyant.spark_workshop.wordcount.java;

import junit.framework.TestCase;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertsanders on 12/3/15.
 */
public class WordCountJavaSparkAppTest extends TestCase {

    private String master = "local[2]";
    private String appName = this.getClass().getSimpleName();

    private SparkConf conf = new SparkConf().setMaster(master).setAppName(appName);

    private JavaSparkContext sc;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        sc = new JavaSparkContext(conf);
    }

    @Override
    protected void tearDown() throws Exception {
        if (sc != null) {
            sc.stop();
            sc = null;
        }
        super.tearDown();
    }

    public void testEmptySet() {
        List lines = new ArrayList<String>() {{
            add("");
        }};

        JavaPairRDD<String, Integer> wordCounts = WordCountJavaSparkApp.count(sc.parallelize(lines));

        System.out.println(wordCounts);

        assertTrue(wordCounts.collect().isEmpty());
    }

    public void testShakespeare() {
        List lines = new ArrayList<String>() {{
            add("To be or not to be.");
            add("That is the question.");
        }};

        JavaPairRDD<String, Integer> wordCounts = WordCountJavaSparkApp.count(sc.parallelize(lines));

        System.out.println(wordCounts);

        List expectedWordCounts = new ArrayList<Tuple2<String, Integer>>(){{
            add(new Tuple2("is", 1));
            add(new Tuple2("question.", 1));
            add(new Tuple2("not", 1));
            add(new Tuple2("or", 1));
            add(new Tuple2("be", 1));
            add(new Tuple2("to", 1));
            add(new Tuple2("To", 1));
            add(new Tuple2("That", 1));
            add(new Tuple2("be.", 1));
            add(new Tuple2("the", 1));
        }};

        assertEquals(expectedWordCounts, wordCounts.collect());
    }


}
