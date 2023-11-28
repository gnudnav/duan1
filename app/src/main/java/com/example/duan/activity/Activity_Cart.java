package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.duan.R;
import com.example.duan.dao.CartAdapter;
import com.example.duan.dao.SanPhamDao;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class Activity_Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ImageView ic_back=findViewById(R.id.ic_back);
        RecyclerView recyclerView_cart=findViewById(R.id.recyclerView_cart);
        TextView soluong=findViewById(R.id.soluong);

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        SanPhamDao sanPhamDao=new SanPhamDao(this);
        ArrayList<SanPham>list=sanPhamDao.listgetDSSANPHAM();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView_cart.setLayoutManager(linearLayoutManager);
        CartAdapter cartAdapter=new CartAdapter(this,list);
        recyclerView_cart.setAdapter(cartAdapter);
    }
}