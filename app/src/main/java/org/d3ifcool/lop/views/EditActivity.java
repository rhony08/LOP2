package org.d3ifcool.lop.views;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import org.d3ifcool.lop.R;
import org.d3ifcool.lop.database.LopContract;

public class EditActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private Uri mContentUri;
    private EditText mName;
    private EditText mDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Intent intent = getIntent();
        mContentUri = intent.getData();

        mName = findViewById(R.id.name);
        mDesc = findViewById(R.id.desc);

        getSupportLoaderManager().initLoader(1, null, this);
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
                mContentUri,   // URI from word table
                projection,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data == null || data.getCount() < 1) {
            return;
        }

        if (data.moveToFirst()){
            int nameColIndex = data.getColumnIndex(LopContract.AchievesEntry.COLUMN_TITLE);
            int descColIndex = data.getColumnIndex(LopContract.AchievesEntry.COLUMN_DESC);

            String name = data.getString(nameColIndex);
            String desc = data.getString(descColIndex);

            mName.setText(name);
            mDesc.setText(desc);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mName.setText("");
        mDesc.setText("");
    }
}
