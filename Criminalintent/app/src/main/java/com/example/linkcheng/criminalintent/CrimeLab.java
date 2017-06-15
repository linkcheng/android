package com.example.linkcheng.criminalintent;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by link on 2017/5/14.
 */

public class CrimeLab {
    private static final String TAG = "CrimeLab";
    private static final String FILENAME = "crime.json";

    private ArrayList<Crime> mCrimes;
    private CriminalIntentJSONSerializer mSerializer;

    private Context mAppContext;
    private static CrimeLab sCrimeLab;

    private CrimeLab(Context appContext) {
        mAppContext = appContext;
        mSerializer = new CriminalIntentJSONSerializer(mAppContext, FILENAME);

        try {
            mCrimes = mSerializer.loadCrimes();
        } catch (Exception e) {
            mCrimes = new ArrayList<>();
            Log.d(TAG, "without any local crimes");
        }
    }

    public static CrimeLab get(Context c) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes() {
        return mCrimes;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public Crime getCrime(UUID id) {
        for (Crime c : mCrimes) {
            if (c.getmId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public boolean saveCrimes() {
        try {
            mSerializer.saveCrimes(mCrimes);
            Log.d(TAG, "Crimes saved to file.");
            return true;
        } catch (Exception e){
            Log.e(TAG, "Error saving crimes: ", e);
            return false;
        }
    }
}
