package com.example.gastonyelmini.entregableservicioswebyelmini.Model.POJO;

import com.google.gson.annotations.SerializedName;

/**
 * Created by gastonyelmini on 18/6/17.
 */

public class Track {

    @SerializedName("id")
    private Integer id;
    @SerializedName("title")
    private String trackName;
    @SerializedName("albumId")
    private Integer albumId;
    @SerializedName("thumbnailUrl")
    private String trackThumbnailUrl;
    @SerializedName("url")
    private String trackImageUrl;

    public Track(Integer id, String trackName, Integer albumId, String trackThumbnailUrl, String trackImageUrl) {
        this.id = id;
        this.trackName = trackName;
        this.albumId = albumId;
        this.trackThumbnailUrl = trackThumbnailUrl;
        this.trackImageUrl = trackImageUrl;
    }

    public Track() {}

    public Integer getId() {
        return id;
    }

    public String getTrackName() {
        return trackName;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public String getTrackThumbnailUrl() {
        return trackThumbnailUrl;
    }

    public String getTrackImageUrl() {
        return trackImageUrl;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public void setTrackThumbnailUrl(String trackThumbnailUrl) {
        this.trackThumbnailUrl = trackThumbnailUrl;
    }

    public void setTrackImageUrl(String trackImageUrl) {
        this.trackImageUrl = trackImageUrl;
    }
}
