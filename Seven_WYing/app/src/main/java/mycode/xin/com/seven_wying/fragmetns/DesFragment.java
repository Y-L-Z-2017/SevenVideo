package mycode.xin.com.seven_wying.fragmetns;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import mycode.xin.com.seven_wying.base.BaseFragment;
import mycode.xin.com.seven_wying.bean.Video;
import mycode.xin.com.seven_wying.mvp.video.VideoPresenter;
import mycode.xin.com.seven_wying.mvp.video.VideoView;

/**
 * data:2017/12/15
 * auther:admin
 * 简介的的fragment
 */

public class DesFragment extends BaseFragment<VideoView,VideoPresenter> {


    @Override
    protected int setLayout() {
        return 0;
    }

    @Override
    protected void bridge() {

    }

    @Override
    protected VideoPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initView(View mview) {

    }

    @Override
    protected void logic() {

    }
}
