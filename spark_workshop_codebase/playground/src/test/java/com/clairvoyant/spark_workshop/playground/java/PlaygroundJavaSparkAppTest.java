package com.clairvoyant.spark_workshop.playground.java;

import junit.framework.TestCase;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * Created by robertsanders on 1/8/16.
 */
public class PlaygroundJavaSparkAppTest extends TestCase {

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

    public void test() {
        //PlaygroundJavaSparkApp.{your_function}
        assertTrue(true);
    }

}
