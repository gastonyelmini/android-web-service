package com.example.gastonyelmini.entregableservicioswebyelmini.Model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gaston on 19/06/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "musicAppDatabase";
    public static final Integer DATABASE_VERSION = 1;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Crear la tabla
        String query = "CREATE TABLE " + DAOTrackDatabase.TABLE_NAME + " (" +
                DAOTrackDatabase.COLUMN_ID + " INTEGER PRIMARY KEY, " +
                DAOTrackDatabase.COLUMN_TITLE + " TEXT NOT NULL, " +
                DAOTrackDatabase.COLUMN_ALBUM_ID + " INTEGER NOT NULL, " +
                DAOTrackDatabase.COLUMN_THUMBNAIL + " TEXT NOT NULL, " +
                DAOTrackDatabase.COLUMN_IMAGE + " TEXT NOT NULL);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
