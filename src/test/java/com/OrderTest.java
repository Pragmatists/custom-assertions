package com;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.Order.newOrder;

class OrderTest {

    @Test
    void creates_empty_open_order() {
        Order order = newOrder(new Customer("ACME"));

        Assertions.assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.OPEN);
        Assertions.assertThat(order.getApprovalDate()).isNull();
        Assertions.assertThat(order.getTotalCost()).isEqualTo(Money.ZERO);
        Assertions.assertThat(order.getOrderedProducts()).isEmpty();
        Assertions.assertThat(order.getCustomer()).isEqualTo(new Customer("ACME"));
    }
}
