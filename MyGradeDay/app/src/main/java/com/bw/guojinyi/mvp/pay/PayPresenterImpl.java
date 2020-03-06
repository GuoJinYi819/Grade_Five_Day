package com.bw.guojinyi.mvp.pay;

import com.bw.guojinyi.base.BasePresenter;
import com.bw.guojinyi.bean.PayBean;

import java.util.Map;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/6 16:37
 * @Description: 用途：完成特定功能
 */
public class PayPresenterImpl extends BasePresenter<IPayContract.IPayView> implements IPayContract.IPayPresenter {
    private PayModuleImpl module;
    @Override
    protected void initModule() {
        module = new PayModuleImpl();
    }

    @Override
    public void getData(Map<String, String> param) {
        module.getData( param, new IPayContract.IPayModule.ModuleCallBack() {
            @Override
            public void onSuccess(PayBean bean) {
                baseview.onSuccess( bean );
            }

            @Override
            public void onFailed(String error) {
                baseview.onFailed( error );
            }
        } );
    }
}
