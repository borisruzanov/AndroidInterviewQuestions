package com.kz.dev.myapplication.intentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kz.dev.myapplication.R;

public class IntentServiceActivity extends AppCompatActivity {

    private TextView mSomeTextResult;
    private Intent mMyServiceIntent;
    private MyBroadcastReceiver mMyBroadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        //TODO Need to initiate mSomeTextResult to avoid null pointer exception
        launchIntentService();

        //Register broadcast receiver
        mMyBroadcastReceiver = new MyBroadcastReceiver();

        IntentFilter intentFilter = new IntentFilter(MyIntentService.ACTION_MYINTENTSERVICE);
        intentFilter.addCategory(Intent.CATEGORY_DEFAULT);
        registerReceiver(mMyBroadcastReceiver, intentFilter);

    }

    /**
     * Launch our intent service class with some data
     */
    private void launchIntentService() {
        mMyServiceIntent = new Intent(this, MyIntentService.class);
        startService(mMyServiceIntent.putExtra("task", "make something"));
    }

    /**
     * Class for receive data from service intent
     */
    private class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            //When getting the result from Intent Service showing it in text view
            //Recognizing intent with help of EXTRA_KEY_OUT
            //In case of loading the progress also could receive data here
            String result = intent.getStringExtra(MyIntentService.EXTRA_KEY_OUT);
            mSomeTextResult.setText(result);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyBroadcastReceiver);
        stopOurService();
    }

    /**
     * Stop service method could be called whenever we need
     */
    private void stopOurService() {
        if (mMyServiceIntent != null) {
            stopService(mMyServiceIntent);
            mMyServiceIntent = null;
        }
    }
}
