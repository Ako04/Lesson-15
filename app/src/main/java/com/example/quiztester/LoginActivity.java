package com.example.quiztester;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import static com.example.quiztester.StoreDatabase.COLLUMN_EMAIL;
import static com.example.quiztester.StoreDatabase.COLLUMN_NAME;
import static com.example.quiztester.StoreDatabase.COLLUMN_PASSWORD;
import static com.example.quiztester.StoreDatabase.TABLE_NAME;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {

    Button btn_login, btn_register;
    StoreDatabase storeDatabase;
    SQLiteDatabase sqLiteDatabase;

    EditText et_useremail, et_userpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_login);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        storeDatabase = new StoreDatabase(this);
        sqLiteDatabase = storeDatabase.getWritableDatabase();

        et_useremail = findViewById(R.id.et_useremail);
        et_userpassword = findViewById(R.id.et_userpassword);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrationIntent = new Intent(LoginActivity.this, Registration.class);
                startActivity(registrationIntent);
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (TextUtils.isEmpty(et_useremail.getText())){
                    et_useremail.setError(getResources().getString(R.string.tolyk_toltyru));
                    return;
                }
                if (TextUtils.isEmpty(et_userpassword.getText())){
                    et_userpassword.setError(getResources().getString(R.string.tolyk_toltyru));
                    return;
                }

                String uEmail = et_useremail.getText().toString();
                String uPASS = et_userpassword.getText().toString();

                Cursor LoginCursor = sqLiteDatabase.rawQuery("SELECT * FROM "+ TABLE_NAME+" WHERE "+
                COLLUMN_EMAIL+"=? AND "+COLLUMN_PASSWORD+"=?", new String[]{uEmail, uPASS});

                if (LoginCursor != null && LoginCursor.getCount() > 0){
                    LoginCursor.moveToFirst();
                    String userName = LoginCursor.getString(LoginCursor.getColumnIndex(COLLUMN_NAME));

                    Toast.makeText(LoginActivity.this, "Welcome, "+userName, Toast.LENGTH_LONG).show();

                    Intent registrationIntent = new Intent(LoginActivity.this, MyCabinet.class);

                    registrationIntent.putExtra("name",userName);
                    registrationIntent.putExtra("email",uEmail);
                    registrationIntent.putExtra("password",uPASS);
                    startActivity(registrationIntent);

                }else{
                    Toast.makeText(LoginActivity.this, "Email or password error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void tildiOzgertu(String localeCode){

        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            config.setLocale(new Locale(localeCode.toLowerCase()));
        }else {
            config.locale = new Locale(localeCode.toLowerCase());
        }
        resources.updateConfiguration(config, dm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.kaz_lang:

                tildiOzgertu("kk");
                Intent intent = getIntent();
                finish();
                startActivity(intent);
                break;


            case R.id.rus_lang:

                tildiOzgertu("ru");
                Intent intent2 = getIntent();
                finish();
                startActivity(intent2);
                break;

            case R.id.eng_lang:

                tildiOzgertu("en");
                Intent intent3 = getIntent();
                finish();
                startActivity(intent3);
                break;

        }



        return true;
    }

}