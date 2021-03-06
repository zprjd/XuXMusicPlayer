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
     * ????????????
     * @param itemView
     */
    private void releaseVideo(View itemView){
        final VideoView videoView = itemView.findViewById(R.id.video_item_player);
//        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        //????????????
        videoView.stopPlayback();
//        imgThumb.animate().alpha(1).start();
        //???????????????
        imgPlay.animate().alpha(1f).start();    //1.0???????????????
    }


    /**
     * ????????????
     * @param itemView
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void playVideo(View itemView) {
        final VideoView videoView = itemView.findViewById(R.id.video_item_player);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        final MediaPlayer[] mediaPlayer = {new MediaPlayer()};
//        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
//        final RelativeLayout rootView = itemView.findViewById(R.id.root_view);

        //LayoutParams?????????????????????View??????????????????????????????LayoutParams?????????????????????????????????View??????????????????
        // ???MATCH_PARENT??????????????????????????????????????????img???src:vector???????????????,?????????????????????
//        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT,ConstraintLayout.LayoutParams.MATCH_PARENT);
//        videoView.setLayoutParams(layoutParams);
        videoView.start();
        //?????????????????????
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                //?????????????????????????????????????????????????????????????????????????????????????????????final??????
                //Java?????????final??????????????????????????????????????????????????????????????????
                mediaPlayer[0] = mp;
                mp.setLooping(true);
//                imgThumb.animate().alpha(0).setDuration(200).start();
                return false;
            }
        });
        //???????????????????????????
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
                    imgPlay.animate().alpha(1f).start();    //1.0???????????????
                    videoView.pause();
                    isPlaying = false;
                } else {
                    imgPlay.animate().alpha(0f).start();    //0.0????????????
                    videoView.start();
                    isPlaying = true;
                }
            }
        });
    }
}