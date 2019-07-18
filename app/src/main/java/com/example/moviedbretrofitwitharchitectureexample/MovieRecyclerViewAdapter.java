package com.example.moviedbretrofitwitharchitectureexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
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
        holder.mTextView.setText(mMovieList.get(position).getMovie_title());
    }

    @Override
    public int getItemCount() {
        return mMovieList.size();
    }

    public class MovieRecylerViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView;

        public MovieRecylerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.movie_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, ""+mTextView.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
