package com.ausoccer.ausoccerintramurals;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Kevin Daniel on 9/11/2018.
 */

public class MatchDetailsAdminPagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public MatchDetailsAdminPagerAdapter(FragmentManager fm, int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs = mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                GameEventsFragment tab1 = new GameEventsFragment();
                return tab1;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
