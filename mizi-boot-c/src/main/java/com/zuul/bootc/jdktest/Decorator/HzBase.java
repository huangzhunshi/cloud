package com.zuul.bootc.jdktest.Decorator;

public class HzBase implements IHz {

    private IHz iHz;

    public void setiHz(IHz iHz) {
        this.iHz = iHz;
    }

    @Override
    public void Op() {
        if(iHz!=null){
            iHz.Op();
        }
//        if(iHz==null)
//            return;
//
//        iHz.Op();
        //System.out.println("base");
    }
}
