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
import com.example.duan.activity.Activity_Cart;
import com.example.duan.adapter.ViewPager2FragmentAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class Delivery_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_delivery,container,false);

        TabLayout tabLayout=view.findViewById(R.id.TabLayout);
        ViewPager2 viewPager2=view.findViewById(R.id.ViewPager);
        ImageView icon_cart=view.findViewById(R.id.icon_carts);
        icon_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Activity_Cart.class));
            }
        });

        Fragment[] fragments={new Tab_MyOrder_Fragment(),new Tab_History_Fragment(),new Tab_Cancel_Fragment()};

        ViewPager2FragmentAdapter viewPager2FragmentAdapter=new ViewPager2FragmentAdapter(requireActivity(), fragments);
        viewPager2.setAdapter(viewPager2FragmentAdapter);


        new TabLayoutMediator(tabLayout, viewPager2,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Wait For Confirmation");
                            break;
                        case 1:
                            tab.setText("Purchase History");
                            break;
                        case 2:
                            tab.setText("Cancel Order");
                    }
                }
        ).attach();

        return view;
    }
}
