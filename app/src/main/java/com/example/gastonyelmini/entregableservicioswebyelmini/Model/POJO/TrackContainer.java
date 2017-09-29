package com.example.gastonyelmini.entregableservicioswebyelmini.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by gaston on 19/06/17.
 */

public class TrackContainer {

    @SerializedName("tracks")
    private List<Track> trackList;

    public List<Track> getCards() {
        return trackList;
    }

}
