package com.faw.hongqi.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.sax.RootElement;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.faw.hongqi.R;
import com.faw.hongqi.dbutil.DBUtil;
import com.faw.hongqi.model.NewsModel;
import com.faw.hongqi.ui.C229ContentActivity;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.util.PhoneUtil;
import com.raizlabs.android.dbflow.runtime.transaction.BaseTransaction;
import com.raizlabs.android.dbflow.runtime.transaction.TransactionListener;

import java.util.ArrayList;
import java.util.List;


public class BaseModelItem extends LinearLayout {
    protected Activity mContext;
    protected TextView textView;
    protected ImageView line;

    protected PointView pointView;
    int resID;
    private NewsModel model;
    private void getFastNewsList(String id) {
        DBUtil.getNewsListById(mContext,id, new TransactionListener() {
            @Override
            public void onResultReceived(Object result) {

            }

            @Override
            public boolean onReady(BaseTransaction transaction) {
                return false;
            }

            @Override
            public boolean hasResult(BaseTransaction transaction, Object result) {
                List<NewsModel> result1List = new ArrayList<>();
                if (result != null)
                    result1List = (List<NewsModel>) result;
                final List<NewsModel> finalResult1List = result1List;
                mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        C229ContentActivity.goContentActivity(mContext, finalResult1List.get(0));
                    }
                });
                return false;
            }
        });
    }
    public BaseModelItem(Context context) {
        super(context);
    }

    public BaseModelItem(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseModelItem(Context context, String id, String text, int icon) {
        super(context);
        initView(context, id, text, icon);
    }

    private void initView(final Context context, final String id, String text, int icon) {
        // TODO Auto-generated method stub
        this.mContext = (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.view_model_item,
                this, true);
        resID = icon;
        textView = findViewById(R.id.text);
        line = findViewById(R.id.line);
        pointView = findViewById(R.id.point);
        if (!TextUtils.isEmpty(text)) {
            textView.setText(text);
        }
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 跳转到内容页
                getFastNewsList(id);
            }
        });
    }

    private double k;

    public void setPosition(int x, int y, int style, double k,boolean isShow) {
        this.k = k;
        positionX = x;
        positionY = y;
        setStyle(style,isShow);
//        if (!Constant.IS_PHONE) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = (int) (x * k);
        layoutParams.topMargin = (int) (y * k);
        setLayoutParams(layoutParams);
//        }
    }

    /**
     * 通过style更改文字、亮点、底线的坐标和样式
     *
     * @param style
     */
    private void setStyle(int style,boolean isShow) {

        switch (style) {
            case 1:
                if (Constant.IS_PHONE) {
                    setPhoneLine(100, 0, style);
                    setPhonePoint(490, 0, style);
                    setPhoneText(20, 20, style);
                } else {
                    setLine(0, 10, style);
                    setPoint(350, 105, style);
                    setText(10, 0, style);
                }
                break;
            case 2:
                if (Constant.IS_PHONE) {
                    setPhoneLine(0, 200, style);
                    setPhonePoint(420, 315, style);
                    setPhoneText(0, 170, style);
//                    setPhoneLine(120, 255, style);
//                    setPhonePoint(420, 315, style);
//                    setPhoneText(0, 170, style);
                } else {
                    setLine(0, 15, style);
                    setPoint(380, 0, style);
                    setText(0, 30, style);
                }
                break;
            case 3:
                if (Constant.IS_PHONE) {
                    setPhoneLine(250, 200, style);
                    setPhonePoint(220, 320, style);
                    setPhoneText(450, 200, style);
                } else {
                    setLine(15, 0, style);
                    setPoint(0, 85, style);
                    setText(130, 0, style);
                }
                break;
            case 4:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(15, 12, style);
                        setPoint(650, 0, style);
                        setText(90, 20, style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 5:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 20, style);
                        setPoint(3, 5, style);
                        setText(460,25,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 6:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 24, style);
                        setPoint(570, 5, style);
                        setText(120,55,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 7:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 21, style);
                        setPoint(3, 0, style);
                        setText(280,30,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 8:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 23, style);
                        setPoint(585, 155, style);
                        setText(80,22,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 9:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 27, style);
                        setPoint(670, 128, style);
                        setText(90,20,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 10:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 27, style);
                        setPoint(0, 157, style);
                        setText(380,28,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 11:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(33, 30, style);
                        setPoint(450, 20, style);
                        setText(70,25,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 12:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 23, style);
                        setPoint(10, 4, style);
                        setText(180,32,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 13:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 23, style);
                        setPoint(440, 15, style);
                        setText(140,30,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 14:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 24, style);
                        setPoint(545, 125, style);
                        setText(90,25,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 15:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 20, style);
                        setPoint(0, 0, style);
                        setText(395,30,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 16:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(30, 20, style);
                        setPoint(570, 0, style);
                        setText(80,30,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 17:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 20, style);
                        setPoint(0, 0, style);
                        setText(355,30,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 18:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 27, style);
                        setPoint(0, 150, style);
                        setText(280,20,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 19:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 25, style);
                        setPoint(10, 160, style);
                        setText(455,25,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 20:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 20, style);
                        setPoint(10, 0, style);
                        setText(225,30,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 21:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 20, style);
                        setPoint(10, 0, style);
                        setText(310,30,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 22:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(40, 23, style);
                        setPoint(740, 155, style);
                        setText(125,30,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 23:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 18, style);
                        setPoint(550, 151, style);
                        setText(115,26,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 24:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 22, style);
                        setPoint(520, 3, style);
                        setText(85,33,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 25:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 27, style);
                        setPoint(10, 158, style);
                        setText(230,23,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 26:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 28, style);
                        setPoint(10, 8, style);
                        setText(440,40,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 27:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 22, style);
                        setPoint(540, 153, style);
                        setText(100,30,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 28:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(45, 28, style);
                        setPoint(650, 8, style);
                        setText(105,35,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 29:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 25, style);
                        setPoint(520, 126, style);
                        setText(90,20,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 30:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 22, style);
                        setPoint(545, 10, style);
                        setText(120,22,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
            case 31:
                if (Constant.IS_PHONE){
                    if (!isShow){
                        line.setVisibility(GONE);
                        textView.setVisibility(GONE);
                        pointView.setVisibility(GONE);
                    }else {
                        setLine(25, 22, style);
                        setPoint(10, 3, style);
                        setText(480,35,style);
                        line.setVisibility(VISIBLE);
                        textView.setVisibility(VISIBLE);
                        pointView.setVisibility(VISIBLE);
                    }
                }else{

                }
                break;
        }

    }


    /**
     * 设置车机文字底的横线坐标和样式
     *
     * @param x
     * @param y
     * @param style
     */
    private void setLine(int x, int y, int style) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        //获取图片的宽高
        int height = 0;
        int width = 0;
        if (style == 1) {
            line.setImageResource(R.mipmap.point_view_line_2);
        } else if (style == 2) {
            line.setImageResource(R.mipmap.point_view_line_3);
        } else if (style == 3) {
            line.setImageResource(R.mipmap.point_view_line_1);
        } else if (style == 4){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_4,R.mipmap.point_view_line_4));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_4,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 5){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_5,R.mipmap.point_view_line_5));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_5,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 6){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_6,R.mipmap.point_view_line_6));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_6,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 7){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_7,R.mipmap.point_view_line_7));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_7,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 8){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_8,R.mipmap.point_view_line_8));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_8,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 9){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_9,R.mipmap.point_view_line_9));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_9,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 10){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_10,R.mipmap.point_view_line_10));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_10,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 11){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_11,R.mipmap.point_view_line_11));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_11,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 12){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_12,R.mipmap.point_view_line_12));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_12,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 13){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_11,R.mipmap.point_view_line_11));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_11,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 14){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_14,R.mipmap.point_view_line_14));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_14,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 15){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_15,R.mipmap.point_view_line_15));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_15,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 16){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_16,R.mipmap.point_view_line_16));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_16,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 17){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_17,R.mipmap.point_view_line_17));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_17,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 18){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_18,R.mipmap.point_view_line_18));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_18,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 19){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_19,R.mipmap.point_view_line_19));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_19,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 20){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_20,R.mipmap.point_view_line_20));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_20,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 21){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_21,R.mipmap.point_view_line_21));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_21,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 22){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_22,R.mipmap.point_view_line_22));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_22,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 23){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_23,R.mipmap.point_view_line_23));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_23,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 24){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_24,R.mipmap.point_view_line_24));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_24,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 25){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_25,R.mipmap.point_view_line_25));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_25,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 26){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_26,R.mipmap.point_view_line_26));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_26,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 27){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_27,R.mipmap.point_view_line_27));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_27,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 28){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_28,R.mipmap.point_view_line_28));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_28,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 29){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_29,R.mipmap.point_view_line_29));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_29,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 30){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_30,R.mipmap.point_view_line_30));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_30,options);
            height = options.outHeight;
            width = options.outWidth;
        } else if (style == 31){
            line.setImageDrawable(CreatPressedSelector(mContext,R.mipmap.point_view_line_31,R.mipmap.point_view_line_31));
            BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_31,options);
            height = options.outHeight;
            width = options.outWidth;
        }
        RelativeLayout.LayoutParams lpline = (RelativeLayout.LayoutParams) line.getLayoutParams();
        lpline.leftMargin = (int) (x*k);
        lpline.topMargin = (int) (y*k);
        //根据不同图片设置不同宽高*K
        lpline.width = (int) (width*k);
        lpline.height = (int) (height*k);

        line.setLayoutParams(lpline);


    }
    /**
     * 用java代码的方式动态生成状态选择器
     */
    public static Drawable CreatPressedSelector(Context context, int pressed, int normal) {
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_pressed}, ContextCompat.getDrawable(context,pressed));//状态,设置按下的图片
        drawable.addState(new int[]{}, ContextCompat.getDrawable(context,normal));//默认状态,默认状态下的图片
        //根据SDK版本设置状态选择器过度动画/渐变选择器/渐变动画
        if (Build.VERSION.SDK_INT > 10) {
            drawable.setEnterFadeDuration(500);
            drawable.setExitFadeDuration(500);
        }
        return drawable;
    }
    /**
     * 设置车机亮点坐标和样式
     *
     * @param x
     * @param y
     * @param style
     */
    private void setPoint(int x, int y, int style) {

        RelativeLayout.LayoutParams lppoint = (RelativeLayout.LayoutParams) pointView.getLayoutParams();
        lppoint.leftMargin = (int) (x*k);
        lppoint.topMargin = (int) (y*k);
        pointView.setLayoutParams(lppoint);
    }

    /**
     * 设置车机文字的坐标和样式
     *
     * @param x
     * @param y
     * @param style
     */
    private void setText(int x, int y, int style) {
        textView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(resID, null),
                null, null, null);
        textView.setCompoundDrawablePadding(10);
        RelativeLayout.LayoutParams lptext = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        lptext.leftMargin = (int) (x*k);
        lptext.topMargin = (int) (y*k);
        textView.setLayoutParams(lptext);
    }

    double cha;
    int positionX = 0;
    int positionY = 0;

    /**
     * 设置手机文字底的横线坐标和样式
     *
     * @param x
     * @param y
     * @param style
     */
    private void setPhoneLine(int x, int y, int style) {
        if (style == 1) {
            line.setImageResource(R.mipmap.point_view_line_1);
        } else if (style == 2) {
            line.setImageResource(R.mipmap.point_view_line_2);
        } else if (style == 3) {
            line.setImageResource(R.mipmap.point_view_line_3);
        }
//        ViewTreeObserver vto = line.getViewTreeObserver();
//        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void
//            onGlobalLayout() {
//                line.getViewTreeObserver().removeGlobalOnLayoutListener(this);
//                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) line.getLayoutParams();
//                cha = lp.width * (1 - k);
//                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
//                layoutParams.leftMargin = (int) (positionX * k - cha);
//                layoutParams.topMargin = (int) (positionY * k - cha);
//                setLayoutParams(layoutParams);
//
//
//            }
//
//        });



        RelativeLayout.LayoutParams lpline = (RelativeLayout.LayoutParams) line.getLayoutParams();
        lpline.leftMargin = (int) (x * k);
        lpline.topMargin = (int) (y * k);


//        BitmapFactory.Options options = new BitmapFactory.Options();
//        BitmapFactory.decodeResource(getResources(),R.mipmap.point_view_line_1,options);
//        //获取图片的宽高
//        int height = options.outHeight;
//        int width = options.outWidth;
//        lpline.width = (int) (width*k);
//        lpline.height = (int) (height*k);


        line.setLayoutParams(lpline);
    }

    /**
     * 设置手机亮点坐标和样式
     *
     * @param x
     * @param y
     * @param style
     */
    private void setPhonePoint(int x, int y, int style) {
        RelativeLayout.LayoutParams lppoint = (RelativeLayout.LayoutParams) pointView.getLayoutParams();
        lppoint.leftMargin = (int) (x * k);
        lppoint.topMargin = (int) (y * k);
        pointView.setLayoutParams(lppoint);
    }

    /**
     * 设置手机文字的坐标和样式
     *
     * @param x
     * @param y
     * @param style
     */
    private void setPhoneText(int x, int y, int style) {
        textView.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(resID, null),
                null, null, null);
        textView.setCompoundDrawablePadding(10);
        RelativeLayout.LayoutParams lptext = (RelativeLayout.LayoutParams) textView.getLayoutParams();
        lptext.leftMargin = (int) (x * k);
        lptext.topMargin = (int) (y * k);
        textView.setLayoutParams(lptext);
    }
}
