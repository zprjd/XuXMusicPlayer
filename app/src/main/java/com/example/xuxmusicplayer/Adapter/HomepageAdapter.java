package com.example.xuxmusicplayer.Adapter;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Fragment.HomepageFragment;
import com.example.xuxmusicplayer.R;
import com.example.xuxmusicplayer.ViewHolder.HPMHViewHolder;
import com.example.xuxmusicplayer.ViewHolder.HomepageViewHolder;
import com.example.xuxmusicplayer.ViewHolder.HpRecommendViewHolder;
import com.example.xuxmusicplayer.ViewHolder.LiveViewHolder;
import com.google.android.material.tabs.TabLayout;

public class HomepageAdapter extends RecyclerView.Adapter{
    private Activity activity;
    HomepageFragment fragment;
    public enum ItemType {
        ITEM0, ITEM1,ITEM2
    }

    public HomepageAdapter(HomepageFragment fragment, Activity activity) {
        this.activity = activity;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == ItemType.ITEM0.ordinal()){
            return new HpRecommendViewHolder(activity,LayoutInflater.from(parent.getContext()).inflate(R.layout.hprecommenditem,parent,false));
            //return new HPMHViewHolder(mLayoutInflater.from(parent.getContext()).inflate(R.layout.hpmusichallitem,parent,false),activity);
        }else if(viewType == ItemType.ITEM1.ordinal()){
            return new HPMHViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hpmusichallitem,parent,false),activity);
        }else if(viewType == ItemType.ITEM2.ordinal()){
            return new LiveViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.hplivebroadcast2,parent,false),activity,fragment);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof HpRecommendViewHolder){
            HpRecommendViewHolder hpRecommendViewHolder = (HpRecommendViewHolder)holder;
            hpRecommendViewHolder.initView();
            Log.d("11111","1111111111111111");
        }else if(holder instanceof HPMHViewHolder){
            HPMHViewHolder hpmhViewHolder = (HPMHViewHolder) holder;
            hpmhViewHolder.initView();
            Log.d("11111","2");
        }else  if(holder instanceof LiveViewHolder){
            LiveViewHolder liveViewHolder = (LiveViewHolder)holder;
            liveViewHolder.initView();
            Log.d("11111","3");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0) {
            return ItemType.ITEM0.ordinal();        //获取某个枚举对象的位置索引值
        }else if(position == 1){
            return ItemType.ITEM1.ordinal();
        }else if(position == 2){
            return ItemType.ITEM2.ordinal();
        }
        return 0;
    }
}
