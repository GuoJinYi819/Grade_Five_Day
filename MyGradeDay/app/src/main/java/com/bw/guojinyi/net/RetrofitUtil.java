package com.bw.guojinyi.net;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/26 16:26
 * @Description: 用途：完成特定功能
 */
public class RetrofitUtil {
    //单例
    private static RetrofitUtil instance;
    private final OkHttpClient okhttp;
    private final String baseurl = "http://mobile.bwstudent.com/small/";
    private final Retrofit retrofit;

    private RetrofitUtil(){
        okhttp = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        //添加请求头
                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder();
                        builder.addHeader("userId","28055");
                        builder.addHeader("sessionId","158332612526928055");
                        Request newBuild = builder.build();
                        Response proceed = chain.proceed(newBuild);
                        return proceed;
                    }
                })
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseurl)
                .client(okhttp)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
    public static RetrofitUtil getInstance(){
        if (instance == null) {
            synchronized (RetrofitUtil.class){
                if (instance == null) {
                    instance = new RetrofitUtil();
                }
            }
        }
        return instance;
    }

    public ApiService createService(){
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
