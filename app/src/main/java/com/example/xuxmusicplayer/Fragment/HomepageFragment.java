package com.example.xuxmusicplayer.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.xuxmusicplayer.Adapter.HomepageAdapter;
import com.example.xuxmusicplayer.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomepageFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    final String[] tabs = new String[]{"推荐","音乐馆","直播"};
    private ImageView imageView;
    private Toolbar toolbar;
    private NestedScrollView nestedScrollView;
    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homepagefragment,container,false);
        toolbar=view.findViewById(R.id.toolbar222);
        //toolbar.inflateMenu(R.menu.toolbar);
        tabLayout = view.findViewById(R.id.homepageTab);
        viewPager2 = view.findViewById(R.id.homepageViewpager2);
//        nestedScrollView = view.findViewById(R.id.hpnestedScrollView);
        return view;
    }

//    @Override
//    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
//        super.onCreateOptionsMenu(menu, inflater);
//        //inflater.inflate(R.menu.toolbar,menu);
//    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        HomepageAdapter homepageAdapter = new HomepageAdapter(this,getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        viewPager2.setOrientation(viewPager2.ORIENTATION_HORIZONTAL);
        viewPager2.setAdapter(homepageAdapter);
        imageView = getActivity().findViewById(R.id.hpimg1);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(position==0){
                    imageView.setImageResource(R.drawable.qqmusimg1);
                    Log.d("onPageSelected11111","1");
                }else if(position == 1){
                    imageView.setImageResource(R.drawable.qqmusimg1);
                    Log.d("onPageSelected11111","2");
                }else if(position == 2){
                    imageView.setImageResource(R.drawable.plus1);
                    Log.d("onPageSelected11111","3");
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
        viewPager2.setOffscreenPageLimit(3);
//        tabLayout.setFocusableInTouchMode(false);   //触摸是否获得焦点
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull  TabLayout.Tab tab, int position) {
                tab.setText(tabs[position]);
            }
        }).attach();
//        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                nestedScrollView.getParent().requestDisallowInterceptTouchEvent(true);
//            }
//        });
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                //在这里可以设置选中状态下  tab字体显示样式
//                viewPager2.setCurrentItem(tab.getPosition());
//                View view = tab.getCustomView();
//                if (null != view && view instanceof TextView) {
//                    ((TextView) view).setTextSize(19);
//                    //((TextView) view).setTextColor(ContextCompat.getColor(getActivity(), R.color.));
//                }
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                View view = tab.getCustomView();
//                if (null != view && view instanceof TextView) {
//                    ((TextView) view).setTextSize(14);
//                    //((TextView) view).setTextColor(ContextCompat.getColor(getActivity(), R.color.));
//                }
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });

        /*无ViewPager2*/
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
//        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
    }

}
