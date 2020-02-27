package com.bw.guojinyi.mvp;

import com.bw.guojinyi.base.BasePresenter;
import com.bw.guojinyi.bean.BannerBean;
import com.bw.guojinyi.bean.ShoppingBean;

import java.util.Map;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/26 16:51
 * @Description: 用途：完成特定功能
 */
public class ShoppingresenterImpl extends BasePresenter<IShoppingContract.IBannerView> implements IShoppingContract.IBannerPresenter {
    private ShoppingModuleImpl module;
    @Override
    protected void initModule() {
        module = new ShoppingModuleImpl();
    }


    @Override
    public void getData(Map<String,Object> param) {
        module.getData(param, new IShoppingContract.IBannerModule.ModuleCallBack() {
            @Override
            public void onSuccess(ShoppingBean bannerBean) {
                baseview.onSuccess(bannerBean);
            }

            @Override
            public void onFailed(String error) {
                baseview.onFailed(error);
            }
        });
    }
}
