package com.example.duan.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan.R;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder>{
    private int quantity=1;
    private Context context;
    private ArrayList<SanPham>list;

    public CartAdapter(Context context, ArrayList<SanPham> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_layout_cart,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int imgSanPham=((Activity)context).getResources().getIdentifier(
                list.get(position).getImgsanpham(),"drawable",((Activity)context).getPackageName()
        );

        holder.img.setImageResource(imgSanPham);
        holder.ten.setText(list.get(position).getTen());

        String loai="";
        if(list.get(position).getMaloai()==1){
            loai="Man";
        }else if(list.get(position).getMaloai()==2){
            loai="Woman";
        }else {
            loai="Couple";
        }
        holder.loai.setText(loai);
        holder.txt_quantity.setText(String.valueOf(list.get(position).getSoluong()));
        holder.gia.setText(String.valueOf(list.get(position).getGia()));

        holder.dautru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity>1){
                    quantity--;
                    holder.txt_quantity.setText(String.valueOf(quantity));
                }
            }
        });
        holder.daucong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                holder.txt_quantity.setText(String.valueOf(quantity));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CheckBox checkBox;
        private ImageView img;
        private TextView ten,loai,txt_quantity,gia;
        private ImageView dautru;
        private ImageView daucong;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            ten=itemView.findViewById(R.id.ten);
            loai=itemView.findViewById(R.id.loai);
            txt_quantity=itemView.findViewById(R.id.txt_quantity);
            gia=itemView.findViewById(R.id.gia);
            daucong=itemView.findViewById(R.id.daucong);
            dautru=itemView.findViewById(R.id.dautru);
        }
    }
}