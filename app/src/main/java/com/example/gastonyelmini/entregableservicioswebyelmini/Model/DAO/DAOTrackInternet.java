package com.example.gastonyelmini.entregableservicioswebyelmini.Model.DAO;

import com.example.gastonyelmini.entregableservicioswebyelmini.Model.POJO.Track;
import com.example.gastonyelmini.entregableservicioswebyelmini.util.ResultListener;

import java.util.List;

/**
 * Created by gaston on 19/06/17.
 */

public class DAOTrackInternet {

    //Tarea asincrona
    public void getTrackFromInternet(ResultListener<List<Track>> controllerTrack) {

        AsyncTaskTracks asyncTaskTracks = new AsyncTaskTracks(controllerTrack);
        asyncTaskTracks.execute("https://api.myjson.com/bins/zwe9v");

    }

}
