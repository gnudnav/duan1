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
import com.example.duan.adapter.MyOrderAdapter;
import com.example.duan.dao.MyOrderDao;
import com.example.duan.model.CTHD;

import java.util.ArrayList;

public class Tab_History_Fragment extends Fragment {
    private RecyclerView recyclerView_History;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab_history,container,false);

        recyclerView_History=view.findViewById(R.id.recyclerView_History);

        MyOrderDao myOrderDao=new MyOrderDao(getContext());
        ArrayList<CTHD> list= myOrderDao.listgetDSHistory();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView_History.setLayoutManager(linearLayoutManager);
        HistoryAdapter historyAdapter =new HistoryAdapter(getContext(),list);
        recyclerView_History.setAdapter(historyAdapter);

        return view;
    }
}
