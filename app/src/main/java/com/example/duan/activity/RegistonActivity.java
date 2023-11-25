package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.dao.NguoiDungDao;
import com.google.android.material.textfield.TextInputEditText;

public class RegistonActivity extends AppCompatActivity {

    private TextInputEditText edttendangnhap,edtmatkhau,edtsdt;
    private AppCompatButton btnlogin;
    private NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registon);

        edttendangnhap=findViewById(R.id.edttendangnhap);
        edtmatkhau=findViewById(R.id.edtmatkhau);
        btnlogin=findViewById(R.id.btnlogin);
        nguoiDungDao=new NguoiDungDao(this);
        edtsdt=findViewById(R.id.edtsdt);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tendangnhap=edttendangnhap.getText().toString();
                String matkhau=edtmatkhau.getText().toString();
                String sdt=edtsdt.getText().toString();

                boolean check=nguoiDungDao.DangKy(tendangnhap,matkhau,sdt);
                if(tendangnhap==""||matkhau==""||sdt==""){
                    Toast.makeText(RegistonActivity.this, "Mời ban nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else if (check){
                    Toast.makeText(RegistonActivity.this, "Bạn đã đăng ký thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistonActivity.this, LoginActivity.class));
                }else{
                    Toast.makeText(RegistonActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}