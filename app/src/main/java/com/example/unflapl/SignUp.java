package com.example.unflapl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText cpassword;
    Button loginbutton;
    Button signupbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);  // Removes the title bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        username = findViewById(R.id.username);
        password = findViewById(R.id.passwordv);
        cpassword = findViewById(R.id.cpassword);
        loginbutton = findViewById(R.id.logbutton);
        signupbutton = findViewById(R.id.signupbutton);

        userdb db = new userdb(this);

        loginbutton.setOnClickListener(v -> {
            // Navigate to homeactivity
            Intent intent = new Intent(SignUp.this, homeactivity.class);
            startActivity(intent);
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = 0;

                if (username.getText().toString().isEmpty()) {
                    username.setError("Please Enter Your User Name");
                } else {
                    c++;
                }
                if (password.getText().toString().isEmpty()) {
                    password.setError("Please Enter Your Password");
                } else {
                    c++;
                }
                if (cpassword.getText().toString().isEmpty()) {
                    cpassword.setError("Please Confirm Your Password");
                } else {
                    if (password.getText().toString().equals(cpassword.getText().toString())) {
                        c++;
                    } else {
                        Toast.makeText(SignUp.this, "Confirm Password does not match Password", Toast.LENGTH_SHORT).show();
                    }
                }

                if (c == 3) {
                    // Insert user with username and password
                    boolean result = db.insertUser(username.getText().toString(), password.getText().toString());

                    if (result) {
                        Toast.makeText(SignUp.this, "Successfully registered", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(SignUp.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}
