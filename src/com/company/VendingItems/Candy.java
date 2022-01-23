package com.company.VendingItems;

public class Candy extends VendingItem {
    public Candy(String code, String name, double price, int quantity) {
        super(code, name, price, quantity);
    }

    public String vendMessage() {
        return "Enjoy your candy! Yum, yum...";
    }
}
