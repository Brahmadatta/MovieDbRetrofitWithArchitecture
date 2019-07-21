package com.example.moviedbretrofitwitharchitectureexample.movierecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedbretrofitwitharchitectureexample.Movie;
import com.example.moviedbretrofitwitharchitectureexample.R;
import com.example.moviedbretrofitwitharchitectureexample.common.BaseObservableViewMvc;
import com.example.moviedbretrofitwitharchitectureexample.common.BaseViewMvc;

import java.util.ArrayList;
import java.util.List;

public class MovieRecyclerViewMvcImpl extends BaseObservableViewMvc<MovieRecyclerViewMvc.Listener>
        implements MovieRecyclerViewAdapter.onMovieClickListener, MovieRecyclerViewMvc {

    private RecyclerView mRecyclerView;
    private MovieRecyclerViewAdapter mMovieRecyclerViewAdapter;

    public MovieRecyclerViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {

        setView(inflater.inflate(R.layout.activity_main,parent,false));

        mRecyclerView = findViewById(R.id.recycler_view);

    }

    @Override
    public void onMoviesClicked(Movie movie) {
        for (Listener listener : getListeners()){
            listener.onMoviesClicked(movie);
        }
    }

    @Override
    public void bindData(List<Movie> movieList) {
        mMovieRecyclerViewAdapter = new MovieRecyclerViewAdapter(movieList,this,getContext());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecyclerView.setAdapter(mMovieRecyclerViewAdapter);
    }
}
