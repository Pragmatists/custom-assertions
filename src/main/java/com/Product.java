package com;

public class Product {

    private Money price;

    private String name;

    public Product(Money price, String name) {
        this.price = price;
        this.name = name;
    }

    public Money getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
