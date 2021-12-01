package com.example.xuxmusicplayer.Fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.xuxmusicplayer.Adapter.LilViewpagerAdapter111;
import com.example.xuxmusicplayer.Item.RecyclerViewItem2;
import com.example.xuxmusicplayer.R;

import java.util.ArrayList;
import java.util.List;

public class Mhvpfragment1 extends Fragment {
    RecyclerView recyclerView;
    ViewPager2 viewPager2;
    List<List<RecyclerViewItem2>> list0 = new ArrayList<>();
    List<RecyclerViewItem2> list = new ArrayList<>();
    List<RecyclerViewItem2> list2 = new ArrayList<>();
    @Override
    public void onResume() {
        super.onResume();
        //recyclerView.findViewById(R.id.lilviewpagerrecycler);
        initData();
        //ViewPager的Adapter，其中每个item存的是recyclerview,包含竖的3个item
        LilViewpagerAdapter111 lilViewpagerAdapter111 = new LilViewpagerAdapter111(list0,getActivity());
        viewPager2.setAdapter(lilViewpagerAdapter111);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lilvpfragment1,container,false);
        viewPager2 = view.findViewById(R.id.lilviewpagerviewpager);
        return view;
    }

    private void initData() {
        RecyclerViewItem2 r1 = new RecyclerViewItem2();
        r1.setString1("Rollin' On");
        r1.setString2("Mark Knopfler");
        r1.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r2 = new RecyclerViewItem2();
        r2.setString1("Chateau(Acoustic)");
        r2.setString2("Angus & Julia Stone");
        r2.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r3 = new RecyclerViewItem2();
        r3.setString1("In My Life");
        r3.setString2("John Lennon");
        r3.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r4 = new RecyclerViewItem2();
        r4.setString1("Quiet Inside");
        r4.setString2("Andy Tubman");
        r4.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r5 = new RecyclerViewItem2();
        r5.setString1("g小调巴赫平均律变奏曲MayPiano");
        r5.setString2("MayPiano");
        r5.setImageResourse(R.drawable.img1);
        RecyclerViewItem2 r6 = new RecyclerViewItem2();
        r6.setString1("Heart of Gold");
        r6.setString2("Neil Young");
        r6.setImageResourse(R.drawable.img1);
        list.add(r1);
        list.add(r2);
        list.add(r3);
        list2.add(r4);
        list2.add(r5);
        list2.add(r6);
        list0.add(list);
        list0.add(list2);
    }
}
