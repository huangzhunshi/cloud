package com.zuul.bootc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("-----------------------before---------------");
        Object result=method.invoke(target,args);
        System.out.println("-----------------------after----------------");
        return result;
    }


    public Object getProxy() {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                target.getClass().getInterfaces(), this);
    }


    public static void main(String[] arg){
        HelloImpl helloimpl=new HelloImpl();
        MyInvocationHandler myInvocationHandler=new MyInvocationHandler(helloimpl);

        Hello hello=(Hello) myInvocationHandler.getProxy();
        hello.sayHello();

//        Hello hello=(Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(),HelloImpl.class.getInterfaces(),myInvocationHandler);
//        hello.sayHello();


    }
}