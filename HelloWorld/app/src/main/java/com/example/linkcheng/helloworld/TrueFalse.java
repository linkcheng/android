package com.example.linkcheng.helloworld;

/**
 * Created by zhenglong on 2017/4/27.
 */

public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;


    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int mQuestion) {
        this.mQuestion = mQuestion;
    }

    public TrueFalse(int q, boolean t) {
        mQuestion = q;
        mTrueQuestion = t;

    }
}
