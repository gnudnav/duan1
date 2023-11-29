package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.fragment.Delivery_Fragment;

public class Activity_Payment extends AppCompatActivity {
    private TextView edit;
    private ImageView ic_back;
    private AppCompatButton btn_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        edit=findViewById(R.id.edit);
        ic_back=findViewById(R.id.ic_back);
        btn_confirm=findViewById(R.id.btn_confirm);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Payment.this,Activity_address.class));
            }
        });
        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Activity_Payment.this, "Đã mua thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }
}