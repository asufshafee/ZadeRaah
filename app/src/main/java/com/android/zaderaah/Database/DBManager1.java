package com.android.zaderaah.Database;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager1 {

    private DataBaseHelper1 dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager1(Context c) {
        context = c;
    }

    public DBManager1 open() throws SQLException {
        dbHelper = new DataBaseHelper1(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(String ENGLISHTITTLE, String DUAINARABIC, String ENGLISHREF,
                       String ENGLISHTRANSLATE, String URDUTITTLE, String URDUTRANSLATE, String TYPE, Boolean Fav, String Audio) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.ENGLISHTITTLE, ENGLISHTITTLE);
        contentValue.put(DatabaseHelper.DUAINARABIC, DUAINARABIC);
        contentValue.put(DatabaseHelper.ENGLISHREF, ENGLISHREF);
        contentValue.put(DatabaseHelper.ENGLISHTRANSLATE, ENGLISHTRANSLATE);
        contentValue.put(DatabaseHelper.URDUTITTLE, URDUTITTLE);
        contentValue.put(DatabaseHelper.URDUTRANSLATE, URDUTRANSLATE);
        contentValue.put(DatabaseHelper.TYPE, TYPE);
        contentValue.put(DatabaseHelper.AUDIO, Audio);
        contentValue.put(DatabaseHelper.FAV, String.valueOf(Fav));


        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
    }

    public Cursor fetch() {
        String[] columns = new String[]{DatabaseHelper._ID, DatabaseHelper.ENGLISHTITTLE, DatabaseHelper.DUAINARABIC, DatabaseHelper.ENGLISHREF
                , DatabaseHelper.ENGLISHTRANSLATE, DatabaseHelper.URDUTITTLE, DatabaseHelper.URDUTRANSLATE, DatabaseHelper.AUDIO, DatabaseHelper.FAV, DatabaseHelper.TYPE};
        Cursor cursor = database.query("Activity", null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Cursor fetch1() {
        String[] columns = new String[]{DatabaseHelper._ID, DatabaseHelper.ENGLISHTITTLE, DatabaseHelper.DUAINARABIC, DatabaseHelper.ENGLISHREF
                , DatabaseHelper.ENGLISHTRANSLATE, DatabaseHelper.URDUTITTLE, DatabaseHelper.URDUTRANSLATE, DatabaseHelper.AUDIO, DatabaseHelper.FAV, DatabaseHelper.TYPE};
        Cursor cursor = database.query("Dua", null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(long _id, Boolean Fav) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.FAV, String.valueOf(Fav));
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper._ID + " = " + _id, null);
        return i;
    }

    public void delete(long _id) {
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper._ID + "=" + _id, null);
    }

}