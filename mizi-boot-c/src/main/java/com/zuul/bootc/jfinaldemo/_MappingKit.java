package com.zuul.bootc.jfinaldemo;

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.zuul.bootc.jfinaldemo.model.CanalTest;

public class _MappingKit {
    public static void mapping(ActiveRecordPlugin arp) {
        //arp.addMapping("blog", "id", Blog.class);
        arp.addMapping("canal_test", "id", CanalTest.class);

    }

}
