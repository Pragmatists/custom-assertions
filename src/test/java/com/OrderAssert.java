package com;

import org.assertj.core.api.AbstractAssert;

public class OrderAssert extends AbstractAssert<OrderAssert, Order> {
    public OrderAssert(Order actual) {
        super(actual, OrderAssert.class);
    }

    public OrderAssert isOpen() {
        isNotNull();

        if (actual.getStatus() != Order.OrderStatus.OPEN) {
            failWithMessage("Expected new order to have status <%s> but was <%s>", Order.OrderStatus.OPEN, actual.getStatus());
        }
        return this;
    }

    public OrderAssert hasNoApprovalDate() {
        isNotNull();
        if (actual.getApprovalDate() != null) {
            failWithMessage("Expected new order not to have Approval Date but date was <%s>", actual.getApprovalDate());
        }
        return this;
    }
}
