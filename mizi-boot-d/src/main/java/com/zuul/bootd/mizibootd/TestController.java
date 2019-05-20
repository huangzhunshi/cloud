package com.zuul.bootd.mizibootd;

import com.zuul.bootd.mizibootd.strategydemo.DataPowerRule;
import com.zuul.bootd.mizibootd.strategydemo.DataPowerRuleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    DataPowerRuleContext dataPowerRuleContext;

    @RequestMapping("/test")
    public String Test(){
       return "yihui";
    }


    @RequestMapping("/choose")
    public String choose(@RequestParam("ruleName") String ruleName){
        return dataPowerRuleContext.getResource(ruleName);
    }

}
