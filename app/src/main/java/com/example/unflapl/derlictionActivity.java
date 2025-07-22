package com.example.unflapl;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import java.util.Calendar;
public class derlictionActivity extends AppCompatActivity {
    EditText editText1, editText2, editText3;
    Button timePickerButton1, timePickerButton2, timePickerButton3;
    TextView selectedTimeText;
    int hour1, minute1, hour2, minute2, hour3, minute3;
    Handler handler;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derliction);


        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        timePickerButton1 = findViewById(R.id.timePicker1);
        timePickerButton2 = findViewById(R.id.timePicker2);
        timePickerButton3 = findViewById(R.id.timePicker3);
        selectedTimeText = findViewById(R.id.selectedTime);


        mediaPlayer = MediaPlayer.create(this, R.raw.notification); // Make sure the sound file is in res/raw


        handler = new Handler();


        timePickerButton1.setOnClickListener(v -> showTimePickerDialog(1));


        timePickerButton2.setOnClickListener(v -> showTimePickerDialog(2));


        timePickerButton3.setOnClickListener(v -> showTimePickerDialog(3));


        handler.postDelayed(timeCheckRunnable, 1000);
    }

    // Show TimePicker Dialog and store selected time
    private void showTimePickerDialog(int taskId) {
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, (view, hourOfDay, minute) -> {
            if (taskId == 1) {
                hour1 = hourOfDay;
                minute1 = minute;
            } else if (taskId == 2) {
                hour2 = hourOfDay;
                minute2 = minute;
            } else if (taskId == 3) {
                hour3 = hourOfDay;
                minute3 = minute;
            }
            updateTimeText();
        }, currentHour, currentMinute, true);
        timePickerDialog.show();
    }


    private void updateTimeText() {
        StringBuilder timeText = new StringBuilder();

        timeText.append("Task 1 Deadline: ").append(hour1).append(":").append(minute1).append("\n");
        timeText.append("Task 2 Deadline: ").append(hour2).append(":").append(minute2).append("\n");
        timeText.append("Task 3 Deadline: ").append(hour3).append(":").append(minute3).append("\n");

        selectedTimeText.setText(timeText.toString());
    }


    private final Runnable timeCheckRunnable = new Runnable() {
        @Override
        public void run() {

            Calendar calendar = Calendar.getInstance();
            int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
            int currentMinute = calendar.get(Calendar.MINUTE);


            if (currentHour == hour1 && currentMinute == minute1) {
                playSound();
            }
            if (currentHour == hour2 && currentMinute == minute2) {
                playSound();
            }
            if (currentHour == hour3 && currentMinute == minute3) {
                playSound();
            }


            handler.postDelayed(this, 1000);
        }
    };


    private void playSound() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        handler.removeCallbacks(timeCheckRunnable);
    }
}