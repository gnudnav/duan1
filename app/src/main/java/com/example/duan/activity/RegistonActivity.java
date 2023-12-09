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

public class RegistonActivity extends AppCompatActivity {

    private TextInputEditText edttendangnhap,edtmatkhau,edtsdt;
    private AppCompatButton btnlogin;
    private NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registon);
        SharedPreferences sharedPreferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);

        edttendangnhap=findViewById(R.id.edttendangnhap);
        edtmatkhau=findViewById(R.id.edtmatkhau);
        btnlogin=findViewById(R.id.btnlogin);
        nguoiDungDao=new NguoiDungDao(this);
        edtsdt=findViewById(R.id.edtsdt);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tendangnhap = edttendangnhap.getText().toString();
                String matkhau = edtmatkhau.getText().toString();
                String sdtString = edtsdt.getText().toString();

                if (tendangnhap.isEmpty() || matkhau.isEmpty() || sdtString.isEmpty()) {
                    Toast.makeText(RegistonActivity.this, "Mời bạn nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                } else {
                    // Convert sdtString to int
                    int sdt = 0;
                    try {
                        sdt = Integer.parseInt(sdtString);
                    } catch (NumberFormatException e) {
                        Toast.makeText(RegistonActivity.this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (nguoiDungDao.kiemtrasdtTonTai(sdt)) {
                        Toast.makeText(RegistonActivity.this, "Số điện thoại đã tồn tại", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    boolean check = nguoiDungDao.DangKy(tendangnhap, matkhau, String.valueOf(sdt));

                    // Kiểm tra số điện thoại
                    if (kiemtrasdt(sdt)) {
                        if (check) {
                            int manguoidung = sharedPreferences.getInt("manguoidung", -1);
                            Toast.makeText(RegistonActivity.this, "Bạn đã đăng ký thành công" + manguoidung, Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegistonActivity.this, Activity_Login.class));
                        } else {
                            Toast.makeText(RegistonActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegistonActivity.this, "Số điện thoại không hợp lệ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
    private boolean kiemtrasdt(int number){
        return true;
    }
}