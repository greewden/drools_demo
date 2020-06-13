package com.lixar.drools_demo.config;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.lixar.drools_demo.service")
public class RulesEngineConfig {

    @Bean
    public KieContainer kieContainer() {
        KieServices kieServices = KieServices.Factory.get();
        return  kieServices.getKieClasspathContainer();
    }
}
