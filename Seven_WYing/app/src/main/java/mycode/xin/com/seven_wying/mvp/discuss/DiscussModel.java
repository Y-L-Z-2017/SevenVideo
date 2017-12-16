package mycode.xin.com.seven_wying.mvp.discuss;

import javax.inject.Inject;

import io.reactivex.Flowable;
import mycode.xin.com.seven_wying.bean.VideoRes;
import mycode.xin.com.seven_wying.utils.Api;
import mycode.xin.com.seven_wying.utils.ApiService;
import mycode.xin.com.seven_wying.utils.RetrofitUtils;

/**
 * date:2017/12/12  22:46
 * author:Mr.XIn💕
 */


public class DiscussModel {
    @Inject
    public DiscussModel() {
    }

    public Flowable<VideoRes> getDataSpecial(String Id) {
        ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.HOST, ApiService.class);
        Flowable<VideoRes> specialData = apiService.getSpecial(Id);
        return specialData;
    }
}
