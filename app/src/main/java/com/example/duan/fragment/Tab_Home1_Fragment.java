package com.example.duan.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.duan.R;
import com.example.duan.activity.Activity_Sanpham_Man;
import com.example.duan.adapter.BrandAdapter;
import com.example.duan.adapter.SanPhamAdapter;
import com.example.duan.dao.BrandDao;
import com.example.duan.dao.SanPhamDao;
import com.example.duan.model.Brand;
import com.example.duan.model.SanPham;

import java.util.ArrayList;
import java.util.List;

public class Tab_Home1_Fragment extends Fragment {

    private ViewPager2 viewPager;
    private Handler handler;
    private Runnable runnable;
    private ImageView brandall;
    private int delayTime = 3000;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_tab_home1,container,false);
        RecyclerView recyclerView_brand=view.findViewById(R.id.recyclerView_brand);
        RecyclerView recyclerView_sanpham=view.findViewById(R.id.recyclerView_sanpham);


        BrandDao brandDao=new BrandDao(getContext());
        ArrayList<Brand> list=brandDao.getlistDS_Brand();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_brand.setLayoutManager(linearLayoutManager);
        BrandAdapter brandAdapter=new BrandAdapter(getContext(),list,brandDao);
        recyclerView_brand.setAdapter(brandAdapter);

        SanPhamDao sanPhamDao=new SanPhamDao(getContext());
        ArrayList<SanPham>listsanpham=sanPhamDao.listgetDSSANPHAM();

        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),2);
        recyclerView_sanpham.setLayoutManager(gridLayoutManager);
        SanPhamAdapter sanPhamAdapter =new SanPhamAdapter(getContext(),listsanpham);
        recyclerView_sanpham.setAdapter(sanPhamAdapter);


        //auto slide
        viewPager = view.findViewById(R.id.viewPager);

        List<Integer> imageResIds = new ArrayList<>();
        imageResIds.add(R.drawable.giamgia1);
        imageResIds.add(R.drawable.giamgia2);
        imageResIds.add(R.drawable.giamgia3);
        imageResIds.add(R.drawable.giamgia4);


        Tab_Home1_Fragment.SlideshowAdapter slideshowAdapter = new Tab_Home1_Fragment.SlideshowAdapter(imageResIds);
        viewPager.setAdapter(slideshowAdapter);

        // Tạo handler để tự động chuyển slide
        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                int currentItem = viewPager.getCurrentItem();
                viewPager.setCurrentItem((currentItem + 1) % imageResIds.size());
                handler.postDelayed(this, delayTime);
            }
        };
        //auto slide
        return view;
    }
    //auto slide
    @Override
    public void onResume() {
        super.onResume();
        // Bắt đầu tự động chuyển slide khi Fragment được hiển thị
        handler.postDelayed(runnable, delayTime);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Dừng tự động chuyển slide khi Fragment không còn hiển thị
        handler.removeCallbacks(runnable);
    }

    private class SlideshowAdapter extends RecyclerView.Adapter<Tab_Home1_Fragment.SlideshowAdapter.SlideViewHolder> {

        private List<Integer> imageResIds;

        public SlideshowAdapter(List<Integer> imageResIds) {
            this.imageResIds = imageResIds;
        }

        @NonNull
        @Override
        public Tab_Home1_Fragment.SlideshowAdapter.SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.img_layout, parent, false);
            return new Tab_Home1_Fragment.SlideshowAdapter.SlideViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Tab_Home1_Fragment.SlideshowAdapter.SlideViewHolder holder, int position) {
            int imageResId = imageResIds.get(position);
            holder.imageView.setImageResource(imageResId);
        }

        @Override
        public int getItemCount() {
            return imageResIds.size();
        }

        public class SlideViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            public SlideViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.imageView);
            }
        }
    }
    //auto slide
}
