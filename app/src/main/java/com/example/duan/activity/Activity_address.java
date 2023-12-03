package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.duan.R;
import com.example.duan.adapter.HoaDonAdapter;
import com.example.duan.dao.HoaDonDao;
import com.example.duan.dao.NguoiDungDao;
import com.example.duan.model.HoaDon;
import com.example.duan.model.NguoiDung;

import java.util.ArrayList;

public class Activity_address extends AppCompatActivity {
    private ImageView ic_back,img_add_address;
    private HoaDonDao hoaDonDao;
    private HoaDonAdapter hoaDonAdapter;
    private RecyclerView recyclerView_address;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ic_back=findViewById(R.id.ic_back);
        recyclerView_address=findViewById(R.id.recyclerView_address);

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
        hoaDonDao=new HoaDonDao(this);
        ArrayList<HoaDon> list=hoaDonDao.listgetHoaDon1();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView_address.setLayoutManager(linearLayoutManager);
        hoaDonAdapter=new HoaDonAdapter(this,list);
        recyclerView_address.setAdapter(hoaDonAdapter);


    }
}