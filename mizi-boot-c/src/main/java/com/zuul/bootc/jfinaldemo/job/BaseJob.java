package com.zuul.bootc.jfinaldemo.job;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.zuul.bootc.jfinaldemo._MappingKit;

public abstract class BaseJob {

//    public BaseJob(String appFile){
//        startPlugin(appFile);
//    }

    public void execute(String appFile){
        startPlugin(appFile);
        run();
    }

    abstract void run();

    private  void startPlugin(String appFile) {
        PropKit.use(appFile);
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        ActiveRecordPlugin arp = new ActiveRecordPlugin("mysql",druidPlugin);

        _MappingKit.mapping(arp);


        druidPlugin.start();
        arp.start();


        RedisPlugin userRedis=new RedisPlugin("userCache","192.168.146.128");
        userRedis.start();
    }

}
