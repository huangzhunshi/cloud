package com.zuul.bootc.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SQLContext;

import java.util.List;

public class SparkSQLApp {
    public static void main(String[] args){
        //System.out.println("xxxxxx");        SparkConf conf = new SparkConf().setAppName("simpledemo").setMaster("local");
        SparkConf conf =new SparkConf().setAppName("demo").setMaster("local");
       // JavaSparkContext sc=new JavaSparkContext(conf);

        SparkContext sc=new SparkContext(conf);
        RDD<String> bb= sc.textFile("file:///tmp/bb",10);
        SQLContext sqlContext=SQLContext.getOrCreate(sc);
        Object o= sqlContext.sql("select * from bb");
        System.out.println("--------------");
        System.out.println(o);
//        Dataset<Object> aa= sqlContext.sql("select * from bb");
//        List<Object> objectList= aa.collectAsList();
//        for (Object obj:objectList) {
//            System.out.println(obj);
//        }
        //SQLContext
    }
}
