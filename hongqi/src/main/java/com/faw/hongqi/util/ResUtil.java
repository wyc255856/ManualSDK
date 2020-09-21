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
    public static int getDrawableId(Context paramContext, String paramString) {
        int resId = paramContext.getResources().getIdentifier(paramString,
                "file", paramContext.getPackageName());

        return resId;
    }

}
