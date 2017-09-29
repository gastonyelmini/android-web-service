package com.example.gastonyelmini.entregableservicioswebyelmini.Controller;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

import com.example.gastonyelmini.entregableservicioswebyelmini.Model.DAO.DAOTrackDatabase;
import com.example.gastonyelmini.entregableservicioswebyelmini.Model.DAO.DAOTrackInternet;
import com.example.gastonyelmini.entregableservicioswebyelmini.Model.POJO.Track;
import com.example.gastonyelmini.entregableservicioswebyelmini.util.HTTPConnectionManager;
import com.example.gastonyelmini.entregableservicioswebyelmini.util.ResultListener;

import java.util.List;

/**
 * Created by gaston on 19/06/17.
 */

public class ControllerTrack {

    public void getCardList(final  Context context, final ResultListener<List<Track>> viewListener) {

        if(HTTPConnectionManager.isNetworkingOnline(context)) {

            //Lo pedimos a internet
            DAOTrackInternet daoTrackInternet = new DAOTrackInternet();
            daoTrackInternet.getTrackFromInternet(new ResultListener<List<Track>>() {
                @Override
                public void finish(List<Track> resultado) {
                    //lega la respuesta de interntet y guardamos una copia en la DB
                    DAOTrackDatabase daoTrackDatabase = new DAOTrackDatabase(context);
                    daoTrackDatabase.addListTrack(resultado);

                    viewListener.finish(resultado);

                    //Toast para ver de dond viene
                    Toast.makeText(context, "Obteniendo de internet", Toast.LENGTH_SHORT).show();
                }
            });

        } else {

            //Si no tiene internet lo pedimos la DB
            DAOTrackDatabase daoTrackDatabase = new DAOTrackDatabase(context);
            List<Track> trackListFromDb = daoTrackDatabase.getTrackListFromDb();
            //le pasamos la lista
            viewListener.finish(trackListFromDb);

            //Toast para ver de dond viene
            Toast.makeText(context, "Obteniendo de Base de datos", Toast.LENGTH_SHORT).show();

        }

    }

}
