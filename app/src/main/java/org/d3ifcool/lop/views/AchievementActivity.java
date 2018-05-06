package org.d3ifcool.lop.views;

import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.adapters.DataCursorAdapter;
import org.d3ifcool.lop.database.LopContract;
import org.d3ifcool.lop.databinding.ActivityTargetBinding;

public class AchievementActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>  {

    private DataCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTargetBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_target);

        mAdapter = new DataCursorAdapter(this, null);
        binding.listItem.setAdapter(mAdapter);

        binding.listItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(AchievementActivity.this, EditActivity.class);

                Uri uri = ContentUris.withAppendedId(LopContract.AchievesEntry.CONTENT_URI, l);

                intent.setData(uri);

                startActivity(intent);
            }
        });

        getSupportLoaderManager().initLoader(1, null, this);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(AchievementActivity.this, HomeActivity.class));
        finish();
    }
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                LopContract.AchievesEntry._ID,
                LopContract.AchievesEntry.COLUMN_TITLE,
                LopContract.AchievesEntry.COLUMN_DESC,
                LopContract.AchievesEntry.COLUMN_STATUS,
                LopContract.AchievesEntry.COLUMN_TIP_CONDITION,
                LopContract.AchievesEntry.COLUMN_TARGET_CONDITION
        };

        return new CursorLoader(this,       // Parent activity context
                LopContract.AchievesEntry.CONTENT_URI,   // URI from word table
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
