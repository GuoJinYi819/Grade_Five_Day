package com.bw.guojinyi.fragment;

import android.os.Bundle;

import com.bw.guojinyi.R;
import com.bw.guojinyi.base.BaseFragment;
import com.bw.guojinyi.base.BasePresenter;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/5 16:30
 * @Description: 用途：完成特定功能
 */
public class OrderFragment extends BaseFragment {
    @Override
    protected int initLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
    public static My_Fragment newInstance(int status) {

        Bundle args = new Bundle();
        args.putInt("status",status);
        My_Fragment fragment = new My_Fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
