package com.example.moviedbretrofitwitharchitectureexample;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("id")
    private int id;

    @SerializedName("vote_average")
    private float vote_avg;

    @SerializedName("title")
    private String movie_title;

    @SerializedName("poster_path")
    private String poster_path;

    @SerializedName("backdrop_path")
    private String backdrop_path;


    @SerializedName("overview")
    private String overview;


    public Movie(int id, float vote_avg, String movie_title, String poster_path, String backdrop_path, String overview) {
        this.id = id;
        this.vote_avg = vote_avg;
        this.movie_title = movie_title;
        this.poster_path = poster_path;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public float getVote_avg() {
        return vote_avg;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public String getOverview() {
        return overview;
    }
}
