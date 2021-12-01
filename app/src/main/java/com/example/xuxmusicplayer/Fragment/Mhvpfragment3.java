package com.example.xuxmusicplayer.Fragment;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.example.xuxmusicplayer.R;

public class Mhvpfragment3 extends android.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lilvpfragment3,container,false);
        ImageView img1 = view.findViewById(R.id.lilvpfragmentimg1);
        ImageView img2 = view.findViewById(R.id.lilvpfragmentimg2);
        ImageView img3 = view.findViewById(R.id.lilvpfragmentimg3);
        img1.setImageResource(R.drawable.c1);
        img2.setImageResource(R.drawable.c2);
        img3.setImageResource(R.drawable.c3);
        return view;
    }
}
