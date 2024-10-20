package com.example.clock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.clock.fragments.DatePickerFragment;
import com.example.clock.fragments.TimePickerFragment;

public class MainActivity extends AppCompatActivity {

    Button buttonDatePicker;
    Button buttonTimePicker;
    EditText editTextDate;
    EditText editTextTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find views by their IDs
        editTextDate = findViewById(R.id.editTextText);
        editTextTime = findViewById(R.id.editTextText2);
        buttonDatePicker = findViewById(R.id.button);
        buttonTimePicker = findViewById(R.id.button2);

        // Set up the DatePicker button click listener
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new DatePickerFragment and pass the reference of editTextDate
                DatePickerFragment datePickerDialog = new DatePickerFragment(editTextDate);
                datePickerDialog.show(getSupportFragmentManager(), "Date picker dialog");
            }
        });

        // Set up the TimePicker button click listener
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new TimePickerFragment and pass the reference of editTextTime
                TimePickerFragment timePickerDialog = new TimePickerFragment(editTextTime);
                timePickerDialog.show(getSupportFragmentManager(), "Time picker dialog");
            }
        });
    }
}
