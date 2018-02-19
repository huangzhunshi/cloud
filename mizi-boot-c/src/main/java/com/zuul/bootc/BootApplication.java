package com.zuul.bootc;

import com.zuul.bootc.bapi.BServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }


    @Autowired
    BServiceApi bServiceApi;

    @RequestMapping("test")
    public String test(){
        return "我是服务-C";
    }


    @RequestMapping("testb")
    public String testB(){
        return bServiceApi.test();
    }

}
