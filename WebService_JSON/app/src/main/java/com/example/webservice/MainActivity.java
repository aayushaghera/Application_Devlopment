package com.example.webservice;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<String> studentlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_item);
        studentlist = new ArrayList<>();

        String jsonData = "[{'name':'aayush','city':'rajkot'},"
                           + "{'name':'neha','city':'rajkot'},"
                           + "{'name':'kaushil','city':'rajkot'}]";

        try {
            JSONArray jsonArray = new JSONArray(jsonData);

            for(int i = 0; i<jsonArray.length();i++)
            {
                JSONObject student = jsonArray.getJSONObject(i);
                String name = student.getString("name");
                String city = student.getString("city");

                studentlist.add(name +"-" + city );
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,studentlist);
            listView.setAdapter(adapter);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}