package mycode.xin.com.seven_wying.mvp.intro;

import javax.inject.Inject;

import io.reactivex.Flowable;
import mycode.xin.com.seven_wying.bean.IntroBean;
import mycode.xin.com.seven_wying.utils.Api;
import mycode.xin.com.seven_wying.utils.ApiService;
import mycode.xin.com.seven_wying.utils.RetrofitUtils;

/**
 * data:2017/12/15
 * auther:admin
 */

public class IntroModel {
    @Inject
    public IntroModel() {
    }
    public Flowable<IntroBean> getDataIntro(String Id) {
        ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.HOST, ApiService.class);
        Flowable<IntroBean> introData = apiService.getIntroData(Id);
        return introData;
    }
}
