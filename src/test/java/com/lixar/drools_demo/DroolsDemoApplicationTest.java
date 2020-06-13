package com.lixar.drools_demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lixar.drools_demo.service.DiscountService;

@SpringBootTest
class DroolsDemoApplicationTest {

    @Autowired
    private DiscountService discountService;

    @Test
    public void contextLoads() {
        assertThat(discountService).isNotNull();
    }
}