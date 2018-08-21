package com.zuul.bootc.jmh;


import com.google.common.base.Preconditions;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 20, time = 3, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Benchmark)
public class DemoJmhTest {
    private String pid;

    private Hashtable hashtable=new Hashtable();



    @Setup
    public void init() {
        // prepare
        for(Integer i=0;i<10000;i++){
            hashtable.put(i.toString(),i.toString());
        }
    }

    @Benchmark
    public void getHashTableMap(){
        Object o= hashtable.get("9111");
        System.out.println(o);
    }

    @TearDown
    public void destory() {
        // destory
    }

    @Benchmark
    public void benchPrecondition(){
        try{
            Preconditions.checkNotNull(pid);
        }catch (Exception e){

        }
    }

    public void getMap(){

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(".*" +DemoJmhTest.class.getSimpleName()+ ".*")
                .forks(1)
                .build();
        new Runner(opt).run();
    }


}
