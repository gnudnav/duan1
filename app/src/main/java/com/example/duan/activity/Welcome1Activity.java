package com.example.duan.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.example.duan.R;
import com.example.duan.adapter.PhotoViewPagerAdapter;
import com.example.duan.model.Photo;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class Welcome1Activity extends AppCompatActivity {

    private AppCompatButton btnCreate;
    private TextView txtAcount;
    private ViewPager mViewPager;
    private CircleIndicator mCircleIndicator;
    private List<Photo> mListPhoto;
    private Handler mHandler=new Handler();
    private Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            if (mViewPager.getCurrentItem()==mListPhoto.size()-1){
                mViewPager.setCurrentItem(0);
            }else{
                mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);
            }

        }
    };

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);

        mViewPager=findViewById(R.id.view_pager);
        mCircleIndicator=findViewById(R.id.circle_indicator);
        btnCreate = findViewById(R.id.btnCreate);
        txtAcount=findViewById(R.id.txtAcount);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome1Activity.this, RegistonActivity.class));
            }
        });
        txtAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Welcome1Activity.this, Activity_Login.class));
            }
        });

        mListPhoto=getListPhoto();
        PhotoViewPagerAdapter adapter=new PhotoViewPagerAdapter(mListPhoto);
        mViewPager.setAdapter(adapter);
        mCircleIndicator.setViewPager(mViewPager);

        mHandler.postDelayed(mRunnable,5000);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                mHandler.removeCallbacks(mRunnable);
                mHandler.postDelayed(mRunnable,5000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        }
    private List<Photo>getListPhoto(){
        List<Photo>list=new ArrayList<>();
        list.add(new Photo(R.drawable.img_1));
        list.add(new Photo(R.drawable.img_2));
        list.add(new Photo(R.drawable.img_3));
        return list;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(mRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(mRunnable,5000);
    }
}