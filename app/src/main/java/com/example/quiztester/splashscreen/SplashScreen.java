package com.example.quiztester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    Animation rotateAnimation;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        imageView = findViewById(R.id.imageView);

        imageView.startAnimation(rotateAnimation);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){

                startActivity(new Intent(SplashScreen.this, ListActivity.class));
            }
        }, 3000);
    }
}