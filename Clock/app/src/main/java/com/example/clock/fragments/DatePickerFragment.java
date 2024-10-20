
package com.example.clock.fragments;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private EditText editTextDate; // Will hold reference to EditText defined in MainActivity

    // Constructor to receive EditText from MainActivity
    public DatePickerFragment(EditText editText) {
        this.editTextDate = editText; // Store the reference of EditText provided by MainActivity
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(requireContext(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        editTextDate.setText(String.format("%02d-%02d-%04d", day, month + 1, year)); // Set the selected date in EditText with proper formatting (DD-MM-YYYY)
    }
}
