package org.d3ifcool.lop.database;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import org.d3ifcool.lop.database.LopContract.TargetEntry;
import org.d3ifcool.lop.database.LopContract.TipsEntry;
import org.d3ifcool.lop.database.LopContract.AchievesEntry;

/**
 * Database Provider.
 */

public class LopProvider extends ContentProvider{

    private static final String LOG_TAG = LopProvider.class.getSimpleName();

    private static final int TARGET = 100;

    private static final int TARGET_ID = 101;

    private static final int TIP = 200;

    private static final int TIP_ID = 201;

    private static final int ACHIEVE = 300;

    private static final int ACHIEVE_ID = 301;

    private static UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        sUriMatcher.addURI(LopContract.CONTENT_AUTHORITY, LopContract.PATH_TARGET, TARGET );
        sUriMatcher.addURI(LopContract.CONTENT_AUTHORITY, LopContract.PATH_TARGET + "/#", TARGET_ID);

        sUriMatcher.addURI(LopContract.CONTENT_AUTHORITY, LopContract.PATH_TIP, TIP );
        sUriMatcher.addURI(LopContract.CONTENT_AUTHORITY, LopContract.PATH_TIP + "/#", TIP_ID);

        sUriMatcher.addURI(LopContract.CONTENT_AUTHORITY, LopContract.PATH_ACHIEVE, ACHIEVE );
        sUriMatcher.addURI(LopContract.CONTENT_AUTHORITY, LopContract.PATH_ACHIEVE + "/#", ACHIEVE_ID);

    }

    private LopDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        mDbHelper = new LopDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        Cursor cursor;

        int match = sUriMatcher.match(uri);

        switch (match){
            case TARGET:
                cursor = database.query(TargetEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case TARGET_ID:
                selection = TargetEntry._ID + "=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(TargetEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case TIP:
                cursor = database.query(TipsEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case TIP_ID:
                selection = TipsEntry._ID + "=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(TipsEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw  new  IllegalArgumentException("Cannot query unknown URI " + uri);
        }

        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match){
            case TARGET:
                return TargetEntry.CONTENT_LIST_TYPE;
            case TARGET_ID:
                return TargetEntry.CONTENT_ITEM_TYPE;
            case TIP:
                return TipsEntry.CONTENT_LIST_TYPE;
            case TIP_ID:
                return TipsEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalArgumentException("Unknown uri " + uri + " with match " + match);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);

        switch (match){
            case TARGET:
                return insertData(uri, contentValues, TargetEntry.TABLE_NAME);
            case TIP:
                return insertData(uri, contentValues, TipsEntry.TABLE_NAME);
            case ACHIEVE:
                return insertData(uri, contentValues, AchievesEntry.TABLE_NAME);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri + " with match " + match);
        }
    }

    private Uri insertData (Uri uri, ContentValues values, String tableName){
        String name = values.getAsString(TargetEntry.COLUMN_TITLE);
        if (name == null){
            Log.e(LOG_TAG,"Data requires a name");
        }

        String desc = values.getAsString(TargetEntry.COLUMN_DESC);
        if (desc == null){
            Log.e(LOG_TAG,"Data requires a description");
        }

        Integer status = values.getAsInteger(TargetEntry.COLUMN_STATUS);
        if (status != null && status < -2){
            Log.e(LOG_TAG,"Data requires valid status");
        }

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        long id = database.insert(tableName, null, values);

        if (id == -1){
            Log.e(LOG_TAG, "Failed to insert row for uri " + uri);
            return null;
        }

        getContext().getContentResolver().notifyChange(uri, null);

        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        final int match = sUriMatcher.match(uri);
        switch (match){
            case TARGET:
                return database.delete(TargetEntry.TABLE_NAME, selection, selectionArgs);
            case TARGET_ID:
                selection = TargetEntry._ID + "=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                return database.delete(TargetEntry.TABLE_NAME, selection, selectionArgs);
            case TIP:
                return database.delete(TipsEntry.TABLE_NAME, selection, selectionArgs);
            case TIP_ID:
                selection = TipsEntry._ID + "=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                return database.delete(TipsEntry.TABLE_NAME, selection, selectionArgs);
            case ACHIEVE:
                return database.delete(TipsEntry.TABLE_NAME, selection, selectionArgs);
            case ACHIEVE_ID:
                selection = AchievesEntry._ID + "=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                return database.delete(AchievesEntry.TABLE_NAME, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Deleting is not supprted for " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        final int match = sUriMatcher.match(uri);

        switch (match){
            case TARGET:
                return updateData(uri, contentValues, selection, selectionArgs, TargetEntry.TABLE_NAME);
            case TARGET_ID:
                selection = TargetEntry._ID + "=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                return updateData(uri, contentValues, selection, selectionArgs, TargetEntry.TABLE_NAME);
            case TIP:
                return updateData(uri, contentValues, selection, selectionArgs, TargetEntry.TABLE_NAME);
            case TIP_ID:
                selection = TipsEntry._ID + "=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                return updateData(uri, contentValues, selection, selectionArgs, TipsEntry.TABLE_NAME);
            case ACHIEVE:
                return updateData(uri, contentValues, selection, selectionArgs, AchievesEntry.TABLE_NAME);
            case ACHIEVE_ID:
                selection = AchievesEntry._ID + "=?";
                selectionArgs = new String[] {String.valueOf(ContentUris.parseId(uri))};
                return updateData(uri, contentValues, selection, selectionArgs, AchievesEntry.TABLE_NAME);
            default:
                throw new IllegalArgumentException("Updating is not supported for " + uri + " with match " + match);
        }
    }

    private int updateData(Uri uri, ContentValues values, String selection, String[] selectionArgs, String tableName){
        if (values.containsKey(TargetEntry.COLUMN_TITLE)){
            String name = values.getAsString(TargetEntry.COLUMN_TITLE);
            if (name == null){
                throw new IllegalArgumentException("Data requires a name");
            }
        }

        if (values.containsKey(TargetEntry.COLUMN_DESC)){
            String desc = values.getAsString(TargetEntry.COLUMN_DESC);
            if (desc == null){
                throw new IllegalArgumentException("Data requires valid description");
            }
        }

        if (values.containsKey(TargetEntry.COLUMN_STATUS)){
            Integer weight = values.getAsInteger(TargetEntry.COLUMN_STATUS);
            if (weight != null && weight < 0){
                throw new IllegalArgumentException("Data requires valid status");
            }
        }

        if (values.size() == 0){
            return 0;
        }
        SQLiteDatabase database = mDbHelper.getWritableDatabase();
        getContext().getContentResolver().notifyChange(uri, null);
        return database.update(tableName, values, selection, selectionArgs);
    }
}
