package com.faw.hongqi.ui;
import android.content.Intent;

import com.faw.hongqi.R;
public class WelcomeActivity extends BaseActivity{
    @Override
    protected void initData() {
        setContentView(R.layout.activity_welcome_vertical);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent();
                intent.setClass(WelcomeActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }).start();
    }
    @Override
    protected void initViews() {
    }
    @Override
    protected void initWidgetActions() {
    }
    @Override
    boolean isHasTitle() {
        return false;
    }
}