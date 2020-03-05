package com.bw.guojinyi.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bw.guojinyi.fragment.OrderFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/3/5 16:27
 * @Description: 用途：完成特定功能
 */
public class TabViewAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<>();
    private Context context;
    private String[] arr = {"全部订单","待付款","收货订单","待评价"};

    public TabViewAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        list.add(OrderFragment.newInstance(0));
        list.add(OrderFragment.newInstance(1));
        list.add(OrderFragment.newInstance(2));
        list.add(OrderFragment.newInstance(3));
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arr[position];
    }

}
