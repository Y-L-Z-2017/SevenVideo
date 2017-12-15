package mycode.xin.com.seven_wying.fragmetns;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.io.Serializable;

import javax.inject.Inject;

import mycode.xin.com.seven_wying.R;
import mycode.xin.com.seven_wying.activity.VideoActivity;
import mycode.xin.com.seven_wying.bean.Video;
import mycode.xin.com.seven_wying.mvp.choiceness.JpAdapter;
import mycode.xin.com.seven_wying.base.BaseFragment;
import mycode.xin.com.seven_wying.bean.HomeBean;
import mycode.xin.com.seven_wying.mvp.DaggerIComponent;
import mycode.xin.com.seven_wying.mvp.IModule;
import mycode.xin.com.seven_wying.mvp.choiceness.ChoicenessPresenter;
import mycode.xin.com.seven_wying.mvp.choiceness.ChoicenessView;

/**
 * date:2017/12/12  22:45
 * author:Mr.XIn💕
 */


public class ChoicenessFragment extends BaseFragment<ChoicenessView,ChoicenessPresenter> implements ChoicenessView{
    private RelativeLayout titlebar;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;
    private TextView textView;
    int height = 230;// 滑动开始变色的高,真实项目中此高度是由广告轮播或其他首页view高度决定
    int overallXScroll = 0;


    @Inject
    ChoicenessPresenter presenter;
    @Override
    protected int setLayout() {
        return R.layout.fragment_choiceness;
    }

    @Override
    protected void bridge() {
        DaggerIComponent.builder().iModule(new IModule()).build().injectChoiceness(this);
    }

    @Override
    protected ChoicenessPresenter getPresenter() {
        return presenter;
    }

    @Override
    protected void initView(View mview) {
        titlebar=mview.findViewById(R.id.tabbar);
        recyclerView=mview.findViewById(R.id.reycler);
        refreshLayout=mview.findViewById(R.id.swiper);
        textView=mview.findViewById(R.id.titlebar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                overallXScroll = overallXScroll + dy;// 累加y值 解决滑动一半y值为0
                if (overallXScroll <= 0) {//设置标题的背景颜色
                    textView.setVisibility(View.GONE);
                   titlebar.setBackgroundColor(Color.argb((int) 0, 255, 97, 3));
                } else if (overallXScroll > 0 && overallXScroll <= height) { //滑动距离小于banner图的高度时，设置背景和字体颜色颜色透明度渐变
                    float scale = (float) overallXScroll / height;
                    float alpha = (255 * scale);
                   titlebar.setBackgroundColor(Color.argb((int) alpha, 255, 97, 3));

                } else {
                    textView.setVisibility(View.VISIBLE);
                    titlebar.setBackgroundColor(Color.argb((int) 255, 255, 97, 3));
                }
            }
        });
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postAtTime(new Runnable() {
                    @Override
                    public void run() {
                        refreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });
    }

    @Override
    protected void logic() {
        presenter.getData();
    }

    @Override
    public void showData(final HomeBean bean) {
        JpAdapter adapter=new JpAdapter(getActivity(),bean,bean.getRet().getList().get(4).getChildList());
        recyclerView.setAdapter(adapter);
        adapter.setListener(new JpAdapter.OnClickListener() {
            @Override
            public void Onclck(int position) {
                Toast.makeText(getActivity(), "点击"+position, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), VideoActivity.class);
                HomeBean.RetBean.ListBean.ChildListBean v = bean.getRet().getList().get(4).getChildList().get(position-1);
                Video video=new Video(v.getAirTime(),v.getAngleIcon(),v.getDataId(),v.getDescription(),v.getDuration(),v.getLoadType(),v.getLoadURL(),v.getPic(),v.getRoomId(),v.getScore(),v.getShareURL(),v.getTitle());
                intent.putExtra("bean", (Serializable) video);
                startActivity(intent);
            }
        });
    }
}
