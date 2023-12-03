package com.example.duan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.adapter.CTHDAdapter;
import com.example.duan.dao.CTHDDao;
import com.example.duan.model.CTHD;

import java.util.ArrayList;

public class Activity_Cart extends AppCompatActivity {
    private ArrayList<CTHD>list;
    private CTHDAdapter cthdAdapter;
    private AppCompatButton checkout;
    private CTHDDao cthdDao;
    public RecyclerView recyclerView_cart;
    public TextView soluongcheckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ImageView ic_back=findViewById(R.id.ic_back);
        recyclerView_cart=findViewById(R.id.recyclerView_cart);
        soluongcheckbox=findViewById(R.id.soluongcheckbox);
        checkout=findViewById(R.id.checkout);
        cthdDao=new CTHDDao(this);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Cart.this, Activity_Payment.class));
            }
        });


        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        CTHDDao cartDao=new CTHDDao(this);
        list=cthdDao.listgetDSCart();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView_cart.setLayoutManager(linearLayoutManager);
        cthdAdapter=new CTHDAdapter(Activity_Cart.this,list);
        recyclerView_cart.setAdapter(cthdAdapter);


                int macthd=cthdAdapter.getItemCount();
                soluongcheckbox.setText(String.valueOf(macthd));


        //xoa item
        ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                final int position = viewHolder.getAbsoluteAdapterPosition();

                new AlertDialog.Builder(Activity_Cart.this)
                        .setTitle("Thông Báo")
                        .setIcon(R.drawable.ic_warning)
                        .setMessage("Bạn có chắc chắn muốn xóa mục này?")
                        .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                //                 Xử lý khi người dùng chọn "Đồng ý"
                                int macthd=list.get(position).getMacthd();
                                boolean check=cartDao.xoaCart(macthd);
                                if(check){
                                    Toast.makeText(Activity_Cart.this, "Xóa Thành công", Toast.LENGTH_SHORT).show();
                                }
                                list.clear();
                                list.addAll(cartDao.listgetDSCart());
                                cthdAdapter.notifyDataSetChanged();

                            }
                        })
                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Không làm gì nếu người dùng chọn hủy
                                cthdAdapter.notifyItemChanged(position);
                            }
                        })
                        .show();
            }
        });
                itemTouchHelper.attachToRecyclerView(recyclerView_cart);
//                //xoa item

    }
}