package com.example.xuxmusicplayer.NViewHolder;

import android.view.View;

public interface OnViewPagerListener {
    //停止播放的监听
    void onPageRelease(boolean isRelease, View position);

    //播放的监听
    void onPageSelected(boolean isSelected,View position);
}
