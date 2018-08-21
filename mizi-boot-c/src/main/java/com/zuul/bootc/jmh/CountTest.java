package com.zuul.bootc.jmh;

import org.openjdk.jmh.annotations.*;

@BenchmarkMode(Mode.Throughput)
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

}

