package com.company;

import com.company.VendingItems.Drink;
import com.company.VendingItems.VendingItem;
import com.company.VendingItems.VendingMachine;

public class Main {

    public static void main(String[] args) {

        // Read inventory in from CSV - FileReadDAO
        // Create vendingItem objects - FileReadDAO
        // Sort the HashMap by keys - FileReadDAO

        // Display user menu - cli
        // Print item inventory to terminal - cli
        // Input money - cli
        // Purchase item/remove from inventory/vend message - cli/FileWriteDAO
        // Write session to sales report - cli (hidden function)/FileWriteDAO
        // Reset Inventory - cli (hidden function)/FileWriteDAO

        VendingMachine vm = new VendingMachine();
        vm.runMachine();
    }
}