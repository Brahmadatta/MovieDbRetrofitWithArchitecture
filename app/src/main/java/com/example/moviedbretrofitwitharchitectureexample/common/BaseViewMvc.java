package com.example.moviedbretrofitwitharchitectureexample.common;

import android.content.Context;
import android.view.View;

public abstract class BaseViewMvc implements ViewMvc {

    private View mView;

    @Override
    public View getView() {
        return mView;
    }

    protected void setView(View view) {
        mView = view;
    }

    protected  <T extends View>T findViewById(int id) {
        return getView().findViewById(id);
    }

    protected Context getContext() {
        return getView().getContext();
    }
}
