package com.company;

public class Main {

    public static void main(String[] args) {

        // Write session to sales report - cli (hidden function)/FileWriteDAO
        // Reset Inventory - cli (hidden function)/FileWriteDAO

        // Configuration to set dependencies:
        String fileName = "inventory.csv";
        iFileReaderDAO fileReaderDAO = new FileReaderDAO(fileName);
//        String connectionString = null;
//        iFileReaderDAO fileReaderDAO = new DatabaseDAO(connectionString);

        // Creates and runs vending machine:
        VendingMachine vm = new VendingMachine((FileReaderDAO) fileReaderDAO);
        vm.runMachine();
    }
}
