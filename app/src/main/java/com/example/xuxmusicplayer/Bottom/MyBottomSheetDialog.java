package com.example.xuxmusicplayer.Bottom;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.xuxmusicplayer.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MyBottomSheetDialog extends BottomSheetDialog {
    View view;
    int peekHeight;
    public MyBottomSheetDialog(@NonNull Context context,View view) {
        super(context);
    }

    public MyBottomSheetDialog(@NonNull Context context, int theme) {
        super(context, theme);
    }

    protected MyBottomSheetDialog(@NonNull Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        int screenHeight = getScreenHeight(getContext());
        Window window = getWindow();
        assert window != null;

        //设置沉浸式
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,screenHeight);

        //设置最大高度 给dialog设置固定高度
        //相减去的高度，dialog默认最大高度在状态栏下方
//        float reduceHeight = getContext().getResources().getDimension(R.dimen.qb_px_120);
//        int reduceHeight = ScreenUtils.getStatusBarHeight(getContext());

        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,screenHeight+200);
        //不设置的话BottomSheetDialog会显示在屏幕中间
//        window.setGravity(Gravity.BOTTOM);

//        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from();
    }


    @Override
    public void show() {
        super.show();
//        if (peekHeight == 0){
//            View container = findViewById(R.id.dialog_bottomLayout);
//            container.measure(0,0);
//            peekHeight = container.getMeasuredHeight();
//            ConstraintLayout bottomSheet = (ConstraintLayout) findViewById(R.id.dialog_bottomLayout);
//            BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
//            behavior.setPeekHeight(peekHeight);
//        }
    }

    //获取屏幕高度
    public static int getScreenHeight(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        assert wm != null;
        wm.getDefaultDisplay().getSize(point);
        return point.y;
    }
}
