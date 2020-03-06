package com.bw.guojinyi.net;

import com.bw.guojinyi.bean.BannerBean;
import com.bw.guojinyi.bean.CartBean;
import com.bw.guojinyi.bean.DataBean;
import com.bw.guojinyi.bean.PayBean;
import com.bw.guojinyi.bean.ShoppingBean;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/26 16:47
 * @Description: 用途：完成特定功能
 */
public interface ApiService {
    @GET("commodity/v1/bannerShow")
    Observable<BannerBean> getBanner();

    @GET("commodity/v1/commodityList")
    Observable<DataBean> getgoods();

    @GET("order/verify/v1/findShoppingCart")
    Observable<CartBean> getShopping();

    @GET("order/verify/v1/createOrder")
    Observable<CartBean> getCreateOrder(@QueryMap Map<String,String> param);

    //支付
    @POST("order/verify/v1/pay")
    @FormUrlEncoded
    Observable<PayBean> getPay(@FieldMap Map<String,String> param);
}
