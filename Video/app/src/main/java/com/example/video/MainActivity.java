package com.example.video;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    VideoView videodisplay;
    Button Video;
    private Uri videoUri;

    private static final int REQUEST_VIDEO_CAPTURE = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        videodisplay = findViewById(R.id.videoView);
        Video = findViewById(R.id.button);

    Video.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intentvid = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
            startActivityForResult(intentvid,REQUEST_VIDEO_CAPTURE);

        }
    });

    }

    @Override
    protected void onActivityResult(int requestCode , int resultCode ,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==REQUEST_VIDEO_CAPTURE && resultCode == RESULT_OK)
        {
              videoUri = data.getData();
              videodisplay.setVideoURI(videoUri);
              videodisplay.start();
              MediaStore.Video.Media.getContentUri("video demo");
        }
    }
}