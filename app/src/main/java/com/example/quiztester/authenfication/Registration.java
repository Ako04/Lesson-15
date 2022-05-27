package com.example.quiztester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.quiztester.StoreDatabase.COLLUMN_EMAIL;
import static com.example.quiztester.StoreDatabase.COLLUMN_NAME;
import static com.example.quiztester.StoreDatabase.COLLUMN_PASSWORD;
import static com.example.quiztester.StoreDatabase.TABLE_NAME;

public class Registration extends AppCompatActivity {

    EditText et_username, et_useremail, et_userpassword;
    Button btn_register;
    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        btn_register = findViewById(R.id.btn_register);

        et_useremail = findViewById(R.id.et_useremail);
        et_username = findViewById(R.id.et_username);
        et_userpassword = findViewById(R.id.et_userpassword);
        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(et_username.getText())){
                    et_username.setError("Tolyk toltyrynyz");
                    return;
                }
                if (TextUtils.isEmpty(et_useremail.getText())){
                    et_useremail.setError("Tolyk toltyrynyz");
                    return;
                }
                if (TextUtils.isEmpty(et_userpassword.getText())){
                    et_userpassword.setError("Tolyk toltyrynyz");
                    return;
                }

                ContentValues values = new ContentValues();
                values.put(COLLUMN_NAME, et_username.getText().toString());
                values.put(COLLUMN_EMAIL, et_useremail.getText().toString());
                values.put(COLLUMN_PASSWORD, et_userpassword.getText().toString());

                sqLiteDatabase.insert(TABLE_NAME, null, values);



                Intent registrationIntent = new Intent(Registration.this, LoginActivity.class);
                startActivity(registrationIntent);

            }
        });
    }
}