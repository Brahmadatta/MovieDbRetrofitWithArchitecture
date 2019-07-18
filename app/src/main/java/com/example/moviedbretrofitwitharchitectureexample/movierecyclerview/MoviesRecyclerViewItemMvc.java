package com.example.moviedbretrofitwitharchitectureexample.movierecyclerview;

import android.view.View;

import com.example.moviedbretrofitwitharchitectureexample.Movie;

public interface MoviesRecyclerViewItemMvc {

    public interface Listener{
        void onMovieClicked(Movie movie);
    }

    View getView();

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);


    void bindData(Movie movie);
}
