package com.example.duan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan.R;
import com.example.duan.adapter.HistoryAdapter;
import com.example.duan.dao.MyOrderDao;
import com.example.duan.model.CTHD;

import java.util.ArrayList;

public class Tab_Cancel_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab_cancel,container,false);
        RecyclerView recyclerView_cancel=view.findViewById(R.id.recyclerView_cancel);


        MyOrderDao myOrderDao=new MyOrderDao(getContext());
        ArrayList<CTHD> list= myOrderDao.listgetCancel();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView_cancel.setLayoutManager(linearLayoutManager);
        HistoryAdapter historyAdapter =new HistoryAdapter(getContext(),list);
        recyclerView_cancel.setAdapter(historyAdapter);
        return view;
    }
}
