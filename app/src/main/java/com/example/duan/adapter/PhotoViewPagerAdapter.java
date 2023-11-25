package com.example.duan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.duan.R;
import com.example.duan.model.Photo;

import java.util.List;

public class PhotoViewPagerAdapter extends PagerAdapter {

    private List<Photo> mlistPhoto;

    public PhotoViewPagerAdapter(List<Photo> mlistPhoto) {
        this.mlistPhoto = mlistPhoto;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view= LayoutInflater.from(container.getContext()).inflate(R.layout.item_photo,container,false);
        ImageView imgPhoto=view.findViewById(R.id.img_photo);

        Photo photo=mlistPhoto.get(position);
        imgPhoto.setImageResource(photo.getResourceId());
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        if(mlistPhoto!=null){
            return mlistPhoto.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
