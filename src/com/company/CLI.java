package com.company;

import com.company.VendingItems.VendingItem;

import java.util.HashMap;
import java.util.Scanner;

public class CLI {

    public static Scanner userInput = new Scanner(System.in);

    public static void printWelcome() {
        System.out.println("Welcome to Java Vending Machine!");
        try {
            Thread.sleep(4000);
            clearScreen();
        }
        catch (Exception e) {
            System.err.println("### ERROR IN WELCOME MESSAGE ###");
            System.err.println(e);
        }
    }

    public static String printMenu() {
        String first = "Please select from the following:\n";
        String second = "(1) View Inventory\n(2) Add Currency\n(3) Purchase An Item\n(4) Return Change\n(5) Exit\n";
        return first + second;
    }

    public static void printInventory(HashMap<String, VendingItem> items) {
        clearScreen();
        System.out.println("Code:\tItem:\t\t\t\tPrice:\tQuantity:");
        for (String itemCode : items.keySet()) {
            System.out.println(items.get(itemCode));
        }
        System.out.println("\nPress (1) to continue...");
        String finished = "no";
        while (finished.equals("no")) {
            finished = userInput.nextLine();
        }
    }

    public static void printCashTendered(int cashTendered) {
        clearScreen();
        double cash = (double)cashTendered / 100;
        String first = "Cash Tendered: ";
        String second = "$" + String.format("%.2f", cash);
        System.out.println(first + second);
    }

    public static void printMessage(String message) {
        clearScreen();
        System.out.println(message);
        try{
            Thread.sleep(3000);
        }
        catch (Exception i) {
            System.err.println("### COMMAND FAILED: RESET MACHINE ###");
        }
        clearScreen();
    }

    public static String printCashTenderMenu() {
        clearScreen();
        String first = "Please insert cash below:\n\n";
        String second = "(1) $1\n(2) $5\n(3) $10\n(4) $20\n(5) Back to main menu\n\n";
        String third = "This machine does not accept $2 or $50 bills\n";
        return first + second + third;
    }

    public static String printPurchaseMenu(HashMap<String, VendingItem> items) {
        clearScreen();
        StringBuilder sb = new StringBuilder();
        sb.append("Code:\tItem:\t\t\t\tPrice:\tQuantity:\n");
        for (String itemCode : items.keySet()) {
            sb.append(items.get(itemCode));
            sb.append("\n");
        }
        sb.append("\nEnter item code to purchase: ");
        return getItemCode(sb.toString());
    }

    public static void printChange(int total, int tens, int fives, int dollars, int quarters, int dimes, int nickels) {
        clearScreen();
        double dubTotal = (double)total/100;
        String ten = (tens != 1) ? " tens" : " ten";
        String five = (fives != 1) ? " fives" : " five";
        String dollar = (dollars != 1) ? " dollars" : " dollar";
        String quarter = (quarters != 1) ? " quarters" : " quarter";
        String dime = (dimes != 1) ? " dimes" : " dime";
        String nickel = (nickels != 1) ? " nickels" : " nickel";
        System.out.println(tens + ten  + " dispensed");
        System.out.println(fives + five + " dispensed");
        System.out.println(dollars + dollar + " dispensed");
        System.out.println(quarters + quarter + " dispensed");
        System.out.println(dimes + dime + " dispensed");
        System.out.println(nickels + nickel + " dispensed");
        System.out.println("$" + String.format("%.2f", dubTotal) + " total change dispensed");
        try {
            Thread.sleep(7000);
        }
        catch (Exception ignored) {

        }
        clearScreen();
    }

    public static int getSelection(String prompt) {
        boolean hasSelection = false;
        int selection = -1;
        while (!hasSelection) {
            System.out.println(prompt);
            String word = userInput.nextLine();
            try {
                selection = Integer.parseInt(word);
                if (6 > selection && -1 < selection) {
                    hasSelection = true;
                    clearScreen();
                }
                else {
                    clearScreen();
                    System.out.println("Invalid input! Please select again!");
                    Thread.sleep(3000);
                    clearScreen();
                }
            }
            catch (Exception ignored) {

            }
        }
        return selection;
    }

    public static String getItemCode(String prompt) {
        boolean hasSelection = false;
        String itemCode = "";
        while (!hasSelection) {
            System.out.println(prompt);
            itemCode = userInput.nextLine().toUpperCase();
            if (!itemCode.equals("")) {
                hasSelection = true;
            }
            clearScreen();
        }
        return itemCode;
    }

    private static void clearScreen() {
        for (int i = 0; i < 25; i++) {
            System.out.println("\n ");
        }
    }
}
