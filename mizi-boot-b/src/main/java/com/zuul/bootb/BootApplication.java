package com.zuul.bootb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class BootApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }


    @RequestMapping("test")
    public String test() throws InterruptedException {
//        Thread.sleep(2000);
        return "我是服务-B";
    }

    @RequestMapping("addcookie")
    public String addcookie(HttpServletRequest request, HttpServletResponse response, String username){
        CookieUtil.addCookie(response,"username",username,3600);
        return "设置成功";
		/*Users users=new Users();
		users.setUserId("100");
		users.setUserName("huangzun");
		return users;*/
    }

    @RequestMapping("getcookie")
    public String getcookie(HttpServletRequest request, HttpServletResponse response){
        Cookie cookie=CookieUtil.getCookieByName(request,"username");
		/*System.out.print(cookie.getValue());*/
        if(cookie==null){
            return "获取不到cookie";
        }
        return cookie.getValue();
    }

}
