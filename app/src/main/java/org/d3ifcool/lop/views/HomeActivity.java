package org.d3ifcool.lop.views;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.loader.DataLoader;
import org.d3ifcool.lop.models.Data;
import org.d3ifcool.lop.services.AlarmReceiver;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Data>> {

    private SharedPreferences sharedPreferences;

    private static final int ALARM_REQUEST_CODE = 133;

    //Pending intent instance
    private PendingIntent pendingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences("lopApp", MODE_PRIVATE);

        boolean isInserted = sharedPreferences.getBoolean("isInserted", false);

        /* Retrieve a PendingIntent that will perform a broadcast */
        Intent alarmIntent = new Intent(HomeActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(HomeActivity.this, ALARM_REQUEST_CODE, alarmIntent, 0);


        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();


        if (isConnected && !isInserted){
            getSupportLoaderManager().initLoader(1, null,this);
        }else if (!isConnected){
            Toast.makeText(this, "Network unavailable", Toast.LENGTH_SHORT).show();
        }
    }

    public void goToTarget(View view) {
        startActivity(new Intent(HomeActivity.this, TargetActivity.class));
        finish();
    }

    public void goToTips(View view) {
        startActivity(new Intent(HomeActivity.this, TipsActivity.class));
        finish();
    }

    public void goToAchieve(View view) {
        startActivity(new Intent(HomeActivity.this, AchievementActivity.class));
        finish();
    }

    @Override
    public Loader<List<Data>> onCreateLoader(int id, Bundle args) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isInserted", true);
        editor.apply();
        return new DataLoader(this);
    }

    @Override
    public void onLoadFinished(Loader<List<Data>> loader, List<Data> data) {
        return;
    }

    @Override
    public void onLoaderReset(Loader<List<Data>> loader) {
        return;
    }
}
