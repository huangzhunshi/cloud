package com.zuul.bootc.jfinaldemo;

import ch.qos.logback.core.db.dialect.MySQLDialect;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.dialect.PostgreSqlDialect;
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
        arp.setDialect(new MysqlDialect());
        _MappingKit.mapping(arp);
        druidPlugin.start();
        arp.start();

        DruidPlugin druidPluginPG = new DruidPlugin(PropKit.get("jdbcUrlpg"), PropKit.get("userpg"), PropKit.get("passwordpg").trim());
        ActiveRecordPlugin arp2 = new ActiveRecordPlugin("pgsql",druidPluginPG);
        arp2.setDialect(new PostgreSqlDialect());
        _MappingKit.mapping(arp2);

        druidPluginPG.start();
        arp2.start();


        RedisPlugin userRedis=new RedisPlugin("userCache","192.168.146.128");
        userRedis.start();
    }

    public static void main(String arg[]){
        System.out.println("xxxxx122");
        startPlugin();
//        CanalTest canalTest=new CanalTest();
//        canalTest.set("c_name","ceshi222").save();

        List<Record> list= Db.use("pgsql").find("select * from mytest order by id desc");
        for (Record r:list
             ) {
            System.out.println(r.get("id").toString());
        }
        Db.use("pgsql").save("mytest",new Record().set("id",6).set("name","ceshi"));

//        CanalTest canalTest=new CanalTest();
//        List<CanalTest> list= canalTest.use("mysql").dao().find("select * from canal_test");
//
//        for (CanalTest c:list) {
//            System.out.println(c.get("id").toString()+"------"+c.get("c_name").toString());
//        }

        Cache userCache= Redis.use("userCache");

        userCache.getJedis().set("aaa","ccc");
        System.out.println(userCache.getJedis().get("bbbb"));

    }
}
