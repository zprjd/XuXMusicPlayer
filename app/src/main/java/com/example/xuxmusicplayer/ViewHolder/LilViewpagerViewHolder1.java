package com.example.xuxmusicplayer.ViewHolder;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Adapter.RecyclerAdapter1;
import com.example.xuxmusicplayer.Item.RecyclerViewItem1;
import com.example.xuxmusicplayer.R;

public class LilViewpagerViewHolder1 extends RecyclerView.ViewHolder {
    public RecyclerView recyclerView;
    public LilViewpagerViewHolder1(@NonNull View itemView) {
        super(itemView);
        recyclerView = itemView.findViewById(R.id.lilviewpagerrecycler);
    }
}
