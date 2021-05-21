package com.example.firebase_test;

import java.util.UUID;

public class Item {
    public enum Measurement {
        g,
        kg,
        l,
        ml,
        amount
    }

    public enum Category{ //List will expand as app develops
        food,
        clothes,
        toys,
        drinks,
        pets,
        tech,
        noCategory
    }

    public static final int DEFAULT_QUANTITY = 1;
    public static final Measurement DEFAULT_MEASUREMENT = Measurement.amount;
    public static final Category DEFAULT_CATEGORY = Category.noCategory;

    private String uuid;
    private String itemName;
    private int quantity;
    private Measurement measurement;
    private Category category;
    private Boolean purchased;
    private double latitude, longitude;


    public Item(String itemName, int quantity, Measurement measurement, Category category) {
        this.uuid = UUID.randomUUID().toString();
        this.itemName = itemName;
        this.quantity = quantity;
        this.measurement = measurement;
        this.category = category;
        this.purchased = false;
        this.latitude = 0;
        this.longitude = 0;
    }

    public Item(String itemName){
        this(itemName, DEFAULT_QUANTITY, DEFAULT_MEASUREMENT, DEFAULT_CATEGORY);
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Measurement getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Measurement measurement) {
        this.measurement = measurement;
    }

    public String getUuid() {
        return uuid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void wasPurchased(){
        purchased = true;
    }

    public void wasPurchasedCancel(){purchased = false;}

    public Boolean getPurchased() {
        return purchased;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
