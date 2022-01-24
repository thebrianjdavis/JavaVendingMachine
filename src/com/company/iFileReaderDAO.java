package com.company;

import com.company.VendingItems.VendingItem;

import java.util.HashMap;

public interface iFileReaderDAO {

    public HashMap<String, VendingItem> getInventory();

}
