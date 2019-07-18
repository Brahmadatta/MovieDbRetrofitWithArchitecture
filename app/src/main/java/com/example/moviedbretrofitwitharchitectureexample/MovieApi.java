package com.example.moviedbretrofitwitharchitectureexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieApi {


    @GET("discover/movie?api_key="+ Constants.MOVIE_DB_API_KEY +"&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=10")
    Call<MovieListResponse> getMovieListResponse();
}
