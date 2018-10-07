package com.zuul.bootc.jdktest.Decorator;

public class Decorator extends Component {

    private Component component;

    public void setComponent(Component component) {
        this.component = component;
    }

    @Override
    public void op() {
        if(component==null)
            return;

        component.op();
    }
}
