package com.faw.hongqi.util;


import android.content.Context;

import com.faw.hongqi.R;
import com.liulishuo.filedownloader.util.FileDownloadUtils;

import java.io.File;
import java.lang.reflect.Field;

public class ResUtil {
    public static int getMipmapResId(String variableName) {
        try {
            Field idField = R.mipmap.class.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getDrawableResId(String variableName) {
        try {
            Field idField = R.drawable.class.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }


//    /**
//     * 根据url获取本地的图片
//     * @param context 上下文
//     * @param url 图片url
//     * @return 本地图片资源id
//     */
//    public int getLocalImageByURL(Context context, String url) {
//        int resId = 0;
//        String picName = map.get(url);
//        resId = context.getResources().getIdentifier(
//                picName == null ? "no_picture" : picName, "drawable",context.getPackageName());
//
//        return resId;
//    }
}
