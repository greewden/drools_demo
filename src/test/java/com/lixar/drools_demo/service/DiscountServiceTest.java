package com.lixar.drools_demo.service;


import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.lixar.drools_demo.config.RulesEngineConfig;
import com.lixar.drools_demo.model.Purchase;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RulesEngineConfig.class})
class DiscountServiceTest {

    private static final BigDecimal PRICE_UNDER_25_AND_OVER_15 = BigDecimal.valueOf(17.5);
    private static final BigDecimal PRICE_OVER_25 = BigDecimal.valueOf(45.23);
    private static final BigDecimal PRICE_UNDER_15 = BigDecimal.valueOf(8.50);
    private static final int SINGLE_TACO = 1;
    private static final int MULTIPLE_TACOS = 3;

    @Autowired
    DiscountService discountService;

    @Test
    void calculateDiscount_purchaseUnder25_10PercentDiscount() {
        Purchase purchase = new Purchase(PRICE_UNDER_25_AND_OVER_15, SINGLE_TACO, false);
        double result = discountService.calculateDiscount(purchase);

        assertThat(result).isEqualTo(0.10);
    }

    @Test
    void calculateDiscount_purchaseUnder15_NoDiscount() {
        Purchase purchase = new Purchase(PRICE_UNDER_15, SINGLE_TACO, false);
        double result = discountService.calculateDiscount(purchase);

        assertThat(result).isEqualTo(0);
    }

    @Test
    void calculateDiscount_purchaseOver25_15PercentDiscount() {
        Purchase purchase = new Purchase(PRICE_OVER_25, SINGLE_TACO, true);
        double result = discountService.calculateDiscount(purchase);

        assertThat(result).isEqualTo(0.15);
    }

    @Test
    void calculateDiscount_comboPurchaseOver25_20PercentDiscount() {
        Purchase purchase = new Purchase(PRICE_OVER_25, MULTIPLE_TACOS, true);
        double result = discountService.calculateDiscount(purchase);

        assertThat(result).isEqualTo(0.20);
    }

    @Test
    void calculateDiscount_comboPurchaseUnder25_15PercentDiscount() {
        Purchase purchase = new Purchase(PRICE_UNDER_25_AND_OVER_15, MULTIPLE_TACOS, true);
        double result = discountService.calculateDiscount(purchase);

        assertThat(result).isCloseTo(0.15, Offset.offset(0.01));
    }

    @Test
    void calculateDiscount_comboPurchaseUnder15_5PercentDiscount() {
        Purchase purchase = new Purchase(PRICE_UNDER_15, MULTIPLE_TACOS, true);
        double result = discountService.calculateDiscount(purchase);

        assertThat(result).isEqualTo(0.05);
    }
}