package com.kz.dev.myapplication.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MessageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Intent received: " +
                        intent.getStringExtra(BroadCastActivity.MESSAGE_BROADCAST),
                Toast.LENGTH_LONG).show();
    }
}
