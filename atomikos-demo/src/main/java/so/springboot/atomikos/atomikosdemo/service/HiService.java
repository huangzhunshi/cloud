package so.springboot.atomikos.atomikosdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import so.springboot.atomikos.atomikosdemo.dao.CanalTestDAO;
import so.springboot.atomikos.atomikosdemo.model.CanalTestDO;

@Service
public class HiService {
    @Autowired
    private CanalTestDAO canalTestDAO;

    @Transactional
    public void inserttran(){
        CanalTestDO canalTestDO=new CanalTestDO();
        canalTestDO.setcName("0000");
        canalTestDO.setId(45);

        canalTestDAO.insert(canalTestDO);

        canalTestDO.setId(46);
       // int a= 100/0;

        canalTestDO.setcName("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj32323");
        canalTestDAO.insert(canalTestDO);


    }
}
