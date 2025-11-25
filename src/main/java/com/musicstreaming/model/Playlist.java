package com.musicstreaming.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private int id;
    private String ownerEmail;
    private String title;
    private List<MusicTrack> tracks = new ArrayList<>();

    public Playlist(int id, String ownerEmail, String title) {
        this.id = id;
        this.ownerEmail = ownerEmail;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MusicTrack> getTracks() {
        return tracks;
    }

    public void addTrack(MusicTrack track) {
        this.tracks.add(track);
    }
}
