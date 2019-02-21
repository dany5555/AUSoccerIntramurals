package com.ausoccer.ausoccerintramurals;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Kevin Daniel on 9/2/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Matchday1Fragment tab1 = new Matchday1Fragment();
                return tab1;
            case 1:
                Matchday2Fragment tab2 = new Matchday2Fragment();
                return tab2;
            case 2:
                Matchday3Fragment tab3 = new Matchday3Fragment();
                return tab3;
            case 3:
                Matchday4Fragment tab4 = new Matchday4Fragment();
                return tab4;
            case 4:
                Matchday5Fragment tab5 = new Matchday5Fragment();
                return tab5;
            case 5:
                Matchday6Fragment tab6 = new Matchday6Fragment();
                return tab6;
            case 6:
                Matchday7Fragment tab7 = new Matchday7Fragment();
                return tab7;
            case 7:
                Matchday8Fragment tab8 = new Matchday8Fragment();
                return tab8;
            case 8:
                Matchday9Fragment tab9 = new Matchday9Fragment();
                return tab9;
            case 9:
                Matchday10Fragment tab10 = new Matchday10Fragment();
                return tab10;
            case 10:
                Matchday11Fragment tab11 = new Matchday11Fragment();
                return tab11;
            case 11:
                FinalFragment tab12 = new FinalFragment();
                return tab12;
            default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
