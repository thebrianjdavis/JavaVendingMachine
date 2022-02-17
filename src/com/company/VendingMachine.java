package com.company;

import com.company.VendingItems.VendingItem;

import java.util.HashMap;

public class VendingMachine {

    // Fields store a sorted list of vending machine items, a DataAccessObject
    // and the value of the customer's cash tendered currently in the machine
    private HashMap<String, VendingItem> items;
    private final iFileReaderDAO fileIn;
    private int cashTendered;

    // These fields contain the values to direct user input through the menus
    // ...added to maintain loose coupling allowing easily changing source of
    // user input
    private final int printInventory = 1;
    private final int addCash = 2;
    private final int buyItem = 3;
    private final int returnChange = 4;
    private final int tenderOne = 11;
    private final int tenderFive = 12;
    private final int tenderTen = 13;
    private final int tenderTwenty = 14;

    // Constructor passes in DAO so source of information is determined before
    // machine is switched on
    public VendingMachine(FileReaderDAO dao) {
        this.fileIn = dao;
    }

    // Primary method runs machine until it is turned off
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

    // MainMenu contains logic to direct user input to appropriate methods
    private void MainMenu(int selection) {

        switch (selection) {
            case printInventory -> {
                CLI.printInventory(items);
            }
            case addCash -> {
                int cash = CLI.getSelection(CLI.printCashTenderMenu());
                AddCash(cash);
            }
            case buyItem -> {
                String itemCode = CLI.printPurchaseMenu(items);
                if (items.containsKey(itemCode)) {
                    VendingItem temp = items.get(itemCode);
                    if (1 > temp.getQuantity()) {
                        CLI.printMessage("Item is currently out of stock!");
                    } else if (temp.getPrice() > (double)cashTendered / 100) {
                        CLI.printMessage("Insufficient funds! Enter more cash to purchase " + temp.getName());
                    } else {
                        this.cashTendered -= temp.getPrice() * 100;
                        String message = temp.vendItem();
                        CLI.printMessage(message);
                        items.put(temp.getCode(), temp);
                    }
                } else {
                    CLI.printMessage("Item code not recognized!");
                }
            }
            case returnChange -> {
                MakeChange();
            }
        }
    }

    // AddCash method adds appropriate value to cash tendered based on
    // user input -- line between the %% comments can be commented out
    // if selection commands are hardware routed
    private void AddCash(int selection) {

        // %%%%%%%%%%%%
        selection += 10;
        // %%%%%%%%%%%%

        switch (selection) {
            case tenderOne -> cashTendered += 100;
            case tenderFive -> cashTendered += 500;
            case tenderTen -> cashTendered += 1000;
            case tenderTwenty -> cashTendered += 2000;
            default -> {}
        }
    }

    // MakeChange method calculates correct value of change to return
    // to the customer and routes change into CLI to print to screen
    private void MakeChange() {
        int change = this.cashTendered;
        int tens = 0;
        int fives = 0;
        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        while (change >= 1000) {
            tens++;
            change -= 1000;
        }
        while (change >= 500) {
            fives++;
            change -= 500;
        }
        while (change >= 100) {
            dollars++;
            change -= 100;
        }
        while (change >= 25) {
            quarters++;
            change -= 25;
        }
        while (change >= 10) {
            dimes++;
            change -= 10;
        }
        while (change >= 5) {
            nickels++;
            change -= 5;
        }
        CLI.printChange(this.cashTendered, tens, fives, dollars, quarters, dimes, nickels);
        this.cashTendered = change;
    }
}