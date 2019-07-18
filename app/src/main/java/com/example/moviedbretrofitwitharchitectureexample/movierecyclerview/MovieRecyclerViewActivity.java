package com.example.moviedbretrofitwitharchitectureexample.movierecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.example.moviedbretrofitwitharchitectureexample.Constants;
import com.example.moviedbretrofitwitharchitectureexample.Movie;
import com.example.moviedbretrofitwitharchitectureexample.MovieApi;
import com.example.moviedbretrofitwitharchitectureexample.MovieListResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRecyclerViewActivity extends AppCompatActivity implements MovieRecyclerViewMvcImpl.Listener {

    private MovieApi mMovieApi;


    private MovieRecyclerViewMvc mMovieRecyclerViewMvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        mMovieRecyclerViewMvc = new MovieRecyclerViewMvcImpl(LayoutInflater.from(this),null);



        mMovieRecyclerViewMvc.registerListener(this);

        mMovieApi = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        .create(MovieApi.class);


        setContentView(mMovieRecyclerViewMvc.getView());

       // https://api.themoviedb.org/3/discover/movie?api_key=b7ae4931443ae44ae879c87b191bb8e5&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=10
    }


    @Override
    protected void onStart() {
        super.onStart();
        fetchData();
    }

    private void fetchData() {

        mMovieApi.getMovieListResponse().enqueue(new Callback<MovieListResponse>() {
            @Override
            public void onResponse(Call<MovieListResponse> call, Response<MovieListResponse> response) {
                if (response.isSuccessful()){
                    List<Movie> results = response.body().getMovie_result();
                    bindList(results);
                    Log.e("resultss", results.toString());
                }

            }

            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t) {
                    networkCallFailed();
            }
        });
    }

    private void networkCallFailed() {
        Toast.makeText(MovieRecyclerViewActivity.this, "Network call failed", Toast.LENGTH_SHORT).show();
    }

    private void bindList(List<Movie> movies) {

        List<Movie> movieList = new ArrayList<>(movies.size());
        for (Movie movie : movies){
            movieList.add(new Movie(movie.getId(),movie.getVote_avg(),movie.getMovie_title(),movie.getPoster_path(),movie.getBackdrop_path(),movie.getOverview()));
        }
        mMovieRecyclerViewMvc.bindData(movieList);

    }


    @Override
    public void onMoviesClicked(Movie movie) {
        Toast.makeText(this, movie.getMovie_title() + "\n" + movie.getOverview(), Toast.LENGTH_SHORT).show();
    }
}
