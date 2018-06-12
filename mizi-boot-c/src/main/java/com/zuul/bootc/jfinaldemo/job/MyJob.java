package com.zuul.bootc.jfinaldemo.job;

import com.zuul.bootc.jfinaldemo.model.CanalTest;

import java.util.List;

public class MyJob  extends BaseJob{


    @Override
    void run() {
        CanalTest canalTest=new CanalTest();
        List<CanalTest> list= canalTest.dao().find("select * from canal_test");
        for (CanalTest c:list) {
            System.out.println(c.get("id").toString()+"------"+c.get("c_name").toString());
        }
       System.out.println("myjob");
    }
}
