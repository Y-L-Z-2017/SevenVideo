package mycode.xin.com.seven_wying.mvp.special;

import javax.inject.Inject;

import io.reactivex.Flowable;
import mycode.xin.com.seven_wying.bean.IntroBean;
import mycode.xin.com.seven_wying.bean.VideoRes;
import mycode.xin.com.seven_wying.utils.Api;
import mycode.xin.com.seven_wying.utils.ApiService;
import mycode.xin.com.seven_wying.utils.RetrofitUtils;

/**
 * date:2017/12/12  22:46
 * author:Mr.XIn💕
 */


public class SpcialModel {
    @Inject
    public SpcialModel() {
    }

    public Flowable<VideoRes> getDataSpecial(String Id, String pum) {
        ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.HOST, ApiService.class);
        Flowable<VideoRes> specialData = apiService.getSpecial(Id);
        return specialData;
    }
}
