package com.example.moviedbretrofitwitharchitectureexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRecyclerViewActivity extends AppCompatActivity {

    private MovieApi mMovieApi;

    private RecyclerView mRecyclerView;
    private MovieRecyclerViewAdapter mMovieRecyclerViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view);

        mMovieApi = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        .create(MovieApi.class);




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
                List<Movie> results = response.body().getMovie_result();
                bindList(results);
                Log.e("resultss", results.toString());
            }

            @Override
            public void onFailure(Call<MovieListResponse> call, Throwable t) {
                Toast.makeText(MovieRecyclerViewActivity.this, "Network call failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void bindList(List<Movie> movies) {


//        for (Movie movie : movieList){z
//            movieList.add(new Movie(movie.getId(),movie.getVote_avg(),movie.getMovie_title(),movie.getPoster_path()
//                ,movie.getBackdrop_path(),movie.getOverview()));
//        }

        mMovieRecyclerViewAdapter = new MovieRecyclerViewAdapter(movies,this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mMovieRecyclerViewAdapter);

    }
}
