package com.example.moviedbretrofitwitharchitectureexample.movierecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.moviedbretrofitwitharchitectureexample.Movie;
import com.example.moviedbretrofitwitharchitectureexample.R;

import java.util.ArrayList;
import java.util.List;

public class MoviesRecyclerViewListeItemViewImpl implements MoviesRecyclerViewItemMvc{

    private View mView;
    private List<Listener> mListeners = new ArrayList<>(1);

    private Movie mMovie;
    private TextView movie_title,movie_vote_average;
    private ImageView movie_image;;

    public MoviesRecyclerViewListeItemViewImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {

        mView = inflater.inflate(R.layout.layout_movie_text,parent,false);

        movie_title = findViewById(R.id.movie_title);
        movie_vote_average = findViewById(R.id.movie_vote_average);

        movie_image = findViewById(R.id.movie_image);
        getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (Listener listener : mListeners){
                    listener.onMovieClicked(mMovie);
                }
            }
        });
    }

    private <T extends View>T findViewById(int id) {
        return getView().findViewById(id);
    }

    @Override
    public View getView() {
        return mView;
    }

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    @Override
    public void bindData(Movie movie) {
        mMovie = movie;
        movie_title.setText(movie.getMovie_title());

    }
}
