package com.customer.fragmentdemo.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.customer.fragmentdemo.R;
import com.customer.fragmentdemo.adapters.ViewPagerAdapter;

/**
 * Created by tesark on 18/8/16.
 */
public class Indicator extends Fragment implements ViewPager.OnPageChangeListener {

    ViewPager viewPager;
    LinearLayout page_indicator;
    int dotscount;
    ImageView[] dots;
    ViewPagerAdapter viewPagerAdapter;
    //int[] imgs = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher };
    int[] imgs = {R.mipmap.clothing, R.mipmap.designers, R.mipmap.diapering, R.mipmap.feeding, R.mipmap.feeding, R.mipmap.footwear};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.indicator, container, false);

        viewPager = (ViewPager)view.findViewById(R.id.vp_indicator);
        page_indicator = (LinearLayout)view.findViewById(R.id.viewPagerCountDots);
        viewPagerAdapter = new ViewPagerAdapter(getActivity(), imgs);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.setOnPageChangeListener(this);
        setUiPageViewController();
        return view;
    }

    private void setUiPageViewController() {
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for (int i = 0; i< dotscount; i++){
            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.unselecteditem));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );

            params.setMargins(4, 0, 4, 0);

            page_indicator.addView(dots[i], params);
        }
        dots[0].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem));
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotscount; i++) {
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.unselecteditem));
        }

        dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem));

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
