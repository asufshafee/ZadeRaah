package com.android.zaderaah.Database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "COUNTRIES";

    // Table columns
    public static final String _ID = "_id";
    public static final String ENGLISHTITTLE = "ENGLISHTITTLE";
    public static final String DUAINARABIC = "DUAINARABIC";
    public static final String ENGLISHREF = "ENGLISHREF";
    public static final String ENGLISHTRANSLATE = "ENGLISHTRANSLATE";
    public static final String URDUTITTLE = "URDUTITTLE";
    public static final String AUDIO = "AUDIO";

    public static final String FAV = "FAV";
    public static final String Roman = "Roman";

    public static final String URDUTRANSLATE = "URDUTRANSLATE";
    public static final String TYPE = "TYPECHCEK";
    public static final String MAINTYPE = "MAINTYPE";

    // Database Information
    static final String DB_NAME = "Zaderaah1.DB";

    // database version
    static final int DB_VERSION = 1;

    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "" + ENGLISHTITTLE + " TEXT," +
            "" + DUAINARABIC + " TEXT," +
            "" + ENGLISHREF + " TEXT," +
            "" + ENGLISHTRANSLATE + " TEXT," +
            "" + URDUTRANSLATE + " TEXT," +
            "" + URDUTITTLE + " TEXT," +
            "" + TYPE + " TEXT," +
            "" + AUDIO + " TEXT," +
            "" + FAV + " TEXT," +
            " " + Roman + " TEXT);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}