package org.d3ifcool.lop.views;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.adapters.DataCursorAdapter;
import org.d3ifcool.lop.database.LopContract;
import org.d3ifcool.lop.databinding.ActivityTargetBinding;
import org.d3ifcool.lop.models.Data;

import java.util.ArrayList;

public class TargetActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private DataCursorAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTargetBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_target);
//        ListViewAdapter adapter = new ListViewAdapter(this,fetchData());

        mAdapter = new DataCursorAdapter(this, null);
        binding.listItem.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(1, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = {
                LopContract.TargetEntry._ID,
                LopContract.TargetEntry.COLUMN_TITLE,
                LopContract.TargetEntry.COLUMN_DESC,
                LopContract.TargetEntry.COLUMN_STATUS
        };

        return new CursorLoader(this,       // Parent activity context
                LopContract.TargetEntry.CONTENT_URI,   // URI from word table
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
