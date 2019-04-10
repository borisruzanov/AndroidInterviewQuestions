package com.kz.dev.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.kz.dev.myapplication.R;

public class MediaPlayerService extends Service {

    private MediaPlayer mediaPlayer;

    public MediaPlayerService(){
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //Get some random file from resources
        mediaPlayer = MediaPlayer.create(this, R.drawable.ic_launcher_background);
        mediaPlayer.setLooping(false);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}
