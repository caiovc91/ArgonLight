package caio.systems.argontest;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HomeMainSlider extends Fragment {

    private ViewPager mPager;
    private InternalPagerAdapter pagerAdapter;

    public HomeMainSlider() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_main_slider, container, false);
        mPager = v.findViewById(R.id.pager);
        pagerAdapter = new InternalPagerAdapter(getFragmentManager());
        mPager.setAdapter(pagerAdapter);
        return v;
    }
    static class InternalPagerAdapter extends FragmentPagerAdapter {
        static final int NUMBER_OF_PAGES = 3;

        public InternalPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        public Fragment getItem(int position) {
            switch (position){
                case 0:return  HomeGraphFragment.newInstance("HOME MAIN FRAGMENT, Instance 1");
                case 1: return HomeEconomyFragment.newInstance("HOME ECONOMY FRAGMENT, Instance 1");
                case 2: return HomeGreenFragment.newInstance("HOME GREEN FRAGMENT, Instance 1");
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return NUMBER_OF_PAGES;
        }
    }

}
