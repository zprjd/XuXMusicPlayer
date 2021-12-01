package com.example.xuxmusicplayer.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.xuxmusicplayer.R;
import com.google.android.material.tabs.TabLayout;

public class MineFragment extends Fragment {
    private TabLayout tabLayout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.minefragment,null);
        tabLayout=view.findViewById(R.id.mineTab);
        tabLayout.addTab(tabLayout.newTab().setText("我的"));
        return view;
    }
}
