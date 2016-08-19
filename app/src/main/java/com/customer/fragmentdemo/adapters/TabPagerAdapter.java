package com.customer.fragmentdemo.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.customer.fragmentdemo.fragments.Tab1_fragment;
import com.customer.fragmentdemo.fragments.Tab2_fragment;
import com.customer.fragmentdemo.fragments.Tab3_fragment;

/**
 * Created by tesark on 18/8/16.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter{
    int tabCount;
    public TabPagerAdapter(FragmentManager fm, int tabCount) {

        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Tab1_fragment();
            case 1:
                return new Tab2_fragment();
            case 2:
                return new Tab3_fragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
