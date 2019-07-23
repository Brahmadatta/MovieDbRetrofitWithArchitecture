package com.example.moviedbretrofitwitharchitectureexample.common.common.dependencyInjection;

import android.app.Activity;
import android.view.LayoutInflater;

import com.example.moviedbretrofitwitharchitectureexample.MovieApi;
import com.example.moviedbretrofitwitharchitectureexample.screens.common.ViewMvcFactory;

public class ControllerCompositionRoot {

    private final CompositionRoot mCompositionRoot;

    private Activity mActivity;

    public ControllerCompositionRoot(CompositionRoot compositionRoot,Activity activity) {
        mCompositionRoot = compositionRoot;
        mActivity = activity;
    }

    public MovieApi getStackOverflowApi() {
        return mCompositionRoot.getStackOverflowApi();
    }

    private LayoutInflater getLayoutInflater(){
        return LayoutInflater.from(mActivity);
    }

    public ViewMvcFactory getViewMvcFactory(){
        return new ViewMvcFactory(getLayoutInflater());
    }
}
