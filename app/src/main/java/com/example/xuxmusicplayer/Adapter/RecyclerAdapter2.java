package com.example.xuxmusicplayer.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Item.RecyclerViewItem1;
import com.example.xuxmusicplayer.R;
import com.example.xuxmusicplayer.ViewHolder.RecyclerViewHolder2;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerViewHolder2> {
    List<RecyclerViewItem1> list;

    public RecyclerAdapter2(List<RecyclerViewItem1> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("22222222",",,,,,,");
        return new RecyclerViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler2item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewHolder2 holder, int position) {
        RecyclerViewItem1 r1 = list.get(position);
        holder.imageView.setImageResource(r1.getImageView());
        holder.textView.setText(r1.getTextView());
        Log.d("22222222","");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
