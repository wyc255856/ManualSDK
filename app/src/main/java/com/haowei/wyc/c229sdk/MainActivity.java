package com.haowei.wyc.c229sdk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.faw.hongqi.C229API;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.start_c229).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C229API.openManual(MainActivity.this);
            }
        });
    }
}
