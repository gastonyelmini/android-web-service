package com.example.gastonyelmini.entregableservicioswebyelmini.Model.DAO;

import android.os.AsyncTask;

import com.example.gastonyelmini.entregableservicioswebyelmini.Model.POJO.Track;
import com.example.gastonyelmini.entregableservicioswebyelmini.Model.POJO.TrackContainer;
import com.example.gastonyelmini.entregableservicioswebyelmini.util.DAOException;
import com.example.gastonyelmini.entregableservicioswebyelmini.util.HTTPConnectionManager;
import com.example.gastonyelmini.entregableservicioswebyelmini.util.ResultListener;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 19/06/17.
 */

public class AsyncTaskTracks extends AsyncTask<String, Void, List<Track>> {

    private ResultListener<List<Track>> controllerListener;



    public AsyncTaskTracks(ResultListener<List<Track>> controllerListener) {
     this.controllerListener = controllerListener;
    }

    @Override
    protected List<Track> doInBackground(String... params) {

        String url = params[0];
        List<Track> tracksList = new ArrayList<>();

        HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;

        try {

            inputStream = httpConnectionManager.getRequestStream(url);
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            Gson gson = new Gson();
            TrackContainer trackContainer = gson.fromJson(bufferedReader, TrackContainer.class);
            tracksList = trackContainer.getCards();

        } catch (DAOException e) {

            e.printStackTrace();

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e1) {

                e1.printStackTrace();
                try {
                    inputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

            }
            //Cerrar la conexion
            httpConnectionManager.closeConnection();

            return tracksList;

        }

    }


    @Override
    protected void onPostExecute(List<Track> tracks) {
        super.onPostExecute(tracks);
        controllerListener.finish(tracks);
    }
}
