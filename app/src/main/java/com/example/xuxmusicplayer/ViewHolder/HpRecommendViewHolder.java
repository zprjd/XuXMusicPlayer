package com.example.xuxmusicplayer.ViewHolder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xuxmusicplayer.Adapter.RecyclerAdapter1;
import com.example.xuxmusicplayer.Adapter.RecyclerAdapter2;
import com.example.xuxmusicplayer.Item.RecyclerViewItem1;
import com.example.xuxmusicplayer.R;

import java.util.ArrayList;
import java.util.List;

public class HpRecommendViewHolder extends RecyclerView.ViewHolder {
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    Context context;
    List<RecyclerViewItem1> list1 = new ArrayList<>();
    List<RecyclerViewItem1> list2 = new ArrayList<>();
    public HpRecommendViewHolder(@NonNull Context context, View itemView) {
        super(itemView);
    }

    public void initView(){
        initData();
        recyclerView1 = itemView.findViewById(R.id.recommendrecycler1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        RecyclerAdapter1 recyclerAdapter1 = new RecyclerAdapter1(list1);
        recyclerView1.setAdapter(recyclerAdapter1);
        recyclerView1.setLayoutManager(linearLayoutManager);
        initData2();
        recyclerView2 = itemView.findViewById(R.id.recommendrecycler2);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context);
        linearLayoutManager2.setOrientation(RecyclerView.HORIZONTAL);
        RecyclerAdapter2 recyclerAdapter2 = new RecyclerAdapter2(list2);
        recyclerView2.setLayoutManager(linearLayoutManager2);
        recyclerView2.setAdapter(recyclerAdapter2);
    }

    public void initData(){
        RecyclerViewItem1 r1 = new RecyclerViewItem1();
        r1.setImageView(R.drawable.background);
        r1.setTextView("Let It Be(Remaster) - The Beatles");
        RecyclerViewItem1 r2 = new RecyclerViewItem1();
        r2.setImageView(R.drawable.thenameoflife);
        r2.setTextView("??????30???");
        RecyclerViewItem1 r3 = new RecyclerViewItem1();
        r3.setImageView(R.drawable.thenameoflife);
        r3.setTextView("????????????");
        RecyclerViewItem1 r4 = new RecyclerViewItem1();
        r4.setImageView(R.drawable.thenameoflife);
        r4.setTextView("???????????????");
        RecyclerViewItem1 r5 = new RecyclerViewItem1();
        r5.setImageView(R.drawable.thenameoflife);
        r5.setTextView("????????????");
        RecyclerViewItem1 r6 = new RecyclerViewItem1();
        r6.setImageView(R.drawable.thenameoflife);
        r6.setTextView("??????60???");
        RecyclerViewItem1 r7 = new RecyclerViewItem1();
        r7.setImageView(R.drawable.thenameoflife);
        r7.setTextView("K?????????");
        RecyclerViewItem1 r8 = new RecyclerViewItem1();
        r8.setImageView(R.drawable.thenameoflife);
        r8.setTextView("????????????");
        list1.add(r1);
        list1.add(r2);
        list1.add(r3);
        list1.add(r4);
        list1.add(r5);
        list1.add(r6);
        list1.add(r7);
        list1.add(r8);
    }
    public void initData2(){
        RecyclerViewItem1 r1 = new RecyclerViewItem1();
        r1.setTextView("?????????????????? | Alternative");
        r1.setImageView(R.drawable.profile_default_folder_bg);
        RecyclerViewItem1 r2 = new RecyclerViewItem1();
        r2.setTextView("?????????????????? | Indie Music");
        r2.setImageView(R.drawable.profile_default_folder_bg);
        RecyclerViewItem1 r3 = new RecyclerViewItem1();
        r3.setTextView("R&B ?? ????????????");
        r3.setImageView(R.drawable.profile_default_folder_bg);
        RecyclerViewItem1 r4 = new RecyclerViewItem1();
        r4.setTextView("??????????????? | Lost in Island");
        r4.setImageView(R.drawable.profile_default_folder_bg);
        RecyclerViewItem1 r5 = new RecyclerViewItem1();
        r5.setTextView("????????????????????? | Dream Vibe");
        r5.setImageView(R.drawable.profile_default_folder_bg);
        list2.add(r1);
        list2.add(r2);
        list2.add(r3);
        list2.add(r4);
        list2.add(r5);
    }
}