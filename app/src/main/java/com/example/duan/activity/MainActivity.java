package com.example.duan.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.duan.R;
import com.example.duan.fragment.Delivery_Fragment;
import com.example.duan.fragment.Heart_Fragment;
import com.example.duan.fragment.Home_Fragment;
import com.example.duan.fragment.Person_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.frameLayout);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);

        loadFragment(new Home_Fragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment=null;
                if(item.getItemId()==R.id.btm_home){
                    fragment=new Home_Fragment();
                } else if (item.getItemId()==R.id.btm_delivery) {
                    fragment=new Delivery_Fragment();
                }else if (item.getItemId()==R.id.btm_heart){
                    fragment=new Heart_Fragment();
                } else if (item.getItemId()==R.id.btm_person) {
                    fragment=new Person_Fragment();
                }
                return loadFragment(fragment);
            }
        });
    }
    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment)
                    .commit();
            return true;
        }
        return false;
    }
}