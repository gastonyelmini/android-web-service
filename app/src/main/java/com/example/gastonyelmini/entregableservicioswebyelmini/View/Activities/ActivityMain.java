package com.example.gastonyelmini.entregableservicioswebyelmini.View.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.gastonyelmini.entregableservicioswebyelmini.Controller.ControllerTrack;
import com.example.gastonyelmini.entregableservicioswebyelmini.Model.POJO.Track;
import com.example.gastonyelmini.entregableservicioswebyelmini.R;
import com.example.gastonyelmini.entregableservicioswebyelmini.View.Adapters.AdapterRecyclerViewTracks;
import com.example.gastonyelmini.entregableservicioswebyelmini.util.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity {

    private List<Track> tracksList;
    private AdapterRecyclerViewTracks adapterRecyclerViewTracks;
    private RecyclerView recyclerViewTracks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //arranco un track list y lo inicializo para no tener null pointer
        tracksList = new ArrayList<>();

        //Traigo el recycler
        recyclerViewTracks = (RecyclerView) findViewById(R.id.recyclerViewTracks);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewTracks.setLayoutManager(layoutManager);

        adapterRecyclerViewTracks = new AdapterRecyclerViewTracks(ActivityMain.this, tracksList);
        recyclerViewTracks.setAdapter(adapterRecyclerViewTracks);

        ControllerTrack controllerTrack = new ControllerTrack();
        controllerTrack.getCardList(this, new ResultListener<List<Track>>() {
            @Override
            public void finish(List<Track> resultado) {
                adapterRecyclerViewTracks.setTrackList(resultado);
            }
        });

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer position = recyclerViewTracks.getChildAdapterPosition(v);
                Track track = adapterRecyclerViewTracks.getItem(position);

                Intent intent = new Intent(ActivityMain.this, ActivitySongDetail.class);

                Bundle bundle = new Bundle();
                bundle.putInt(ActivitySongDetail.TRACK_ID, track.getId());
                bundle.putString(ActivitySongDetail.TRACK_TITLE, track.getTrackName());
                bundle.putInt(ActivitySongDetail.TRACK_ALBUM_ID, track.getAlbumId());
                bundle.putString(ActivitySongDetail.TRACK_THUMBNAIL, track.getTrackThumbnailUrl());
                bundle.putString(ActivitySongDetail.TRACK_IMAGE, track.getTrackImageUrl());

                intent.putExtras(bundle);
                startActivity(intent);
            }
        };

        adapterRecyclerViewTracks.setOnClickListener(listener);

    }
}
