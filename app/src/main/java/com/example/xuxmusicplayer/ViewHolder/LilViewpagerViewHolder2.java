package com.example.xuxmusicplayer.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.R;

public class LilViewpagerViewHolder2 extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;
    public TextView textView2;
    public LilViewpagerViewHolder2(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.lilviewpagerimg1);
        textView = itemView.findViewById(R.id.lilviewpagertext1);
        textView2 = itemView.findViewById(R.id.lilviewpagertext2);
    }

    @Override
    public String toString() {
        return "LilViewpagerViewHolder2{" +
                "imageView=" + imageView +
                ", textView=" + textView +
                ", textView2=" + textView2 +
                '}';
    }
}
