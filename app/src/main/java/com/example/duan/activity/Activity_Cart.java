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

import com.example.duan.R;
import com.example.duan.adapter.CartAdapter;
import com.example.duan.dao.SanPhamDao;
import com.example.duan.model.SanPham;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class Activity_Cart extends AppCompatActivity {
    private ArrayList<SanPham>list;
    private CartAdapter cartAdapter;
    private AppCompatButton checkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ImageView ic_back=findViewById(R.id.ic_back);
        RecyclerView recyclerView_cart=findViewById(R.id.recyclerView_cart);
        TextView soluong=findViewById(R.id.soluong);
        checkout=findViewById(R.id.checkout);

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

        SanPhamDao sanPhamDao=new SanPhamDao(this);
        list=sanPhamDao.listgetDSSANPHAM();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView_cart.setLayoutManager(linearLayoutManager);
        cartAdapter=new CartAdapter(this,list);
        recyclerView_cart.setAdapter(cartAdapter);

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
                        .setMessage("Bạn có chắc chắn muốn xóa mục này?")
                        .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                //                 Xử lý khi người dùng chọn "Đồng ý"
                                list.remove(position);
                                cartAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Không làm gì nếu người dùng chọn hủy
                                cartAdapter.notifyItemChanged(position);
                            }
                        })
                        .show();
            }
        });
                itemTouchHelper.attachToRecyclerView(recyclerView_cart);
                //xoa item

            }

    private void showConfirmationSnackbar(String removedItem) {
        Snackbar.make(findViewById(android.R.id.content),
                "Đã xóa: " + removedItem, Snackbar.LENGTH_LONG).show();
    }

}