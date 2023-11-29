package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.duan.R;

public class Activity_address extends AppCompatActivity {
    private ImageView ic_back,img_add_address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ic_back=findViewById(R.id.ic_back);

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        img_add_address=findViewById(R.id.img_add_address);
        img_add_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_address.this, Activity_New_Address.class));
            }
        });
    }
}