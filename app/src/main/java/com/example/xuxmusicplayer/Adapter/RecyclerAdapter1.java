package com.example.xuxmusicplayer.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Item.RecyclerViewItem1;
import com.example.xuxmusicplayer.R;
import com.example.xuxmusicplayer.ViewHolder.RecyclerViewHolder1;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter1 extends RecyclerView.Adapter<RecyclerViewHolder1>{
    List<RecyclerViewItem1> list = new ArrayList<>();

    public RecyclerAdapter1(List<RecyclerViewItem1> list) {
        this.list = list;
    }
    public enum ItemType{
        ITEM0,ITEM1
    }

    @NonNull
    @Override
    public RecyclerViewHolder1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == ItemType.ITEM0.ordinal()) {
            return new RecyclerViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler0item, parent, false));
        }
        else if(viewType == ItemType.ITEM1.ordinal()) {
            return new RecyclerViewHolder1(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler1item, parent, false));
        }
        return  null;
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerViewHolder1 holder, int position) {
        RecyclerViewItem1 recyclerViewItem1 = list.get(position);
        holder.imageView.setImageResource(recyclerViewItem1.getImageView());
        holder.textView.setText(recyclerViewItem1.getTextView());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0){
            return ItemType.ITEM0.ordinal();
        }else {
            return ItemType.ITEM1.ordinal();
        }
    }
}
