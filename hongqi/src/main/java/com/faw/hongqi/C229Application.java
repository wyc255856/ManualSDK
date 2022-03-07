package com.faw.hongqi;

import android.app.Application;


import org.xutils.x;

public class C229Application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        C229API.init(this);
    }
}
