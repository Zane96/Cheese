package com.example.zane.cheeses.moduel.homepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zane on 15/12/2.
 */
public class ViewpagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> mFragment = new ArrayList<>();
    private List<String> mFragmentTitle = new ArrayList<>();

    public ViewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(CheesesListFragment fragment, String title){
        mFragment.add(fragment);
        mFragmentTitle.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitle.get(position);
    }
}
