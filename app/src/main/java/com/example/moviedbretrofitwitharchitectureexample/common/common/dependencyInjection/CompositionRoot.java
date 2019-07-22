package com.example.moviedbretrofitwitharchitectureexample.common.common.dependencyInjection;

import com.example.moviedbretrofitwitharchitectureexample.Constants;
import com.example.moviedbretrofitwitharchitectureexample.MovieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompositionRoot {

    private Retrofit mRetrofit;

    public MovieApi getStackOverflowApi() {
        return getRetrofit().create(MovieApi.class);
    }

    private Retrofit getRetrofit(){
        if (mRetrofit == null){
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }
}
