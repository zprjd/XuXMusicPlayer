package com.example.xuxmusicplayer;

import android.annotation.SuppressLint;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Field;

public class BottomNavigationViewHelper {
    @SuppressLint("RestrictedApi")
    public static void disableShiftMode(BottomNavigationView view){
        BottomNavigationMenuView menuView = (BottomNavigationMenuView)view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("ShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView,false);
            shiftingMode.setAccessible(false);
            for(int i = 0;i< menuView.getChildCount();i++){
                BottomNavigationItemView item = (BottomNavigationItemView)menuView.getChildAt(i);
                item.setShifting(false);
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}