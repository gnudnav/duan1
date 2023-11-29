package com.example.duan.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan.R;

public class Tab_MyOrder_Fragment extends Fragment {
    private RecyclerView recyclerView_myOrder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab_myorder,container,false);
        recyclerView_myOrder=view.findViewById(R.id.recyclerView_myOrder);

        return view;
    }
}
