package com.bw.guojinyi.mvp;

import com.bw.guojinyi.base.IBaseView;
import com.bw.guojinyi.bean.BannerBean;
import com.bw.guojinyi.bean.ShoppingBean;

import java.util.Map;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/26 16:39
 * @Description: 用途：完成特定功能
 */
public interface IShoppingContract {
     interface IBannerView extends IBaseView{
        void onSuccess(ShoppingBean bannerBean);
        void onFailed(String error);
    }
    interface IBannerModule{
        void getData(Map<String,Object> param, ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(ShoppingBean bannerBean);
            void onFailed(String error);
        }
    }
    interface IBannerPresenter{
         void getData(Map<String,Object> param);
    }
}
