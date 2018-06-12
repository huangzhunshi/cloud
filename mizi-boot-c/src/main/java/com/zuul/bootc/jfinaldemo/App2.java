package com.zuul.bootc.jfinaldemo;

import com.zuul.bootc.jfinaldemo.job.BaseJob;
import com.zuul.bootc.jfinaldemo.job.MyJob;

public class App2 {
    public static void main(String arg[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //BaseJob myJob=new MyJob();
        BaseJob job= (BaseJob) Class.forName("com.zuul.bootc.jfinaldemo.job.MyJob").newInstance();
        job.execute("a_little_config.txt");

    }
}
