package com.haowei.wyc.c229sdk;

import android.app.Application;

import com.faw.hongqi.C229API;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        C229API.init(this);
    }
}
