package com;

public class OrderItem {

    private final Product product;
    private int quantity;
    private Money cost;

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        calculatePrice();
    }

    public void addItems(int quantity) {
        this.quantity += quantity;
        calculatePrice();
    }

    public void calculatePrice() {
        cost = product.getPrice().multiplyBy(quantity);
    }

    public Money getCost() {
        return cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

}
