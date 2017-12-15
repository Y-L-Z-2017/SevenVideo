package mycode.xin.com.seven_wying.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.bean.Video;

public class VideoActivity extends AppCompatActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.video_name)
    TextView videoName;
    @BindView(R.id.collect)
    ImageView collect;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.video)
    JZVideoPlayerStandard video;

    private Unbinder bind;
    private List<String> list;
    private Video bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        bind = ButterKnife.bind(this);
        Intent intent = getIntent();
        bean = (Video) intent.getSerializableExtra("bean");
        ininView();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if(JZVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }

    private void ininView() {
        video.setUp(bean.getLoadURL(),JZVideoPlayerStandard.SCREEN_LAYOUT_NORMAL,bean.getTitle());
        Glide.with(this).load(bean.getPic()).into(video.thumbImageView);
        video.thumbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        list = new ArrayList<>();
        list.add("简介");
        list.add("评论");
        videoName.setText(bean.getTitle());
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        for (int i = 0; i < list.size(); i++) {
            tablayout.addTab(tablayout.newTab().setText(list.get(i)));
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewpager.setAdapter(adapter);
//        tablayout.setupWithViewPager(viewpager);
//        tablayout.setTabsFromPagerAdapter(adapter);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return list.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return null;
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
