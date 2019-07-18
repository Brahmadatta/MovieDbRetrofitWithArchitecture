package com.example.moviedbretrofitwitharchitectureexample.movierecyclerview;

import android.view.View;

import com.example.moviedbretrofitwitharchitectureexample.Movie;

import java.util.List;

interface MovieRecyclerViewMvc {
    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    View getView();

    void bindData(List<Movie> movieList);

    public interface Listener{
        void onMoviesClicked(Movie movie);
    }
}
