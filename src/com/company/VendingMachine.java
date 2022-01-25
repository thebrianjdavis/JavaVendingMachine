package com.company;

import com.company.VendingItems.VendingItem;

import java.util.HashMap;

public class VendingMachine {

    private HashMap<String, VendingItem> items;
    private final iFileReaderDAO fileIn = new FileReaderDAO("Inventory.csv");
    private double cashTendered;

    public void runMachine() {
        items = fileIn.getInventory();
        CLI.printWelcome();
        boolean isRunning = true;

        while (isRunning) {
            CLI.printCashTendered(cashTendered);
            int selection = CLI.getSelection(CLI.printMenu());
            if (selection == 5) {
                isRunning = false;
            }
            else {
                MainMenu(selection);
                }
            }
        }

    public void MainMenu(int selection) {
        switch (selection) {
            case 1 -> {
                CLI.printInventory(items);
            }
            case 2 -> {
                int cash = CLI.getSelection(CLI.printCashTenderMenu());
                AddCash(cash);
            }
            case 3 -> {
                String itemCode = CLI.printPurchaseMenu(items);
                if (items.containsKey(itemCode)) {
                    VendingItem temp = items.get(itemCode);
                    if (1 > temp.getQuantity()) {
                        CLI.printMessage("Item is currently out of stock!");
                    } else if (temp.getPrice() > cashTendered) {
                        CLI.printMessage("Insufficient funds! Enter more cash to purchase " + temp.getName());
                    } else {
                        this.cashTendered -= temp.getPrice();
                        String message = temp.vendItem();
                        CLI.printMessage(message);
                        items.put(temp.getCode(), temp);
                    }
                } else {
                    CLI.printMessage("Item code not recognized!");
                }
            }
            case 4 -> {
                MakeChange();
            }
        }
    }

    private void AddCash(int selection) {
        switch (selection) {
            case 1 -> cashTendered += 1;
            case 2 -> cashTendered += 5;
            case 3 -> cashTendered += 10;
            case 4 -> cashTendered += 20;
            default -> cashTendered += 0;
        }
    }

    private void MakeChange() {
        double change = Math.round(this.cashTendered*100.0)/100.0;
        int tens = 0;
        int fives = 0;
        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        while (change >= 10) {
            tens++;
            change -= 10;
        }
        while (change >= 5) {
            fives++;
            change -= 5;
        }
        while (change >= 1) {
            dollars++;
            change -= 1;
        }
        while (change >= 0.25) {
            quarters++;
            change -= 0.25;
        }
        while (change >= 0.10) {
            dimes++;
            change -= 0.10;
        }
        while (change >= 0.05) {
            nickels++;
            change -= 0.05;
        }
        CLI.printChange(this.cashTendered, tens, fives, dollars, quarters, dimes, nickels);
        this.cashTendered = change;
    }
}