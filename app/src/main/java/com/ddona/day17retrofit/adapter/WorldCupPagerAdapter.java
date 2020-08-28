package com.ddona.day17retrofit.adapter;


import com.ddona.day17retrofit.fragment.MatchesFragment;
import com.ddona.day17retrofit.fragment.PlayerFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WorldCupPagerAdapter extends FragmentPagerAdapter {
    public WorldCupPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    private String[] arrTitle=new String[]{"Lịch đấu","Cầu thủ"};
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return MatchesFragment.getInstance();
            case 1: return PlayerFragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrTitle[position];
    }
}
