package com.example.xuxmusicplayer.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

import com.example.xuxmusicplayer.Adapter.LilViewpagerAdapter111;
import com.example.xuxmusicplayer.Item.RecyclerViewItem2;
import com.example.xuxmusicplayer.R;

import java.util.ArrayList;
import java.util.List;

public class Mhvpfragment2 extends Fragment {
    ViewPager2 viewPager2;
    static List<List<RecyclerViewItem2>> list0 = new ArrayList<>();
    static List<RecyclerViewItem2> list = new ArrayList<>();
    static List<RecyclerViewItem2> list2 = new ArrayList<>();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
        //recyclerView.findViewById(R.id.lilviewpagerrecycler);
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

    private static void initData() {
        RecyclerViewItem2 r1 = new RecyclerViewItem2();
        r1.setString1("舞厅");
        r1.setString2("派克特");
        r1.setImageResourse(R.drawable.p6);
        RecyclerViewItem2 r2 = new RecyclerViewItem2();
        r2.setString1("The Show Must Go On");
        r2.setString2("Queen");
        r2.setImageResourse(R.drawable.p6);
        RecyclerViewItem2 r3 = new RecyclerViewItem2();
        r3.setString1("To Be By Your Side");
        r3.setString2("Bruno Coulais");
        r3.setImageResourse(R.drawable.p6);
        RecyclerViewItem2 r4 = new RecyclerViewItem2();
        r4.setString1("Why we here");
        r4.setString2("Jony J / 宫阁");
        r4.setImageResourse(R.drawable.p6);
        RecyclerViewItem2 r5 = new RecyclerViewItem2();
        r5.setString1("DNA.");
        r5.setString2("Kendrick Lamar");
        r5.setImageResourse(R.drawable.p6);
        RecyclerViewItem2 r6 = new RecyclerViewItem2();
        r6.setString1("Congratulations");
        r6.setString2("Post Malone/Quavo");
        r6.setImageResourse(R.drawable.p6);
        if(list2.size()<=3) {
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
}
