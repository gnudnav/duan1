package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.dao.NguoiDungDao;
import com.example.duan.database.DbHelper;
import com.google.android.material.textfield.TextInputEditText;

public class ChangePassActivity extends AppCompatActivity {

    private TextInputEditText edtmatkhau,edtRematkhau;
    private AppCompatButton btnxacnhan;
    private NguoiDungDao nguoiDungDao;
    private ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pass);

        edtmatkhau=findViewById(R.id.edtmatkhau);
        edtRematkhau=findViewById(R.id.edtRematkhau);
        btnxacnhan=findViewById(R.id.btnxacnhan);
        nguoiDungDao=new NguoiDungDao(this);
        ic_back=findViewById(R.id.ic_back);

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangePassActivity.this, LoginActivity.class));
            }
        });

        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String matkhau=edtmatkhau.getText().toString();
                String Rematkhau=edtRematkhau.getText().toString();
                if(!matkhau.equals(Rematkhau)){
                    Toast.makeText(ChangePassActivity.this, "Hai mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}