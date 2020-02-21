package com.bw.guojinyi;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bw.guojinyi.adapter.MyViewPagerFragmentAdapter;

public class MainActivity extends AppCompatActivity {

    private ViewPager mainVp;
    private TabLayout mainTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        mainVp = findViewById(R.id.main_vp);
        mainTab = findViewById(R.id.main_tab);
        TabLayout.Tab tab = mainTab.newTab();
        tab.setIcon(R.mipmap.show);
        mainTab.addTab(tab);

        tab = mainTab.newTab();
        tab.setIcon(R.mipmap.a1);
        mainTab.addTab(tab);

        tab = mainTab.newTab();
        tab.setIcon(R.mipmap.a2);
        mainTab.addTab(tab);

        tab = mainTab.newTab();
        tab.setIcon(R.mipmap.a3);
        mainTab.addTab(tab);

        tab = mainTab.newTab();
        tab.setIcon(R.mipmap.a4);
        mainTab.addTab(tab);
        //创建 vp的适配器
        MyViewPagerFragmentAdapter myViewPagerFragmentAdapter = new MyViewPagerFragmentAdapter(getSupportFragmentManager());
        mainVp.setAdapter(myViewPagerFragmentAdapter);

    }
    private void initListener() {
        mainVp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                mainTab.setScrollPosition(i,0,false);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                mainVp.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
