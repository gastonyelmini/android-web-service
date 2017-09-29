package com.example.gastonyelmini.entregableservicioswebyelmini.View.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gastonyelmini.entregableservicioswebyelmini.Model.POJO.Track;
import com.example.gastonyelmini.entregableservicioswebyelmini.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaston on 19/06/17.
 */

public class AdapterRecyclerViewTracks extends RecyclerView.Adapter implements View.OnClickListener {

    private Context context;
    private List<Track> trackList = new ArrayList<>();
    private View.OnClickListener onClickListener;

    public AdapterRecyclerViewTracks(Context context, List<Track> trackList) {
        this.context = context;
        this.trackList = trackList;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public Track getItem(Integer position) {
        return trackList.get(position);
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Create inflater
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate
        View view = inflater.inflate(R.layout.cardview_track, parent, false);

        // Set in the View the onclick listener
        view.setOnClickListener(this);

        // Instance ViewHolder
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Track song = trackList.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.loadData(song);

    }

    @Override
    public int getItemCount() {
        return trackList.size();
    }

    @Override
    public void onClick(View v) {
        if(onClickListener != null) {
            onClickListener.onClick(v);
        }
    }

    // Create class ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageViewSongImage;
        private TextView textViewSongTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            imageViewSongImage = (ImageView) itemView.findViewById(R.id.cardviewImage);
            textViewSongTitle = (TextView) itemView.findViewById(R.id.cardviewTitle);
        }

        // Falta cargar los datos del detalle de las canciones
        public void loadData(Track track){
            Picasso.with(context).load(track.getTrackThumbnailUrl()).placeholder(R.drawable.albumdefault).into(imageViewSongImage);
            textViewSongTitle.setText(track.getTrackName());
        }
    }


}
