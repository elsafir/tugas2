package com.ppb.tugas2.ui.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mahasiswa.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table mahsiswa(nama text null, nim text null);";
        Log.d("Data","onCreate: "+sql);
        db.execSQL(sql);

        sql = "INSERT INTO mahasiswa (nama, nim) VALUES ('Safitr', '180411100001');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
