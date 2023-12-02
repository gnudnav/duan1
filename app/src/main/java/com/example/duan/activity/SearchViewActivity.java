package com.example.duan.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.adapter.BrandAdapter;
import com.example.duan.adapter.SanPhamAdapter;
import com.example.duan.dao.BrandDao;
import com.example.duan.dao.SanPhamDao;
import com.example.duan.model.Brand;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class SearchViewActivity extends AppCompatActivity {
    private ArrayList<SanPham> list;
    private SanPhamAdapter sanPhamAdapter;
    private Button btn_all;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);
        ImageView ic_back1=findViewById(R.id.ic_back);
        SearchView searchView=findViewById(R.id.searchView);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        ImageView ic_setting=findViewById(R.id.ic_setting);
        btn_all=findViewById(R.id.btn_all);

        //set click btn_all
        btn_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(recyclerView.getVisibility()==View.VISIBLE){
                    recyclerView.setVisibility(View.GONE);
                }
                else {
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }
        });
        
        ic_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDiaLog();
            }
        });

        ic_back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
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
        SanPhamDao sanPhamDao=new SanPhamDao(this);
        list=sanPhamDao.listgetDSSANPHAM();

        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        sanPhamAdapter=new SanPhamAdapter(this,list);
        recyclerView.setAdapter(sanPhamAdapter);

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
        AlertDialog.Builder builder=new AlertDialog.Builder(SearchViewActivity.this);
        LayoutInflater inflater=(SearchViewActivity.this).getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog_search,null);
        builder.setView(view);

        AlertDialog dialog=builder.create();
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.show();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }
}