package com.example.xuxmusicplayer.ViewHolder;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import android.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.xuxmusicplayer.Fragment.Mhvpfragment1;
import com.example.xuxmusicplayer.Fragment.Mhvpfragment2;
import com.example.xuxmusicplayer.Fragment.Mhvpfragment3;
import com.example.xuxmusicplayer.Item.RecyclerViewItem2;
import com.example.xuxmusicplayer.Loader.MyImageLoader;
import com.example.xuxmusicplayer.R;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;


import java.util.ArrayList;
import java.util.List;

public class HPMHViewHolder extends RecyclerView.ViewHolder {
    Banner mBanner;
    ArrayList<Integer> imagePath;
    ArrayList<String> imageTitle;
    public Context context;
    MyImageLoader myImageLoader;
    TabLayout tab1;
    ViewPager2 viewPager21;
    List<RecyclerViewItem2> list = new ArrayList<>();
    List<RecyclerViewItem2> list2 = new ArrayList<>();
    Activity activity;

    public HPMHViewHolder(@NonNull View itemView, Activity activity) {
        super(itemView);
        this.activity = activity;
    }

    public HPMHViewHolder(@NonNull View itemView) {
        super(itemView);
    }
//    public void initData(){
//        imagePath = new ArrayList<>();
//        imageTitle = new ArrayList<>();
//        imagePath.add(R.drawable.thenameoflife);
//        imagePath.add(R.drawable.thenameoflife);
//        imagePath.add(R.drawable.thenameoflife);
//        imageTitle.add("我是图1");
//        imageTitle.add("我是图2");
//        imageTitle.add("我是图3");
//    }
    @SuppressLint("WrongConstant")
    public void initView(){
        imagePath = new ArrayList<>();
        imageTitle = new ArrayList<>();
        imagePath.add(R.drawable.thenameoflife);
        imagePath.add(R.drawable.thenameoflife);
        imagePath.add(R.drawable.thenameoflife);
        imageTitle.add("我是图1");
        imageTitle.add("我是图2");
        imageTitle.add("我是图3");
        myImageLoader = new MyImageLoader();
        mBanner = itemView.findViewById(R.id.hpmhbanner);
        Log.d("11",mBanner.toString());
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);//样式
        mBanner.setImageLoader(myImageLoader);//图片加载器
        mBanner.setBannerAnimation(Transformer.ZoomOutSlide);//轮播动画效果
        mBanner.setBannerTitles(imageTitle);    //轮播图片的文字
        mBanner.setDelayTime(3000);     //设置轮播间隔时间
        mBanner.isAutoPlay(true);   //自动轮播
        mBanner.setIndicatorGravity(BannerConfig.CENTER);   //设置指示器位置，小点点，居中显示
        mBanner.setImages(imagePath).setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(itemView.getContext(),"你点了第"+(position+1)+"张轮播图",Toast.LENGTH_SHORT).show();
            }
        }).start();
        tab1=itemView.findViewById(R.id.musicahalltab1);
        tab1.setTabMode(TabLayout.MODE_SCROLLABLE);//Must be one of: TabLayout.MODE_SCROLLABLE, TabLayout.MODE_FIXED, TabLayout.MODE_AUTO
//        viewPager21 = itemView.findViewById(R.id.musichallviewpager1);
        initData1();
        //LilViewpagerAdapter lilViewpagerAdapter = new LilViewpagerAdapter(list,activity);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Mhvpfragment1());             //fragment中是个viewpager
        fragments.add(new Mhvpfragment2());         //12布局相同但数据不同
        fragments.add(new Mhvpfragment3());
        tab1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
//                layoutManager.setOrientation(RecyclerView.VERTICAL);
                replaceFragment(fragments.get(tab.getPosition()));
                Log.d("333333333333",tab.getPosition()+"");
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        tab1.addTab(tab1.newTab().setText("新歌"));
        tab1.addTab(tab1.newTab().setText("新碟"));
        tab1.addTab(tab1.newTab().setText(" 数字专辑 "));
        //        viewPager21.setAdapter(lilViewpagerAdapter);
//        final String[] tabs = new String[]{"新歌","新碟"," 数字专辑 "};
//        new TabLayoutMediator(tab1, viewPager21, new TabLayoutMediator.TabConfigurationStrategy() {
//            @Override
//            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
//                tab.setText(tabs[position]);
//            }
//        }).attach();
    }
    void initData1(){
//        LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
//        layoutManager.setOrientation(RecyclerView.HORIZONTAL);
//        LilViewpagerAdapter lilViewpagerAdapter = new LilViewpagerAdapter(list);
//        RecyclerView recyclerView = itemView.findViewById(R.id.lilviewpagerimg1);
//        recyclerView.setAdapter(lilViewpagerAdapter);
        RecyclerViewItem2 r1 = new RecyclerViewItem2();
        r1.setString1("ESCAPE PLAN");
        r1.setString2("Travis Scott");
        r1.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r2 = new RecyclerViewItem2();
        r2.setString1("So Hot");
        r2.setString2("IXFORM");
        r2.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r3 = new RecyclerViewItem2();
        r3.setString1("Playground");
        r3.setString2("Bea Miller");
        r3.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r4 = new RecyclerViewItem2();
        r4.setString1("光亮");
        r4.setString2("周深");
        r4.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r5 = new RecyclerViewItem2();
        r5.setString1("又弹起心爱的土琵琶");
        r5.setString2("刘德华");
        r5.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r6 = new RecyclerViewItem2();
        r6.setString1("Smoking Out The Window");
        r6.setString2("Bruno Mars/Anderson Paak/Silk Sonic");
        r6.setImageResourse(R.drawable.img1);
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list2.add(r4);
        list2.add(r5);
        list2.add(r6);
    }
    private void replaceFragment(Fragment fragment){
        activity.getFragmentManager().beginTransaction().replace(R.id.musichallframe1,fragment).commit();
        Log.d("333333333333",fragment.toString()+"");
    }
}
