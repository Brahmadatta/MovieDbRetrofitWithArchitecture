package com.example.moviedbretrofitwitharchitectureexample.screens.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.example.moviedbretrofitwitharchitectureexample.movierecyclerview.MovieRecyclerViewMvc;
import com.example.moviedbretrofitwitharchitectureexample.movierecyclerview.MovieRecyclerViewMvcImpl;
import com.example.moviedbretrofitwitharchitectureexample.movierecyclerview.MoviesRecyclerViewListeItemViewImpl;

public class ViewMvcFactory {

    private LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public MovieRecyclerViewMvc getMoviesRecylerViewItemMvc(@Nullable ViewGroup parent){
        return new MovieRecyclerViewMvcImpl(mLayoutInflater,parent);

    }
}
