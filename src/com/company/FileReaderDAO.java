package com.company;

import com.company.VendingItems.Candy;
import com.company.VendingItems.Chips;
import com.company.VendingItems.Drink;
import com.company.VendingItems.Gum;
import com.company.VendingItems.VendingItem;

import java.nio.file.Path;
import java.util.*;

public class FileReaderDAO implements iFileReaderDAO {

    private final Path filePath;

    public FileReaderDAO(String fileName) {
        this.filePath = Path.of(fileName);
    }

    public HashMap<String, VendingItem> getInventory() {
        HashMap<String, VendingItem> inventory = new HashMap<>();
        HashMap<String, VendingItem> items = new LinkedHashMap<>();

        try {
            Scanner fileRead = new Scanner(this.filePath);
            while (fileRead.hasNextLine()) {
                String[] line = fileRead.nextLine().split(",");
                String code = line[0];
                String name = line[1];
                double price = Double.parseDouble(line[2]);
                int quantity = 5;
                switch(line[3]) {
                    case "Candy":
                        Candy tempA = new Candy(code, name, price, quantity);
                        inventory.put(code, tempA);
                        break;
                    case "Chip":
                        Chips tempB = new Chips(code, name, price, quantity);
                        inventory.put(code, tempB);
                        break;
                    case "Drink":
                        Drink tempC = new Drink(code, name, price, quantity);
                        inventory.put(code, tempC);
                        break;
                    case "Gum":
                        Gum tempD = new Gum(code, name, price, quantity);
                        inventory.put(code, tempD);
                        break;
                    default:
                        VendingItem tempE = new VendingItem(code, name, price, quantity);
                        inventory.put(code, tempE);
                }
            }
            items = sortList(inventory);
        }
        catch (Exception e) {
            System.err.println("### ERROR READING .CSV FILE ###");
            System.err.println(e);
        }

        return items;
    }

    private HashMap<String, VendingItem> sortList(HashMap<String, VendingItem> inventory) {

        HashMap<String, VendingItem> items = new LinkedHashMap<>();
        List<Map.Entry<String, VendingItem>> inventoryList = new LinkedList<>(inventory.entrySet());

        inventoryList.sort(Map.Entry.comparingByKey());

        for (Map.Entry<String, VendingItem> temp : inventoryList) {
            items.put(temp.getKey(), temp.getValue());
        }

        return items;
    }
}
