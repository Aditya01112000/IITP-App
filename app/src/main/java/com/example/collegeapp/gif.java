package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.TaskStackBuilder;

import com.bumptech.glide.Glide;
import com.example.collegeapp.R;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

public class gif extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);
        imageView=findViewById(R.id.gif);
        preferences=this.getSharedPreferences("splash",MODE_PRIVATE);
        editor=preferences.edit();
        Glide.with(this).asGif().load(R.drawable.giphy).into(imageView);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                         startActivity(new Intent(gif.this,MainActivity.class));
            }
        },4000);
    }
}