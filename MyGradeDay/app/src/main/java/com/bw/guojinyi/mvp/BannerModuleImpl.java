package com.bw.guojinyi.mvp;

import com.bw.guojinyi.bean.BannerBean;
import com.bw.guojinyi.net.ApiService;
import com.bw.guojinyi.net.RetrofitUtil;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/26 16:49
 * @Description: 用途：完成特定功能
 */
public class BannerModuleImpl implements IBannerContract.IBannerModule {
    @Override
    public void getData(final ModuleCallBack moduleCallBack) {
        RetrofitUtil instance = RetrofitUtil.getInstance();
        ApiService service = instance.createService();//获获取实例
        Observable<BannerBean> banner = service.getBanner(); //响应式编程
        banner.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BannerBean value) {
                        moduleCallBack.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        moduleCallBack.onFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
