package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.dao.NguoiDungDao;
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
        SharedPreferences sharedPreferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);
        edtmatkhau=findViewById(R.id.edtmatkhau);
        edtRematkhau=findViewById(R.id.edtRematkhau);
        btnxacnhan=findViewById(R.id.btnxacnhan);
        nguoiDungDao=new NguoiDungDao(this);
        ic_back=findViewById(R.id.ic_back);

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ChangePassActivity.this, Activity_Login.class));
            }
        });

        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @   Override
            public void onClick(View v) {
                String matKhau = edtmatkhau.getText().toString();
                String reMatKhau = edtRematkhau.getText().toString();
                int manguoidung=sharedPreferences.getInt("manguoidung",-1);
                boolean success = nguoiDungDao.DoiMatKhau(manguoidung, matKhau);


                if(matKhau.isEmpty()||reMatKhau.isEmpty()){
                    Toast.makeText(ChangePassActivity.this, "Vui lòng nhập đầy đủ", Toast.LENGTH_SHORT).show();
                }else if(!matKhau.equals(reMatKhau)){
                    Toast.makeText(ChangePassActivity.this, "2 mật khẩu không giống nhau", Toast.LENGTH_SHORT).show();
                }else {
                    if (success) {
                        Toast.makeText(ChangePassActivity.this, "Thành công "+manguoidung, Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ChangePassActivity.this,Activity_Login.class));
                    } else {
                        Toast.makeText(ChangePassActivity.this, "Lỗi khi cập nhật mật khẩu", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}