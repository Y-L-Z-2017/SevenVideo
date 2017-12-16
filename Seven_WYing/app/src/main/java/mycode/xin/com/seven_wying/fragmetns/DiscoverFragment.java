package mycode.xin.com.seven_wying.fragmetns;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.fashare.stack_layout.StackLayout;
import com.fashare.stack_layout.transformer.AngleTransformer;
import com.fashare.stack_layout.transformer.StackPageTransformer;

import javax.inject.Inject;

import dagger.Component;
import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.base.BaseFragment;
import mycode.xin.com.seven_wying.bean.DiscoverBean;
import mycode.xin.com.seven_wying.mvp.DaggerIComponent;
import mycode.xin.com.seven_wying.mvp.IComponent;
import mycode.xin.com.seven_wying.mvp.IModule;
import mycode.xin.com.seven_wying.mvp.discover.Adapter;
import mycode.xin.com.seven_wying.mvp.discover.DiscoverPresenter;
import mycode.xin.com.seven_wying.mvp.discover.DiscoverView;
import mycode.xin.com.seven_wying.mvp.discover.MyAlphaTransformer;

/**
 * date:2017/12/13  0:01
 * author:Mr.XIn💕
 */


public class DiscoverFragment extends BaseFragment<DiscoverView,DiscoverPresenter> implements DiscoverView {

    @Inject
    DiscoverPresenter discoverPresenter;
    StackLayout mStackLayout;
    private Button b;

    int page=1;
    private DiscoverBean bb;

    @Override
    protected int setLayout() {
       return R.layout.fragment_discover;
    }

    @Override
    protected void bridge() {
        DaggerIComponent.builder().iModule(new IModule()).build().injectDiscover(this);
    }

    @Override
    protected DiscoverPresenter getPresenter() {

        return discoverPresenter;
    }

    @Override
    protected void initView(View mview) {
        b = mview.findViewById(R.id.button);
        mStackLayout = mview.findViewById(R.id.stack_layout);
    }

    @Override
    protected void logic() {
        discoverPresenter.relevance();
        mStackLayout.setOnSwipeListener(new StackLayout.OnSwipeListener() {
            @Override
            public void onSwiped(View swipedView, int swipedItemPos, boolean isSwipeLeft, int itemLeft) {
                if(itemLeft<1){
                    Toast.makeText(getActivity(), "已经是最后一张了", Toast.LENGTH_SHORT).show();
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page++;
                //fp.attachhuan(page,getActivity());

            }
        });
    }

    @Override
    public void setData(DiscoverBean discoverBean) {
        Log.i("SSS",discoverBean.toString());
        bb=discoverBean;
        mStackLayout.setAdapter(new Adapter(getActivity(),discoverBean));
        mStackLayout.addPageTransformer(
                new StackPageTransformer(),     // 堆叠
                new MyAlphaTransformer(),       // 渐变
                new AngleTransformer()          // 角度
        );
    }
}
