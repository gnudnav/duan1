package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.adapter.CTHDAdapter;
import com.example.duan.dao.CTHDDao;
import com.example.duan.dao.HoaDonDao;
import com.example.duan.dao.NguoiDungDao;
import com.example.duan.database.DbHelper;
import com.example.duan.fragment.Delivery_Fragment;
import com.example.duan.model.CTHD;
import com.example.duan.model.HoaDon;
import com.example.duan.model.NguoiDung;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Activity_Payment extends AppCompatActivity {
    private TextView edit;
    private ImageView ic_back;
    private AppCompatButton btn_confirm;
    public RecyclerView recyclerView_cthd;
    private ArrayList<CTHD> list;
    private CTHDDao cthdDao;
    private CTHDAdapter cthdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        edit=findViewById(R.id.edit);
        ic_back=findViewById(R.id.ic_back);
        btn_confirm=findViewById(R.id.btn_confirm);
        TextView txt_quantity=findViewById(R.id.txt_quantity);
        recyclerView_cthd=findViewById(R.id.recyclerView_cthd);

        TextView txttennguoidung=findViewById(R.id.txt_tennguoidung);
        TextView txtsdt=findViewById(R.id.txt_sdt);
        TextView txtdiachi=findViewById(R.id.txt_diachi);


        cthdDao=new CTHDDao(this);
        list=cthdDao.listgetDSCart();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recyclerView_cthd.setLayoutManager(linearLayoutManager);
        cthdAdapter=new CTHDAdapter(Activity_Payment.this,list);
        recyclerView_cthd.setAdapter(cthdAdapter);

        TextView giasanphamhienthi=findViewById(R.id.giasanphamhienthi);
        int tonggia = cthdAdapter.tinhTongGia();
        DecimalFormat decimalFormat = new DecimalFormat("#,###,###");
        String formattedTongGia = decimalFormat.format(tonggia);
        giasanphamhienthi.setText(formattedTongGia + " VND");



        int macthd=cthdAdapter.getItemCount();
        txt_quantity.setText(String.valueOf(macthd));

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Payment.this, Activity_New_Address.class));
            }
        });
        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        HoaDonDao hoaDonDao=new HoaDonDao(this);
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mahoadon = hoaDonDao.themHD();
                if(cthdDao.updateTrangThaiHD(mahoadon)){
                    // Nếu cập nhật thành công, chuyển đến màn hình thanh toán
                    Toast.makeText(Activity_Payment.this, "Đặt mua thành công", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Activity_Payment.this, Activity_ThongBao.class);
                    // Gửi mã hoá đơn đến Activity thanh toán nếu cần thiết
                    intent.putExtra("mahoadon", mahoadon);
                    startActivity(intent);
                } else {
                    Toast.makeText(Activity_Payment.this, "Failed to update order status", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}