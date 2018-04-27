package org.d3ifcool.lop.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.d3ifcool.lop.database.LopContract.LopEntry;

/**
 * Created by CHEVALIER-11 on 24-Apr-18.
 */

public class LopDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "lop.db";
    private static final int DATABASE_VERSION = 1;

    public LopDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_TARGETS_TABLE = "CREATE TABLE " + LopEntry.TARGETS_TABLE_NAME + " (" +
                LopEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LopEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                LopEntry.COLUMN_DESC + " TEXT NOT NULL, " +
                LopEntry.COLUMN_STATUS + " INTEGER NOT NULL DEFAULT -1);";
        String SQL_CREATE_TIPS_TABLE = "CREATE TABLE " + LopEntry.TIPS_TABLE_NAME + " (" +
                LopEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LopEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                LopEntry.COLUMN_DESC + " TEXT NOT NULL, " +
                LopEntry.COLUMN_STATUS + " INTEGER NOT NULL DEFAULT -1);";
        sqLiteDatabase.execSQL(SQL_CREATE_TARGETS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TIPS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // The database is still at version 1,
        // so there is nothing to do here.
    }
}
