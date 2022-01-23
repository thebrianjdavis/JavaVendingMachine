package com.company.VendingItems;

public class Gum extends VendingItem {
    public Gum(String code, String name, double price, int quantity) {
        super(code, name, price, quantity);
    }

    public String vendMessage() {
        return "Enjoy your gum! Chew, chew...";
    }
}
