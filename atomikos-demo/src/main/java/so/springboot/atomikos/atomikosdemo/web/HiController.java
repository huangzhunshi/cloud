package so.springboot.atomikos.atomikosdemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import so.springboot.atomikos.atomikosdemo.dao.CanalTestDAO;
import so.springboot.atomikos.atomikosdemo.service.HiService;

@RestController
public class HiController {

    @Autowired
    CanalTestDAO canalTestDAO;

    @Autowired
    HiService hiService;

    @RequestMapping("hiIndex")
    public Object hiIndex(){
        return canalTestDAO.selectByPrimaryKey(2);
    }

    @RequestMapping("addtran")
    public String addtran(){
        hiService.inserttran();
        return "ok";
    }
}
