package com.bw.guojinyi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.bw.guojinyi.R;
import com.bw.guojinyi.ShowActivity;
import com.bw.guojinyi.adapter.ExpandableAdapter;
import com.bw.guojinyi.adapter.RecyclerAdapter;
import com.bw.guojinyi.base.BaseFragment;
import com.bw.guojinyi.bean.CartBean;
import com.bw.guojinyi.bean.ShoppingBean;
import com.bw.guojinyi.mvp.BannerPresenterImpl;
import com.bw.guojinyi.mvp.IBannerContract;
import com.bw.guojinyi.mvp.IShoppingContract;
import com.bw.guojinyi.mvp.ShoppingresenterImpl;

import java.util.HashMap;
import java.util.List;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/21 13:43
 * @Description: 用途：完成特定功能
 */
public class Shopping_Fragment extends BaseFragment<ShoppingresenterImpl> implements IShoppingContract.IBannerView {

    private RecyclerView recycler;
    private ExpandableListView expandable_view;
    private Button btnJS;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_shopping;
    }

    @Override
    protected void initView() {
        recycler = view.findViewById(R.id.recycelr);
        btnJS = view.findViewById(R.id.btnJS);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);


        expandable_view = view.findViewById(R.id.expandable_view);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    protected void initListener() {
        //设置是厄齐
//        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getContext());
//        recycler.setAdapter(recyclerAdapter);
        //跳转至结算页
        btnJS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ShowActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected ShoppingresenterImpl initPresenter() {
        return new ShoppingresenterImpl();
    }

    @Override
    public void onSuccess(CartBean bannerBean) {
        //传传递数U
        List<CartBean.ResultBean> result = bannerBean.getResult();
        ExpandableAdapter expandableAdapter = new ExpandableAdapter(result, getContext());
        expandable_view.setAdapter(expandableAdapter);

    }

    @Override
    public void onFailed(String error) {

    }
}
