package com.example.duan.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan.R;
import com.example.duan.activity.Activity_Cart;
import com.example.duan.activity.SearchViewActivity;
import com.example.duan.adapter.SanPhamAdapter;
import com.example.duan.dao.SanPhamDao;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class Heart_Fragment extends Fragment {

    private ArrayList<SanPham> list;
    private SanPhamAdapter sanPhamAdapter;
    private Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heart, container, false);
        SearchView searchView = view.findViewById(R.id.searchView);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView_heart);
        ImageView ic_setting = view.findViewById(R.id.ic_setting);
        ImageView ic_cart = view.findViewById(R.id.ic_cart);

        ic_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Activity_Cart.class));
            }
        });

        ic_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDiaLog();
            }
        });

        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        SanPhamDao sanPhamDao=new SanPhamDao(getContext());
        list=sanPhamDao.listgetDS();

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        sanPhamAdapter=new SanPhamAdapter(getContext(),list);
        recyclerView.setAdapter(sanPhamAdapter);


        return view;
    }
    private void filterList(String text){
        ArrayList<SanPham> filteredList=new ArrayList<>();
        for(SanPham sanPham : list){
            if (sanPham.getTen().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(sanPham);
            }
        }
        sanPhamAdapter.setFilteredList(filteredList);
}
    private void showDiaLog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        LayoutInflater inflater=(this).getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_search,null);
        builder.setView(view);

        AlertDialog dialog=builder.create();
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}
