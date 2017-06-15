package com.example.linkcheng.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by link on 2017/6/1.
 */

public class CrimePagerActivity extends AppCompatActivity {
    private ViewPager mViewpager;
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewpager = new ViewPager(this);
        mViewpager.setId(R.id.viewpager);
        setContentView(mViewpager);
        mCrimes = CrimeLab.get(this).getCrimes();

        // 设置 adapter，实现滑动
        FragmentManager fm = getSupportFragmentManager();
        mViewpager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Crime crime = mCrimes.get(position);
                return CrimeFragment.newInstance(crime.getmId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });

        // 设置标题栏
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Crime crime = mCrimes.get(position);
                if (crime.getmTitle() != null) {
                    setTitle(crime.getmTitle());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // 设置选中项为当前 view 的内容
        UUID crimeId = (UUID) getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
        for (int i=0; i<mCrimes.size(); i++) {
            if (mCrimes.get(i).getmId().equals(crimeId)) {
                mViewpager.setCurrentItem(i);
                break;
            }
        }
    }
}
