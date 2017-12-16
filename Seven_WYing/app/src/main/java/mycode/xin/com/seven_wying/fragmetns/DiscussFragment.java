package mycode.xin.com.seven_wying.fragmetns;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.base.BaseFragment;
import mycode.xin.com.seven_wying.bean.VideoRes;
import mycode.xin.com.seven_wying.mvp.DaggerIComponent;
import mycode.xin.com.seven_wying.mvp.IModule;
import mycode.xin.com.seven_wying.mvp.discuss.DiscussPresenter;
import mycode.xin.com.seven_wying.mvp.discuss.DiscussView;

/**
 * date:2017/12/15  17:02
 * author:Mr.XIn💕
 */


public class DiscussFragment extends BaseFragment<DiscussView, DiscussPresenter>implements DiscussView {
    @Inject
    DiscussPresenter mDiscussPresenter;
    private Bundle mBundle;
    Unbinder unbinder;
    @Override
    protected int setLayout() {
        return R.layout.discussfragment;
    }

    @Override
    protected void bridge() {
        mBundle = getArguments();
        DaggerIComponent.builder().iModule(new IModule()).build().injectDiscuss(this);
    }

    @Override
    protected DiscussPresenter getPresenter() {

        return mDiscussPresenter;
    }

    @Override
    protected void initView(View mview) {
        unbinder = ButterKnife.bind(this, mview);
    }

    @Override
    protected void logic() {
        mDiscussPresenter.getData(mBundle.getString("Id"));
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void Success(VideoRes videoRes) {
        Log.e("XXXXXXXXXX", "Success: "+videoRes.getRet().getList().get(1).getMsg() );

    }
}
