package com.example.xuxmusicplayer.Video;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.R;

import org.salient.artplayer.VideoView;

public class VideoViewholder extends RecyclerView.ViewHolder {
    public VideoView videoView;
    public VideoViewholder(@NonNull View itemView) {
        super(itemView);
        videoView = itemView.findViewById(R.id.video_item_player);
    }
}
