package com.zuul.bootc.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SparkApp {
    public static void main(String[] args) throws IOException {
        SparkConf sparkConf = new SparkConf().setAppName("JavaWordCount").setMaster("local");
        JavaSparkContext javaSparkContext=new JavaSparkContext(sparkConf);
        JavaRDD<String> lines=javaSparkContext.textFile("file:///tmp/bb");
        /**
         * 数据逐行读取，并根据,号分隔，变成string list
         */
        JavaRDD<String> words=lines.flatMap((FlatMapFunction<String, String>) s -> {
            //return null;
            //return Arrays.asList(s.split(","));
            String[] strarray= s.split(",");
            List<String> list=new ArrayList<>();
            for (String str: strarray) {
                list.add(str);
               // System.out.println("!---------------"+str);

            }
            return list.iterator();
        });

        /**
         * 每个数组变成键值对
         */
        JavaPairRDD<String, Integer> ones=words.mapToPair((PairFunction<String, String, Integer>) s ->
                new Tuple2<String,Integer>(s,1)
        );

//        JavaPairRDD<String, Integer> counts = ones.reduceByKey(new Function2<Integer, Integer, Integer>() {
//            @Override
//            public Integer call(Integer i1, Integer i2) {
//                return i1 + i2;
//            }
//        });

        /**
         * 分组
         */
        JavaPairRDD<String,Integer> counts=ones.reduceByKey((Function2<Integer, Integer, Integer>)
                 (integer, integer2) -> integer+integer2
         );

        /**
         * 转成list
         */
        List<Tuple2<String, Integer>> output = counts.collect();

        /**
         * 输出
         */
        for (Tuple2<?,?> tuple : output) {
            System.out.println(tuple._1() + "----: " + tuple._2());
        }

        System.in.read();


    }
}
