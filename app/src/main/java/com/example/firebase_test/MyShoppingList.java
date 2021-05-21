package com.example.firebase_test;

import java.util.ArrayList;
import java.util.UUID;
import com.example.firebase_test.Item;

public class MyShoppingList {
    private String uuid;
    private String name;
    private ArrayList<Item> items;

    public MyShoppingList(){

    }

    public MyShoppingList(String name) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        items = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItem(Item item){
        items.add(item);
    }

    @Override
    public String toString() {
        return "MyShoppingList{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

    public int size(){
        return items.size();
    }
}