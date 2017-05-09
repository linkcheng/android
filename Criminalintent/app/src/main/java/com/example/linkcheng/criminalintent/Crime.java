package com.example.linkcheng.criminalintent;

import java.util.UUID;

/**
 * Created by zhenglong on 2017/5/7.
 */

public class Crime {
    private UUID mId;
    private String mTitle;

    public UUID getmId() {
        return mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Crime() {
        // 生成唯一标识符
        mId = UUID.randomUUID();
    }
}
