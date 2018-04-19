package com.zuul.bootc;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleTest {
    public static void main(String[] arg){
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
            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }


}
