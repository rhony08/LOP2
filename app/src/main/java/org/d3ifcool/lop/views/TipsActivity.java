package org.d3ifcool.lop.views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.adapters.DataCursorAdapter;
import org.d3ifcool.lop.database.LopContract;
import org.d3ifcool.lop.database.LopDbHelper;
import org.d3ifcool.lop.databinding.ActivityTargetBinding;

public class TipsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private DataCursorAdapter mAdapter;
    private LopDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTargetBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_target);
//        ListViewAdapter adapter = new ListViewAdapter(this,fetchData());
        mDbHelper = new LopDbHelper(this);
        mAdapter = new DataCursorAdapter(this, null);
        binding.listItem.setAdapter(mAdapter);

        getSupportLoaderManager().initLoader(1, null, this);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(TipsActivity.this, HomeActivity.class));
        finish();
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                LopContract.TipsEntry._ID,
                LopContract.TipsEntry.COLUMN_TITLE,
                LopContract.TipsEntry.COLUMN_DESC,
                LopContract.TipsEntry.COLUMN_STATUS
        };

        return new CursorLoader(this,       // Parent activity context
                LopContract.TipsEntry.CONTENT_URI,   // URI from word table
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
