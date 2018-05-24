package com.zuul.bootc.jfinaldemo;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.generator.MappingKitGenerator;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.Cache;
import com.jfinal.plugin.redis.Redis;
import com.jfinal.plugin.redis.RedisPlugin;
import com.zuul.bootc.jfinaldemo.model.CanalTest;

import java.util.List;

public class App {

    public static void startPlugin() {
        PropKit.use("a_little_config.txt");
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        ActiveRecordPlugin arp = new ActiveRecordPlugin("mysql",druidPlugin);

        _MappingKit.mapping(arp);


        druidPlugin.start();
        arp.start();


        RedisPlugin userRedis=new RedisPlugin("userCache","192.168.146.128");
        userRedis.start();
    }

    public static void main(String arg[]){
        System.out.println("xxxxx");
        startPlugin();
//        CanalTest canalTest=new CanalTest();
//        canalTest.set("c_name","ceshi222").save();

        CanalTest canalTest=new CanalTest();
        List<CanalTest> list= canalTest.dao().find("select * from canal_test");
        for (CanalTest c:list) {
            System.out.println(c.get("id").toString()+"------"+c.get("c_name").toString());
        }

        Cache userCache= Redis.use("userCache");

        userCache.getJedis().set("aaa","ccc");
        System.out.println(userCache.getJedis().get("bbbb"));
        //userCache.set("bbbb","aaaaa");
        //userCache.getCounter("bbbb");
       // System.out.println(userCache.ge("bbbb").toString());
        //System.out.println(Db.queryStr("select c_name from canal_test limit ?",1));
    }
}
