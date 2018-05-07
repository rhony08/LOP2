package org.d3ifcool.lop.views;

import android.app.LoaderManager;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.database.LopContract;
import org.d3ifcool.lop.databinding.ActivityDescriptionTargetBinding;

public class DescriptionTargetActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private ActivityDescriptionTargetBinding binding;
    private SharedPreferences mSharedPreferences;
    private int mTarget;
    private int mTips;
    private int mType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_description_target);

        mSharedPreferences = getSharedPreferences("lopApp", MODE_PRIVATE);
        mTarget = mSharedPreferences.getInt("target", -1);
        mTips = mSharedPreferences.getInt("tips", -1);

        Intent intent = getIntent();
        mType = intent.getIntExtra("type", -1);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String[] projection = null;
        switch (mType){
            case 1: {
                projection = new String[] {
                        LopContract.TargetEntry._ID,
                        LopContract.TargetEntry.COLUMN_TITLE,
                        LopContract.TargetEntry.COLUMN_DESC,
                        LopContract.TargetEntry.COLUMN_STATUS
                };
                break;
            }case 2: {
                projection = new String[] {
                        LopContract.TipsEntry._ID,
                        LopContract.TipsEntry.COLUMN_TITLE,
                        LopContract.TipsEntry.COLUMN_DESC,
                        LopContract.TipsEntry.COLUMN_STATUS
                };
                break;
            }
        }

        String selection = "status = ?";

        String[] selectionArgs = { String.valueOf((mType == 1) ? LopContract.TargetEntry.LOCKED_STATUS : LopContract.TipsEntry.LOCKED_STATUS )};

        return (projection != null) ? new CursorLoader(this,       // Parent activity context
                LopContract.TargetEntry.CONTENT_URI,   // URI from word table
                projection,
                selection,
                selectionArgs,
                "RANDOM() limit 1") : null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null) {
            if (cursor.moveToFirst()){
                int idColumnIndex = cursor.getColumnIndex(LopContract.TargetEntry._ID);
                int nameColIndex = cursor.getColumnIndex(LopContract.TargetEntry.COLUMN_TITLE);
                int descColIndex = cursor.getColumnIndex(LopContract.TargetEntry.COLUMN_DESC);
                binding.setName(cursor.getString(nameColIndex));
                binding.setDesc(cursor.getString(descColIndex));

                long id = cursor.getInt(idColumnIndex);

                switch (mType){
                    case 1: {
                        mTarget++;
                        break;
                    }case 2:{
                        mTips++;
                        break;
                    }
                }

                Uri uri = ContentUris.withAppendedId(LopContract.AchievesEntry.CONTENT_URI, id);
                ContentValues values = new ContentValues();
                values.put(LopContract.TipsEntry.COLUMN_STATUS, (mType == 1) ?
                LopContract.TargetEntry.ONPROGRESS_STATUS : LopContract.TipsEntry.COMPLETED_STATUS);

                getContentResolver().update(uri, values, null, null);
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        return;
    }
}
