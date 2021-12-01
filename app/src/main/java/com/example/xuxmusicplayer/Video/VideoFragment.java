package com.example.xuxmusicplayer.Video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;


import com.example.xuxmusicplayer.R;

import androidx.recyclerview.widget.RecyclerView;


import org.salient.artplayer.VideoView;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment {
    private ViewPager2 viewPager2;
    private RecyclerView recyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.videofragment, null);
//        viewPager2 = view.findViewById(R.id.videoViewpager2);
//        VideoViewpager2Adapter videoViewpager2Adapter = new VideoViewpager2Adapter(getActivity());
//        viewPager2.setAdapter(videoViewpager2Adapter);
//        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        recyclerView = view.findViewById(R.id.videoRecycler);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            private int thisPosition = -1;
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE: //滚动停止
                        LinearLayoutManager layoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                        if (layoutManager != null) {
                            int firstVisibleItem = layoutManager.findFirstVisibleItemPosition();
                            int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
                            int eddVisibleItem = layoutManager.findLastCompletelyVisibleItemPosition();
                            if (eddVisibleItem == thisPosition) return;
                            thisPosition = eddVisibleItem;
                            int thisVideoView = eddVisibleItem - firstVisibleItem;
                            if (layoutManager != null && layoutManager.getChildAt(thisVideoView) != null
                                    && layoutManager.getChildAt(thisVideoView).findViewById(R.id.video_item_player) != null) {
                                VideoView videoView = layoutManager.getChildAt(thisVideoView).findViewById(R.id.video_item_player);
                                videoView.start();
                                //LogUtils.loge("开始播放新视频");
                            }
                        }
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING: //手指拖动
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING: //惯性滚动
                        break;
                }
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        VideoViewpager2Adapter videoViewpager2Adapter = new VideoViewpager2Adapter(getActivity());
        recyclerView.setAdapter(videoViewpager2Adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        //viewPager2.=
        return view;
    }
}
