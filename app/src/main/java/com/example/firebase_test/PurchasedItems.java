package com.example.firebase_test;

import java.util.ArrayList;
import com.example.firebase_test.Item;

public class PurchasedItems {
    private ArrayList<Item> purchasedItems;

    public PurchasedItems() {
        this.purchasedItems = new ArrayList<>();
    }

    public ArrayList<Item> getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(ArrayList<Item> purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

    public void addPurchasedItem(Item item){
        purchasedItems.add(item);
    }
}
