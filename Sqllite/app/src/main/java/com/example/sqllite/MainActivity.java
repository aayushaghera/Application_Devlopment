package com.example.sqllite;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sqllite.DBHelper;
import com.example.sqllite.MainActivity2;
import com.example.sqllite.R;

public class MainActivity extends AppCompatActivity {

    private EditText usernameInput, passwordInput, repeatPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper dbHelper = new DBHelper(this);

        usernameInput = findViewById(R.id.usernameInput);
        passwordInput = findViewById(R.id.passwordInput);
        repeatPassword = findViewById(R.id.repeatPassword);
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();
                String rePassword = repeatPassword.getText().toString();
                if(username.isEmpty())
                    Toast.makeText(MainActivity.this, "Username field is empty", Toast.LENGTH_LONG).show();
                else if(password.isEmpty())
                    Toast.makeText(MainActivity.this, "Password field is empty", Toast.LENGTH_LONG).show();
                else if(rePassword.isEmpty())
                    Toast.makeText(MainActivity.this, "Repeat Password field is empty", Toast.LENGTH_LONG).show();
                else if(!password.equals(rePassword))
                    Toast.makeText(MainActivity.this, "Password doesn't match", Toast.LENGTH_LONG).show();
                else {
                    Log.d("adding","before adding");
                    dbHelper.addUser(username, password);
                    Log.d("after adding","after adding");
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    Log.d("intent call","call");
                    startActivity(intent);
                }
            }
        });
    }
}

//nds AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Instantiate DBHelper
//        DBHelper dbHelper = new DBHelper(this);
//
//        // Add a user
//        dbHelper.addUser("exampleUser", "examplePassword");
//
//        // Retrieve and display all users (for demonstration purposes)
//        Cursor cursor = dbHelper.getAllUsers();
//        if (cursor.moveToFirst()) {
//            do {
//                String username = cursor.getString(cursor.getColumnIndex("username"));
//                String password = cursor.getString(cursor.getColumnIndex("password"));
//                Log.d("DBHelper", "User: " + username + ", Password: " + password);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//}
//}
