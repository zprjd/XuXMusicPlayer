package com.example.xuxmusicplayer.NViewHolder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class VideoLayoutManager extends LinearLayoutManager implements RecyclerView.OnChildAttachStateChangeListener {
    //判断是否上滑还是下滑
    private int mDrift;

    //监听播放、停止播放
    private OnViewPagerListener onViewPagerListener;

    //RecyclerView的辅助类，辅助RecyclerView滚动结束时将Item对齐到某个位置，吸顶，吸底
    private PagerSnapHelper pagerSnapHelper;

    public void setOnViewPagerListener(OnViewPagerListener onViewPagerListener) {
        this.onViewPagerListener = onViewPagerListener;
    }

    public OnViewPagerListener getOnViewPagerListener() {
        return onViewPagerListener;
    }

    public VideoLayoutManager(Context context) {
        super(context);
    }

    public VideoLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
        pagerSnapHelper = new PagerSnapHelper();
    }

    /**
     * 当manager完全添加到recycleview中是会被调用
     * @param view
     * onCreate->onStart->onResume->onAttachedToWindow
     */
    @Override
    public void onAttachedToWindow(RecyclerView view) {
        //注册一个监听器, 当子组件被附加或者从 RecycleView 中移除时, 会得到一个相关的通知.
        view.addOnChildAttachStateChangeListener(this);
        //主要调用了 setupCallbacks()和snapToTargetExistingView()，
        // setupCallbacks()主要是添加了OnScrollListener和OnFlingListener监听回调。
        //snapToTargetExistingView()是初始化当前RecyclerView里Item的对齐位置，滑动结束后再次调用是为了使滑动结束后的Item也保持对齐
        pagerSnapHelper.attachToRecyclerView(view);
        super.onAttachedToWindow(view);
    }

    @Override
    public boolean canScrollVertically() {
        return super.canScrollVertically();
    }

    @Override
    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        mDrift = dy;
        return super.scrollVerticallyBy(dy, recycler, state);

    }

    @Override
    public void onChildViewAttachedToWindow(@NonNull View view) {
        if (mDrift > 0){
            //向上滑
            if (onViewPagerListener != null && Math.abs(mDrift) == view.getHeight()){
                onViewPagerListener.onPageSelected(false,view);
            }
        }else {
            //向下滑
            if (onViewPagerListener != null && Math.abs(mDrift) == view.getHeight()){
                onViewPagerListener.onPageSelected(true,view);
            }
        }
    }

    @Override
    public void onChildViewDetachedFromWindow(@NonNull View view) {
        if (mDrift >= 0){
            //向上滑
            if (onViewPagerListener != null){
                onViewPagerListener.onPageRelease(true,view);
            }
        }else {
            //向下滑
            if (onViewPagerListener != null){
                onViewPagerListener.onPageRelease(false,view);
            }
        }
    }

    //onScrollStateChanged是当滚动状态发生改变时调用,这里的 newState有三种状态：
    //public static final int SCROLL_STATE_IDLE = 0;//静止没有滚动
    //public static final int SCROLL_STATE_DRAGGING = 1;//正在被外部拖拽,一般为用户正在用手指滚动
    //public static final int SCROLL_STATE_SETTLING = 2;//自动滚动
    @Override
    public void onScrollStateChanged(int state) {
        switch (state){
            case RecyclerView.SCROLL_STATE_IDLE:
                //当前显示的item
                View snapView = pagerSnapHelper.findSnapView(this);
                if (onViewPagerListener != null){
                    onViewPagerListener.onPageSelected(false,snapView);
                }
                break;
        }
        super.onScrollStateChanged(state);
    }
}
