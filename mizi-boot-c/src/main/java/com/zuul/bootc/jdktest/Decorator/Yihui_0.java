package com.zuul.bootc.jdktest.Decorator;

public class Yihui_0 extends Yihui_Sx {

    private Yihui_Base yihui_base;

    public void setYihui_base(Yihui_Base yihui_base) {
        this.yihui_base = yihui_base;
    }

    @Override
    public void Op() {
        //super.Op();
        if(yihui_base==null)
            return;

        yihui_base.Op();
    }
}
