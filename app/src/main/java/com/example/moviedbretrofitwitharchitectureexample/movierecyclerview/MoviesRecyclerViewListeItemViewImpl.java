package com.example.moviedbretrofitwitharchitectureexample.movierecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.moviedbretrofitwitharchitectureexample.Movie;
import com.example.moviedbretrofitwitharchitectureexample.R;
import com.example.moviedbretrofitwitharchitectureexample.common.BaseObservableViewMvc;
import com.example.moviedbretrofitwitharchitectureexample.common.BaseViewMvc;

import java.util.ArrayList;
import java.util.List;

public class MoviesRecyclerViewListeItemViewImpl extends BaseObservableViewMvc<MoviesRecyclerViewItemMvc.Listener> implements MoviesRecyclerViewItemMvc{

    private Movie mMovie;
    private TextView movie_title,movie_vote_average;
    private ImageView movie_image;;

    public MoviesRecyclerViewListeItemViewImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {

        setView(inflater.inflate(R.layout.layout_movie_text,parent,false));

        movie_title = findViewById(R.id.movie_title);
        movie_vote_average = findViewById(R.id.movie_vote_average);

        movie_image = findViewById(R.id.movie_image);
        getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : getListeners()){
                    listener.onMovieClicked(mMovie);
                }
            }
        });
    }


    @Override
    public void bindData(Movie movie) {
        mMovie = movie;
        movie_title.setText(movie.getMovie_title());

    }
}
