package com.company.VendingItems;

public class Chips extends VendingItem {
    public Chips(String code, String name, double price, int quantity) {
        super(code, name, price, quantity);
    }

    public String vendMessage() {
        return "Enjoy your chips! Crunch, crunch...";
    }
}
