package com.company.VendingItems;

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

    public double getPrice() {
        return this.price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(code + "   \t");
        if (18 > name.length()) {
            while (18 > name.length()) {
                name += " ";
            }
        }
        output.append(name + "\t");
        output.append("$" + String.format("%.2f", price) + "\t");
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
