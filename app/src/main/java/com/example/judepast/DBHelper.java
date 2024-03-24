package com.example.judepast;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "jude.db";
    private static final int version = 1;
    private static final String TABLE = "clients";
    private static final String ID = "CLIENT_ID";
    private static final String F_NAME = "CLIENT_FNAME";
    private static final String L_NAME = "CLIENT_LNAME";
    private static final String EMAIL = "CLIENT_EMAIL";
    SQLiteDatabase db;
    DBHelper(Context context){
        super(context,DB_NAME, null,version);
        db = getWritableDatabase();
        onCreate(db);
    }





    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+ TABLE+" ( "+ ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"

                +F_NAME + "TEXT, "+ L_NAME+ " TEXT, "+ EMAIL +" TEXT)";

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    void addClient(String first, String last, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(F_NAME, first);
        values.put(L_NAME, last);
        values.put(EMAIL, email);

        db.insert(TABLE,null,values);
    }
}
