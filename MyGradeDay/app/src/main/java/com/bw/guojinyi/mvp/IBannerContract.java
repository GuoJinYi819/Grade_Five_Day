package com.bw.guojinyi.mvp;

import com.bw.guojinyi.base.IBaseView;
import com.bw.guojinyi.bean.BannerBean;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/26 16:39
 * @Description: 用途：完成特定功能
 */
public interface IBannerContract {
     interface IBannerView extends IBaseView{
        void onSuccess(BannerBean bannerBean);
        void onFailed(String error);
    }
    interface IBannerModule{
        void getData(ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(BannerBean bannerBean);
            void onFailed(String error);
        }
    }
    interface IBannerPresenter{
         void getData();
    }
}
