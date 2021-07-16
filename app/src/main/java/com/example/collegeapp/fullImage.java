package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class fullImage extends AppCompatActivity {

    private PhotoView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        imageView=findViewById(R.id.fullImage);
        String image=getIntent().getStringExtra("Image");

        Glide.with(this).load(image).into(imageView);
    }
}