package com.company;

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

        iFileReaderDAO fileReaderDAO = new FileReaderDAO("inventory.csv");
        VendingMachine vm = new VendingMachine((FileReaderDAO) fileReaderDAO);
        vm.runMachine();
    }
}
