package com;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Order {

    public enum OrderStatus {
        OPEN,
        APPROVED,
        CANCELLED
    }

    private final Customer client;
    private final List<OrderItem> items;
    private Money totalCost;
    private LocalDate approvalDate;
    private OrderStatus status;


    public static Order newOrder(Customer client) {
        return new Order(client, Money.ZERO, OrderStatus.OPEN);
    }

    protected Order(Customer client, Money initialCost, OrderStatus initialStatus) {
        this.client = client;
        totalCost = initialCost;
        status = initialStatus;
        items = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        isOpen();

        OrderItem item = find(product);
        if (item == null) {
            items.add(new OrderItem(product, quantity));
        } else {
            item.addItems(quantity);
        }

        calculatePrice();
    }

    public void approve() {
        isOpen();

        status = OrderStatus.APPROVED;
        approvalDate = LocalDate.now();
    }

    private void isOpen() {
        if (status != OrderStatus.OPEN)
            throw new RuntimeException("Operation not allowed");
    }

    public void cancel() {
        if (status != OrderStatus.APPROVED)
            throw new RuntimeException("Operation not allowed");

        status = OrderStatus.CANCELLED;
    }

    private void calculatePrice() {
        totalCost = Money.ZERO;
        for (OrderItem item : items) {
            totalCost = totalCost.add(item.getCost());
        }
    }

    private OrderItem find(Product product) {
        for (OrderItem item : items) {
            if (product.equals(item.getProduct()))
                return item;
        }
        return null;
    }


    public Money getTotalCost() {
        return totalCost;
    }

    public List<OrderItem> getOrderedProducts() {
        List<OrderItem> result = new ArrayList<>(items.size());
        for (OrderItem item : items) {
            result.add(new OrderItem(item.getProduct(), item.getQuantity()));
        }
        return Collections.unmodifiableList(result);
    }

    public LocalDate getApprovalDate() {
        return approvalDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return client;
    }

}
