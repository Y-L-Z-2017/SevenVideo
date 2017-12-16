package mycode.xin.com.seven_wying.mvp.discuss;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subscribers.DisposableSubscriber;
import mycode.xin.com.seven_wying.base.BasePresenter;
import mycode.xin.com.seven_wying.bean.VideoRes;

/**
 * date:2017/12/12  22:45
 * author:Mr.XIn💕
 */


public class DiscussPresenter extends BasePresenter<DiscussView> {
    @Inject
    DiscussModel mDiscussModel;

    @Inject
    public DiscussPresenter() {
    }
    public void getData(String id) {
        Flowable<VideoRes> flowable = mDiscussModel.getDataSpecial(id);
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
