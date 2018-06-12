package com.zuul.bootc.test;

import com.zuul.bootc.GeOMain;
import com.zuul.bootc.drools.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public void ok(){
        List<Product> productList=new ArrayList<Product>();
        productList.add(new Product("A",100));
        productList.add(new Product("B",50));
        productList.add(new Product("C",10));

        List<Product> plist= productList.stream().filter(a->a.getDiscount()>10).collect(Collectors.toList());
        plist.stream().forEach(a-> {
            System.out.println(a.getDiscount());
        });
//        productList.stream().forEach(b->{
//           System.out.println(b.getDiscount());
//        });

//        double b= productList.stream().mapToDouble(a->a.getDiscount()*2).sum();
//        System.out.println(b);

//        List<Integer> plist= productList.stream().map(a->a.getDiscount()*2).collect(Collectors.toList());
//        System.out.println(plist);

//        long b= productList.stream().map(a->a.getDiscount()*2).count();
//        System.out.println(b);

       /* List<String> alpha = Arrays.asList("a", "b", "c", "d");
        List<String> collect = alpha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]*/
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
