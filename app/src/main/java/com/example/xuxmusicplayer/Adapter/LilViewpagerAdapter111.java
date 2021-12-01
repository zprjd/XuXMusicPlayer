package com.example.xuxmusicplayer.Adapter;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import android.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Fragment.Mhvpfragment1;
import com.example.xuxmusicplayer.Item.RecyclerViewItem2;
import com.example.xuxmusicplayer.R;
import com.example.xuxmusicplayer.ViewHolder.LilViewpagerViewHolder1;

import java.util.List;

public class LilViewpagerAdapter111 extends RecyclerView.Adapter<LilViewpagerViewHolder1> {
    List<RecyclerViewItem2> list1 ;
    List<RecyclerViewItem2> list2 ;
    List<List<RecyclerViewItem2>> list;
    Activity activity;
    public LilViewpagerAdapter111(List<List<RecyclerViewItem2>> list, Activity activity) {
        this.list = list;
        this.activity = activity;
        list1=list.get(0);
        list2=list.get(1);
    }

    @NonNull
    @Override
    public LilViewpagerViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LilViewpagerViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.lilviewpageritem0,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LilViewpagerViewHolder1 holder, int position) {
        Log.d("000000000",position+"");
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        //ViewPager中ReyclerView的Adapter其中存的是一张图两个字符串
        if(position == 0) {
            RecyclerAdapter3 recyclerAdapter3 = new RecyclerAdapter3(list1);
            holder.recyclerView.setAdapter(recyclerAdapter3);
            holder.recyclerView.setLayoutManager(layoutManager);
        }else {
            RecyclerAdapter3 recyclerAdapter3 = new RecyclerAdapter3(list2);
            holder.recyclerView.setAdapter(recyclerAdapter3);
            holder.recyclerView.setLayoutManager(layoutManager);
        }
    }

    @Override
    public int getItemCount() {
        return 2;   //ViewPager有两页,每一页只有一个recyclerview
    }
}
