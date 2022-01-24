package com.company;

import com.company.CLI;
import com.company.FileReaderDAO;
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
            int selection = CLI.getSelection(CLI.printMenu());
            if (selection == 4) {
                isRunning = false;
            }
            else {
                MainMenu(selection);
                }
            }
        }

    public void MainMenu(int selection) {
        switch (selection) {
            case 1 -> CLI.printInventory(items);
            case 2 -> {
                int cash = CLI.getSelection(CLI.printCashTenderMenu());
                AddCash(cash);
            }
            case 3 -> {
                String itemCode = CLI.printPurchaseMenu(items);
                if (items.containsKey(itemCode)) {
                    VendingItem temp = items.get(itemCode);
                    if (1 > temp.getQuantity()) {
                        // print that item is out of stock
                    } else if (temp.getPrice() > cashTendered) {
                        // print insufficient funds
                    } else {
                        temp.vendItem();
                        items.put(temp.getCode(), temp);
                    }
                } else {
                    // print incorrect itemCode message
                }
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
}