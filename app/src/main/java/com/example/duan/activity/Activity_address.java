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


    }
}