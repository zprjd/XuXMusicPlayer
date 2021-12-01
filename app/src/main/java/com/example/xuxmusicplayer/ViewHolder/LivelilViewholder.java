package com.example.xuxmusicplayer.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.R;

public class LivelilViewholder extends RecyclerView.ViewHolder {
    public TextView textView1;
    public TextView textView1_5;
    public TextView textView2;
    public TextView textView2_5;
    public ImageView img1;
    public ImageView img2;
    public LivelilViewholder(@NonNull View itemView) {
        super(itemView);
        textView1=itemView.findViewById(R.id.lilLivetext1);
        textView1_5=itemView.findViewById(R.id.lilLivetext1_5);
        textView2=itemView.findViewById(R.id.lilLivetext2);
        textView2_5=itemView.findViewById(R.id.lilLivetext2_5);
        img1 = itemView.findViewById(R.id.lilLiveimge1);
        img2 = itemView.findViewById(R.id.lilLiveimge2);
    }
}
