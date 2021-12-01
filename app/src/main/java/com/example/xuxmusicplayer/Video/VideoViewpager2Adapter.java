package com.example.xuxmusicplayer.Video;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.R;

import org.salient.artplayer.MediaPlayerManager;
import org.salient.artplayer.ui.ControlPanel;

public class VideoViewpager2Adapter extends RecyclerView.Adapter<VideoViewholder> {
    Context context;
    private int[] videos = {R.raw.a2,R.raw.a3,R.raw.a3};

    public VideoViewpager2Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public VideoViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoitem,parent,false);
        VideoViewholder videoViewHolder = new VideoViewholder(view);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewholder holder, int position) {
        holder.videoView.setUp("http://vfx.mtime.cn/Video/2018/06/27/mp4/180627094726195356.mp4");
        Log.d("1111111111", String.valueOf(Uri.parse("android.resource://"+context.getPackageName()+"/"+ videos[position])));
        final boolean[] isPlay = {false};
        holder.videoView.setUp("android.resource://"+context.getPackageName()+"/"+ videos[position]);
        holder.videoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (holder.videoView == null) return;
                if (isPlay[0]) {
                    isPlay[0] = false;
                    MediaPlayerManager.instance().pause(); // 停止播放
                    holder.videoView.setVisibility(View.GONE);
                } else {
                    //if (getPosition()!=Attention_Adapter.startPosition){
                    MediaPlayerManager.instance().releaseMediaPlayer();
                    //}
                    isPlay[0] = true;
                    MediaPlayerManager.instance().start();
                    holder.videoView.setVisibility(View.VISIBLE);
                }
            }
        });
        MediaPlayerManager.instance().setLooping(true);
        //holder.videoView.setUp("http://vfx.mtime.cn/Video/2018/06/27/mp4/180627094726195356.mp4");
        holder.videoView.setControlPanel(new ControlPanel(context));
        holder.videoView.start();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
//
//    @NonNull
//    @Override
//    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoitem,parent,false);
//        VideoViewHolder videoViewHolder = new VideoViewHolder(context,view);
//        return videoViewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
////        holder.videoView.setUp("http://vfx.mtime.cn/Video/2018/06/27/mp4/180627094726195356.mp4");
//        Log.d("1111111111", String.valueOf(Uri.parse("android.resource://"+context.getPackageName()+"/"+ videos[position])));
//        final boolean[] isPlay = {false};
//        holder.videoView.setUp("android.resource://"+context.getPackageName()+"/"+ videos[position]);
//        holder.videoView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (holder.videoView == null) return;
//                if (isPlay[0]) {
//                    isPlay[0] = false;
//                    MediaPlayerManager.instance().pause(); // 停止播放
//                    holder.videoView.setVisibility(View.GONE);
//                } else {
//                    //if (getPosition()!=Attention_Adapter.startPosition){
//                        MediaPlayerManager.instance().releaseMediaPlayer();
//                    //}
//                    isPlay[0] = true;
//                    MediaPlayerManager.instance().start();
//                    holder.videoView.setVisibility(View.VISIBLE);
//                }
//            }
//        });
//        MediaPlayerManager.instance().setLooping(true);
//        //holder.videoView.setUp("http://vfx.mtime.cn/Video/2018/06/27/mp4/180627094726195356.mp4");
//        holder.videoView.setControlPanel(new ControlPanel(context));
//        holder.videoView.start();



}
