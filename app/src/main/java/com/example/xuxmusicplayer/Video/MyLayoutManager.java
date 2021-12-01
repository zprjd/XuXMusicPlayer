//package com.example.xuxmusicplayer.Video;
//
//import android.view.View;
//
//import androidx.recyclerview.widget.PagerSnapHelper;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class MyLayoutManager extends RecyclerView.LayoutManager {
//    PagerSnapHelper helper;
//    OnSnapChangedListener onSnapChangedListener;
//    private OnViewPagerListener mOnViewPagerListener;
//    public static final int SCROLL_STATE_IDLE = 0;  //空闲  静止状态
//
//    public static final int SCROLL_STATE_DRAGGING = 1;  //滚动状态
//
//    public static final int SCROLL_STATE_SETTLING = 2; //动画滚动时
//
//    public MyLayoutManager(PagerSnapHelper helper) {
//        this.helper = helper;
//    }
//
//    @Override
//    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
//        return null;
//    }
//    @Override
//    public void onAttachedToWindow(RecyclerView recyclerView) {
//        super.onAttachedToWindow(recyclerView);
//        helper.attachToRecyclerView(recyclerView);
//    }
//
//    @Override
//    public void onScrollStateChanged(int state) {
//        super.onScrollStateChanged(state);
//        if (state == RecyclerView.SCROLL_STATE_IDLE) {
//            View view = helper.findSnapView(this);
//            if (view != null) {
//                int position = getPosition(view);
//                if (onSnapChangedListener != null && getChildCount() == 1) {
//                    onSnapChangedListener.onSnapChanged(position);
//                }
//            }
//        }
//    }
//    public interface OnSnapChangedListener {
//        void onSnapChanged(int position);
//    }
//    public void setOnSnapChangedListener(OnSnapChangedListener onSnapChangedListener) {
//        this.onSnapChangedListener = onSnapChangedListener;
//    }
//
//    private int direction;
//
//    @Override
//    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
//        direction = dy;
//        return super.scrollVerticallyBy(dy, recycler, state);
//    }
//    private RecyclerView.OnChildAttachStateChangeListener mChildAttachStateChangeListener
//            = new RecyclerView.OnChildAttachStateChangeListener() {
//        @Override
//        public void onChildViewAttachedToWindow(View view) {
//            if (mOnViewPagerListener != null && getChildCount() == 1) {
//                mOnViewPagerListener.onInitComplete(); //第一次初始化
//            }
//        }
//
//        @Override
//        public void onChildViewDetachedFromWindow(View view) {
//            //向上滑动还是向下滑动
//            if (direction >= 0) {
//                if (mOnViewPagerListener != null) {
//                    mOnViewPagerListener.onPageRelease(true, getPosition(view));
//                }
//            } else {
//                if (mOnViewPagerListener != null) {
//                    mOnViewPagerListener.onPageRelease(false, getPosition(view));
//                }
//            }
//
//        }
//    };
//
//
//}
