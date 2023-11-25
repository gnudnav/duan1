package com.example.duan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.duan.activity.Activity_Sanpham_Couple;
import com.example.duan.activity.Activity_Sanpham_Man;
import com.example.duan.R;
import com.example.duan.activity.Activity_Sanpham_Woman;

public class Tab_Category1_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab_category,container,false);
        ImageView man=view.findViewById(R.id.man);
        ImageView woman=view.findViewById(R.id.woman);
        ImageView couple=view.findViewById(R.id.couple);

        man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Activity_Sanpham_Man.class));
            }
        });
        woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Activity_Sanpham_Woman.class));
            }
        });
        couple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Activity_Sanpham_Couple.class));
            }
        });
        return view;
    }
}
