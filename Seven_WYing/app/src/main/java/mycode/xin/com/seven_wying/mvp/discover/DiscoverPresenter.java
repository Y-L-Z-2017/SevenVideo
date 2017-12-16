package mycode.xin.com.seven_wying.mvp.discover;

import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import mycode.xin.com.seven_wying.base.BasePresenter;
import mycode.xin.com.seven_wying.bean.DiscoverBean;
import mycode.xin.com.seven_wying.mvp.choiceness.ChoicenessModel;
import mycode.xin.com.seven_wying.mvp.choiceness.ChoicenessView;

/**
 * date:2017/12/12  22:45
 * author:Mr.XIn💕
 */


public class DiscoverPresenter extends BasePresenter<DiscoverView> {
    @Inject
    DiscoverModel discoverModel;

    @Override
    public DiscoverView getView() {
        return super.getView();
    }

    private int code;

    @Inject
    public DiscoverPresenter() {
    }
    public void relevance(){
        Flowable<DiscoverBean> data = discoverModel.getData();
        DisposableSubscriber<DiscoverBean> disposable = data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<DiscoverBean>() {
                    @Override
                    public void onNext(DiscoverBean discoverBean) {
                        code = discoverBean.getCode();
                        if (code == 200) {
                            getView().setData(discoverBean);
                            Log.i("SSS", discoverBean.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        Log.e("eee", t.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
        add(disposable);
    }
}
