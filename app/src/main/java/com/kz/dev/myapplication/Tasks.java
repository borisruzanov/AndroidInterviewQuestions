package com.kz.dev.myapplication;

import android.util.Log;

public class Tasks {

    public void reverseString(){
        String input = "something";
        int length = input.length();
        String result = "";
        for (int i=0; i < length; i++){
            result = input.charAt(i) + result;
        }
        Log.d("test", "result -> " + result);
    }
}
