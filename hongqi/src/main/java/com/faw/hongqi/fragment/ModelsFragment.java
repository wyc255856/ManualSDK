package com.faw.hongqi.fragment;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.faw.hongqi.R;
import com.faw.hongqi.ui.C229SelectCarModelActivity;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.util.PhoneUtil;
import com.faw.hongqi.widget.HomeModelHotPointView;
import com.liulishuo.filedownloader.util.FileDownloadUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ModelsFragment extends BaseFragment implements View.OnTouchListener {
    ImageView car_model;
    HomeModelHotPointView homeModelHotPointView;
    View view_select_car_model;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_c229_model;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView(View view) {
        //e115-36images.zip
        car_model = view.findViewById(R.id.car_model);
        car_model.setImageURI(Uri.parse(FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + File.separator + Constant.CAR_NAME + "-36images/" + Constant.CAR_NAME + "_car_1.png"));
        homeModelHotPointView = view.findViewById(R.id.home_model_hot_point_view);
        view_select_car_model = view.findViewById(R.id.view_select_car_model);
        initPics();
        car_model.setOnTouchListener(this);
    }


    @Override
    protected void initWidgetActions() {
        ViewTreeObserver vto = car_model.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void
            onGlobalLayout() {
                car_model.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) car_model.getLayoutParams();
                if (Constant.IS_PHONE) {
                    //TODO 手机尺寸适配

                    int screenWidth = PhoneUtil.getDisplayWidth(mContext);
//                    lp.width = screenWidth-PhoneUtil.dip2px(mContext,120);
                    lp.width = screenWidth - PhoneUtil.dip2px(mContext, (float) (screenWidth * 0.1) / 2);
                    lp.height = (int) (lp.width * 0.46785);
                } else {
                    lp.width = 1440;
                    lp.height = 675;
                }

                car_model.setLayoutParams(lp);

            }

        });
        ViewTreeObserver vtoView = homeModelHotPointView.getViewTreeObserver();
        vtoView.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void
            onGlobalLayout() {
                homeModelHotPointView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) homeModelHotPointView.getLayoutParams();
                if (Constant.IS_PHONE) {
                    //TODO 手机尺寸适配
                    int screenWidth = PhoneUtil.getDisplayWidth(mContext);
//                    lp.width = screenWidth-PhoneUtil.dip2px(mContext,120);
                    lp.width = screenWidth - PhoneUtil.dip2px(mContext, (float) (screenWidth * 0.1) / 2);
                    lp.height = (int) (lp.width * 0.46785);
                    homeModelHotPointView.setItem(lp.width);
                    LogUtil.logError("image:" + lp.width);
                } else {
                    lp.width = PhoneUtil.getDisplayWidth(mContext);
                    lp.height = 620;
                    homeModelHotPointView.setItem(lp.width);
                }
                homeModelHotPointView.setLayoutParams(lp);


            }

        });

        view_select_car_model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),C229SelectCarModelActivity.class);
                intent.putExtra("data",C229SelectCarModelActivity.model);
                startActivity(intent);
            }
        });
    }

    @Override
    public void refreshData() {

    }

    float start;
    boolean leftScreen;
    long startTime;
    float singleSpec = 15;

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                homeModelHotPointView.hideAllView();
                leftScreen = false;
                start = event.getX();
                startTime = System.currentTimeMillis();
                break;
            case MotionEvent.ACTION_UP:
                float distance = event.getX() - start;
                distance = distance > 0 ? distance : -distance;
                long partTime = System.currentTimeMillis() - startTime;
                float v = distance / partTime;
                v = v > 0 ? v : -v;
                float StandardV = singleSpec / 60;
                Log.e(Tag, "distance=" + distance + ">>singleSpec=" + singleSpec + ">>v=" + v + ">>StandardV=" + StandardV);
                if (distance < singleSpec) {
                    leftScreen = false;
                } else if (v < StandardV) {
                    leftScreen = false;
                } else {
                    leftScreen = true;
                    Log.e(Tag, "ACTION_UP>>");
//                    intertia(NowID, intertiaStart);
                }

                NowID = NowID == 0 ? 1 : NowID;
                OldID = NowID;
                homeModelHotPointView.showHotPointViewByResId(pics.get(NowID - 1));
                break;
            case MotionEvent.ACTION_MOVE:
                if (OldID != NowID) {
                    homeModelHotPointView.hideAllView();
                } else {

                }
                int nowX = (int) event.getX();
                //计算移动距离
                float spec = nowX - start;
                int mo;
                String id;
                if (spec > 0) {
                    //从左向右滑
                    mo = (int) ((spec / singleSpec) + (pics.size() + 1 - OldID));
                    if (mo > pics.size()) {
                        mo = mo % pics.size();

                    }
                    mo = pics.size() + 1 - mo;
                } else {
                    //从右向左滑
//                    Log.e(Tag, "1  spec=" + spec + ">>singleSpec=" + singleSpec);
                    spec = 0 - spec;
                    mo = (int) ((spec / singleSpec) + OldID);
                    if (mo > pics.size())
                        mo = mo % pics.size() + 1;
                }
                if (mo != 0 && mo != 37) {
                    id = pics.get(mo - 1);
                    if (mo != NowID && !leftScreen) {
                        Log.e(Tag, "ACTION_MOVE>>" + NowID);
                        NowID = mo;
                        // car_model.setImageResource(id);
                        String url = FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                                + File.separator + "MyFolder" + File.separator + Constant.CAR_NAME + "-36images/" +id+".png";
                        car_model.setImageURI(Uri.parse(url));
                    }

                }

                break;
        }
        return true;

    }

    int NowID = 0;
    int OldID = 0;
    List<String> pics;

    private void initPics() {
        pics = new ArrayList<>();
        for (int i = 0; i < 36; i++) {
            pics.add(Constant.CAR_NAME + "_car_" + (i+1));
        }
    }
}
