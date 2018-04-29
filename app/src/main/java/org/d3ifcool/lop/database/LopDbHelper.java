package org.d3ifcool.lop.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.d3ifcool.lop.database.LopContract.TargetEntry;
import org.d3ifcool.lop.database.LopContract.TipsEntry;
import org.d3ifcool.lop.database.LopContract.AchievesEntry;

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
        String SQL_CREATE_TARGETS_TABLE = "CREATE TABLE " + TargetEntry.TABLE_NAME + " (" +
                TargetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TargetEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                TargetEntry.COLUMN_DESC + " TEXT NOT NULL, " +
                TargetEntry.COLUMN_STATUS + " INTEGER NOT NULL DEFAULT -1);";

        String SQL_CREATE_TIPS_TABLE = "CREATE TABLE " + TipsEntry.TABLE_NAME + " (" +
                TipsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TipsEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                TipsEntry.COLUMN_DESC + " TEXT NOT NULL, " +
                TipsEntry.COLUMN_STATUS + " INTEGER NOT NULL DEFAULT -1);";

        String SQL_CREATE_ACHIEVES_TABLE = "CREATE TABLE " + AchievesEntry.TABLE_NAME + " (" +
                AchievesEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                AchievesEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                AchievesEntry.COLUMN_DESC + " TEXT NOT NULL, " +
                AchievesEntry.COLUMN_TARGET_CONDITION + " INTEGER NOT NULL DEFAULT 0, " +
                AchievesEntry.COLUMN_TIP_CONDITION + " INTEGER NOT NULL DEFAULT 0, " +
                AchievesEntry.COLUMN_STATUS + " INTEGER NOT NULL DEFAULT -1);";

        sqLiteDatabase.execSQL(SQL_CREATE_TARGETS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TIPS_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ACHIEVES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // The database is still at version 1,
        // so there is nothing to do here.
    }
}
