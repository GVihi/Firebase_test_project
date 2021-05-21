package com.example.firebase_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.firebase_test.MyShoppingList;
import com.example.firebase_test.Item;
import com.example.firebase_test.List;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello World!");

        List list = new List();

        for (int i = 0; i < 10; i++) {
            Random r = new Random();
            String[] slNames = {"Špar", "Big bang", "Merkur", "Dipo", "Hrana", "Fitnes"};
            MyShoppingList temp = new MyShoppingList(slNames[r.nextInt(slNames.length)]);
            for (int j = 0; j < 10; j++) {
                r = new Random();
                String[] itemNames = {"Banana", "Apple", "PC", "Bread", "Water", "Proteins", "Tooth paste", "Thermal paste", "Wrench", "Phone",
                        "Nutella", "Keyboard", "Screwdriver", "Drill", "USB-C cable"};
                String itemName = itemNames[r.nextInt(itemNames.length)];

                r = new Random();
                int[] qtArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
                int qt = qtArray[r.nextInt(qtArray.length)];

                r = new Random();
                Item.Measurement[] m = Item.Measurement.values();
                Item.Measurement me = m[r.nextInt(m.length)];

                r = new Random();
                Item.Category[] c = Item.Category.values();
                Item.Category ct = c[r.nextInt(c.length)];

                Item tempItem = new Item(itemName, qt, me, ct);
                temp.addItem(tempItem);
            }
            list.addShoppingList(temp);
        }
        myRef = database.getReference("Shopping Lists");
        myRef.setValue(list);
    }
}