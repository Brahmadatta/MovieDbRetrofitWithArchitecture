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

import java.util.ArrayList;
import java.util.List;

public class MovieRecyclerViewMvcImpl implements MovieRecyclerViewAdapter.onMovieClickListener, MovieRecyclerViewMvc {

    private RecyclerView mRecyclerView;
    private final View mView;
    private MovieRecyclerViewAdapter mMovieRecyclerViewAdapter;

    private List<Listener> mListeners = new ArrayList<>(1);

    public MovieRecyclerViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {

        mView = inflater.inflate(R.layout.activity_main,parent,false);

        mRecyclerView = findViewById(R.id.recycler_view);

    }

    @Override
    public void registerListener(Listener listener){
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener){
        mListeners.remove(listener);
    }

    private Context getContext() {
        return getView().getContext();
    }

    private <T extends View>T findViewById(int id) {
        return getView().findViewById(id);
    }

    @Override
    public View getView() {
        return mView;
    }

    @Override
    public void onMoviesClicked(Movie movie) {
        for (Listener listener : mListeners){
            listener.onMoviesClicked(movie);
        }
    }

    @Override
    public void bindData(List<Movie> movieList) {
        mMovieRecyclerViewAdapter = new MovieRecyclerViewAdapter(movieList,this,mView.getContext());
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        mRecyclerView.setAdapter(mMovieRecyclerViewAdapter);
    }
}
