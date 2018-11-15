package com.ausoccer.ausoccerintramurals;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TeamDataPagerAdapter extends FragmentStatePagerAdapter {

    int numOfTabs;

    public TeamDataPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                SquadFragment tab1 = new SquadFragment();
                return tab1;
            case 1:
                TeamStandingsFragment tab2 = new TeamStandingsFragment();
                return tab2;
            default:
                return null;


        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
