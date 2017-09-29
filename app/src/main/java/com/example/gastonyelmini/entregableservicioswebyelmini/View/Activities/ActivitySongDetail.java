package com.example.gastonyelmini.entregableservicioswebyelmini.View.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gastonyelmini.entregableservicioswebyelmini.R;
import com.squareup.picasso.Picasso;

public class ActivitySongDetail extends AppCompatActivity {

    public static final String TRACK_ID = "songId";
    public static final String TRACK_TITLE = "title";
    public static final String TRACK_ALBUM_ID = "albumId";
    public static final String TRACK_THUMBNAIL = "thumbnailUrl";
    public static final String TRACK_IMAGE = "imageUrl";

    private ImageView songDetailImage;
    private TextView songDetailSongTitle;
    private TextView songDetailSongID;
    private TextView songDetailAlbumID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        songDetailImage = (ImageView) findViewById(R.id.songDetailImage);
        songDetailSongTitle = (TextView) findViewById(R.id.songDetailTitle);
        songDetailSongID = (TextView) findViewById(R.id.songDetailSongId);
        songDetailAlbumID = (TextView) findViewById(R.id.songDetailAlbumId);

        //Recibe el intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Picasso.with(this).load(bundle.getString(TRACK_IMAGE)).placeholder(R.drawable.albumdefault).into(songDetailImage);

        songDetailSongTitle.setText(bundle.getString(TRACK_TITLE));

        Integer trackId = bundle.getInt(TRACK_ID);
        songDetailSongID.setText("ID: " + trackId.toString());

        Integer trackAlbumId = bundle.getInt(TRACK_ALBUM_ID);
        songDetailAlbumID.setText("Album ID: " + trackAlbumId.toString());

    }
}
