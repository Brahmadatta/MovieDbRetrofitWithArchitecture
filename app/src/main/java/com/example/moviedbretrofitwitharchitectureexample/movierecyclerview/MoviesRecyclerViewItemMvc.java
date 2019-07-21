package com.example.moviedbretrofitwitharchitectureexample.movierecyclerview;

import android.view.View;

import com.example.moviedbretrofitwitharchitectureexample.Movie;
import com.example.moviedbretrofitwitharchitectureexample.common.ObservableViewMvc;

public interface MoviesRecyclerViewItemMvc extends ObservableViewMvc<MoviesRecyclerViewItemMvc.Listener> {

    public interface Listener{
        void onMovieClicked(Movie movie);
    }

    void bindData(Movie movie);
}
