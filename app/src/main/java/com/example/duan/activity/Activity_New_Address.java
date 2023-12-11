package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan.R;
import com.google.android.material.textfield.TextInputEditText;

public class Activity_New_Address extends AppCompatActivity {
    private ImageView ic_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_address);
        ic_back=findViewById(R.id.ic_back);

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            String tenNguoiDung = intent.getStringExtra("tennguoidung");
            int sdt = intent.getIntExtra("sdt", 0);
            String diaChi = intent.getStringExtra("diachi");

            // Hiển thị dữ liệu trên giao diện của Activity_New_Address
            TextInputEditText edtTenNguoiDung = findViewById(R.id.edttendangnhap);
            TextInputEditText edtSdt = findViewById(R.id.edtsdt);
            TextInputEditText edtDiaChi = findViewById(R.id.edtdiachi);

            edtTenNguoiDung.setText(tenNguoiDung);
            edtSdt.setText(String.valueOf(sdt));
            edtDiaChi.setText(diaChi);
        }
    }
}