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
import com.google.android.material.textfield.TextInputEditText;

public class FindAccountActivity extends AppCompatActivity {

    private TextInputEditText edtsdt;
    private AppCompatButton btnxacnhan;
    private NguoiDungDao nguoiDungDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_account);

        edtsdt = findViewById(R.id.edtsdt);
        btnxacnhan = findViewById(R.id.btnxacnhan);
        nguoiDungDao=new NguoiDungDao(this);
        ImageView imageView=findViewById(R.id.back);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindAccountActivity.this, Activity_Login.class));
            }
        });
        btnxacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sdt=edtsdt.getText().toString();
                boolean check=nguoiDungDao.KiemTraSdt(sdt);
                if(check){
                    Toast.makeText(FindAccountActivity.this, "Đã tìm thấy tài khoản", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FindAccountActivity.this, ChangePassActivity.class));
                }else{
                    Toast.makeText(FindAccountActivity.this, "Không tìm thấy tài khoản", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}