package com.example.xuxmusicplayer.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.xuxmusicplayer.Adapter.BottomAdapter;
import com.example.xuxmusicplayer.Bottom.MyBottomSheetDialog;
import com.example.xuxmusicplayer.BottomNavigationViewHelper;
import com.example.xuxmusicplayer.Fragment.HeartFragment;
import com.example.xuxmusicplayer.Fragment.HomepageFragment;
import com.example.xuxmusicplayer.Fragment.MineFragment;
import com.example.xuxmusicplayer.NViewHolder.VideoFragment1;
import com.example.xuxmusicplayer.Video.VideoFragment;
import com.example.xuxmusicplayer.Fragment.mRadioFragment;
import com.example.xuxmusicplayer.R;
import com.example.xuxmusicplayer.ViewPager.NoScrollViewPager;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import org.salient.artplayer.MediaPlayerManager;

import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static com.example.xuxmusicplayer.R.color.black;
import static com.example.xuxmusicplayer.R.drawable.black_background;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private NoScrollViewPager viewPager;
    private View mainCard2;
    private CardView mainCard1;
    private ImageView mainImg;
    private ConstraintLayout mainconstraint;

    private MediaPlayer mediaPlayer;
    private boolean isPlay;
    private SeekBar seekBar;
    //?????????????????????????????????SeekBar?????????????????????
    private boolean isChanging=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("","");
        initView();
        checkPermission();

    }

    private  void checkPermission(){
        if (ContextCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] { WRITE_EXTERNAL_STORAGE }, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length >= 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this,  "?????????????????????", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,  "?????????????????????", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void initView(){
        //?????????????????????????????????
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        bottomNavigationView = findViewById(R.id.mbottom_navigation);
        viewPager = findViewById(R.id.viewpager);

        mainCard2 = findViewById(R.id.mainCard2);
        mainCard1 = findViewById(R.id.mainCard1);
        mainImg = findViewById(R.id.mainImg);

        mainconstraint = findViewById(R.id.mainConstra);

        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        //????????????
        setupViewPager(viewPager);
        viewPager.setOffscreenPageLimit(5);
        //????????????
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homepage:
                        bottomNavigationView.setBackgroundResource(R.color.white);
                        mainconstraint.setBackgroundResource(R.color.white);
                        viewPager.setCurrentItem(0);
                        mainCard1.setVisibility(View.VISIBLE);
                        mainCard2.setVisibility(View.VISIBLE);
                        mainImg.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.mRadio:
                        bottomNavigationView.setBackgroundResource(R.color.white);
                        mainconstraint.setBackgroundResource(R.color.white);
                        viewPager.setCurrentItem(1);
                        mainCard1.setVisibility(View.VISIBLE);
                        mainCard2.setVisibility(View.VISIBLE);
                        mainImg.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.video:
                        viewPager.setCurrentItem(2);
                        bottomNavigationView.setBackgroundResource(R.color.black);
                        mainconstraint.setBackgroundResource(R.color.black);
                        mainCard1.setVisibility(View.GONE);
                        mainCard2.setVisibility(View.GONE);
                        mainImg.setVisibility(View.GONE);
                        return true;
                    case R.id.heart:
                        bottomNavigationView.setBackgroundResource(R.color.white);
                        mainconstraint.setBackgroundResource(R.color.white);
                        viewPager.setCurrentItem(3);
                        mainCard1.setVisibility(View.VISIBLE);
                        mainCard2.setVisibility(View.VISIBLE);
                        mainImg.setVisibility(View.VISIBLE);
                        return true;
                    case R.id.mine:
                        bottomNavigationView.setBackgroundResource(R.color.white);
                        mainconstraint.setBackgroundResource(R.color.white);
                        viewPager.setCurrentItem(4);
                        mainCard1.setVisibility(View.VISIBLE);
                        mainCard2.setVisibility(View.VISIBLE);
                        mainImg.setVisibility(View.VISIBLE);
                        return true;
                }
                return false;
            }
        });

        //viewPager??????
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                //bottomNavigationView.getMenu().getItem(position).setChecked(true);
                Log.d("111111", String.valueOf(position));
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        mainCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initBottomSheetDialog();
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        BottomAdapter adapter = new BottomAdapter(getSupportFragmentManager());
        adapter.addFragment(new HomepageFragment());
        adapter.addFragment(new mRadioFragment());
        adapter.addFragment(new VideoFragment1());
        adapter.addFragment(new HeartFragment());
        adapter.addFragment(new MineFragment());
        viewPager.setAdapter(adapter);
    }
    private void initMusic() {
        mediaPlayer = new MediaPlayer();
        seekBar = findViewById(R.id.MusicSeekbar);
//        seekBar.setOnSeekBarChangeListener(new);
    }
    private void initBottomSheetDialog(){
        MyBottomSheetDialog bottomSheetDialog = new MyBottomSheetDialog(this,this.getWindow().getDecorView());
        bottomSheetDialog.setContentView(R.layout.dialog_bottom);
        bottomSheetDialog.show();
    }
    @Override
    public void onBackPressed() {
        if (MediaPlayerManager.instance().backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        MediaPlayerManager.instance().pause();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        MediaPlayerManager.instance().releasePlayerAndView(this);
    }
    //?????????????????? ???????????????helper ?????????????????? ?????????????????????

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

    }
    public class MySeekbar implements SeekBar.OnSeekBarChangeListener {
        @Override
        //????????????????????????
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        }

        @Override
        //??????????????????????????????
        public void onStartTrackingTouch(SeekBar seekBar) {
            isChanging=true;
        }

        @Override
        //??????????????????????????????
        public void onStopTrackingTouch(SeekBar seekBar) {
            //????????????????????????MediaPlayer????????????????????????????????????seekTo????????????????????????????????????????????????????????????
            mediaPlayer.seekTo(seekBar.getProgress());
            isChanging = false;
        }
    }
}