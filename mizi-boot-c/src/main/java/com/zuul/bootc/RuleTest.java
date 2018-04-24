package com.zuul.bootc;

import com.zuul.bootc.drools.model.Product;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleTest {
    public static void main(String[] arg){
        //sample();
        //my();
        product();
    }

    private static void product(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

        Product product=new Product();

        product.setType(Product.DIAMOND);
        kSession.insert(product);
        kSession.fireAllRules();
        kSession.dispose();

        System.out.println("The discount for the product " + product.getType() + " is " + product.getDiscount()+"%");
    }

    private static void my(){
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("ksession-rules");

 //       kSession.insert("haha");
        Message message=new Message();
        message.setStatus(0);
        message.setMessage("haha");
        kSession.insert(message);
        kSession.fireAllRules();
    }

    private static void sample(){
        try {
            // load up the knowledge base
            KieServices ks = KieServices.Factory.get();
            KieContainer kContainer = ks.getKieClasspathContainer();
            KieSession kSession = kContainer.newKieSession("ksession-rules");

            // go !
            Message message = new Message();
            //message.setMessage("Hello World");
            message.setMessage("GoodBye");
            message.setStatus(Message.HELLO);
            kSession.insert(message);

            message.setMessage("Hello World");
            message.setStatus(Message.HELLO);
            kSession.insert(message);


            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
