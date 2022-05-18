package com.example.quiztester;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    TextView user_baba, user_anne, user_bro, user_babaPhone, user_AnnePhone, user_BroPhone;
    Button btn_call, btn_sms, btn_camera;
    Uri fileUri;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        user_babaPhone = findViewById(R.id.user_babaPhone);
        btn_call = findViewById(R.id.btn_call);
        btn_sms = findViewById(R.id.btn_sms);
        btn_camera = findViewById(R.id.btn_camera);
        imageView = findViewById(R.id.imageView);


        btn_call.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:8747512515"+user_babaPhone.getText()));
                startActivity(intent);
            }
        });

        btn_sms.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Uri uri = Uri.parse("smsto: "+user_babaPhone.getText());
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body", "Salem, siz proektke tirkeldiniz");
                startActivity(intent);
            }
        });

        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takePhoto();
            }

            public void takePhoto(){
                if (checkPermission()){
                    requestPermissions();
                }else{
                    CropImage.activity()
                            .setGuidelines(CropImageView.Guidelines.ON)
                            .start(this);

                }

            }
        });

        private boolean checkPermission() {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED){
                return false;
            }
            return true;
        }

        private static final int PERMISSION_REQUEST_CODE = 200;

        private void requestPermission(){
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    PERMISSION_REQUEST_CODE);
        }

        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){

                CropImage.ActivityResult result = CropImage.getActivityResult(data);

                if (resultCode == RESULT_OK){
                    fileUri = result.getUri();
                    imageView.setImageURI(fileUri);

                }else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                    Exception error = result.getError();
                }
            }
        }

    }
}