package com.example.quiztester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyCabinet extends AppCompatActivity {
    CircleImageView user_image;
    TextView user_email, user_password, user_name;
    Button start_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cabinet);
        user_image = findViewById(R.id.user_image);

        Intent intent = getIntent();
        String uName = intent.getStringExtra("name");
        String uEmail = intent.getStringExtra("email");
        String uPass = intent.getStringExtra("password");

        user_name = findViewById(R.id.user_name);
        user_email = findViewById(R.id.user_email);
        user_password = findViewById(R.id.user_password);

        user_name.setText("User name: "+uName);
        user_email.setText("User email: "+uEmail);
        user_password.setText("User password: "+uPass);

        Glide.with(this)
                .load("https://avatars.mds.yandex.net/i?id=c7b7747ced16072f3c15805c28519d2e-5467540-images-thumbs&n=13&exp=1")
                .centerCrop()
                .placeholder(R.drawable.ic_baseline_account_circle_24)
                .into(user_image);

        start_test = findViewById(R.id.start_test);
        start_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyCabinet.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}