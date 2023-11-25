package com.example.duan.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan.fragment.Tab_Category1_Fragment;
import com.example.duan.fragment.Tab_Home1_Fragment;

public class ViewPager2FragmentAdapter extends FragmentStateAdapter {
    private final Fragment[]fragments;

    public ViewPager2FragmentAdapter(@NonNull FragmentActivity fragmentActivity, Fragment[] fragments) {
        super(fragmentActivity);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments[position];
    }

    @Override
    public int getItemCount() {
        return fragments.length;
    }
}
