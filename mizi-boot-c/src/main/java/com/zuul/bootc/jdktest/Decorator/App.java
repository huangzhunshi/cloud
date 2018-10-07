package com.zuul.bootc.jdktest.Decorator;

public class App {
    public static void main(String[] args){
//        DecoratorA decoratorA=new DecoratorA();
//        DecoratorB decoratorB=new DecoratorB();
//        decoratorB.setComponent(new ConcreateComponent());
//        decoratorA.setComponent(decoratorB);
//        decoratorA.op();

//        ConcreateComponent concreateComponent=new ConcreateComponent();
//
//        DecoratorA decoratorA=new DecoratorA();
//        decoratorA.setComponent(concreateComponent);
//
//        DecoratorB decoratorB=new DecoratorB();
//        decoratorB.setComponent(decoratorA);
//
//        decoratorB.op();


//        Yihui_Sx yihui_sx=new Yihui_Sx();
//        Yihui_A yihui_a=new Yihui_A();
//
//        yihui_a.setYihui_base(yihui_sx);
//
//        Yihui_B yihui_b=new Yihui_B();
//        yihui_b.setYihui_base(yihui_a);
//
//
//        yihui_b.Op();

        HzA hzA=new HzA();
        HzB hzB=new HzB();

        hzB.setiHz(hzA);

        hzB.Op();

        System.out.println("____________");

        HzC hzC=new HzC();
        hzC.setiHz(hzB);


        hzC.Op();

    }
}
