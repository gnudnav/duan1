package com.example.duan.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.duan.R;
import com.example.duan.model.HoaDon;
import com.example.duan.model.NguoiDung;

import java.util.ArrayList;

public class HoaDonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    private ArrayList<HoaDon>list;

    public HoaDonAdapter(Context context, ArrayList<HoaDon> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=((Activity)context).getLayoutInflater();
        View view=layoutInflater.inflate(R.layout.item_layout_address,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ViewHolder){
            ViewHolder viewHolder=(ViewHolder) holder;
            viewHolder.txttenguoidung.setText(list.get(position).getHoten());
            viewHolder.txtsdt.setText(String.valueOf(list.get(position).getSdt()));
            viewHolder.txtdiachi.setText(list.get(position).getDiachi());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txttenguoidung,txtsdt,txtdiachi,txtsua;
        private RadioButton radiobutton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txttenguoidung=itemView.findViewById(R.id.txttennguoidung);
            txtsdt=itemView.findViewById(R.id.txtsdt);
            txtdiachi=itemView.findViewById(R.id.txtdiachi);
            txtsua=itemView.findViewById(R.id.txtsua);
            radiobutton=itemView.findViewById(R.id.radiobutton);
        }
    }
}


