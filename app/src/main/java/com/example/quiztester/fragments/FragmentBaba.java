package com.example.quiztester.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.quiztester.R;

public class FragmentBaba extends Fragment {
    View view;
    TextView textView, user_babaPhone;
    Button btn_call, btn_sms;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);
        btn_call = view.findViewById(R.id.btn_call);
        btn_sms = view.findViewById(R.id.btn_sms);
        user_babaPhone = view.findViewById(R.id.user_babaPhone);



    btn_call.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + user_babaPhone.getText()));
            startActivity(intent);
        }
    });

    btn_sms.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Uri uri = Uri.parse("smsto: " + user_babaPhone.getText());
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra("sms_body", "Salem, siz proektke tirkeldiniz");
            startActivity(intent);
        }
    });

        return view;
    }




}