package com.zuul.bootc.jfinaldemo.job;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.redis.RedisPlugin;
import com.zuul.bootc.jfinaldemo._MappingKit;

/**
 * 基础Job类
 */
public abstract class BaseJob {


    /**
     * 执行任务方法
     * @param appFile 配置文件路径
     */
    public void execute(String appFile){
        startPlugin(appFile);
        run();
    }

    /**
     * run方法，子类执行
     */
    abstract void run();

    /**
     * 初始化配置
     * @param appFile  配置文件路径
     */
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
