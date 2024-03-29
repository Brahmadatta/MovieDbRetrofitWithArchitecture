package com.example.moviedbretrofitwitharchitectureexample;

import android.app.Application;

import com.example.moviedbretrofitwitharchitectureexample.common.common.dependencyInjection.CompositionRoot;

public class CustomApplication extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate() {
        super.onCreate();
        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot(){
        return mCompositionRoot;
    }
}
