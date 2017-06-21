package com.beiyi.demo.myconstaintlayout;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.transition.TransitionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout constraintLayout;
    private ConstraintSet mConstraintSet1, mConstraintSet2;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraint_layout);
        text = (TextView) findViewById(R.id.text);

        mConstraintSet1 = new ConstraintSet();
        mConstraintSet2 = new ConstraintSet();

        text.setTag("1");

        mConstraintSet1.clone(constraintLayout);
        mConstraintSet2.clone(this, R.layout.layout_two);

        text.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (TextUtils.equals("1", (String) v.getTag())) {
            TransitionManager.beginDelayedTransition(constraintLayout);
            mConstraintSet2.applyTo(constraintLayout);
            text.setTag("2");
        } else {
            TransitionManager.beginDelayedTransition(constraintLayout);
            mConstraintSet1.applyTo(constraintLayout);
            text.setTag("1");
        }
    }
}
