package com.faw.hongqi;

import android.content.Context;
import android.content.Intent;

import com.faw.hongqi.ui.C229WelcomeActivity;
import com.faw.hongqi.ui.WelcomeActivity;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.SharedpreferencesUtil;
import com.liulishuo.filedownloader.FileDownloader;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.config.hongqiGeneratedDatabaseHolder;

public class C229API {
    public static void init(Context context) {
        FlowManager.init(context);
        FileDownloader.setup(context);

        FlowManager.initModule(hongqiGeneratedDatabaseHolder.class);
        Constant.initData();
    }

    public static void openManual(Context context) {
        Intent intent = new Intent(context, C229WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        context.startActivity(intent);

    }
    public static void openManualVertical(String carType,Context context) {
        Constant.CAR_TYPE = carType;
        Intent intent = new Intent(context, WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK );
        context.startActivity(intent);

    }
    public static void openManual(Context context, String carType, String trim) {
        Constant.CAR_TYPE = carType;
        Constant.INTPROPERTY_TYPE = trim;
        context.startActivity(new Intent(context, C229WelcomeActivity.class));
    }

    public static void openManual(Context context, String model) {
        SharedpreferencesUtil.setCarModel(context, model);
        openManual(context);

    }
}
