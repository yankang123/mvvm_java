package com.example.retrofit;

import android.app.Application;
import android.content.Context;



public class weatherApplication extends Application {
    private static Context context;
    public static String token="ZguV9Q69L30VHTlp";
    @Override
    public void onCreate(){
        super.onCreate();
        context=getApplicationContext();

    }
    public static Context getContext(){
        return context;
    }
}
