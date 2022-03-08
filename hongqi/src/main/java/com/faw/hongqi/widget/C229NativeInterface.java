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
        List<NewsModel> result1List = new ArrayList<>();
        if (DBUtil.getNewsListById(BrightSpotFragment.context,id) != null)
            result1List = (List<NewsModel>) DBUtil.getNewsListById(BrightSpotFragment.context,id);
        final List<NewsModel> finalResult1List = result1List;
        if (finalResult1List.size() == 0){

        }else {
            BrightSpotFragment.context.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (finalResult1List.get(0).getTemplate1() != 6) {
                        C229ContentActivity.goContentActivity(BrightSpotFragment.context, finalResult1List.get(0));

                    }else {
                        C229PlayVideoActivity.goVideoActivity(BrightSpotFragment.context,finalResult1List.get(0));

                    }
//                            C229ContentActivity.goContentActivity(BrightSpotFragment.context, finalResult1List.get(0));
                }
            });
        }

//        DBUtil.getNewsListById(BrightSpotFragment.context,id, new TransactionListener() {
//            @Override
//            public void onResultReceived(Object result) {
//
//            }
//
//            @Override
//            public boolean onReady(BaseTransaction transaction) {
//                return false;
//            }
//
//            @Override
//            public boolean hasResult(BaseTransaction transaction, Object result) {
//                List<NewsModel> result1List = new ArrayList<>();
//                if (result != null)
//                    result1List = (List<NewsModel>) result;
//                final List<NewsModel> finalResult1List = result1List;
//                if (finalResult1List.size() == 0){
//
//                }else {
//                    BrightSpotFragment.context.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            if (finalResult1List.get(0).getTemplate1() != 6) {
//                                C229ContentActivity.goContentActivity(BrightSpotFragment.context, finalResult1List.get(0));
//
//                            }else {
//                                C229PlayVideoActivity.goVideoActivity(BrightSpotFragment.context,finalResult1List.get(0));
//
//                            }
////                            C229ContentActivity.goContentActivity(BrightSpotFragment.context, finalResult1List.get(0));
//                        }
//                    });
//                }
//                return false;
//            }
//        });
    }
}
