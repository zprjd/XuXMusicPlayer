package com.example.xuxmusicplayer.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Adapter.LivelilAdapter;
import com.example.xuxmusicplayer.Item.LivelilViewItem;
import com.example.xuxmusicplayer.R;

import java.util.ArrayList;
import java.util.List;

public class Livefragment2 extends Fragment {
    RecyclerView recyclerView;
    List<LivelilViewItem> list = new ArrayList<>();
    List<LivelilViewItem> list2 = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.livefragment,container,false);
        recyclerView=view.findViewById(R.id.liveframe_recycler);
        LivelilAdapter livelilAdapter = new LivelilAdapter(list2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(livelilAdapter);
        return view;
    }

    private void initData(){
        LivelilViewItem l1 = new LivelilViewItem();
        l1.setTextView1("EL-仙女养乐斋🦋");
        l1.setTextView1_5("6.8万");
        l1.setTextView2("浪漫满屋");
        l1.setTextView2_5("5.6万");
        LivelilViewItem l2 = new LivelilViewItem();
        l2.setTextView1("花满楼一楼");
        l2.setTextView1_5("4.0万");
        l2.setTextView2("Yo~甜蜜暴击十月...");
        l2.setTextView2_5("3.9万");
        LivelilViewItem l3 = new LivelilViewItem();
        l3.setTextView1("Hi-魔法少女 新厅...");
        l3.setTextView1_5("3.7万");
        l3.setTextView2("Hi-耳畔轻语⭐约修...");
        l3.setTextView2_5("5.6万");
        LivelilViewItem l4 = new LivelilViewItem();
        l4.setTextView1("祈愿-心动女嘉宾...");
        l4.setTextView1_5("3.6万");
        l4.setTextView2("诗音·玩乐大师");
        l4.setTextView2_5("3.5万");
        LivelilViewItem l5 = new LivelilViewItem();
        l5.setTextView1("【星芽】极致声诱♥...");
        l5.setTextView1_5("3.5万");
        l5.setTextView2("EL-长相思-对你孤...");
        l5.setTextView2_5("3.4万");
        LivelilViewItem l6 = new LivelilViewItem();
        l6.setTextView1("Hi-不期而遇");
        l6.setTextView1_5("3.3万");
        l6.setTextView2("Er.诠释浪漫");
        l6.setTextView2_5("3.2万");
        LivelilViewItem l7 = new LivelilViewItem();
        l7.setTextView1("祈愿-心动女嘉宾...");
        l7.setTextView1_5("3.6万");
        l7.setTextView2("诗音·玩乐大师");
        l7.setTextView2_5("3.5万");
        LivelilViewItem l8 = new LivelilViewItem();
        l8.setTextView1("【星芽】极致声诱♥...");
        l8.setTextView1_5("3.5万");
        l8.setTextView2("EL-长相思-对你孤...");
        l8.setTextView2_5("3.4万");
        LivelilViewItem l9 = new LivelilViewItem();
        l9.setTextView1("Hi-不期而遇");
        l9.setTextView1_5("3.3万");
        l9.setTextView2("Er.诠释浪漫");
        l9.setTextView2_5("3.2万");
        LivelilViewItem l10 = new LivelilViewItem();
        l10.setTextView1("Hi-不期而遇");
        l10.setTextView1_5("3.3万");
        l10.setTextView2("Er.诠释浪漫");
        l10.setTextView2_5("3.2万");
        LivelilViewItem l11 = new LivelilViewItem();
        l11.setTextView1("Hi-魔法少女 新厅...");
        l11.setTextView1_5("3.7万");
        l11.setTextView2("Hi-耳畔轻语⭐约修...");
        l11.setTextView2_5("5.6万");
        l1.setImg1(R.drawable.img4);
        l2.setImg1(R.drawable.profile_default_folder_bg);
        l3.setImg1(R.drawable.img6);
        l4.setImg1(R.drawable.img7);
        l5.setImg1(R.drawable.img8);
        l6.setImg1(R.drawable.thenameoflife);
        l7.setImg1(R.drawable.img9);
        l8.setImg1(R.drawable.img10);
        l9.setImg1(R.drawable.img11);
        l10.setImg1(R.drawable.img3);
        l11.setImg1(R.drawable.img2);

        l1.setImg2(R.drawable.img7);
        l2.setImg2(R.drawable.img10);
        l3.setImg2(R.drawable.img5);
        l4.setImg2(R.drawable.img9);
        l5.setImg2(R.drawable.img2);
        l6.setImg2(R.drawable.img11);
        l7.setImg2(R.drawable.img7);
        l8.setImg2(R.drawable.img4);
        l9.setImg2(R.drawable.profile_default_folder_bg);
        l10.setImg2(R.drawable.p6);
        l11.setImg2(R.drawable.img6);

//        list.add(l1);
//        list.add(l2);
//        list.add(l11);
//        list.add(l3);
//        list.add(l10);
//        list.add(l4);
//        list.add(l5);
//        list.add(l9);
//        list.add(l8);
//        list.add(l7);
//        list.add(l6);
        list2.add(l11);
        list2.add(l10);
        list2.add(l9);
        list2.add(l8);
        list2.add(l7);
        list2.add(l6);
        list2.add(l5);
        list2.add(l4);
    }
}
