package com.example.xuxmusicplayer.NViewHolder;

import android.annotation.TargetApi;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;


import com.example.xuxmusicplayer.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class VideoFragment1 extends Fragment {
    private View view;

    private RecyclerView recyclerView;

    private VideoLayoutManager videoLayoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videofragment, container, false);
        //BottomNavigationView navView = view.findViewById(R.id.nav_view);
        initView(view);
        return view;
    }

    private void initView(View view) {
        recyclerView =  view.findViewById(R.id.videoRecycler);
        videoLayoutManager = new VideoLayoutManager(getActivity(), OrientationHelper.VERTICAL,false);
        recyclerView.setLayoutManager(videoLayoutManager);
        recyclerView.setAdapter(new MyAdapter());
        videoLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {
            @Override
            public void onPageRelease(boolean isNest, View position) {
                releaseVideo(position);
            }

            @Override
            public void onPageSelected(boolean isButten, View position) {
//                int index = 0;
//                if (isButten){
//                    index = 0;
//                }else {
//                    index = 1;
//                }
                playVideo(position);
            }
        });
    }


    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
//        private int[] imgs = {R.mipmap.shop,R.mipmap.shop,R.mipmap.shop,R.mipmap.shop,R.mipmap.shop,R.mipmap.shop};
        private int[] videos = {R.raw.a3,R.raw.a2,R.raw.a1};
        public MyAdapter(){
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.videoitem,parent,false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
//            holder.img_thumb.setImageResource(imgs[position]);
            holder.videoView.setVideoURI(Uri.parse("android.resource://"+getContext().getPackageName()+"/"+ videos[position]));
        }

        @Override
        public int getItemCount() {
            return 3;
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
//            ImageView img_thumb;
            VideoView videoView;
            ImageView img_play;
//            RelativeLayout rootView;
            public ViewHolder(View itemView) {
                super(itemView);
//                img_thumb = itemView.findViewById(R.id.img_thumb);
                videoView = itemView.findViewById(R.id.video_item_player);
                img_play = itemView.findViewById(R.id.img_play);
//                rootView = itemView.findViewById(R.id.root_view);
            }
        }
    }


    /**
     * 停止播放
     * @param itemView
     */
    private void releaseVideo(View itemView){
        final VideoView videoView = itemView.findViewById(R.id.video_item_player);
//        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        //停止播放
        videoView.stopPlayback();
//        imgThumb.animate().alpha(1).start();
        //设置透明度
        imgPlay.animate().alpha(1f).start();    //1.0完全不透明
    }


    /**
     * 开始播放
     * @param itemView
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void playVideo(View itemView) {
        final VideoView videoView = itemView.findViewById(R.id.video_item_player);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        final MediaPlayer[] mediaPlayer = {new MediaPlayer()};
//        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
//        final RelativeLayout rootView = itemView.findViewById(R.id.root_view);

        //LayoutParams主要保存了一个View的布局参数，可以使用LayoutParams来改变布局参数从而达到View位置的效果，
        // 不MATCH_PARENT的话，播放按钮也可以居中，在img的src:vector中自己绘制,然后调整布局。
//        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT);
//        videoView.setLayoutParams(layoutParams);
        videoView.start();
        //注册事件监听器
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                //不能在匿名内部类中访问成员方法中的局部变量，如果要访问必须要被final修饰
                //Java可以对final数组中的元素赋值，但不能改变数组引用的指向，
                mediaPlayer[0] = mp;
                mp.setLooping(true);
//                imgThumb.animate().alpha(0).setDuration(200).start();
                return false;
            }
        });
        //注册准备播放监听器
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mp) {
//
//            }
//        });
        imgPlay.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = true;
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    imgPlay.animate().alpha(1f).start();    //1.0完全不透明
                    videoView.pause();
                    isPlaying = false;
                } else {
                    imgPlay.animate().alpha(0f).start();    //0.0完全透明
                    videoView.start();
                    isPlaying = true;
                }
            }
        });
    }
}