package com.zuul.bootdemo.web;

import com.zuul.bootdemo.domain.entity.CanalTestDO;
import com.zuul.bootdemo.dto.Result;
import com.zuul.bootdemo.service.CanalTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = {"application/json;charset=UTF-8"})
public class DemoController {

    @Autowired
    private CanalTestService canalTestService;

    @RequestMapping(value = "test")
    public Result test(){
//       Result result=new Result();
//       result.setCode(19);
//       result.setMsg("返回成功");
 //      return result;
        return Result.builder().code(100).msg("返回成功").build();
   }



   @RequestMapping("test1")
   @ResponseBody
    public String test1(){
       CanalTestDO canalTestDO= canalTestService.getCanalTestByid(2);
       return "xxxx";

   }

}
