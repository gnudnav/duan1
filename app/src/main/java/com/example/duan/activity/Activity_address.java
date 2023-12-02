package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.duan.R;
import com.example.duan.adapter.BrandAdapter;
import com.example.duan.adapter.NguoiDungAdapter;
import com.example.duan.dao.BrandDao;
import com.example.duan.dao.NguoiDungDao;
import com.example.duan.model.Brand;
import com.example.duan.model.NguoiDung;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class Activity_address extends AppCompatActivity {
    private ImageView ic_back,img_add_address;
    private NguoiDungDao nguoiDungDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ic_back=findViewById(R.id.ic_back);
        RecyclerView recyclerView_address=findViewById(R.id.recyclerView_address);

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
        nguoiDungDao=new NguoiDungDao(this);
        ArrayList<NguoiDung> list=nguoiDungDao.listgetDSNGUOIDUNG();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView_address.setLayoutManager(linearLayoutManager);
        NguoiDungAdapter nguoiDungAdapter=new NguoiDungAdapter(this,list);
        recyclerView_address.setAdapter(nguoiDungAdapter);


    }
}