package com.example.helloretrofit.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.helloretrofit.PageFragment;

/**
 * Created by Administrator on 2017/3/8.
 */
public class MyFragmentAdapter extends FragmentPagerAdapter {
    public final int COUNT=10;
    private String[] titles=new String[]{"社会","国内","国际","娱乐","体育","NBA","足球","科技","创业","苹果"};

    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}