package com.example.unflapl;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class options extends AppCompatActivity {
    Button finance;
    Button derliction;
    Button relationship;
    Button Behavioural;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_options);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        finance = findViewById(R.id.button1);
        derliction = findViewById(R.id.button2);
        relationship = findViewById(R.id.button3);
        Behavioural = findViewById(R.id.button4);


        finance.setOnClickListener(v -> {
            Intent intent = new Intent(options.this, Financial2.class);
            startActivity(intent);
        });

       derliction.setOnClickListener(v -> {
            Intent intent = new Intent(options.this, derlictionActivity.class);
            startActivity(intent);
        });

       relationship.setOnClickListener(v -> {
            Intent intent = new Intent(options.this, addictions.class);
            startActivity(intent);
        });

        Behavioural.setOnClickListener(v -> {
            Intent intent = new Intent(options.this, relationships.class);
            startActivity(intent);
        });
    }
}
