package org.d3ifcool.lop.views;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.d3ifcool.lop.R;

public class AlarmActivity extends AppCompatActivity {

    private SharedPreferences mSharedPreferences;
    private int mTarget;
    private int mTips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);

        mSharedPreferences = getSharedPreferences("lopApp", MODE_PRIVATE);
        mTarget = mSharedPreferences.getInt("target", -1);
        mTips = mSharedPreferences.getInt("tips", -1);
    }


    public void doTarget(View view) {
        mTarget++;
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("target", mTarget);
        editor.apply();
    }

    public void skipTarget(View view) {
        mTips++;
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("tips", mTips);
        editor.apply();
    }
}
