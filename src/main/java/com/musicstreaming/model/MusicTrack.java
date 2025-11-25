package com.musicstreaming.model;

public class MusicTrack {
    private int id;
    private String title;
    private String artistName;
    private String album;
    private String genre;
    private boolean approved;
    private int streams;
    private int likes;

    public MusicTrack(int id, String title, String artistName, String album, String genre,
                      boolean approved, int streams, int likes) {
        this.id = id;
        this.title = title;
        this.artistName = artistName;
        this.album = album;
        this.genre = genre;
        this.approved = approved;
        this.streams = streams;
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public int getStreams() {
        return streams;
    }

    public void setStreams(int streams) {
        this.streams = streams;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
