package org.d3ifcool.lop.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.d3ifcool.lop.contract.LopContract;
import org.d3ifcool.lop.helper.LopDbHelper;

/**
 * Created by CHEVALIER-11 on 24-Apr-18.
 */

public class LopProvider extends ContentProvider{

    private static final String LOG_TAG = LopProvider.class.getSimpleName();

    private static final int LOP = 100;

    private static final int LOP_ID = 101;

    private static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(LopContract.CONTENT_AUTHORITY, LopContract.PATH_LOP, LOP );

        sUriMatcher.addURI(LopContract.CONTENT_AUTHORITY, LopContract.PATH_LOP + "/#", LOP_ID);

    }

    private LopDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new LopDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }


}
