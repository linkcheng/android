package com.example.linkcheng.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by zhenglong on 2017/5/5.
 */

public class CheatActivity extends AppCompatActivity {
    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.linkcheng.helloworld.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.linkcheng.helloworld.answer_shown";
    private boolean mAnswerIsTrue;
    private TextView mShowTextView;
    private Button mShowButton;

    private void setAnswerShownResult(boolean isAnswerShown) {
        // 通过 intent，返回值给进入这个 activity 的入口 activity
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        setAnswerShownResult(false);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mShowTextView = (TextView) findViewById(R.id.answerTextView);

        mShowButton = (Button) findViewById(R.id.showAnswerButton);
        mShowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswerIsTrue) {
                    mShowTextView.setText(R.string.true_button);
                } else {
                    mShowTextView.setText(R.string.false_button);
                }
                setAnswerShownResult(true);
            }
        });
    }
}
