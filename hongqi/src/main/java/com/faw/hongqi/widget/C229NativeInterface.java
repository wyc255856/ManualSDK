package com.faw.hongqi.widget;

import android.content.Intent;
import android.webkit.JavascriptInterface;

import com.faw.hongqi.dbutil.DBUtil;
import com.faw.hongqi.fragment.BrightSpotFragment;
import com.faw.hongqi.model.NewsModel;
import com.faw.hongqi.ui.C229ContentActivity;
import com.faw.hongqi.ui.C229InteractionGameActivity;
import com.faw.hongqi.ui.C229PlayVideoActivity;

import java.util.ArrayList;
import java.util.List;

public class C229NativeInterface {

    @JavascriptInterface
    public void JsTest(final String id) {
        BrightSpotFragment.context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if ("213".equals(id)){
                    BrightSpotFragment.context.startActivity(new Intent(BrightSpotFragment.context, C229InteractionGameActivity.class));
                }else{
                    getFastNewsList(id);
                }
            }
        });
    }
    private void getFastNewsList(String  id) {
        final NewsModel newsModel=DBUtil.getInstance().getNewsListById(id);
        BrightSpotFragment.context.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (newsModel.getTemplate1() != 6) {
                    C229ContentActivity.goContentActivity(BrightSpotFragment.context, newsModel);

                }else {
                    C229PlayVideoActivity.goVideoActivity(BrightSpotFragment.context,newsModel);

                }
                //  C229ContentActivity.goContentActivity(BrightSpotFragment.context, newsModel);
            }
        });
    }
}
