package com.example.unflapl;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;
public class addictions extends AppCompatActivity {

    private CalendarView calendarView;
    private EditText addictionTriggersEditText;
    private CheckBox removeDistractionsCheckBox;
    private Spinner activitySpinner;
    private Button submitButton, communityLinkButton;
    private TextView selectedDateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addictions);


        calendarView = findViewById(R.id.calendarView);
        addictionTriggersEditText = findViewById(R.id.addictionTriggersEditText);
        removeDistractionsCheckBox = findViewById(R.id.removeDistractionsCheckBox);
        activitySpinner = findViewById(R.id.activitySpinner);
        submitButton = findViewById(R.id.submitButton);
        communityLinkButton = findViewById(R.id.communityLinkButton);
        selectedDateTextView = findViewById(R.id.selectedDateText);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.activities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(adapter);


        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            String selectedDate = "Selected Date: " + dayOfMonth + "/" + (month + 1) + "/" + year;
            selectedDateTextView.setText(selectedDate);
        });


        submitButton.setOnClickListener(v -> {
            String selectedDate = selectedDateTextView.getText().toString();
            String triggers = addictionTriggersEditText.getText().toString();
            boolean distractionsRemoved = removeDistractionsCheckBox.isChecked();
            String selectedActivity = activitySpinner.getSelectedItem().toString();

            String message = "Date Set: " + selectedDate + "\n" +
                    "Triggers: " + triggers + "\n" +
                    "Distractions Removed: " + distractionsRemoved + "\n" +
                    "Activity: " + selectedActivity;


            Toast.makeText(this, "All checked, ready to start your journey", Toast.LENGTH_LONG).show();
        });


        communityLinkButton.setOnClickListener(v -> {
            String url = "https://ccar.us/"; // Replace with the actual community URL
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}
