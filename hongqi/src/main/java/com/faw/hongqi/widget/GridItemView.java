package com.faw.hongqi.widget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.faw.hongqi.R;
import com.faw.hongqi.event.BaseEvent;
import com.faw.hongqi.event.SecondaryOnclickEvent;
import com.faw.hongqi.model.NewsModel;
import com.faw.hongqi.ui.C229ContentActivity;
import com.faw.hongqi.ui.C229PlayVideoActivity;
import com.faw.hongqi.ui.C229VideoActivity;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.FileUtil;
import com.faw.hongqi.util.GlideRoundTransform;
import com.faw.hongqi.util.LogUtil;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class GridItemView extends LinearLayout implements View.OnClickListener {

    ImageView imageView;
    TextView title;
    int index;

    private Activity mContext;

    public GridItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public GridItemView(Context context) {
        super(context);
        initView(context);
    }

    @SuppressLint("WrongViewCast")
    private void initView(Context context) {
        // TODO Auto-generated method stub
        this.mContext = (Activity) context;
        LayoutInflater.from(context).inflate(R.layout.item_grid,
                this, true);
        imageView = findViewById(R.id.imageView);
        title = findViewById(R.id.title);

//        Glide.with(mContext).load(R.drawable.c229_point).into(point_view_1_point1);
//        Glide.with(mContext).load(R.drawable.c229_point)
//                .diskCacheStrategy(DiskCacheStrategy.ALL).into(point_view_1_point1);
        setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                if (TextUtils.isEmpty(data.getVideo1())) {
//                    C229ContentActivity.goContentActivity(mContext, data);
                } else {
//            mContext.startActivity(new Intent(mContext, C229PlayVideoActivity.class));
//                    C229PlayVideoActivity.goVideoActivity(mContext,data);
                }
            }
        });
    }

    public NewsModel data;
//    //设置图片圆角角度
//    RoundedCorners roundedCorners= new RoundedCorners(4);
//    //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
//    RequestOptions options=RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
    public void setData(NewsModel model, int index) {
        data = model;
        data.setStatus(index);
        this.index = index;
        if (!TextUtils.isEmpty(model.getHead_image())) {
//            String url = FileUtil.getResPath() + model.getHead_image().replace("HONGQIH9/standard/","");
            String url = Constant.BASE_URL + model.getHead_image();
            LogUtil.logError("image url = " + url);
//            Glide.with(mContext).load(url).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(imageView);
//            Bitmap bitmap = FileUtil.getLoacalBitmap(url);
//            LogUtil.logError("bitmap = " + bitmap);
//            imageView.setImageBitmap(bitmap);
//            File file = new File(FileUtil.getResPath() + model.getHead_image().replace("HONGQIH9/standard/",""));
            File file = new File(Constant.BASE_URL + model.getHead_image());
//            LogUtil.logError("file url = " + file.exists());

            Glide.with(mContext)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.mipmap.download_error)
                    .dontAnimate()
                    .into(imageView);
//            Glide.with(mContext) 
//                    .load(Uri.fromFile(file)).apply(options).into(imageView);
        } else {
            String url = "images/2019-04-26/5cc2b440a0ab1.png";
            Glide.with(mContext)
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.mipmap.download_error)
                    .dontAnimate()
                    .into(imageView);
//            Glide.with(mContext)
//                    .load(Uri.fromFile(new File(FileUtil.getResPath() + url))).apply(options).into(imageView);
//            imageView.setImageBitmap(getBitmap(url));
//            imageView.setImageBitmap(FileUtil.getLoacalBitmap(FileUtil.getResPath() + url));
        }
        title.setText(model.getTitle() + "");
    }

    @Subscribe
    public void onEvent(BaseEvent event) {
        if (event instanceof SecondaryOnclickEvent) {

        }
    }

    @Override
    public void onClick(View v) {
//        EventBus.getDefault().post(new SecondaryOnclickEvent(SecondaryOnclickEvent.FAST, index));
        if (TextUtils.isEmpty(data.getVideo1())) {
            C229ContentActivity.goContentActivity(mContext, data);
        } else {
//            mContext.startActivity(new Intent(mContext, C229PlayVideoActivity.class));
            C229PlayVideoActivity.goVideoActivity(mContext,data);
        }

    }

    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

    private Bitmap getBitmap(String fileName) {
        Bitmap bitmap = null;
        AssetManager assetManager = mContext.getAssets();
        try {
            InputStream inputStream = assetManager.open(fileName);//filename是assets目录下的图片名
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
