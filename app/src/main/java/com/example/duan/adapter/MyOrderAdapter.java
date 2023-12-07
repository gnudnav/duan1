package com.example.duan.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan.R;
import com.example.duan.dao.MyOrderDao;
import com.example.duan.model.CTHD;
import com.example.duan.model.HoaDon;
import com.example.duan.model.SanPham;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder>{
    private Context context;
    private ArrayList<CTHD>list;
    private MyOrderDao myOrderDao;

    public MyOrderAdapter(Context context, ArrayList<CTHD> list, MyOrderDao myOrderDao) {
        this.context = context;
        this.list = list;
        this.myOrderDao = myOrderDao;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        View view=inflater.inflate(R.layout.item_layout_myorder,parent,false);
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
        holder.txt_quantity.setText(String.valueOf(list.get(position).getSoluongcthd()));

        NumberFormat numberFormat=NumberFormat.getInstance();
        int gia=list.get(position).getGia();
        int quantity=list.get(position).getSoluongcthd();
        int totalGia=gia*quantity;
        holder.gia.setText(numberFormat.format(totalGia)+"đ");

        SharedPreferences sharedPreferences= ((Activity) context).getSharedPreferences("dataUser",Context.MODE_PRIVATE);
        int role=sharedPreferences.getInt("role",-1);
        switch (role){
            case 1:
                holder.btn_xacnhan.setVisibility(View.GONE);
                break;
            case 2:
                holder.btn_xacnhan.setVisibility(View.VISIBLE);
        }
        holder.btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int macthd=list.get(holder.getAdapterPosition()).getMacthd();
                boolean check=myOrderDao.updateTrangThaiHD(macthd,2);
                if(check){
                    Toast.makeText(context, "Xác nhận thành công", Toast.LENGTH_SHORT).show();
                    int position = holder.getAdapterPosition();
                    list.remove(position);
                    notifyItemRemoved(position);
                }else {
                    Toast.makeText(context, "Xác nhận thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });
        holder.btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int macthd=list.get(holder.getAdapterPosition()).getMacthd();
                boolean check=myOrderDao.updateTrangThaiHD(macthd,3);
                if(check){
                    Toast.makeText(context, "Hủy thành công", Toast.LENGTH_SHORT).show();
                    int position = holder.getAdapterPosition();
                    list.remove(position);
                    notifyItemRemoved(position);
                }else {
                    Toast.makeText(context, "Hủy thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView ten,loai,txt_quantity,gia;
        private AppCompatButton btn_xacnhan,btn_huy;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            ten=itemView.findViewById(R.id.ten);
            loai=itemView.findViewById(R.id.loai);
            txt_quantity=itemView.findViewById(R.id.txt_quantity);
            gia=itemView.findViewById(R.id.gia);
            btn_xacnhan=itemView.findViewById(R.id.btn_xacnhan);
            btn_huy=itemView.findViewById(R.id.btn_huy);
        }
    }
}
