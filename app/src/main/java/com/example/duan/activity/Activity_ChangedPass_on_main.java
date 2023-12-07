package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.dao.NguoiDungDao;
import com.google.android.material.textfield.TextInputEditText;

public class Activity_ChangedPass_on_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changed_pass);
        TextInputEditText edt_matkhau=findViewById(R.id.edtmatkhau);
        TextInputEditText edt_Rematkhau=findViewById(R.id.edtRematkhau);
        AppCompatButton btnxacnhan=findViewById(R.id.btnxacnhan);
        NguoiDungDao nguoiDungDao=new NguoiDungDao(this);

        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}