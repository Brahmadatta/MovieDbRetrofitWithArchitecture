package com.example.moviedbretrofitwitharchitectureexample.movierecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviedbretrofitwitharchitectureexample.Constants;
import com.example.moviedbretrofitwitharchitectureexample.Movie;
import com.example.moviedbretrofitwitharchitectureexample.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieRecylerViewHolder> implements MoviesRecyclerViewItemMvc.Listener {


    private List<Movie> mMovieList;


    private onMovieClickListener mOnMovieClickListener;

    private Context mContext;

    public MovieRecyclerViewAdapter(List<Movie> movieList,onMovieClickListener listener,Context context) {
        mMovieList = movieList;
        mOnMovieClickListener = listener;
        mContext = context;
    }



    public interface onMovieClickListener{
        void onMoviesClicked(Movie movie);
    }

    @NonNull
    @Override
    public MovieRecylerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MoviesRecyclerViewListeItemViewImpl moviesRecyclerViewListeItemView = new MoviesRecyclerViewListeItemViewImpl(
                LayoutInflater.from(mContext),parent);
        moviesRecyclerViewListeItemView.registerListener(this);
        return new MovieRecylerViewHolder(moviesRecyclerViewListeItemView.getView());
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRecylerViewHolder holder, int position) {

        final Movie movie = mMovieList.get(position);

        holder.movie_title.setText(mMovieList.get(position).getMovie_title());
        holder.movie_vote_average.setText(String.valueOf(mMovieList.get(position).getVote_avg()));
        Picasso.get().load(Constants.IMAGE_BASE_URL + mMovieList.get(position).getPoster_path()).into(holder.movie_image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnMovieClickListener.onMoviesClicked(movie);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MovieRecylerViewHolder extends RecyclerView.ViewHolder{

        TextView movie_title,movie_vote_average;
        ImageView movie_image;

        public MovieRecylerViewHolder(@NonNull View itemView) {
            super(itemView);



            movie_title = itemView.findViewById(R.id.movie_title);
            movie_vote_average = itemView.findViewById(R.id.movie_vote_average);
            movie_image = itemView.findViewById(R.id.movie_image);


            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnMovieClickListener.onMoviesClicked(movie_title.getText().toString());
                }
            });*/

        }

    }

    @Override
    public void onMovieClicked(Movie movie) {
        mOnMovieClickListener.onMoviesClicked(movie);
    }
}
