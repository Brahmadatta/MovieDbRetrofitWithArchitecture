package com.example.moviedbretrofitwitharchitectureexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieRecyclerViewAdapter extends RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieRecylerViewHolder>{


    private List<Movie> mMovieList;

    private Context mContext;

    public MovieRecyclerViewAdapter(List<Movie> movieList, Context context) {
        mMovieList = movieList;
        mContext = context;
    }

    @NonNull
    @Override
    public MovieRecylerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_movie_text,parent,false);
        return new MovieRecylerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieRecylerViewHolder holder, int position) {
        holder.movie_title.setText(mMovieList.get(position).getMovie_title());
        holder.movie_vote_average.setText(String.valueOf(mMovieList.get(position).getVote_avg()));
        Picasso.get().load(Constants.IMAGE_BASE_URL + mMovieList.get(position).getPoster_path()).into(holder.movie_image);

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, ""+movie_title.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
