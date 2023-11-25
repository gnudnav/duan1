package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.adapter.BrandAdapter;
import com.example.duan.adapter.SanPhamAdapter;
import com.example.duan.dao.BrandDao;
import com.example.duan.dao.SanPham_WomanDao;
import com.example.duan.model.Brand;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class Activity_Sanpham_Woman extends AppCompatActivity {
    private ArrayList<SanPham>list_woman;
    private SanPhamAdapter sanPhamAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanpham_woman);
        RecyclerView recyclerView_brand=findViewById(R.id.recyclerView_brand);
        RecyclerView recyclerView_woman=findViewById(R.id.recyclerView_woman);
        ImageView ic_back=findViewById(R.id.ic_back);
        SearchView searchView_Woman=findViewById(R.id.searchView_Woman);
        searchView_Woman.clearFocus();
        searchView_Woman.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
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
        ArrayList<Brand> list=brandDao.getlistDS_Brand();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView_brand.setLayoutManager(linearLayoutManager);
        BrandAdapter brandAdapter=new BrandAdapter(Activity_Sanpham_Woman.this,list,brandDao);
        recyclerView_brand.setAdapter(brandAdapter);

        SanPham_WomanDao sanPhamWomanDao=new SanPham_WomanDao(this);
        list_woman=sanPhamWomanDao.getDsSanPhamWoman();

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView_woman.setLayoutManager(gridLayoutManager);
        sanPhamAdapter=new SanPhamAdapter(Activity_Sanpham_Woman.this,list_woman);
        recyclerView_woman.setAdapter(sanPhamAdapter);

        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void filterList(String text){
        ArrayList<SanPham> filteredList=new ArrayList<>();
        for(SanPham sanPham : list_woman){
            if (sanPham.getTen().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(sanPham);
            }
        }
        if(filteredList.isEmpty()){
            Toast.makeText(this, "Không tìm thấy", Toast.LENGTH_SHORT).show();
        }else{
            sanPhamAdapter.setFilteredList(filteredList);
        }
    }
}