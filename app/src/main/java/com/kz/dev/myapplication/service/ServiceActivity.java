package com.kz.dev.myapplication.service;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startPlayerService();
        stopPlayerService();
    }

    /**
     * Stop service
     */
    private void stopPlayerService() {
        stopService(new Intent(ServiceActivity.this, MediaPlayerService.class));
    }

    /**
     * Start of the service even if activity destroyed and service not stop it will continue work
     */
    private void startPlayerService() {
        startService(new Intent(ServiceActivity.this, MediaPlayerService.class));
    }


}
