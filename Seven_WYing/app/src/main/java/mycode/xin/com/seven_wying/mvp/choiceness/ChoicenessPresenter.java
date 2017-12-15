package mycode.xin.com.seven_wying.mvp.choiceness;

import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DefaultSubscriber;
import io.reactivex.subscribers.DisposableSubscriber;
import mycode.xin.com.seven_wying.base.BasePresenter;
import mycode.xin.com.seven_wying.bean.HomeBean;

/**
 * date:2017/12/12  22:45
 * author:Mr.XIn💕
 */


public class ChoicenessPresenter extends BasePresenter<ChoicenessView> {
    @Inject
    ChoicenessModel mChoicenessModel;
    @Inject
    public ChoicenessPresenter() {
    }

    public void getData(){
        Flowable<HomeBean> flowable = mChoicenessModel.getData();
        DisposableSubscriber<HomeBean> subscriber = flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSubscriber<HomeBean>() {
                    @Override
                    public void onNext(HomeBean bean) {
                        getView().showData(bean);
                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
        add(subscriber);


    }
}
