package com.faw.hongqi.util;

import android.content.Context;

import com.faw.hongqi.model.HotWord;
import com.faw.hongqi.model.NewsModel_Table;
import com.raizlabs.android.dbflow.sql.language.property.IntProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wyc on 17/3/1.
 */

public class Constant {
//        public final static String BASE_URL = "http://www.haoweisys.com/";
    public final static String BASE_URL = "http://www.e-guides.faw.cn/";
        public static String CAR_TYPE = "C229";//车型
//    public static String CAR_TYPE = "E115";//车型
//    public static String CAR_TYPE = "C235";//车型
    public static String INTPROPERTY_TYPE = "c229_1";//车型配置
    public static String TRIM_WEB_URL = "";//内饰360webview地址
    public static String GAME_WEB_URL = "";//互动游戏webview地址
    public static String ZIP_VERSION = "";//36张图资源包版本
    public static String ZIP_URL = "";//36张图资源包下载地址
    public static String CAR_NAME = "";//车型名称
    public final static boolean IS_PHONE = true;//判断包是否是手机应用
    public final static boolean DEBUG = true;//是否是调试包
    public final static boolean TEST = true;//是否是不带资源的测试包
    private static Map<String, IntProperty> intPropertyList = new HashMap<>();


    public static void initData() {
        intPropertyList.put("C229_1", NewsModel_Table.sdss);
        intPropertyList.put("C229_2", NewsModel_Table.sdhh);
        intPropertyList.put("C229_3", NewsModel_Table.sdzg);
        intPropertyList.put("C229_4", NewsModel_Table.zdss);
        intPropertyList.put("C229_5", NewsModel_Table.zdhh);
        intPropertyList.put("C229_6", NewsModel_Table.zdzg);
        intPropertyList.put("C229_7", NewsModel_Table.zdqj);
    }

    public static IntProperty getCurrentIntProperty(Context context) {
        String modle = SharedpreferencesUtil.getCarModel(context);
        return intPropertyList.get(modle);
    }

    public static void initHotWord() {
        HotWord hotWord1 = new HotWord();
        hotWord1.setWord("爆胎");
        hotWord1.save();

        HotWord hotWord2 = new HotWord();
        hotWord2.setWord("雾灯");
        hotWord2.save();

        HotWord hotWord3 = new HotWord();
        hotWord3.setWord("安全带");
        hotWord3.save();

        HotWord hotWord4 = new HotWord();
        hotWord4.setWord("方向盘");
        hotWord4.save();
    }
}