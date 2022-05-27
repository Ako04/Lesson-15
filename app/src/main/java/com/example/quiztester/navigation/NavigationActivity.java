package com.example.quiztester.navigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quiztester.R;
import com.example.quiztester.fragments.FragmentAnne;
import com.example.quiztester.fragments.FragmentBaba;
import com.example.quiztester.fragments.FragmentBro;
import com.example.quiztester.fragments.FragmentKardes;

public class NavigationActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_baba, btn_anne, btn_bro, btn_kardes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        btn_baba = findViewById(R.id.btn_baba);
        btn_anne = findViewById(R.id.btn_anne);
        btn_bro = findViewById(R.id.btn_bro);
        btn_kardes = findViewById(R.id.btn_kardes);

        btn_baba.setOnClickListener(this);
        btn_anne.setOnClickListener(this);
        btn_bro.setOnClickListener(this);
        btn_kardes.setOnClickListener(this);

        changeFragment(new FragmentBaba());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_baba:
                changeFragment(new FragmentBaba());

                break;
            case R.id.btn_anne:
                changeFragment(new FragmentAnne());

                break;
            case R.id.btn_bro:
                changeFragment(new FragmentBro());

                break;
            case R.id.btn_kardes:
                changeFragment(new FragmentKardes());

                break;
        }
    }
    public void changeFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (fragmentManager != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment);
            fragmentTransaction.commit();
        }

    }
}