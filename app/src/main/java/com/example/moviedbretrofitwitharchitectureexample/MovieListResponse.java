package com.example.moviedbretrofitwitharchitectureexample;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieListResponse {

    @SerializedName("page")
    private int page;

    @SerializedName("total_results")
    private int total_results;

    @SerializedName("total_pages")
    private int total_pages;

    @SerializedName("results")
    private List<Movie> movie_result;

    public MovieListResponse(int page, int total_results, int total_pages, List<Movie> movie_result) {
        this.page = page;
        this.total_results = total_results;
        this.total_pages = total_pages;
        this.movie_result = movie_result;
    }

    public int getPage() {
        return page;
    }

    public int getTotal_results() {
        return total_results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<Movie> getMovie_result() {
        return movie_result;
    }
}
