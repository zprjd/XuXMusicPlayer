package com.example.xuxmusicplayer.Adapter;

import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Item.LivelilViewItem;
import com.example.xuxmusicplayer.R;
import com.example.xuxmusicplayer.ViewHolder.LivelilViewholder;

import java.util.ArrayList;
import java.util.List;

public class LivelilAdapter extends RecyclerView.Adapter<LivelilViewholder> {
    List<LivelilViewItem> list = new ArrayList<>();

    public LivelilAdapter(List<LivelilViewItem> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public LivelilViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.livelilviewholder,parent,false);
        LivelilViewholder livelilViewholder = new LivelilViewholder(view);
        return livelilViewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull LivelilViewholder holder, int position) {
        LivelilViewItem l = list.get(position);
        holder.textView1.setText(l.getTextView1());
        holder.textView1_5.setText(l.getTextView1_5());
        holder.textView2.setText(l.getTextView2());
        holder.textView2_5.setText(l.getTextView2_5());
        holder.img1.setImageResource(l.getImg1());
        holder.img2.setImageResource(l.getImg2());
        Log.d("LivelilAdapterLivelilAdapter",holder.textView1.getText()+",,"+l.getImg1());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
