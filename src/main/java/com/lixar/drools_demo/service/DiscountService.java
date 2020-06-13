package com.lixar.drools_demo.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lixar.drools_demo.model.Purchase;

@Service
public class DiscountService {

    private KieContainer kieContainer;

    @Autowired
    public DiscountService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public double calculateDiscount(Purchase purchase) {

        // Create a session that contains the rules defined in the discountRules.drl file.
        KieSession kieSession = getKieSession("ksession-rules");

        // Add facts to the session
        kieSession.insert(purchase);
        int fired = kieSession.fireAllRules();
        kieSession.dispose();
        System.out.println("Number of Rules executed = " + fired);
        return purchase.getDiscount();
    }

    private KieSession getKieSession(String sessionName) {
        return kieContainer.newKieSession(sessionName);
    }
}
