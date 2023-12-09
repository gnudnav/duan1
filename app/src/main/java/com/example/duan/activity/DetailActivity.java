package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duan.R;
import com.example.duan.adapter.SanPhamAdapter;
import com.example.duan.dao.CTHDDao;
import com.example.duan.dao.HoaDonDao;
import com.example.duan.dao.SanPhamDao;
import com.example.duan.model.SanPham;

import java.text.NumberFormat;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity  {
    private int quantity=1;
    private TextView txt_quantity,txt_tensanpham,txt_giasanpham;
    private ImageView ic_cart,ic_heart,ic_back,img_sanpham,dautru,daucong;
    private Button btn_add;
    private boolean isHeartRed=false;
    private CTHDDao cthdDao;
    private SanPhamDao sanPhamDao;
    private HoaDonDao hoaDonDao;
    private SanPham sanPham;
    private SanPhamAdapter sanPhamAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        SharedPreferences sharedPreferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);

        Bundle bundle=getIntent().getExtras();
        if(bundle==null){
            return;
        }
        cthdDao=new CTHDDao(this);
        sanPhamDao=new SanPhamDao(this);
        hoaDonDao=new HoaDonDao(this);

        sanPham= (SanPham) bundle.get("object");
        ic_back=findViewById(R.id.ic_back);
        dautru=findViewById(R.id.dautru);
        daucong=findViewById(R.id.daucong);
        txt_quantity=findViewById(R.id.txt_quantity);
        txt_tensanpham=findViewById(R.id.txt_tensanpham);
        img_sanpham=findViewById(R.id.img_sanpham);
        txt_giasanpham=findViewById(R.id.txt_giasanpham);

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
                int manguoidung=sharedPreferences.getInt("manguoidung",-1);
                int mahoadon=hoaDonDao.themHD(manguoidung);
                // Thêm vào bảng CTHD trong CTHDDao
                if (mahoadon!=-1&&cthdDao.themCTHD(masanpham,mahoadon,1,quantity)) {
                    // Thông báo thành công
                    Toast.makeText(DetailActivity.this, "Thêm thành công vào giỏ hàng"+manguoidung, Toast.LENGTH_SHORT).show();
                    cthdDao.updateSoLuong(masanpham,quantity);
                } else {
                    // Thông báo thất bại
                    Toast.makeText(DetailActivity.this, "Thêm vào giỏ hàng thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        });

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
        ArrayList<SanPham>list=new ArrayList<>();
        sanPhamAdapter=new SanPhamAdapter(this,list);
        ic_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int masanpham=sanPham.getMasanpham();
                if(isHeartRed){
                    ic_heart.setImageResource(R.drawable.ic_img_heart_red);
                    sanPhamDao.updateTrangThai(masanpham,2);
                }else {
                    ic_heart.setImageResource(R.drawable.ic_img_heart_black);
                    sanPhamDao.updateTrangThai(masanpham,1);
                }
                isHeartRed=!isHeartRed;
                list.clear();
                list.addAll(sanPhamDao.listgetDS());
                sanPhamAdapter.notifyDataSetChanged();

            }
        });
        txt_tensanpham.setText(sanPham.getTen());
        Object giaObject = sanPham.getGia();
        int gia=(Integer)giaObject;
        NumberFormat numberFormat=NumberFormat.getInstance();
        txt_giasanpham.setText(numberFormat.format(gia));

        txt_quantity.setText(String.valueOf(quantity));
            //ham hien thị hình ảnh lên detail
        Bundle bundle1=getIntent().getExtras();
        if(bundle1!=null){
            SanPham sanPham1=(SanPham) bundle.getSerializable("object");
            if(sanPham1!=null){
                int imgSanPham=getResources().getIdentifier(sanPham1.getImgsanpham(),"drawable",getPackageName());img_sanpham.setImageResource(imgSanPham);
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