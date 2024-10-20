package com.example.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    // List of scientists
    private String[] scientists = {
            "Virat Kohli",
            "Rohit Sharma",
            "KL Rahul",
            "Jasprit Bumrah",
            "MS Dhoni",
            "Hardik Pandya",
            "Shikhar Dhawan",
            "Ravindra Jadeja",
            "Rishabh Pant"

    };

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.list_item);


        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                scientists
        );

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = (String) parent.getItemAtPosition(position);


                Toast.makeText(MainActivity.this, "You selected " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
