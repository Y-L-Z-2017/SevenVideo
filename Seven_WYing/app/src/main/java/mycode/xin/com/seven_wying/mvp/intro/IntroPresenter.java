package mycode.xin.com.seven_wying.mvp.intro;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.internal.schedulers.NewThreadScheduler;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import mycode.xin.com.seven_wying.base.BasePresenter;
import mycode.xin.com.seven_wying.bean.IntroBean;

/**
 * data:2017/12/15
 * auther:admin
 */

public class IntroPresenter extends BasePresenter<IntroView> {
    @Inject
    public IntroPresenter() {
    }

    @Inject
    IntroModel mIntroModel;

    public void getData(String id) {
        Flowable<IntroBean> flowable = mIntroModel.getDataIntro(id);
        DisposableSubscriber<IntroBean> disposableSubscriber = flowable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(
                new DisposableSubscriber<IntroBean>() {
                    @Override
                    public void onNext(IntroBean introBean) {
                        getView().Success(introBean);

                    }

                    @Override
                    public void onError(Throwable t) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );
   add(disposableSubscriber);

    }


}
