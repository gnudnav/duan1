package com.example.duan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.duan.R;
import com.example.duan.activity.SearchViewActivity;
import com.example.duan.adapter.ViewPager2FragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Home_Fragment extends Fragment {
    public Home_Fragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);

        TabLayout tabLayout=view.findViewById(R.id.TabLayout);
        ViewPager2 viewPager2=view.findViewById(R.id.ViewPager);
        ImageView ic_searchView=view.findViewById(R.id.ic_searchView);
        ic_searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchViewActivity.class));
            }
        });

        Fragment[] fragments={new Tab_Home1_Fragment(),new Tab_Category1_Fragment()};

        ViewPager2FragmentAdapter viewPager2FragmentAdapter=new ViewPager2FragmentAdapter(requireActivity(), fragments);
        viewPager2.setAdapter(viewPager2FragmentAdapter);


        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Home");
                            break;
                        case 1:
                            tab.setText("Category");
                            break;
                    }
                }
        ).attach();
        return view;

    }
}
