package com.zuul.bootc.proxy;

import java.util.ArrayList;
import java.util.List;

public class ObserverTest {
    /**
     * 被观察者
     */
    public interface Observerable{
        void reg(Obserer obserer);
        void remove(Obserer obserer);
        void noifyall();

    }

    /**
     * 观察者
     */
    public interface Obserer{
        void notifyMessage();
    }

    public static class Gril implements  Observerable{

        List<Obserer> list;

        public Gril() {
            this.list =new ArrayList<>();
        }

        @Override
        public void reg(Obserer obserer) {
           list.add(obserer);
        }

        @Override
        public void remove(Obserer obserer) {
          list.remove(obserer);
        }

        @Override
        public void noifyall() {
            for (Obserer obserertmp:list) {
                obserertmp.notifyMessage();
            }
        }
    }

    public static class Boy implements Obserer{

        @Override
        public void notifyMessage() {
            System.out.println("男孩通知过来了");
        }
    }

    public static class Man implements Obserer{


        @Override
        public void notifyMessage() {
            System.out.println("男人通知过来了");
        }
    }

    public static void main(String[] args){
        Gril gril=new Gril();

        Boy boy=new Boy();
        Man man=new Man();

        gril.reg(boy);
        gril.reg(man);

        gril.noifyall();

    }
}
