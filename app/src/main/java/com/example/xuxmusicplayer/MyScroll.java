package com.example.xuxmusicplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;

public class MyScroll extends NestedScrollView {
    int mLastX = 0;
    int mLastY = 0;
    int mLastXIntercept = 0 ;
    int mLastYIntercept = 0;
    public MyScroll(@NonNull Context context) {
        super(context);
    }

    public MyScroll(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScroll(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                // 禁止parent拦截down事件
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int deltaX = x - mLastX;
                int deltaY = y - mLastY;
//                if (disallowParentInterceptTouchEvent) { // 根据需求条件来决定是否让Parent View拦截事件。
//                    parent.requestDisallowInterceptTouchEvent(false);
//                }
                break;
            }
            case MotionEvent.ACTION_UP: {
                break;
            }
            default:
                break;
        }

        mLastX = x;
        mLastY = y;
        return super.dispatchTouchEvent(event);
    }
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//        boolean intercepted = false;
//        int x = (int) event.getX();
//        int y = (int) event.getY();
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_DOWN: {
//                intercepted = false;
//                break;
//            }
//            case MotionEvent.ACTION_MOVE: {
////                if (needIntercept) { // 这里根据需求判断是否需要拦截
////                    intercepted = true;
////                } else {
////                    intercepted = false;
////                }
//                break;
//            }
//            case MotionEvent.ACTION_UP: {
//                intercepted = false;
//                break;
//            }
//            default:
//                break;
//        }
//        mLastXIntercept = x;
//        mLastYIntercept = y;
//        return intercepted;
//    }
}
