package com.bw.guojinyi.mvp;

import com.bw.guojinyi.base.BasePresenter;
import com.bw.guojinyi.bean.BannerBean;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/26 16:51
 * @Description: 用途：完成特定功能
 */
public class BannerPresenterImpl extends BasePresenter<IBannerContract.IBannerView> implements IBannerContract.IBannerPresenter {
    private BannerModuleImpl module;
    @Override
    protected void initModule() {
        module = new BannerModuleImpl();
    }

    @Override
    public void getData() {
        module.getData(new IBannerContract.IBannerModule.ModuleCallBack() {
            @Override
            public void onSuccess(BannerBean bannerBean) {
                baseview.onSuccess(bannerBean);
            }

            @Override
            public void onFailed(String error) {
                baseview.onFailed(error);
            }
        });
    }
}
