package com.example.moviedbretrofitwitharchitectureexample.movierecyclerview;

import android.view.View;

import com.example.moviedbretrofitwitharchitectureexample.Movie;
import com.example.moviedbretrofitwitharchitectureexample.common.ObservableViewMvc;
import com.example.moviedbretrofitwitharchitectureexample.common.ViewMvc;

import java.util.List;

public interface MovieRecyclerViewMvc extends ObservableViewMvc<MovieRecyclerViewMvc.Listener> {

    public interface Listener{
        void onMoviesClicked(Movie movie);
    }

    void bindData(List<Movie> movieList);

}
