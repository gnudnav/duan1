package com.example.duan.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan.R;
import com.example.duan.activity.DetailActivity;
import com.example.duan.dao.SanPhamDao;
import com.example.duan.dao.SanPham_NamDao;
import com.example.duan.model.SanPham;

import java.text.NumberFormat;
import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamAdapter.ViewHolder>{
    private Context context;
    private ArrayList<SanPham>list;
    public void setFilteredList(ArrayList<SanPham>filteredList){
        this.list=filteredList;
        notifyDataSetChanged();
    }

    public SanPhamAdapter(Context context, ArrayList<SanPham> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_layout_sanpham,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SanPham sanPham=list.get(position);
        holder.txt_ten.setText(list.get(position).getTen());
        NumberFormat numberFormat=NumberFormat.getInstance();
        holder.txt_gia.setText(numberFormat.format(list.get(position).getGia()));


        int imgSanPham=((Activity)context).getResources().getIdentifier(
                list.get(position).getImgsanpham(),"drawable",((Activity)context).getPackageName()
        );

        holder.img_sanpham.setImageResource(imgSanPham);
        holder.layout_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(sanPham);
            }
        });
    }
    private void onClickGoToDetail(SanPham sanPham){
        Intent intent=new Intent(context, DetailActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object",sanPham);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout layout_item;
        private ImageView img_sanpham;
        private TextView txt_ten,txt_gia;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_sanpham=itemView.findViewById(R.id.imgsanpham);
            txt_ten=itemView.findViewById(R.id.ten);
            txt_gia=itemView.findViewById(R.id.gia);
            layout_item=itemView.findViewById(R.id.layout_item);
        }
    }
}
