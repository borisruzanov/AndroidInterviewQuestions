package com.kz.dev.myapplication.loader;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.kz.dev.myapplication.R;

public class LoaderActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Loader loader = new Loader(this);
        loader.startLoading();
    }

    @NonNull
    @Override
    public Loader onCreateLoader(int i, @Nullable Bundle bundle) {
        return null;
    }

    @Override
    public void onLoadFinished(@NonNull Loader loader, Object o) {

    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {

    }
}
