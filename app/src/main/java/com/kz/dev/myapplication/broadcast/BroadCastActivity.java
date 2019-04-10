package com.kz.dev.myapplication.broadcast;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class BroadCastActivity extends AppCompatActivity {

    //This filter suppose to be in intent filter in manifest
    public static final String ACTION_BROADCAST = "com.kz.dev.myapplication.broadcast.action.ACTION_BROADCAST";
    public static final String MESSAGE_BROADCAST = "com.kz.dev.myapplication.broadcast.message.MESSAGE_BROADCAST";
    private String mSomeExtraValue = "value";
    private String mSomeMessage = "Please call this action while receive this broadcast";

    private TimeBroadCastReceiver mTimeBroadCastReceiver = new TimeBroadCastReceiver();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sendingIntentMessageReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcastReceiver();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterBroadcastReceiver();
    }

    /**
     * Register receiver programmatically
     * for intent "android.intent.action.TIME_TICK".
     * Executes every minute
     * If it is long process better put registration out of UI thread
     */
    public void registerBroadcastReceiver() {
        this.registerReceiver(mTimeBroadCastReceiver, new IntentFilter(
                "android.intent.action.TIME_TICK"));
        Toast.makeText(getApplicationContext(), "Receiver is ON",
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Deregister receiver
     */
    public void unregisterBroadcastReceiver() {
        this.unregisterReceiver(mTimeBroadCastReceiver);
        Toast.makeText(getApplicationContext(), "Receiver is OFF", Toast.LENGTH_SHORT)
                .show();
    }

    private void sendingIntentMessageReceiver() {
        Intent intent = new Intent();
        intent.setAction(ACTION_BROADCAST);
        intent.putExtra(MESSAGE_BROADCAST, mSomeMessage);
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        sendBroadcast(intent);
    }
}
