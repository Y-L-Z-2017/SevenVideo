package mycode.xin.com.seven_wying.mvp.choiceness;

import javax.inject.Inject;

import io.reactivex.Flowable;
import mycode.xin.com.seven_wying.bean.HomeBean;
import mycode.xin.com.seven_wying.utils.Api;
import mycode.xin.com.seven_wying.utils.ApiService;
import mycode.xin.com.seven_wying.utils.RetrofitUtils;

/**
 * date:2017/12/12  22:46
 * author:Mr.XIn💕
 */


public class ChoicenessModel {
    @Inject
    public ChoicenessModel() {
    }

    //得到数据
    public Flowable<HomeBean> getData(){
        ApiService service = RetrofitUtils.getInstance().getApiService(Api.HOST, ApiService.class);
        Flowable<HomeBean> flowable = service.getHomeData();
        return flowable;
    }
}
