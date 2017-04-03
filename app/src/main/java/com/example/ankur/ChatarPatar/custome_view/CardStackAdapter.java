package com.example.ankur.ChatarPatar.custome_view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ankur on 03-04-2017.
 */

public class CardStackAdapter extends FragmentStatePagerAdapter {
    public CardStackAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new CardStackFragment();
    }

    @Override
    public int getCount() {
        return 10;
    }
}
