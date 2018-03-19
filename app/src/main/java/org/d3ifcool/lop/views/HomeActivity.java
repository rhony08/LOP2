package org.d3ifcool.lop.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import org.d3ifcool.lop.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void goToTarget(View view) {
        startActivity(new Intent(HomeActivity.this, TargetActivity.class));
    }

    public void goToTips(View view) {
        startActivity(new Intent(HomeActivity.this, TipsActivity.class));
    }

    public void goToAchieve(View view) {
        startActivity(new Intent(HomeActivity.this, AchievementActivity.class));
    }
}
