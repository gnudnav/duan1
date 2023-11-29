package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.dao.NguoiDungDao;
import com.google.android.material.textfield.TextInputEditText;

public class Activity_Login extends AppCompatActivity {

    private TextInputEditText edttendangnhap,edtmatkhau;
    private TextView txtquenmk;
    private AppCompatButton btndangnhap;
    private NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edttendangnhap=findViewById(R.id.edttendangnhap);
        edtmatkhau=findViewById(R.id.edtmatkhau);
        txtquenmk=findViewById(R.id.txtquenmk);
        btndangnhap=findViewById(R.id.btndangnhap);
        nguoiDungDao=new NguoiDungDao(this);
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tendangnhap=edttendangnhap.getText().toString();
                String matkhau=edtmatkhau.getText().toString();
                boolean check=nguoiDungDao.KiemTraDangNhap(tendangnhap,matkhau);
                if (check){
                    Toast.makeText(Activity_Login.this, "Bạn đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Activity_Login.this, MainActivity.class));
                }else{
                    Toast.makeText(Activity_Login.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
        txtquenmk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Login.this, FindAccountActivity.class));
            }
        });

    }
}