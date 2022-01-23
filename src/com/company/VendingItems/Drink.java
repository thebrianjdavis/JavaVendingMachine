package com.company.VendingItems;

public class Drink extends VendingItem {
    public Drink(String code, String name, double price, int quantity) {
        super(code, name, price, quantity);
    }

    public String vendMessage() {
        return "Enjoy your drink! Gulp, gulp...";
    }
}
