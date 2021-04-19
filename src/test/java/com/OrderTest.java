package com;

import org.junit.jupiter.api.Test;

import static com.Assertions.assertThat;
import static com.Order.newOrder;

class OrderTest {

    @Test
    void creates_empty_open_order() {
        Order order = newOrder(new Customer("ACME"));

        assertThat(order.getStatus()).isEqualTo(Order.OrderStatus.OPEN);
        assertThat(order.getApprovalDate()).isNull();
        assertThat(order.getTotalCost()).isEqualTo(Money.ZERO);
        assertThat(order.getOrderedProducts()).isEmpty();
        assertThat(order.getCustomer()).isEqualTo(new Customer("ACME"));
    }

    @Test
    void creates_empty_open_order_improved() {
        Order order = newOrder(new Customer("ACME"));

        assertThat(order)
                .isOpen()
                .hasNoApprovalDate();
    }
}
