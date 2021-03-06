package mycode.xin.com.seven_wying.mvp.special;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import mycode.xin.com.seven_wying.base.BasePresenter;
import mycode.xin.com.seven_wying.bean.IntroBean;
import mycode.xin.com.seven_wying.bean.VideoRes;
import mycode.xin.com.seven_wying.mvp.choiceness.ChoicenessModel;
import mycode.xin.com.seven_wying.mvp.choiceness.ChoicenessView;

/**
 * date:2017/12/12  22:45
 * author:Mr.XIn💕
 */


public class SpecialPresenter extends BasePresenter<SpecialView> {
    @Inject
    SpcialModel mSpcialModel;

    @Inject
    public SpecialPresenter() {
    }
    public void getData(String id,String pum) {
        Flowable<VideoRes> flowable = mSpcialModel.getDataSpecial(id,pum);
        DisposableSubscriber<VideoRes> disposableSubscriber = flowable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(
                new DisposableSubscriber<VideoRes>() {
                    @Override
                    public void onNext(VideoRes videoRes) {
                        getView().Success(videoRes);

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
