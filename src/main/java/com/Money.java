package com;

import java.math.BigDecimal;

public class Money {

    public static final Money ZERO = new Money(0);

    private BigDecimal value;

    public Money(double value) {
        this.value = new BigDecimal(value);
    }

    public Money multiplyBy(double multiplier) {
        this.value = this.value.multiply(new BigDecimal(multiplier));
        return this;
    }

    public Money add(Money money) {
        this.value = this.value.add(money.value);
        return this;
    }
}
