package com.kz.dev.myapplication.intentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;


class MyIntentService extends IntentService {

    public static final String ACTION_MYINTENTSERVICE = "com.kz.dev.myapplication.intentservice.RESPONSE";
    public static final String EXTRA_KEY_OUT = "EXTRA_OUT";
    String extraOut = "Job Done";

    //Showing toast from service
    private Handler mHandler;

    public MyIntentService() {
        super("name");
    }

    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler = new Handler();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Can build logic based on received data from intent
        String label = intent.getStringExtra("task");

        //Sending back the result to activity
        Intent responseIntent = new Intent();
        responseIntent.setAction(ACTION_MYINTENTSERVICE);
        responseIntent.addCategory(Intent.CATEGORY_DEFAULT);
        responseIntent.putExtra(EXTRA_KEY_OUT, extraOut);
        sendBroadcast(responseIntent);

        //Showing toast message
        //Because of we are not in activity we are using application context
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "Message from service",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
