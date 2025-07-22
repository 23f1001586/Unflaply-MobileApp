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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;


import androidx.appcompat.app.AppCompatActivity;

public class relationships extends AppCompatActivity {

    private VideoView videoView1, videoView2, videoView3;
    private ImageButton bookLinkButton1, bookLinkButton2, bookLinkButton3;
    private Button pauseButton1;
    private Button pauseButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relationships);


        videoView1 = findViewById(R.id.videoView2);
        videoView2 = findViewById(R.id.videoView);
        pauseButton1 = findViewById(R.id.button5);
        pauseButton2= findViewById(R.id.button6);





        bookLinkButton1 = findViewById(R.id.imageButton8);
        bookLinkButton2 = findViewById(R.id.imageButton11);
        bookLinkButton3 = findViewById(R.id.imageButton12);


        setVideoView(videoView1, R.raw.video1);
        setVideoView(videoView2, R.raw.video2);

        pauseButton1.setOnClickListener(v -> {
            if (videoView1.isPlaying()) {
                videoView1.pause();
                pauseButton1.setText("Resume");
            } else {
                videoView1.start();
                pauseButton1.setText("Pause");
            }
        });
        pauseButton2.setOnClickListener(v -> {
            if (videoView2.isPlaying()) {
                videoView2.pause();
                pauseButton2.setText("Resume");  // Change button text to 'Resume'
            } else {
                videoView2.start();  // Resume the video
                pauseButton2.setText("Pause");  // Change button text to 'Pause'
            }
        });
        bookLinkButton1.setOnClickListener(v -> openBookLink("https://www.amazon.in/Art-Friendship-Creating-Keeping-Relationships/dp/0764234439"));
        bookLinkButton2.setOnClickListener(v -> openBookLink("https://www.amazon.in/Friendship-Evolution-Biology-Extraordinary-Fundamental/dp/0393651541"));
        bookLinkButton3.setOnClickListener(v -> openBookLink("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.amazon.in%2FBig-Friendship-Keep-Other-Close-ebook%2Fdp%2FB0888SLWTN&psig=AOvVaw05AiF-F0gk4j6hd3lzyIb_&ust=1735249223489000&source=images&cd=vfe&opi=89978449&ved=0CAMQjB1qFwoTCOCfg6Xxw4oDFQAAAAAdAAAAABAE"));
    }
    private void setVideoView(VideoView videoView, int videoResId) {
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + videoResId);
        videoView.setVideoURI(videoUri);
        videoView.setOnPreparedListener(mp -> {
            mp.setLooping(true);  // Loop the video
        });
        videoView.start();
    }
    private void openBookLink(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}