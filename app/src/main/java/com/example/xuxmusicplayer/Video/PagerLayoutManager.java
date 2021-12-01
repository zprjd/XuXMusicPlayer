//package com.example.xuxmusicplayer.Video;
//
//import android.content.Context;
//import android.widget.LinearLayout;
//
//import androidx.recyclerview.widget.PagerSnapHelper;
//import androidx.recyclerview.widget.RecyclerView;
//
//public class PagerLayoutManager extends LinearLayout {
//    public PagerLayoutManager(Context context) {
//        super(context);
//    }
//
//    private PagerSnapHelper helper;
//
//    private void init(Context context) {
//
//        helper = new PagerSnapHelper() {
//            @Override
//            public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
//                int position = super.findTargetSnapPosition(layoutManager, velocityX, velocityY);
////                ToastUtils.show(context, "当前滑动页号：" + position);
//
//                return position;
//            }
//        };
//    }
//
//    @Override
//    protected void onAttachedToWindow() {
//        super.onAttachedToWindow();
//        helper.attachToRecyclerView(recyclerView);
//        recyclerView.addOnChildAttachStateChangeListener(mChildAttachStateChangeListener);
//    }
//}
