package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.model.SanPham;

public class DetailActivity extends AppCompatActivity  {
    private int quantity=1;
    private TextView txt_quantity;
    private ImageView ic_cart,ic_heart;
    private Button btn_add;
    private boolean isHeartRed=false;


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
        ic_heart=findViewById(R.id.heart);
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
                Toast.makeText(DetailActivity.this, "đã thêm thành công", Toast.LENGTH_SHORT).show();
            }
        });
        ic_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isHeartRed){
                    ic_heart.setImageResource(R.drawable.ic_hearttttt);
                }else {
                    ic_heart.setImageResource(R.drawable.ic_img_heart_red);
                }
                isHeartRed=!isHeartRed;
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
        txt_quantity.setText(String.valueOf(sanPham.getSoluong()));
    }
    private void tang(){
        quantity++;
        updateQuantity();
    }
    private void giam(){
        if(quantity>1){
            quantity--;
            updateQuantity();
        }
    }
    private void updateQuantity(){
        txt_quantity.setText(String.valueOf(quantity));
    }
}