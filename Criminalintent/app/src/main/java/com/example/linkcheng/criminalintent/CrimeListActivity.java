package com.example.linkcheng.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;

/**
 * Created by link on 2017/5/15.
 */

public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
