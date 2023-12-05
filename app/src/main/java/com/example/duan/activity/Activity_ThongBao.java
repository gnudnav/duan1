package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.duan.R;

public class Activity_ThongBao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_bao);
        ImageView img_icon_cart=findViewById(R.id.img_icon_cart);
        AppCompatButton btn_trangchu=findViewById(R.id.trangchu);
        AppCompatButton btn_donmua=findViewById(R.id.donmua);
        img_icon_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThongBao.this, Activity_Cart.class));
            }
        });
        btn_trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ThongBao.this, MainActivity.class));
            }
        });
        btn_donmua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Activity_ThongBao.this,MainActivity.class);
                intent.putExtra("openDeliveryFragment",true);
                startActivity(intent);
            }
        });
    }
}