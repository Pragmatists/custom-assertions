package com;

public class Assertions extends org.assertj.core.api.Assertions {
    public static OrderAssert assertThat(Order actual) {
        return new OrderAssert(actual);
    }
}
