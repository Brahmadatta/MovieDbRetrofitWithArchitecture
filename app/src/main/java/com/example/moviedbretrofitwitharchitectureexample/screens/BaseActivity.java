package com.example.moviedbretrofitwitharchitectureexample.screens;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviedbretrofitwitharchitectureexample.CustomApplication;
import com.example.moviedbretrofitwitharchitectureexample.common.common.dependencyInjection.CompositionRoot;
import com.example.moviedbretrofitwitharchitectureexample.common.common.dependencyInjection.ControllerCompositionRoot;

public class BaseActivity extends AppCompatActivity {

    private ControllerCompositionRoot mControllerCompositionRoot;

    protected ControllerCompositionRoot getCompositionRoot(){
        if (mControllerCompositionRoot == null){
            mControllerCompositionRoot = new ControllerCompositionRoot(
                    ((CustomApplication)getApplication()).getCompositionRoot(),this
            );
        }
        return mControllerCompositionRoot;
    }
}
