package com.zuul.bootc.jmh;

import org.openjdk.jmh.annotations.*;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

//@BenchmarkMode(Mode.Throughput)
@BenchmarkMode({Mode.Throughput,Mode.AverageTime})
@State(Scope.Thread)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(2)
public class CountTest {
    @Benchmark
    @Warmup(iterations = 2)
    @Measurement(iterations = 2)
    public void serialLazyJDK() throws InterruptedException {
       Thread.sleep(100);
    }

    @Benchmark
    @Warmup(iterations = 2)
    @Measurement(iterations = 2)
    public void serialLazyGSC() {

    }



     Hashtable hashtable=new Hashtable();

     HashMap hashMap=new HashMap();

     public  CountTest(){
         loadData();
     }

    @Setup
    public void loadData(){
        for(Integer i=0;i<10000;i++){
            hashtable.put(i.toString(),i.toString());
            hashMap.put(i.toString(),i.toString());
        }
    }

    @Benchmark
    public void getMapKey(){
        Object object= hashMap.get("9000");
        //System.out.println(object);
    }

    @Benchmark
    public void getHashKey(){
        Object object=hashtable.get("9000");
       // System.out.println(object);

    }



}

