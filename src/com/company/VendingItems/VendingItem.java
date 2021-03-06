package com.company.VendingItems;

// Superclass for the four vending item types
public class VendingItem {
    private String code;
    private String name;
    private double price;
    private int quantity;

    public VendingItem(String code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(code).append("   \t");
        StringBuilder tempName = new StringBuilder(this.name);
        if (18 > tempName.length()) {
            while (18 > tempName.length()) {
                tempName.append(" ");
            }
        }
        output.append(tempName).append("\t");
        output.append("$").append(String.format("%.2f", price)).append("\t");
        output.append(quantity);
        return output.toString();
    }

    public String vendItem() {
        quantity--;
        return vendMessage();
    }

    public String vendMessage() {
        return "Enjoy your item!";
    }
}
