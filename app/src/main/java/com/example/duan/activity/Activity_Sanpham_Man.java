package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.adapter.BrandAdapter;
import com.example.duan.adapter.SanPhamAdapter;
import com.example.duan.dao.BrandDao;
import com.example.duan.dao.SanPham_NamDao;
import com.example.duan.model.Brand;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class Activity_Sanpham_Man extends AppCompatActivity {
    private ArrayList<SanPham>list_nam;
    private SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham_man);
        RecyclerView recyclerView_brand=findViewById(R.id.recyclerView_brand);
        RecyclerView recyclerView_man=findViewById(R.id.recyclerView_man);
        ImageView ic_back=findViewById(R.id.ic_back);
        SearchView searchView_Man=findViewById(R.id.searchView_Man);
        searchView_Man.clearFocus();
        searchView_Man.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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

        BrandDao brandDao=new BrandDao(this);
        ArrayList<Brand>list=brandDao.getlistDS_Brand();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView_brand.setLayoutManager(linearLayoutManager);
        BrandAdapter brandAdapter=new BrandAdapter(Activity_Sanpham_Man.this,list,brandDao);
        recyclerView_brand.setAdapter(brandAdapter);

        SanPham_NamDao sanPham_namDao=new SanPham_NamDao(this);
        list_nam=sanPham_namDao.getDsSanPhamNam();

        GridLayoutManager linearLayoutManager1=new GridLayoutManager(this,2);
        recyclerView_man.setLayoutManager(linearLayoutManager1);
        sanPhamAdapter=new SanPhamAdapter(Activity_Sanpham_Man.this,list_nam);
        recyclerView_man.setAdapter(sanPhamAdapter);

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void filterList(String text){
        ArrayList<SanPham> filteredList=new ArrayList<>();
        for(SanPham sanPham : list_nam){
            if (sanPham.getTen().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(sanPham);
            }
        }

            sanPhamAdapter.setFilteredList(filteredList);

    }
}