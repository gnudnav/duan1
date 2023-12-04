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
import com.example.duan.adapter.BrandAdapter;
import com.example.duan.adapter.MyOrderAdapter;
import com.example.duan.dao.BrandDao;
import com.example.duan.dao.MyOrderDao;
import com.example.duan.model.Brand;
import com.example.duan.model.CTHD;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class Tab_MyOrder_Fragment extends Fragment {
    private RecyclerView recyclerView_myOrder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab_myorder,container,false);
        recyclerView_myOrder=view.findViewById(R.id.recyclerView_myOrder);

        MyOrderDao myOrderDao=new MyOrderDao(getContext());
        ArrayList<CTHD>list= myOrderDao.listgetDS();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        recyclerView_myOrder.setLayoutManager(linearLayoutManager);
        MyOrderAdapter myOrderAdapter=new MyOrderAdapter(getContext(),list,myOrderDao);
        recyclerView_myOrder.setAdapter(myOrderAdapter);

        return view;
    }
}
