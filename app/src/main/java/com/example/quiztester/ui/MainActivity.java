package com.example.quiztester.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.quiztester.R;

public class MainActivity extends AppCompatActivity {
    TextView tv_surak1, tv_surak2, tv_surak3, tv_surak4;
    RadioButton rb_s1_jauap1, rb_s1_jauap2, rb_s1_jauap3, rb_s1_jauap4;
    RadioButton rb_s2_jauap1, rb_s2_jauap2, rb_s2_jauap3, rb_s2_jauap4;
    RadioButton rb_s3_jauap1, rb_s3_jauap2, rb_s3_jauap3, rb_s3_jauap4;
    RadioButton rb_s4_jauap1, rb_s4_jauap2, rb_s4_jauap3, rb_s4_jauap4;
    Button btn_check;
    String [] suraktar = {"0", "138+49=?", "138+59=?", "148+49=?", "158+59=?" };

    String [][] variant = {
            {"0", "0"},
            {"187", "177", "197", "147"},
            {"197", "199", "137", "157"},
            {"197", "207", "187", "177"},
            {"217", "214", "187", "177"},
    };

    String [] jauaptar = {"0", "187", "197", "197", "217"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_surak1 = findViewById(R.id.tv_surak1);
        tv_surak2 = findViewById(R.id.tv_surak2);
        tv_surak3 = findViewById(R.id.tv_surak3);
        tv_surak4 = findViewById(R.id.tv_surak4);

        rb_s1_jauap1 = findViewById(R.id.rb_s1_jauap1);
        rb_s1_jauap2 = findViewById(R.id.rb_s1_jauap2);
        rb_s1_jauap3 = findViewById(R.id.rb_s1_jauap3);
        rb_s1_jauap4 = findViewById(R.id.rb_s1_jauap4);

        rb_s2_jauap1 = findViewById(R.id.rb_s2_jauap1);
        rb_s2_jauap2 = findViewById(R.id.rb_s2_jauap2);
        rb_s2_jauap3 = findViewById(R.id.rb_s2_jauap3);
        rb_s2_jauap4 = findViewById(R.id.rb_s2_jauap4);

        rb_s3_jauap1 = findViewById(R.id.rb_s3_jauap1);
        rb_s3_jauap2 = findViewById(R.id.rb_s3_jauap2);
        rb_s3_jauap3 = findViewById(R.id.rb_s3_jauap3);
        rb_s3_jauap4 = findViewById(R.id.rb_s3_jauap4);

        rb_s4_jauap1 = findViewById(R.id.rb_s4_jauap1);
        rb_s4_jauap2 = findViewById(R.id.rb_s4_jauap2);
        rb_s4_jauap3 = findViewById(R.id.rb_s4_jauap3);
        rb_s4_jauap4 = findViewById(R.id.rb_s4_jauap4);

        btn_check = findViewById(R.id.btn_check);
        suraktarJinau();

        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tekseris(tv_surak1, rb_s1_jauap1, rb_s1_jauap2, 1);
                tekseris(tv_surak2, rb_s2_jauap1, rb_s2_jauap2, 2);
                tekseris(tv_surak3, rb_s3_jauap1, rb_s3_jauap2, 3);
                tekseris(tv_surak4, rb_s4_jauap1, rb_s4_jauap2, 4);


            }
        });


    }
    public void  tekseris(TextView tv_surak, RadioButton rb1, RadioButton rb2, int index){
        if (rb1.isChecked() &&
                rb1.getText().toString().equals(jauaptar[index])){
            tv_surak.setText(suraktar[index]+"\nRight");
            tv_surak.setTextColor(getResources().getColor(R.color.zhasyl));
        }else if (rb2.isChecked() &&
                rb2.getText().toString().equals(jauaptar[index])){
            tv_surak.setText(suraktar[index]+"\nRight");
            tv_surak.setTextColor(getResources().getColor(R.color.zhasyl));

        }else if (rb2.isChecked() &&
                rb2.getText().toString().equals(jauaptar[index])){
            tv_surak.setText(suraktar[index]+"\nRight");
            tv_surak.setTextColor(getResources().getColor(R.color.zhasyl));

        }else{
            tv_surak.setText(suraktar[index]+"\nWrong");
            tv_surak.setTextColor(getResources().getColor(R.color.kyzyl));

        }
    }
    public void suraktarJinau(){
        tv_surak1.setText(suraktar[1]);
        rb_s1_jauap1.setText(variant[1][0]);
        rb_s1_jauap2.setText(variant[1][1]);

        tv_surak2.setText(suraktar[2]);
        rb_s2_jauap1.setText(variant[2][0]);
        rb_s2_jauap2.setText(variant[2][1]);

        tv_surak3.setText(suraktar[3]);
        rb_s3_jauap1.setText(variant[3][0]);
        rb_s3_jauap2.setText(variant[3][1]);

        tv_surak4.setText(suraktar[4]);
        rb_s4_jauap1.setText(variant[4][0]);
        rb_s4_jauap2.setText(variant[4][1]);
    }
}