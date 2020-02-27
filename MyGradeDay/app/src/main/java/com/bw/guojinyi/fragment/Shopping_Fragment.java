package com.bw.guojinyi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bw.guojinyi.R;
import com.bw.guojinyi.adapter.RecyclerAdapter;
import com.bw.guojinyi.base.BaseFragment;
import com.bw.guojinyi.bean.ShoppingBean;
import com.bw.guojinyi.mvp.BannerPresenterImpl;
import com.bw.guojinyi.mvp.IBannerContract;
import com.bw.guojinyi.mvp.IShoppingContract;
import com.bw.guojinyi.mvp.ShoppingresenterImpl;

import java.util.HashMap;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/21 13:43
 * @Description: 用途：完成特定功能
 */
public class Shopping_Fragment extends BaseFragment<ShoppingresenterImpl> implements IShoppingContract.IBannerView {

    private RecyclerView recycler;

    @Override
    protected int initLayoutId() {
        return R.layout.fragment_shopping;
    }

    @Override
    protected void initView() {
        recycler = view.findViewById(R.id.recycelr);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userId","33417");
        hashMap.put("sessionId","158279483524733417");
        presenter.getData(hashMap);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected ShoppingresenterImpl initPresenter() {
        return new ShoppingresenterImpl();
    }

    @Override
    public void onSuccess(ShoppingBean bannerBean) {
        //设置是厄齐
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getContext());
        recycler.setAdapter(recyclerAdapter);
    }

    @Override
    public void onFailed(String error) {

    }
}
