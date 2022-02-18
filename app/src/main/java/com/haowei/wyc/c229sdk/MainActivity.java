package com.haowei.wyc.c229sdk;


import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.faw.hongqi.C229API;
import com.faw.hongqi.util.Constant;

public class MainActivity extends Activity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_c229).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constant.CAR_TYPE = "C229";
                C229API.openManual(MainActivity.this);

            }
        });
        findViewById(R.id.start_c2291).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constant.CAR_TYPE = "E115";
                C229API.openManual(MainActivity.this);
            }
        });
        findViewById(R.id.start_c2292).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Constant.CAR_TYPE = "C235";
                C229API.openManual(MainActivity.this);
            }
        });

    }
}
