package com.example.firebase_test;

import java.util.ArrayList;

public class List {
    private ArrayList<MyShoppingList> lists;

    public List() {
        lists = new ArrayList<>();
    }

    public ArrayList<MyShoppingList> getLists() {
        return lists;
    }

    public void addShoppingList(MyShoppingList li){
        lists.add(li);
    }

    public int size(){
        return lists.size();
    }
}
