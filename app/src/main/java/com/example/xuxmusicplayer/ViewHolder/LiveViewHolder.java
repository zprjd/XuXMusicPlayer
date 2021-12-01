package com.example.xuxmusicplayer.ViewHolder;

import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Activity.MainActivity;
import com.example.xuxmusicplayer.Fragment.HomepageFragment;
import com.example.xuxmusicplayer.Fragment.Livefragment1;
import com.example.xuxmusicplayer.Fragment.Livefragment2;
import com.example.xuxmusicplayer.Fragment.Mhvpfragment1;
import com.example.xuxmusicplayer.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class LiveViewHolder extends RecyclerView.ViewHolder {
    TabLayout tab1;
    Activity activity;
    HomepageFragment fragment;
    List<Fragment> fragmentList = new ArrayList<>();
//    AppBarLayout appBarLayout;
//    CollapsingToolbarLayout collapsingToolbarLayout;
//    Window window;
//    Toolbar toolbar;
//    ConstraintLayout constraintLayout;
    public LiveViewHolder(@NonNull View itemView, Activity activity, HomepageFragment fragment) {
        super(itemView);
        this.activity = activity;
        this.fragment = fragment;
//        collapsingToolbarLayout = itemView.findViewById(R.id.collapsingToolbar);
//        appBarLayout = itemView.findViewById(R.id.appLayout);
//        window = activity.getWindow();
//        toolbar = itemView.findViewById(R.id.liveTool);
//        constraintLayout = itemView.findViewById(R.id.liveConstrain);
    }

    public void initView() {
//        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//            @Override
//            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                if (verticalOffset <= -constraintLayout.getHeight() / 2) {
//                    collapsingToolbarLayout.setTitle("Future OneX");
//                    toolbar.setVisibility(View.VISIBLE);
////                    toolbar.setNavigationIcon(R.drawable.v7);
//                    //使用下面两个CollapsingToolbarLayout的方法设置展开透明->折叠时你想要的颜色
//                    collapsingToolbarLayout.setExpandedTitleColor(activity.getResources().getColor(android.R.color.transparent));
//                    collapsingToolbarLayout.setCollapsedTitleTextColor(activity.getResources().getColor(R.color.white));
//
//                    window.setStatusBarColor(activity.getResources().getColor(R.color.white));
//                } else {
//                    toolbar.setVisibility(View.GONE);
//                    collapsingToolbarLayout.setTitle("");
//                    window.setStatusBarColor(Color.TRANSPARENT);
//                }
//            }
//        });
        tab1 = itemView.findViewById(R.id.liveTab1);
        tab1.setTabMode(TabLayout.MODE_SCROLLABLE);
        //tab1.setTabRippleColor();
        fragmentList.add(new Livefragment1());
        fragmentList.add(new Livefragment2());
        fragmentList.add(new Livefragment1());
        fragmentList.add(new Livefragment2());
        fragmentList.add(new Livefragment1());
        fragmentList.add(new Livefragment2());
        fragmentList.add(new Livefragment1());
        fragmentList.add(new Livefragment2());
        fragmentList.add(new Livefragment1());
        fragmentList.add(new Livefragment2());
        fragmentList.add(new Livefragment2());
        fragmentList.add(new Livefragment2());
        fragmentList.add(new Livefragment2());
        tab1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                replaceFragment(fragmentList.get(tab.getPosition()));
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
        tab1.addTab(tab1.newTab().setText("热门"));
        tab1.addTab(tab1.newTab().setText("附近"));
        tab1.addTab(tab1.newTab().setText("音乐"));
        tab1.addTab(tab1.newTab().setText("情感"));
        tab1.addTab(tab1.newTab().setText("脱口秀"));
        tab1.addTab(tab1.newTab().setText("萌新"));
        tab1.addTab(tab1.newTab().setText("校园"));
        tab1.addTab(tab1.newTab().setText("男神"));
        tab1.addTab(tab1.newTab().setText("配音"));
        tab1.addTab(tab1.newTab().setText("音乐人"));
    }


    private void replaceFragment(Fragment fragment){
        Log.d("replaceFragment","11");
        FragmentManager fragmentManager = this.fragment.getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.liveframe,fragment);
        fragmentTransaction.commit();
    }
}
