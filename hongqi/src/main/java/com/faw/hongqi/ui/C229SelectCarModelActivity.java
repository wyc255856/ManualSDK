package com.faw.hongqi.ui;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.faw.hongqi.R;
import com.faw.hongqi.util.SharedpreferencesUtil;

public class C229SelectCarModelActivity extends BaseActivity{

    private TextView tv_car_model_1;
    private TextView tv_car_model_2;
    private TextView tv_car_model_3;
    private TextView tv_car_model_4;
    private TextView tv_car_model_5;
    @Override
    protected void initData() {
        setContentView(R.layout.activity_c229_select_car_model);
        tv_car_model_1 = findViewById(R.id.tv_car_model_1);
        tv_car_model_2 = findViewById(R.id.tv_car_model_2);
        tv_car_model_3 = findViewById(R.id.tv_car_model_3);
        tv_car_model_4 = findViewById(R.id.tv_car_model_4);
        tv_car_model_5 = findViewById(R.id.tv_car_model_5);
    }

    @Override
    protected void initViews() {
        tv_car_model_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_1");
                startActivity(new Intent(C229SelectCarModelActivity.this,C229MainActivity.class));
                finish();
            }
        });
        tv_car_model_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_2");
                startActivity(new Intent(C229SelectCarModelActivity.this,C229MainActivity.class));
                finish();
            }
        });
        tv_car_model_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_3");
                startActivity(new Intent(C229SelectCarModelActivity.this,C229MainActivity.class));
                finish();
            }
        });
        tv_car_model_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_4");
                startActivity(new Intent(C229SelectCarModelActivity.this,C229MainActivity.class));
                finish();
            }
        });
        tv_car_model_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedpreferencesUtil.setCarModel(C229SelectCarModelActivity.this,"C229_5");
                startActivity(new Intent(C229SelectCarModelActivity.this,C229MainActivity.class));
                finish();
            }
        });
    }

    @Override
    protected void initWidgetActions() {

    }

    @Override
    boolean isHasTitle() {
        return false;
    }
}
