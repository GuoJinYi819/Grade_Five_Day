package com.bw.guojinyi.fragment;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TableLayout;

import com.bw.guojinyi.R;
import com.bw.guojinyi.adapter.TabViewAdapter;
import com.bw.guojinyi.base.BaseFragment;
import com.bw.guojinyi.base.BasePresenter;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/21 13:43
 * @Description: 用途：完成特定功能
 */
public class My_Fragment extends BaseFragment {

    private TableLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    protected void initView() {
        tabLayout = view.findViewById( R.id.tabLayout );
        viewPager = view.findViewById( R.id.viewPager );

    }

    @Override
    protected void initData() {

    }


    @Override
    protected void initListener() {

    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }
}
