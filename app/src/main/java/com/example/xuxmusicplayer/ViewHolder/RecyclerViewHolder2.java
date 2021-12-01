package com.example.xuxmusicplayer.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.R;

public class RecyclerViewHolder2 extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;
    public RecyclerViewHolder2(@NonNull View itemView) {
        super(itemView);
        imageView=itemView.findViewById(R.id.recycler2img);
        textView=itemView.findViewById(R.id.recycler2text);
    }
}
