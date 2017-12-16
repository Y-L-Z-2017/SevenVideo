package mycode.xin.com.seven_wying.mvp.discover;

import javax.inject.Inject;

import io.reactivex.Flowable;
import mycode.xin.com.seven_wying.bean.DiscoverBean;
import mycode.xin.com.seven_wying.utils.Api;
import mycode.xin.com.seven_wying.utils.ApiService;
import mycode.xin.com.seven_wying.utils.RetrofitUtils;

/**
 * date:2017/12/12  22:46
 * author:Mr.XIn💕
 */


public class DiscoverModel {
    @Inject
    public DiscoverModel() {
    }

    public Flowable<DiscoverBean> getData(){
        ApiService apiService = RetrofitUtils.getInstance().getApiService(Api.HOST, ApiService.class);
        Flowable<DiscoverBean> discoverData = apiService.getDiscoverData("402834815584e463015584e539330016", 1);
        return discoverData;
    }
}
