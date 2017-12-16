package mycode.xin.com.seven_wying.fragmetns;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.base.BaseFragment;
import mycode.xin.com.seven_wying.bean.IntroBean;
import mycode.xin.com.seven_wying.mvp.DaggerIComponent;
import mycode.xin.com.seven_wying.mvp.IModule;
import mycode.xin.com.seven_wying.mvp.intro.IntroAdapter;
import mycode.xin.com.seven_wying.mvp.intro.IntroPresenter;
import mycode.xin.com.seven_wying.mvp.intro.IntroView;

/**
 * data:2017/12/15
 * auther:admin
 * 简介的的fragment
 */

public class IntroFragment extends BaseFragment<IntroView, IntroPresenter> implements IntroView {
    private static final String TAG = "intro";
    @Inject
    IntroPresenter mIntroPresenter;
    @BindView(R.id.director)
    TextView mDirector;
    @BindView(R.id.protagonist)
    TextView mProtagonist;
    @BindView(R.id.rv_intro)
    RecyclerView mRvIntro;
    Unbinder unbinder;
    private Bundle mBundle;


    @Override
    protected int setLayout() {
        return R.layout.introfragment;
    }

    @Override
    protected void bridge() {
        mBundle = getArguments();
        Log.e(TAG, mBundle.getString("Id"));
        DaggerIComponent.builder().iModule(new IModule()).build().injectIntro(this);
    }

    @Override
    protected IntroPresenter getPresenter() {

        return mIntroPresenter;
    }

    @Override
    protected void initView(View mview) {
        unbinder = ButterKnife.bind(this, mview);
        mRvIntro.setLayoutManager(new GridLayoutManager(getActivity(),3));
    }

    @Override
    protected void logic() {
        mIntroPresenter.getData(mBundle.getString("Id"));
    }

    @Override
    public void Success(IntroBean introBean) {
        mDirector.setText("导演:" + introBean.getRet().getDirector());
        mProtagonist.setText("主演:" + introBean.getRet().getActors());
        mRvIntro.setAdapter(new IntroAdapter(getActivity(),introBean));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
