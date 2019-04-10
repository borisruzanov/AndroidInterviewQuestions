package com.kz.dev.myapplication.handler;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class HandlerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Start process in separate thread
        //It could be any process NOT ui thread
        new Thread(myThread).start();
    }

    private Runnable myThread = new Runnable() {
        @Override
        public void run() {
                try {
                    //Sending the message from thread we started with message
                    myHandler.sendMessage(myHandler.obtainMessage());
                } catch (Throwable t) {
                    //Handle throwable scenario
            }
        }

        @SuppressLint("HandlerLeak")
        Handler myHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                //Receiving the message from NOT ui threat and handle it
                //For example updating the UI
            }
        };
    };
}
