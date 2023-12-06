package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.duan.R;
import com.example.duan.adapter.HistoryAdapter;
import com.example.duan.adapter.MyOrderAdapter;
import com.example.duan.dao.MyOrderDao;
import com.example.duan.model.CTHD;

import java.util.ArrayList;

public class Activity_Cancel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        RecyclerView recyclerView_cancel=findViewById(R.id.recyclerView_cancel);


        MyOrderDao myOrderDao=new MyOrderDao(this);
        ArrayList<CTHD> list= myOrderDao.listgetCancel();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView_cancel.setLayoutManager(linearLayoutManager);
        HistoryAdapter historyAdapter =new HistoryAdapter(this,list);
        recyclerView_cancel.setAdapter(historyAdapter);

    }
}