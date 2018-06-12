package com.zuul.bootc.bapi;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 远程微服务调动 
 */
@FeignClient(name = "service-hi-b",fallback = BServiceHystrix.class)
public interface BServiceApi {

    @RequestMapping("test")
    String test();
}
