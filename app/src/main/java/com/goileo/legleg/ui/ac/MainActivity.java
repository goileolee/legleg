package com.goileo.legleg.ui.ac;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.goileo.legleg.R;
import com.goileo.legleg.ui.fragment.LeftFragment;
import com.goileo.legleg.ui.fragment.MineFragment;
import com.goileo.legleg.ui.fragment.WeatherFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by Goileo on 2018/4/16.
 */

public class MainActivity extends BaseActivity {

    @Bind(R.id.tabLayout)
    public TabLayout mTabLayout;
    @Bind(R.id.viewPager)
    public ViewPager mViewPager;
    private List<Fragment> mList;
    private String[] mTitles;
    private final Integer[] mTitleViews = new Integer[]{
            R.drawable.left_selected_tab, R.drawable.weather_selected_tab,
            R.drawable.mine_selected_tab};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFullScreen();
        initView();
    }

    public void initView() {
        mTitles = getResources().getStringArray(R.array.navigationName);
        mList = new ArrayList<>();
        mList.add(LeftFragment.getInstance());
        mList.add(new WeatherFragment());
        mList.add(new MineFragment());
        mViewPager.setOffscreenPageLimit(3);
        TabMainAdapter fpAdapter = new TabMainAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(fpAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        for (int i = 0; i < mTitles.length; i++) {
            if (null != mTabLayout.getTabAt(i))
                mTabLayout.getTabAt(i).setCustomView(fpAdapter.getTabView(i));
        }
        mViewPager.setCurrentItem(1);
    }

    class TabMainAdapter extends FragmentPagerAdapter{

        public TabMainAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mTitles.length;
        }

        public View getTabView(int position) {
            View tabView = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.item_tab_main, null);
            ImageView tabMainIv = tabView.findViewById(R.id.tab_main_iv);
            TextView tabMainTv = tabView.findViewById(R.id.tab_main_tv);
            tabMainIv.setImageResource(mTitleViews[position]);
            tabMainTv.setText(mTitles[position]);
            return tabView;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private long exitTime = 0;
    @Override
    public void onBackPressed() {

        if ((System.currentTimeMillis() - exitTime) > 2000) {
            showToast(R.string.app_quit);
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }

}
