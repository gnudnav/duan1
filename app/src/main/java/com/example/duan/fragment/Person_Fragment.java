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

import com.example.duan.R;
import com.example.duan.activity.Activity_Edit_Profile;
import com.example.duan.activity.Activity_NhapPass;

public class Person_Fragment extends Fragment {
    private ImageView profile,changed_password,notification,language,cancel,hegalndpolicies,helpsupport,logout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_person,container,false);
        profile=view.findViewById(R.id.profile);
        changed_password=view.findViewById(R.id.changed_password);
        notification=view.findViewById(R.id.notification);
        language=view.findViewById(R.id.language);
        helpsupport=view.findViewById(R.id.helpsupport);
        hegalndpolicies=view.findViewById(R.id.Helpandpolicies);
        logout=view.findViewById(R.id.logout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Activity_Edit_Profile.class));
            }
        });
        changed_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Activity_NhapPass.class));
            }
        });


        return view;
    }
}
