package com.company.VendingItems;

import com.company.CLI;
import com.company.FileReaderDAO;
import java.util.HashMap;

public class VendingMachine {

    private HashMap<String, VendingItem> items;
    private FileReaderDAO fileIn = new FileReaderDAO("Inventory.csv");
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
            case 1:
                CLI.printInventory(items);
                break;
            case 2:
                int cash = CLI.getSelection(CLI.printCashTenderMenu());
                AddCash(cash);
                break;
            case 3:

                break;
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