package com.lixar.drools_demo.model;

import java.math.BigDecimal;

// POJO representing a purchase made by a customer. The discount field will be
// set after the discountRules are applied by the Drools rule engine.
public class Purchase {

    private BigDecimal total;
    private int tacoCount;
    private boolean drinkIncluded;
    private double discount;

    public Purchase(BigDecimal total, int tacoCount, boolean drinkIncluded) {
        this.total = total;
        this.tacoCount = tacoCount;
        this.drinkIncluded = drinkIncluded;
        this.discount = 0;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public int getTacoCount() {
        return tacoCount;
    }

    public void setTacoCount(int tacoCount) {
        this.tacoCount = tacoCount;
    }

    public boolean isDrinkIncluded() {
        return drinkIncluded;
    }

    public void setDrinkIncluded(boolean drinkIncluded) {
        this.drinkIncluded = drinkIncluded;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
