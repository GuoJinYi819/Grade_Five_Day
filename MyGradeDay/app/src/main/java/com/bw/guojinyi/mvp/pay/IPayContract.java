package com.bw.guojinyi.mvp.pay;

import com.bw.guojinyi.base.IBaseView;
import com.bw.guojinyi.bean.BannerBean;
import com.bw.guojinyi.bean.PayBean;
import com.bw.guojinyi.mvp.IBannerContract;

import java.util.Map;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/6 16:34
 * @Description: 用途：完成特定功能
 */
public interface IPayContract {
    interface IPayView extends IBaseView {
        void onSuccess(PayBean bean);
        void onFailed(String error);
    }
    interface IPayModule{
        void getData(Map<String,String> param,ModuleCallBack moduleCallBack);
        interface ModuleCallBack{
            void onSuccess(PayBean bean);
            void onFailed(String error);
        }
    }
    interface IPayPresenter{
        void getData(Map<String,String> param);
    }
}
