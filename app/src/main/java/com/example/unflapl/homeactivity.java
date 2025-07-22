package com.example.unflapl;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class homeactivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginbutton;
    Button signupbutton;

    userdb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  // Removes the title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_homeactivity);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginbutton = findViewById(R.id.loginbutton);
        signupbutton = findViewById(R.id.Signupbutton);


        db = new userdb(this);


        loginbutton.setOnClickListener(v -> {
            // Get username and password from the EditText fields
            String enteredUsername = username.getText().toString();
            String enteredPassword = password.getText().toString();


            if (db.checkUser(enteredUsername, enteredPassword)) {

                Toast.makeText(homeactivity.this, "Login successful", Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(homeactivity.this, Personality_test.class);
                startActivity(intent);
            } else {

                Toast.makeText(homeactivity.this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        });


        signupbutton.setOnClickListener(v -> {
            Intent intent = new Intent(homeactivity.this, SignUp.class);
            startActivity(intent);
        });
    }
}
