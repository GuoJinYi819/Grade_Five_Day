package com.bw.guojinyi.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bw.guojinyi.fragment.Home_Fragment;
import com.bw.guojinyi.fragment.My_Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MyGradeDay
 *
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/2/21 13:41
 * @Description: 用途：完成特定功能
 */
public class MyViewPagerFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();

    public MyViewPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
        //创建fragment
        Home_Fragment home_fragment = new Home_Fragment();
        My_Fragment my_fragment = new My_Fragment();
        fragmentList.add(home_fragment);
        fragmentList.add(my_fragment);

        my_fragment = new My_Fragment();
        fragmentList.add(my_fragment);
        my_fragment = new My_Fragment();
        fragmentList.add(my_fragment);
        my_fragment = new My_Fragment();
        fragmentList.add(my_fragment);
        my_fragment = new My_Fragment();
        fragmentList.add(my_fragment);
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

}
