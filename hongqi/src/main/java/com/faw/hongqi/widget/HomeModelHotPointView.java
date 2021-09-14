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
        if (resID.equals(Constant.CAR_NAME + "_car_1")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(25, 340, 28, k, true);
                view_list.get(4).setPosition(1060, 230, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(60, 365, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(60, 360, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_2")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(10, 340, 28, k, true);
                view_list.get(4).setPosition(1060, 230, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(20, 365, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(60, 360, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_3")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(10, 340, 28, k, true);
                view_list.get(4).setPosition(1060, 230, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(20, 365, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(60, 360, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_4")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(00, 340, 28, k, true);
                view_list.get(4).setPosition(1060, 230, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(20, 365, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(60, 360, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_5")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(0, 340, 28, k, true);
                view_list.get(4).setPosition(1110, 230, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(20, 365, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(60, 360, 28, k, true);
                view_list.get(4).setPosition(1000, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_6")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(0, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(100, 210, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1250, 260, 10, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(130, 255, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1250, 260, 10, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(140, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(120, 240, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1100, 260, 10, k, true);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_7")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(0, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(65, 210, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1230, 260, 10, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 570, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(90, 255, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1240, 260, 10, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(140, 530, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(90, 240, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1100, 260, 10, k, true);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_8")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(0, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(30, 210, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1185, 260, 10, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 570, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(90, 255, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1240, 260, 10, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(140, 530, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(75, 240, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1070, 260, 10, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_9")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(0, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(0, 210, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1430, 460, 12, k, true);
                view_list.get(8).setPosition(1190, 235, 10, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 570, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(90, 255, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1240, 260, 10, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(140, 530, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(65, 240, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1020, 260, 10, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_10")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(0, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(10, 210, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1420, 460, 12, k, true);
                view_list.get(8).setPosition(1190, 235, 10, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 570, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(90, 255, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1240, 260, 10, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(160, 530, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(65, 240, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(970, 260, 10, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_11")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(30, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(0, 210, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1420, 460, 12, k, true);
                view_list.get(8).setPosition(1190, 235, 10, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 570, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(90, 255, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1240, 260, 10, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(190, 530, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(65, 240, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(920, 260, 10, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_12")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(80, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(0, 210, 9, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1420, 460, 12, k, true);
                view_list.get(8).setPosition(1190, 235, 10, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(40, 570, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(110, 255, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1450, 480, 12, k, true);
                view_list.get(8).setPosition(1000, 170, 10, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(230, 500, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(210, 245, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 430, 12, k, true);
                view_list.get(8).setPosition(1000, 170, 10, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_13")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(60, 570, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(140, 220, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1210, 480, 12, k, true);
                view_list.get(8).setPosition(200, 480, 30, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(40, 570, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(110, 255, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1400, 480, 12, k, true);
                view_list.get(8).setPosition(240, 480, 30, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(255, 500, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(220, 245, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1180, 430, 12, k, true);
                view_list.get(8).setPosition(1000, 170, 10, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_14")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(40, 570, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(145, 220, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1210, 480, 12, k, true);
                view_list.get(8).setPosition(170, 480, 30, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(40, 570, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(120, 255, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1330, 480, 12, k, true);
                view_list.get(8).setPosition(200, 480, 30, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(305, 500, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(230, 245, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1120, 430, 12, k, true);
                view_list.get(8).setPosition(1000, 170, 10, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_15")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(140, 400, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(175, 220, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1100, 480, 12, k, true);
                view_list.get(8).setPosition(135, 435, 30, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(140, 400, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(150, 255, 29, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 480, 12, k, true);
                view_list.get(8).setPosition(165, 480, 30, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(140, 400, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(285, 155, 29, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1030, 430, 12, k, true);
                view_list.get(8).setPosition(205, 390, 30, k, true);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_16")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(140, 400, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1180, 175, 18, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(110, 480, 16, k, true);
                view_list.get(8).setPosition(1170, 480, 17, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(140, 400, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1180, 230, 18, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(110, 480, 16, k, true);
                view_list.get(8).setPosition(1170, 480, 17, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(240, 550, 11, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(210, 155, 14, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(950, 430, 15, k, true);
                view_list.get(8).setPosition(320, 350, 13, k, false);
            }


        } else if (resID.equals(Constant.CAR_NAME + "_car_17")) {
            if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(140, 400, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1130, 220, 18, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(120, 430, 16, k, true);
                view_list.get(8).setPosition(1130, 480, 17, k, true);
            } else {
                view_list.get(0).setPosition(140, 400, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1180, 230, 18, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(110, 480, 16, k, true);
                view_list.get(8).setPosition(1170, 480, 17, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_18")) {
            if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(140, 400, 11, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1140, 220, 18, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(100, 430, 16, k, true);
                view_list.get(8).setPosition(1130, 480, 17, k, true);
            } else {
                view_list.get(0).setPosition(1250, 570, 20, k, true);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(1015, 255, 19, k, true);
                view_list.get(7).setPosition(50, 480, 16, k, true);
                view_list.get(8).setPosition(1130, 380, 17, k, false);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_19")) {
            if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(160, 240, 22, k, true);
                view_list.get(7).setPosition(100, 430, 16, k, true);
                view_list.get(8).setPosition(1130, 480, 17, k, true);
            } else {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(185, 255, 22, k, true);
                view_list.get(7).setPosition(30, 480, 16, k, true);
                view_list.get(8).setPosition(1180, 480, 21, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_20")) {
            if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(110, 240, 22, k, true);
                view_list.get(7).setPosition(100, 430, 16, k, false);
                view_list.get(8).setPosition(1130, 480, 17, k, true);
            } else {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(90, 255, 22, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 480, 21, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_21")) {
            if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(60, 240, 22, k, true);
                view_list.get(7).setPosition(100, 430, 16, k, false);
                view_list.get(8).setPosition(1130, 480, 17, k, true);
            } else {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(0, 255, 22, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1200, 480, 21, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_22")) {
            if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(20, 240, 22, k, true);
                view_list.get(7).setPosition(100, 430, 16, k, false);
                view_list.get(8).setPosition(1130, 480, 17, k, true);
            } else {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(110, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1220, 480, 21, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_23")) {
            if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-20, 240, 22, k, true);
                view_list.get(7).setPosition(100, 430, 16, k, false);
                view_list.get(8).setPosition(1130, 480, 17, k, true);
            } else {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(70, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1250, 480, 21, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_24")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-10, 245, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1200, 480, 31, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(0, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1250, 480, 21, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-50, 240, 22, k, true);
                view_list.get(7).setPosition(100, 430, 16, k, false);
                view_list.get(8).setPosition(1130, 480, 17, k, true);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_25")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-30, 245, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1200, 480, 31, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-30, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1200, 480, 31, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(1190, 400, 20, k, false);
                view_list.get(1).setPosition(200, 250, 6, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-70, 240, 22, k, true);
                view_list.get(7).setPosition(100, 430, 16, k, false);
                view_list.get(8).setPosition(1100, 480, 17, k, true);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_26")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(0, 570, 24, k, true);
                view_list.get(1).setPosition(1400, 210, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-40, 235, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 570, 24, k, true);
                view_list.get(1).setPosition(1400, 250, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-80, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(150, 510, 24, k, true);
                view_list.get(1).setPosition(1200, 220, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(105, 250, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_27")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(0, 570, 24, k, true);
                view_list.get(1).setPosition(1400, 210, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-40, 235, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 570, 24, k, true);
                view_list.get(1).setPosition(1400, 250, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-80, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(150, 510, 24, k, true);
                view_list.get(1).setPosition(1200, 220, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(105, 250, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_28")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(0, 570, 24, k, true);
                view_list.get(1).setPosition(1400, 210, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-40, 235, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 570, 24, k, true);
                view_list.get(1).setPosition(1400, 250, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-80, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(150, 510, 24, k, true);
                view_list.get(1).setPosition(1200, 220, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(105, 250, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_29")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(0, 570, 24, k, true);
                view_list.get(1).setPosition(1400, 230, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-50, 245, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(0, 570, 24, k, true);
                view_list.get(1).setPosition(1400, 250, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(-50, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(150, 510, 24, k, true);
                view_list.get(1).setPosition(1200, 220, 25, k, true);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(125, 250, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_30")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(950, 220, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(0, 245, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(950, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(0, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(950, 275, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(165, 240, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_31")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(950, 220, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(30, 245, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(950, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(30, 255, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(950, 275, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(180, 240, 23, k, true);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(1180, 350, 21, k, false);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_32")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(950, 220, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 350, 27, k, true);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(950, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 380, 27, k, true);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(950, 275, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(250, 270, 27, k, true);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_33")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(190, 340, 28, k, true);
                view_list.get(4).setPosition(950, 220, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(190, 370, 28, k, true);
                view_list.get(4).setPosition(950, 270, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(100, 400, 24, k, false);
                view_list.get(1).setPosition(1300, 150, 25, k, false);
                view_list.get(2).setPosition(1150, 135, 18, k, false);
                view_list.get(3).setPosition(170, 360, 28, k, true);
                view_list.get(4).setPosition(950, 275, 26, k, true);
                view_list.get(5).setPosition(350, 340, 6, k, false);
                view_list.get(6).setPosition(135, 155, 23, k, false);
                view_list.get(7).setPosition(80, 340, 16, k, false);
                view_list.get(8).setPosition(200, 200, 27, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_34")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(160, 400, 4, k, false);
                view_list.get(1).setPosition(180, 240, 8, k, true);
                view_list.get(2).setPosition(1185, 340, 7, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(150, 410, 6, k, true);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1200, 230, 4, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(160, 400, 4, k, false);
                view_list.get(1).setPosition(180, 270, 8, k, true);
                view_list.get(2).setPosition(1185, 380, 7, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(150, 450, 6, k, true);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1200, 230, 4, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(160, 400, 4, k, false);
                view_list.get(1).setPosition(200, 230, 8, k, true);
                view_list.get(2).setPosition(1085, 370, 7, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(145, 420, 6, k, true);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1200, 230, 4, k, false);
            }

        } else if (resID.equals(Constant.CAR_NAME + "_car_35")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(160, 400, 4, k, false);
                view_list.get(1).setPosition(150, 240, 8, k, true);
                view_list.get(2).setPosition(1175, 340, 7, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(60, 410, 6, k, true);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1200, 230, 4, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(160, 400, 4, k, false);
                view_list.get(1).setPosition(180, 270, 8, k, true);
                view_list.get(2).setPosition(1185, 380, 7, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(150, 450, 6, k, true);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1200, 230, 4, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(160, 400, 4, k, false);
                view_list.get(1).setPosition(170, 230, 8, k, true);
                view_list.get(2).setPosition(1080, 365, 7, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(80, 420, 6, k, true);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1200, 230, 4, k, false);
            }
        } else if (resID.equals(Constant.CAR_NAME + "_car_36")) {
            if (Constant.CAR_NAME.equals("e115")) {
                view_list.get(0).setPosition(160, 400, 4, k, false);
                view_list.get(1).setPosition(60, 240, 8, k, true);
                view_list.get(2).setPosition(1155, 340, 7, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(-30, 410, 6, k, true);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1200, 230, 4, k, false);
            } else if (Constant.CAR_NAME.equals("c229")) {
                view_list.get(0).setPosition(160, 400, 4, k, false);
                view_list.get(1).setPosition(180, 260, 8, k, true);
                view_list.get(2).setPosition(1155, 380, 7, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1030, 205, 5, k, false);
                view_list.get(5).setPosition(-70, 450, 6, k, true);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1200, 230, 4, k, false);
            } else if (Constant.CAR_NAME.equals("c235")) {
                view_list.get(0).setPosition(160, 400, 4, k, false);
                view_list.get(1).setPosition(120, 230, 8, k, true);
                view_list.get(2).setPosition(1050, 365, 7, k, true);
                view_list.get(3).setPosition(170, 280, 4, k, false);
                view_list.get(4).setPosition(1010, 205, 5, k, false);
                view_list.get(5).setPosition(10, 420, 6, k, true);
                view_list.get(6).setPosition(1200, 230, 4, k, false);
                view_list.get(7).setPosition(1200, 230, 4, k, false);
                view_list.get(8).setPosition(1200, 230, 4, k, false);
            }
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
        if (Constant.CAR_NAME.equals("e115")) {
            BaseModelItem baseModelItem1 = new BaseModelItem(mContext, "180", mContext.getString(R.string.model_item_text_1), R.mipmap.test_point_view_icon_2);
            BaseModelItem baseModelItem2 = new BaseModelItem(mContext, "183", mContext.getString(R.string.model_item_text_11), R.mipmap.test_point_view_icon_8);
            BaseModelItem baseModelItem3 = new BaseModelItem(mContext, "81", mContext.getString(R.string.model_item_text_3), R.mipmap.test_point_view_icon_4);
            BaseModelItem baseModelItem4 = new BaseModelItem(mContext, "175", mContext.getString(R.string.model_item_text_4), R.mipmap.test_point_view_icon_6);
            BaseModelItem baseModelItem5 = new BaseModelItem(mContext, "27", mContext.getString(R.string.model_item_text_5), R.mipmap.test_point_view_icon_5);
            BaseModelItem baseModelItem6 = new BaseModelItem(mContext, "177", mContext.getString(R.string.model_item_text_6), R.mipmap.test_point_view_icon_l);
            BaseModelItem baseModelItem7 = new BaseModelItem(mContext, "181", mContext.getString(R.string.model_item_text_10), R.mipmap.test_point_view_icon_9);
            BaseModelItem baseModelItem8 = new BaseModelItem(mContext, "28", mContext.getString(R.string.model_item_text_8), R.mipmap.test_point_view_icon_3);
            BaseModelItem baseModelItem9 = new BaseModelItem(mContext, "190", mContext.getString(R.string.model_item_text_9), R.mipmap.test_point_view_icon_7);
            view_list.add(baseModelItem1);
            view_list.add(baseModelItem2);
            view_list.add(baseModelItem3);
            view_list.add(baseModelItem4);
            view_list.add(baseModelItem5);
            view_list.add(baseModelItem6);
            view_list.add(baseModelItem7);
            view_list.add(baseModelItem8);
            view_list.add(baseModelItem9);
        } else if (Constant.CAR_NAME.equals("c229")) {
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
        } else if (Constant.CAR_NAME.equals("c235")){
            BaseModelItem baseModelItem1 = new BaseModelItem(mContext, "63", mContext.getString(R.string.model_item_text_1), R.mipmap.test_point_view_icon_2);
            BaseModelItem baseModelItem2 = new BaseModelItem(mContext, "59", mContext.getString(R.string.model_item_text_2), R.mipmap.test_point_view_icon_8);
            BaseModelItem baseModelItem3 = new BaseModelItem(mContext, "61", mContext.getString(R.string.model_item_text_3), R.mipmap.test_point_view_icon_4);
            BaseModelItem baseModelItem4 = new BaseModelItem(mContext, "60", mContext.getString(R.string.model_item_text_4), R.mipmap.test_point_view_icon_6);
            BaseModelItem baseModelItem5 = new BaseModelItem(mContext, "65", mContext.getString(R.string.model_item_text_5), R.mipmap.test_point_view_icon_5);
            BaseModelItem baseModelItem6 = new BaseModelItem(mContext, "62", mContext.getString(R.string.model_item_text_6), R.mipmap.test_point_view_icon_l);
            BaseModelItem baseModelItem7 = new BaseModelItem(mContext, "66", mContext.getString(R.string.model_item_text_7), R.mipmap.test_point_view_icon_9);
            BaseModelItem baseModelItem8 = new BaseModelItem(mContext, "67", mContext.getString(R.string.model_item_text_8), R.mipmap.test_point_view_icon_3);
            BaseModelItem baseModelItem9 = new BaseModelItem(mContext, "68", mContext.getString(R.string.model_item_text_9), R.mipmap.test_point_view_icon_7);
            view_list.add(baseModelItem1);
            view_list.add(baseModelItem2);
            view_list.add(baseModelItem3);
            view_list.add(baseModelItem4);
            view_list.add(baseModelItem5);
            view_list.add(baseModelItem6);
            view_list.add(baseModelItem7);
            view_list.add(baseModelItem8);
            view_list.add(baseModelItem9);
        }


        for (BaseModelItem item : view_list) {
            view_layout.addView(item);
        }

        showHotPointViewByResId(Constant.CAR_NAME + "_car_1");
    }


}
