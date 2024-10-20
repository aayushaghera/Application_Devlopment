package com.example.exp_6;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView photodisplay;
    Button photo;

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        photodisplay = findViewById(R.id.imageView);
        photo = findViewById(R.id.button);

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentcam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentcam, REQUEST_IMAGE_CAPTURE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data );
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
        {
             Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            photodisplay.setImageBitmap(imageBitmap);
            MediaStore.Images.Media.insertImage(getContentResolver(),imageBitmap,"Image","Image Info");

        }
    }
}