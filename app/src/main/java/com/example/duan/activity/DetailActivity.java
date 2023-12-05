package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.adapter.CTHDAdapter;
import com.example.duan.adapter.SanPhamAdapter;
import com.example.duan.dao.CTHDDao;
import com.example.duan.dao.HoaDonDao;
import com.example.duan.dao.SanPhamDao;
import com.example.duan.database.DbHelper;
import com.example.duan.model.CTHD;
import com.example.duan.model.HoaDon;
import com.example.duan.model.SanPham;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity  {
    private int quantity=1;
    private TextView txt_quantity;
    private ImageView ic_cart;
    private ImageView ic_heart;
    private Button btn_add;
    private boolean isHeartRed=false;
    private CTHDDao cthdDao;
    private SanPhamDao sanPhamDao;
    private HoaDonDao hoaDonDao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }
        cthdDao=new CTHDDao(this);
        sanPhamDao=new SanPhamDao(this);
        hoaDonDao=new HoaDonDao(this);

        SanPham sanPham= (SanPham) bundle.get("object");

        TextView txt_tensanpham=findViewById(R.id.txt_tensanpham);
        ImageView img_sanpham=findViewById(R.id.img_sanpham);
        TextView txt_giasanpham=findViewById(R.id.txt_giasanpham);

        ic_cart=findViewById(R.id.ic_cart);
        ic_heart=findViewById(R.id.heart);
        ic_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DetailActivity.this,Activity_Cart.class));
            }
        });
        btn_add=findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int masanpham = sanPham.getMasanpham();
                int mahoadon=hoaDonDao.themHD();



                // Thêm vào bảng CTHD trong CTHDDao
                if (mahoadon!=-1&&cthdDao.themCTHD(masanpham,mahoadon,1)) {
                    // Thông báo thành công
                    Toast.makeText(DetailActivity.this, "Thêm thành công vào giỏ hàng", Toast.LENGTH_SHORT).show();
                    sanPhamDao.updateSoLuong(masanpham,quantity);

                } else {
                    // Thông báo thất bại
                    Toast.makeText(DetailActivity.this, "Thêm vào giỏ hàng thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });



        ImageView ic_back=findViewById(R.id.ic_back);
        ImageView dautru=findViewById(R.id.dautru);
        ImageView daucong=findViewById(R.id.daucong);
        txt_quantity=findViewById(R.id.txt_quantity);

        dautru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                giam();
            }
        });
        daucong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tang();
            }
        });



        ic_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        int trangthai=sanPham.getTrangthai();
        if(trangthai==1){
            ic_heart.setImageResource(R.drawable.ic_img_heart_black);
        }else {
            ic_heart.setImageResource(R.drawable.ic_img_heart_red);
        }
        ic_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int matrangthai=sanPham.getMasanpham();
                if(isHeartRed){
                    ic_heart.setImageResource(R.drawable.ic_img_heart_red);
                    sanPhamDao.updateTrangThai(matrangthai,2);
                }else {
                    ic_heart.setImageResource(R.drawable.ic_img_heart_black);
                    sanPhamDao.updateTrangThai(matrangthai,1);
                }
                isHeartRed=!isHeartRed;

            }
        });


        txt_tensanpham.setText(sanPham.getTen());
        txt_giasanpham.setText(String.valueOf(sanPham.getGia()));
        txt_quantity.setText(String.valueOf(sanPham.getSoluong()));
        //ham hien thị hình ảnh lên detail
        Bundle bundle1=getIntent().getExtras();
        if(bundle1!=null){
            SanPham sanPham1=(SanPham) bundle.getSerializable("object");
            if(sanPham1!=null){
                int imgSanPham=getResources().getIdentifier(sanPham1.getImgsanpham(),"drawable",getPackageName());
                img_sanpham.setImageResource(imgSanPham);
            }
        }
        //ham hien thị hình ảnh lên detail
    }
    private void tang(){
        quantity++;
        updateQuantity();
    }
    private void giam(){
        if(quantity>1){
            quantity--;
            updateQuantity();
        }
    }
    private void updateQuantity(){
        txt_quantity.setText(String.valueOf(quantity));
    }

}