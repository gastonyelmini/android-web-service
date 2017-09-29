package com.example.gastonyelmini.entregableservicioswebyelmini.Model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gastonyelmini.entregableservicioswebyelmini.Model.POJO.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 19/06/17.
 */

public class DAOTrackDatabase extends DatabaseHelper {

    public static final String TABLE_NAME = "tableTrack";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_ALBUM_ID = "albumId";
    public static final String COLUMN_THUMBNAIL = "thumbnailUrl";
    public static final String COLUMN_IMAGE = "imageUrl";

    public DAOTrackDatabase(Context context) {
        super(context);
    }

    public void addTrack(Track track) {
        if (!isTrackInDb    (track.getId())) {

            SQLiteDatabase database = getWritableDatabase();

            ContentValues row = new ContentValues();
            row.put(COLUMN_ID, track.getId());
            row.put(COLUMN_TITLE, track.getTrackName());
            row.put(COLUMN_ALBUM_ID, track.getAlbumId());
            row.put(COLUMN_THUMBNAIL, track.getTrackThumbnailUrl());
            row.put(COLUMN_IMAGE, track.getTrackImageUrl());

            database.insert(TABLE_NAME, null, row);

            database.close();

        }
    }

    public void addListTrack(List<Track> trackList) {
        for (Track track: trackList){

            if(!isTrackInDb(track.getId())) {
                addTrack(track);
            }

        }
    }

    public Boolean isTrackInDb(Integer id) {

        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_ID + " = " + "'" + id +"'";

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        Boolean cursorResult = cursor.moveToNext();

        sqLiteDatabase.close();
        cursor.close();

        return cursorResult;
    }

    public List<Track> getTrackListFromDb() {

        List<Track> trackList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM " + TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        while (cursor.moveToNext()) {
            Integer id = cursor.getInt(cursor.getColumnIndex(COLUMN_ID));
            String title = cursor.getString(cursor.getColumnIndex(COLUMN_TITLE));
            Integer albumId = cursor.getInt(cursor.getColumnIndex(COLUMN_ALBUM_ID));
            String thumbnailUrl = cursor.getString(cursor.getColumnIndex(COLUMN_THUMBNAIL));
            String imageUrl = cursor.getString(cursor.getColumnIndex(COLUMN_IMAGE));

            Track track = new Track(id, title, albumId, thumbnailUrl, imageUrl);
            trackList.add(track);
        }

        sqLiteDatabase.close();
        cursor.close();

        return trackList;

    }

}