package com.example.duan.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan.R;
import com.example.duan.dao.BrandDao;
import com.example.duan.model.Brand;

import java.util.ArrayList;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder>{
    private Context context;
    private ArrayList<Brand>list;
    private BrandDao brandDao;

    public BrandAdapter(Context context, ArrayList<Brand> list, BrandDao brandDao) {
        this.context = context;
        this.list = list;
        this.brandDao = brandDao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_layout_brand,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        int imgBrand=((Activity)context).getResources().getIdentifier(
                list.get(position).getImgbrand(),"drawable",((Activity)context).getPackageName()
        );

        holder.img_brand.setImageResource(imgBrand);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_brand;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_brand=itemView.findViewById(R.id.ima_brand);
        }
    }
}
