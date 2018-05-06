package com.zuul.bootc.test;

import com.zuul.bootc.GeOMain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * powermock 测试demo类
 */
@PowerMockIgnore({"javax.management.*"}) //忽略一些mock异常  GeOMain
@RunWith(PowerMockRunner.class)
@PrepareForTest( { GeOMain.class })
public class BaseJunit4 {
    @Test
    public void testCreateHandleNum() {
        //throw new RuntimeException();
        String[] abc={"xxx"};
        GeOMain.main(abc);
        System.out.println("xxxxx");
    }

    @Test
    public void test1() throws Exception {

        GeOMain geOMain= PowerMockito.mock(GeOMain.class);
        //GeOMain geOMain=PowerMockito.mockStatic(GeOMain.class);
        //GeOMain geOMain=PowerMockito.mock(GeOMain.class);
        GeOMain geOMain1=new GeOMain();
        PowerMockito.when(geOMain.testCeshi()).thenReturn(122);

        System.out.println(geOMain.testCeshi());

//        Integer abc= PowerMockito.mock(GeOMain.class).testCeshi();
//        System.out.println(abc);
//        PowerMockito.when(GeOMain.method(Matchers.anyString())).thenReturn(100);


//        GeOMain geOMain=new GeOMain();
//        System.out.println(geOMain.testCeshi());

//        PowerMockito.mockStatic(GeOMain.class);
//
//        PowerMockito.doReturn(123).when(GeOMain.class,"main");

    }
}
