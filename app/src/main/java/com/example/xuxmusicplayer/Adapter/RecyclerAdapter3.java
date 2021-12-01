package com.example.xuxmusicplayer.Adapter;

import android.app.Activity;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Item.RecyclerViewItem2;
import com.example.xuxmusicplayer.R;
import com.example.xuxmusicplayer.ViewHolder.LilViewpagerViewHolder1;
import com.example.xuxmusicplayer.ViewHolder.LilViewpagerViewHolder2;

import java.util.List;

public class RecyclerAdapter3 extends RecyclerView.Adapter<LilViewpagerViewHolder2> {
    List<RecyclerViewItem2> list ;

    public RecyclerAdapter3(List<RecyclerViewItem2> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LilViewpagerViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LilViewpagerViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.lilviewpageritem1,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LilViewpagerViewHolder2 holder, int position) {
        RecyclerViewItem2 r = list.get(position);
        Log.d("000000000000000",r.getString1()+","+r.getString2()+","+"");
        holder.imageView.setImageResource(r.getImageResourse());
        holder.textView.setText(r.getString1());
        holder.textView2.setText(r.getString2());
    }

    @Override
    public int getItemCount() {
        return 3;
    }       //只有三个item
}
