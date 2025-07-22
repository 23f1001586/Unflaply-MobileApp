package com.example.unflapl;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Personality_test extends AppCompatActivity {

    private RadioGroup radioGroupPersonality;
    private Button btnSubmitPersonality;
    private TextView btnLinkToTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality_test);
        radioGroupPersonality = findViewById(R.id.radioGroupPersonality);
        btnSubmitPersonality = findViewById(R.id.btnSubmitPersonality);
        btnLinkToTest = findViewById(R.id.btnLinkToTest);
        btnLinkToTest.setMovementMethod(LinkMovementMethod.getInstance());
        btnSubmitPersonality.setOnClickListener(v -> {
            int selectedId = radioGroupPersonality.getCheckedRadioButtonId();
            if (selectedId == -1) {
                Toast.makeText(Personality_test.this, "Please select a personality type", Toast.LENGTH_SHORT).show();
            } else {
                RadioButton selectedRadioButton = findViewById(selectedId);
                String personalityType = selectedRadioButton.getText().toString();

               Intent intent = new Intent(Personality_test.this, options.class);
                intent.putExtra("personalityType", personalityType);
                startActivity(intent);
            }
        });
        btnLinkToTest.setText("Take the personality test: https://www.16personalities.com");
    }
}