package com.example.firebase_test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.example.firebase_test.MyShoppingList;
import com.example.firebase_test.Item;
import com.example.firebase_test.List;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public List readList;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.textViewList);
        tv.setMovementMethod(new ScrollingMovementMethod());

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

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                readList = dataSnapshot.getValue(List.class);
                String list0 = "";
                for(int j = 0; j < readList.size(); j++) {
                    list0 = list0 + readList.getLists().get(j).getName();
                    list0 = list0 + ":\n";
                    for (int i = 0; i < readList.getLists().get(j).size(); i++) {
                        list0 = list0 + "     ";
                        list0 = list0 + readList.getLists().get(j).getItems().get(i).getItemName();
                        list0 = list0 + ",\n";
                    }
                }


                tv.setText(list0);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getBaseContext(), "Failed to read from database", Toast.LENGTH_SHORT).show();
            }
        });



    }
}