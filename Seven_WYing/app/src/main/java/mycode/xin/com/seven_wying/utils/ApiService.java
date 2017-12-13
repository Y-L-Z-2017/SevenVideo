package mycode.xin.com.seven_wying.utils;

import io.reactivex.Flowable;
import mycode.xin.com.seven_wying.bean.HomeBean;
import retrofit2.http.GET;

/**
 * Created by 张丹阳 on 2017/12/13.
 */

public interface ApiService {
    /**
     * 首页：http://api.svipmovie.com/front/homePageApi/homePage.do
     * 请求方式：GET
     * 请求首页的数据
     */
    @GET("homePageApi/homePage.do")
    Flowable<HomeBean> getHomeData();
}
