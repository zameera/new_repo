package com.example.asiqin.trackcoordinate;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Asiqin on 6/5/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "GPS.db";
    public static final String TABLE_NAME = "LOCATION";
    public static final int VERSION = 1;
    public static final String KEY_ID = "ID";
    public static final String LAT = "LATITUDE";
    public static final String LNG = "LONGITUDE";
    private SQLiteDatabase db;

    public static final String SCRIPT = "create table " + TABLE_NAME + "(" + KEY_ID + " integer primary key autoincrement," + LAT + " double," + LNG + " double );";

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table " +TABLE_NAME);
        onCreate(db);

    }
}
