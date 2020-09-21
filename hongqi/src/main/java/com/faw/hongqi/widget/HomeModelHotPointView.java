package com.faw.hongqi.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.faw.hongqi.R;
import com.faw.hongqi.model.BaseModel;
import com.faw.hongqi.util.Constant;

import java.util.ArrayList;
import java.util.List;

public class HomeModelHotPointView extends LinearLayout implements View.OnClickListener {

    FrameLayout view_layout;
//    ImageView point_view_1_point1;

    private Activity mContext;

    public HomeModelHotPointView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public HomeModelHotPointView(Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        // TODO Auto-generated method stub
        this.mContext = (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.view_home_hot_point,
                this, true);
//        point_view_1 = findViewById(R.id.point_view_1);
//        point_view_1_point1 = findViewById(R.id.point_view_1_point1);
//        Glide.with(mContext).load(url).asGif().diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(point_view_1_point1);
//        Glide.with(mContext).load(R.drawable.c229_point).into(point_view_1_point1);
//        Glide.with(mContext).load(R.drawable.c229_point)
//                .diskCacheStrategy(DiskCacheStrategy.ALL).into(point_view_1_point1);
        view_layout = findViewById(R.id.view_layout);
        view_layout.setVisibility(INVISIBLE);
    }


    @Override
    public void onClick(View v) {

    }


    public void hideAllView() {
        view_layout.setVisibility(GONE);
    }

    public void showHotPointViewByResId(String resID) {
        //index 0:轮胎，1：远光灯，2，后备箱
        view_layout.setVisibility(VISIBLE);
        if (Constant.IS_PHONE) {
            setPhonePointView(resID);
        } else {
//            setCarPointView(resID);
        }

    }


    private void setPhonePointView(String resID) {
        if (resID == Constant.CAR_NAME + "_car_1") {
            if (Constant.CAR_NAME.equals("e115")){

            }else if (Constant.CAR_NAME.equals("c229")){

            }
            view_list.get(0).setPosition(100, 400, 24, k, false);
            view_list.get(1).setPosition(1300, 150, 25, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(60, 365, 28, k, true);
            view_list.get(4).setPosition(1000, 270, 26, k, true);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(135, 155, 23, k, false);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(200, 200, 27, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_2") {
            view_list.get(0).setPosition(100, 400, 24, k, false);
            view_list.get(1).setPosition(1300, 150, 25, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(20, 365, 28, k, true);
            view_list.get(4).setPosition(1000, 270, 26, k, true);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(135, 155, 23, k, false);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(200, 200, 27, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_3") {
            view_list.get(0).setPosition(100, 400, 24, k, false);
            view_list.get(1).setPosition(1300, 150, 25, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(20, 365, 28, k, true);
            view_list.get(4).setPosition(1000, 270, 26, k, true);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(135, 155, 23, k, false);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(200, 200, 27, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_4") {
            view_list.get(0).setPosition(100, 400, 24, k, false);
            view_list.get(1).setPosition(1300, 150, 25, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(20, 365, 28, k, true);
            view_list.get(4).setPosition(1050, 270, 26, k, true);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(135, 155, 23, k, false);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(200, 200, 27, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_5") {
            view_list.get(0).setPosition(100, 400, 24, k, false);
            view_list.get(1).setPosition(1300, 150, 25, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(10, 365, 28, k, true);
            view_list.get(4).setPosition(1050, 270, 26, k, true);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(135, 155, 23, k, false);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(200, 200, 27, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_6") {
            view_list.get(0).setPosition(0, 550, 11, k, true);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(130, 255, 9, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 230, 4, k, false);
            view_list.get(8).setPosition(1250, 260, 10, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_7") {
            view_list.get(0).setPosition(0, 570, 11, k, true);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(90, 255, 9, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 230, 4, k, false);
            view_list.get(8).setPosition(1240, 260, 10, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_8") {
            view_list.get(0).setPosition(0, 570, 11, k, true);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(45, 255, 9, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 230, 4, k, false);
            view_list.get(8).setPosition(1200, 260, 10, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_9") {
            view_list.get(0).setPosition(0, 570, 11, k, true);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(15, 255, 9, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 230, 4, k, false);
            view_list.get(8).setPosition(1160, 260, 10, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_10") {
            view_list.get(0).setPosition(0, 570, 11, k, true);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(0, 255, 9, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 230, 4, k, false);
            view_list.get(8).setPosition(1100, 260, 10, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_11") {
            view_list.get(0).setPosition(0, 570, 11, k, true);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(-20, 255, 9, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 230, 4, k, false);
            view_list.get(8).setPosition(1040, 260, 10, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_12") {
            view_list.get(0).setPosition(40, 570, 11, k, true);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(110, 255, 29, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1450, 480, 12, k, true);
            view_list.get(8).setPosition(1000, 170, 10, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_13") {
            view_list.get(0).setPosition(40, 570, 11, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(110, 255, 29, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1400, 480, 12, k, true);
            view_list.get(8).setPosition(240, 480, 30, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_14") {
            view_list.get(0).setPosition(40, 570, 11, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(120, 255, 29, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1330, 480, 12, k, true);
            view_list.get(8).setPosition(200, 480, 30, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_15") {
            view_list.get(0).setPosition(140, 400, 11, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(150, 255, 29, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 480, 12, k, true);
            view_list.get(8).setPosition(165, 480, 30, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_16") {
            view_list.get(0).setPosition(140, 400, 11, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(165, 255, 14, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1050, 480, 15, k, true);
            view_list.get(8).setPosition(320, 350, 13, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_17") {
            view_list.get(0).setPosition(140, 400, 11, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(1180, 230, 18, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(110, 480, 16, k, true);
            view_list.get(8).setPosition(1170, 480, 17, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_18") {
            view_list.get(0).setPosition(1250, 570, 20, k, true);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(1015, 255, 19, k, true);
            view_list.get(7).setPosition(50, 480, 16, k, true);
            view_list.get(8).setPosition(1130, 380, 17, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_19") {
            view_list.get(0).setPosition(1190, 400, 20, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(185, 255, 22, k, true);
            view_list.get(7).setPosition(30, 480, 16, k, true);
            view_list.get(8).setPosition(1180, 480, 21, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_20") {
            view_list.get(0).setPosition(1190, 400, 20, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(90, 255, 22, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1180, 480, 21, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_21") {
            view_list.get(0).setPosition(1190, 400, 20, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(0, 255, 22, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1200, 480, 21, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_22") {
            view_list.get(0).setPosition(1190, 400, 20, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(110, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1220, 480, 21, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_23") {
            view_list.get(0).setPosition(1190, 400, 20, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(70, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1250, 480, 21, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_24") {
            view_list.get(0).setPosition(1190, 400, 20, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(0, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1250, 480, 21, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_25") {
            view_list.get(0).setPosition(1190, 400, 20, k, false);
            view_list.get(1).setPosition(200, 250, 6, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(-30, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1200, 480, 31, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_26") {
            view_list.get(0).setPosition(0, 570, 24, k, true);
            view_list.get(1).setPosition(1400, 250, 25, k, true);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(-80, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1180, 350, 21, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_27") {
            view_list.get(0).setPosition(0, 570, 24, k, true);
            view_list.get(1).setPosition(1400, 250, 25, k, true);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(-80, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1180, 350, 21, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_28") {
            view_list.get(0).setPosition(0, 570, 24, k, true);
            view_list.get(1).setPosition(1400, 250, 25, k, true);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(-80, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1180, 350, 21, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_29") {
            view_list.get(0).setPosition(0, 570, 24, k, true);
            view_list.get(1).setPosition(1400, 250, 25, k, true);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(-50, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1180, 350, 21, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_30") {
            view_list.get(0).setPosition(100, 400, 24, k, false);
            view_list.get(1).setPosition(1300, 150, 25, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(950, 270, 26, k, true);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(0, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1180, 350, 21, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_31") {
            view_list.get(0).setPosition(100, 400, 24, k, false);
            view_list.get(1).setPosition(1300, 150, 25, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(950, 270, 26, k, true);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(30, 255, 23, k, true);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(1180, 350, 21, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_32") {
            view_list.get(0).setPosition(100, 400, 24, k, false);
            view_list.get(1).setPosition(1300, 150, 25, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(950, 270, 26, k, true);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(135, 155, 23, k, false);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(200, 380, 27, k, true);
        } else if (resID == Constant.CAR_NAME + "_car_33") {
            view_list.get(0).setPosition(100, 400, 24, k, false);
            view_list.get(1).setPosition(1300, 150, 25, k, false);
            view_list.get(2).setPosition(1150, 135, 18, k, false);
            view_list.get(3).setPosition(190, 370, 28, k, true);
            view_list.get(4).setPosition(950, 270, 26, k, true);
            view_list.get(5).setPosition(350, 340, 6, k, false);
            view_list.get(6).setPosition(135, 155, 23, k, false);
            view_list.get(7).setPosition(80, 340, 16, k, false);
            view_list.get(8).setPosition(200, 200, 27, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_34") {
            view_list.get(0).setPosition(160, 400, 4, k, false);
            view_list.get(1).setPosition(180, 270, 8, k, true);
            view_list.get(2).setPosition(1185, 380, 7, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(150, 450, 6, k, true);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 230, 4, k, false);
            view_list.get(8).setPosition(1200, 230, 4, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_35") {
            view_list.get(0).setPosition(160, 400, 4, k, false);
            view_list.get(1).setPosition(180, 270, 8, k, true);
            view_list.get(2).setPosition(1185, 380, 7, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(30, 450, 6, k, true);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 230, 4, k, false);
            view_list.get(8).setPosition(1200, 230, 4, k, false);
        } else if (resID == Constant.CAR_NAME + "_car_36") {
            view_list.get(0).setPosition(160, 400, 4, k, false);
            view_list.get(1).setPosition(180, 260, 8, k, true);
            view_list.get(2).setPosition(1155, 380, 7, k, true);
            view_list.get(3).setPosition(170, 280, 4, k, false);
            view_list.get(4).setPosition(1030, 205, 5, k, false);
            view_list.get(5).setPosition(-70, 450, 6, k, true);
            view_list.get(6).setPosition(1200, 230, 4, k, false);
            view_list.get(7).setPosition(1200, 230, 4, k, false);
            view_list.get(8).setPosition(1200, 230, 4, k, false);
        }
    }


    double k;
    public static final double WIDTH = 1920;//手机端模型图片宽度常量

    List<BaseModelItem> view_list = new ArrayList<>();

    public void setItem(double width) {
        if (Constant.IS_PHONE) {
            k = width / WIDTH;//1989
        } else {
            k = 1;
        }
//        BaseModelItem baseModelItem1 = new BaseModelItem(mContext, "42", mContext.getString(R.string.model_item_text_1), R.mipmap.test_point_view_icon_2);
//        BaseModelItem baseModelItem2 = new BaseModelItem(mContext, "38", mContext.getString(R.string.model_item_text_2), R.mipmap.test_point_view_icon_8);
//        BaseModelItem baseModelItem3 = new BaseModelItem(mContext, "40", mContext.getString(R.string.model_item_text_3), R.mipmap.test_point_view_icon_4);
//        BaseModelItem baseModelItem4 = new BaseModelItem(mContext, "39", mContext.getString(R.string.model_item_text_4), R.mipmap.test_point_view_icon_6);
//        BaseModelItem baseModelItem5 = new BaseModelItem(mContext, "43", mContext.getString(R.string.model_item_text_5), R.mipmap.test_point_view_icon_5);
//        BaseModelItem baseModelItem6 = new BaseModelItem(mContext, "41", mContext.getString(R.string.model_item_text_6), R.mipmap.test_point_view_icon_l);
//        BaseModelItem baseModelItem7 = new BaseModelItem(mContext, "44", mContext.getString(R.string.model_item_text_7), R.mipmap.test_point_view_icon_9);
//        BaseModelItem baseModelItem8 = new BaseModelItem(mContext, "36", mContext.getString(R.string.model_item_text_8), R.mipmap.test_point_view_icon_3);
//        BaseModelItem baseModelItem9 = new BaseModelItem(mContext, "186", mContext.getString(R.string.model_item_text_9), R.mipmap.test_point_view_icon_7);
        BaseModelItem baseModelItem1 = new BaseModelItem(mContext, "169", mContext.getString(R.string.model_item_text_1), R.mipmap.test_point_view_icon_2);
        BaseModelItem baseModelItem2 = new BaseModelItem(mContext, "168", mContext.getString(R.string.model_item_text_2), R.mipmap.test_point_view_icon_8);
        BaseModelItem baseModelItem3 = new BaseModelItem(mContext, "127", mContext.getString(R.string.model_item_text_3), R.mipmap.test_point_view_icon_4);
        BaseModelItem baseModelItem4 = new BaseModelItem(mContext, "219", mContext.getString(R.string.model_item_text_4), R.mipmap.test_point_view_icon_6);
        BaseModelItem baseModelItem5 = new BaseModelItem(mContext, "117", mContext.getString(R.string.model_item_text_5), R.mipmap.test_point_view_icon_5);
        BaseModelItem baseModelItem6 = new BaseModelItem(mContext, "129", mContext.getString(R.string.model_item_text_6), R.mipmap.test_point_view_icon_l);
        BaseModelItem baseModelItem7 = new BaseModelItem(mContext, "131", mContext.getString(R.string.model_item_text_7), R.mipmap.test_point_view_icon_9);
        BaseModelItem baseModelItem8 = new BaseModelItem(mContext, "113", mContext.getString(R.string.model_item_text_8), R.mipmap.test_point_view_icon_3);
        BaseModelItem baseModelItem9 = new BaseModelItem(mContext, "112", mContext.getString(R.string.model_item_text_9), R.mipmap.test_point_view_icon_7);
        view_list.add(baseModelItem1);
        view_list.add(baseModelItem2);
        view_list.add(baseModelItem3);
        view_list.add(baseModelItem4);
        view_list.add(baseModelItem5);
        view_list.add(baseModelItem6);
        view_list.add(baseModelItem7);
        view_list.add(baseModelItem8);
        view_list.add(baseModelItem9);
        for (BaseModelItem item : view_list) {
            view_layout.addView(item);
        }

        showHotPointViewByResId("c229_car_1");
    }


//    private void setCarPointView(int resID) {
//        if (resID == R.drawable.c229_car_1) {
//            view_list.get(0).setPosition(160, 400, 2, k);
//            view_list.get(1).setPosition(200, 250, 1, k);
//            view_list.get(2).setPosition(1200, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_2) {
//            view_list.get(0).setPosition(150, 400, 2, k);
//            view_list.get(1).setPosition(160, 250, 1, k);
//            view_list.get(2).setPosition(1270, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_3) {
//            view_list.get(0).setPosition(340, 400, 2, k);
//            view_list.get(1).setPosition(120, 250, 1, k);
//            view_list.get(2).setPosition(1310, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_4) {
//            view_list.get(0).setPosition(340, 400, 2, k);
//            view_list.get(1).setPosition(120, 250, 1, k);
//            view_list.get(2).setPosition(1350, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_5) {
//            view_list.get(0).setPosition(300, 400, 2, k);
//            view_list.get(1).setPosition(160, 240, 1, k);
//            view_list.get(2).setPosition(1350, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_6) {
//            view_list.get(0).setPosition(220, 400, 2, k);
//            view_list.get(1).setPosition(170, 235, 1, k);
//            view_list.get(2).setPosition(1400, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_7) {
//            view_list.get(0).setPosition(195, 400, 2, k);
//            view_list.get(1).setPosition(150, 235, 1, k);
//            view_list.get(2).setPosition(1400, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_8) {
//            view_list.get(0).setPosition(195, 400, 2, k);
//            view_list.get(1).setPosition(150, 235, 1, k);
//            view_list.get(2).setPosition(1400, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_9) {
//            view_list.get(0).setPosition(195, 400, 2, k);
//            view_list.get(1).setPosition(150, 235, 1, k);
//            view_list.get(2).setPosition(1400, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_10) {
//            view_list.get(0).setPosition(195, 400, 2, k);
//            view_list.get(1).setPosition(160, 235, 1, k);
//            view_list.get(2).setPosition(1400, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_11) {
//            view_list.get(0).setPosition(215, 400, 2, k);
//            view_list.get(1).setPosition(190, 235, 1, k);
//            view_list.get(2).setPosition(1380, 220, 3, k);
//        } else if (resID == R.drawable.c229_car_12) {
//            view_list.get(0).setPosition(215, 400, 2, k);
//            view_list.get(1).setPosition(250, 235, 1, k);
//            view_list.get(2).setPosition(1350, 220, 3, k);
//        } else if (resID == R.drawable.c229_car_13) {
//            view_list.get(0).setPosition(255, 400, 2, k);
//            view_list.get(1).setPosition(300, 235, 1, k);
//            view_list.get(2).setPosition(1300, 220, 3, k);
//        } else if (resID == R.drawable.c229_car_14) {
//            view_list.get(0).setPosition(300, 400, 2, k);
//            view_list.get(1).setPosition(400, 235, 1, k);
//            view_list.get(2).setPosition(1250, 220, 3, k);
//        } else if (resID == R.drawable.c229_car_15) {
//            view_list.get(0).setPosition(380, 400, 2, k);
//            view_list.get(1).setPosition(380, 235, 1, k);
//            view_list.get(2).setPosition(1100, 220, 3, k);
//        } else if (resID == R.drawable.c229_car_16) {
//            view_list.get(0).setPosition(400, 400, 2, k);
//            view_list.get(1).setPosition(390, 235, 1, k);
//            view_list.get(2).setPosition(1100, 220, 3, k);
//        } else if (resID == R.drawable.c229_car_17) {
//            view_list.get(0).setPosition(400, 400, 2, k);
//            view_list.get(1).setPosition(390, 235, 1, k);
//            view_list.get(2).setPosition(1100, 220, 3, k);
//        } else if (resID == R.drawable.c229_car_18) {
//            view_list.get(0).setPosition(220, 400, 2, k);
//            view_list.get(1).setPosition(1200, 250, 3, k);
//            view_list.get(2).setPosition(300, 250, 1, k);
//        } else if (resID == R.drawable.c229_car_19) {
//            view_list.get(0).setPosition(220, 400, 2, k);
//            view_list.get(1).setPosition(1250, 250, 3, k);
//            view_list.get(2).setPosition(280, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_20) {
//            view_list.get(0).setPosition(220, 400, 2, k);
//            view_list.get(1).setPosition(1300, 250, 3, k);
//            view_list.get(2).setPosition(280, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_21) {
//            view_list.get(0).setPosition(220, 400, 2, k);
//            view_list.get(1).setPosition(1350, 250, 3, k);
//            view_list.get(2).setPosition(240, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_22) {
//            view_list.get(0).setPosition(260, 400, 2, k);
//            view_list.get(1).setPosition(1370, 250, 3, k);
//            view_list.get(2).setPosition(200, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_23) {
//            view_list.get(0).setPosition(270, 400, 2, k);
//            view_list.get(1).setPosition(1410, 250, 3, k);
//            view_list.get(2).setPosition(160, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_24) {
//            view_list.get(0).setPosition(270, 400, 2, k);
//            view_list.get(1).setPosition(1430, 250, 3, k);
//            view_list.get(2).setPosition(160, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_25) {
//            view_list.get(0).setPosition(290, 400, 2, k);
//            view_list.get(1).setPosition(1440, 250, 3, k);
//            view_list.get(2).setPosition(160, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_26) {
//            view_list.get(0).setPosition(290, 400, 2, k);
//            view_list.get(1).setPosition(1440, 250, 3, k);
//            view_list.get(2).setPosition(150, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_27) {
//            view_list.get(0).setPosition(280, 400, 2, k);
//            view_list.get(1).setPosition(1340, 250, 3, k);
//            view_list.get(2).setPosition(160, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_28) {
//            view_list.get(0).setPosition(240, 400, 2, k);
//            view_list.get(1).setPosition(1340, 250, 3, k);
//            view_list.get(2).setPosition(180, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_29) {
//            view_list.get(0).setPosition(240, 400, 2, k);
//            view_list.get(1).setPosition(1250, 250, 3, k);
//            view_list.get(2).setPosition(200, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_30) {
//            view_list.get(0).setPosition(260, 400, 2, k);
//            view_list.get(1).setPosition(1380, 250, 3, k);
//            view_list.get(2).setPosition(240, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_31) {
//            view_list.get(0).setPosition(280, 400, 2, k);
//            view_list.get(1).setPosition(1320, 250, 3, k);
//            view_list.get(2).setPosition(300, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_32) {
//            view_list.get(0).setPosition(340, 400, 2, k);
//            view_list.get(1).setPosition(1280, 250, 3, k);
//            view_list.get(2).setPosition(340, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_33) {
//            view_list.get(0).setPosition(420, 400, 2, k);
//            view_list.get(1).setPosition(1200, 250, 3, k);
//            view_list.get(2).setPosition(380, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_34) {
//            view_list.get(0).setPosition(360, 400, 2, k);
//            view_list.get(1).setPosition(1100, 250, 3, k);
//            view_list.get(2).setPosition(400, 230, 1, k);
//        } else if (resID == R.drawable.c229_car_35) {
//            view_list.get(0).setPosition(270, 400, 2, k);
//            view_list.get(1).setPosition(320, 250, 1, k);
//            view_list.get(2).setPosition(1120, 230, 3, k);
//        } else if (resID == R.drawable.c229_car_36) {
//            view_list.get(0).setPosition(220, 400, 2, k);
//            view_list.get(1).setPosition(270, 250, 1, k);
//            view_list.get(2).setPosition(1150, 230, 3, k);
//        }
//    }


}
