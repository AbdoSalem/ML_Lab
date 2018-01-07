package com.hci.apps.ml_lab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;

/**
 * Created by abdo on 07/01/18.
 */

public class ScenariosAdapter extends FragmentStatePagerAdapter{

    private static final String TAG = ScenariosAdapter.class.getSimpleName();

    public ScenariosAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 8;
    }


    @Override
    public Fragment getItem(int position) {
        int gestureEnabled = position%2;
        int scenarioId = (position-gestureEnabled)/2;
        Log.d(TAG,"posittion is "+ position+" gestureEnabled is "+gestureEnabled+" :: scenrarioID is "+scenarioId);
        return ScenarioFragment.newInstance(scenarioId,gestureEnabled);
    }

}
