package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.model.SanPham;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    private int quantity=0;
    private TextView txt_quantity;
    private ImageView ic_cart;
    private Button btn_add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }

        SanPham sanPham= (SanPham) bundle.get("object");
        TextView txt_tensanpham=findViewById(R.id.txt_tensanpham);
        ImageView img_sanpham=findViewById(R.id.img_sanpham);
        TextView txt_giasanpham=findViewById(R.id.txt_giasanpham);
        ic_cart=findViewById(R.id.ic_cart);
        ic_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this,Activity_Cart.class));
            }
        });
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailActivity.this, "đã lưu thành công", Toast.LENGTH_SHORT).show();
            }
        });



        ImageView ic_back=findViewById(R.id.ic_back);
        ImageView dautru=findViewById(R.id.dautru);
        ImageView daucong=findViewById(R.id.daucong);
        txt_quantity=findViewById(R.id.txt_quantity);
        dautru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giam();
            }
        });
        daucong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tang();
            }
        });



        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txt_tensanpham.setText(sanPham.getTen());
        txt_giasanpham.setText(String.valueOf(sanPham.getGia()));

    }
    private void tang(){
        quantity++;
        updateQuantity();
    }
    private void giam(){
        if(quantity>0){
            quantity--;
            updateQuantity();
        }
    }
    private void updateQuantity(){
        txt_quantity.setText(String.valueOf(quantity));
    }
}