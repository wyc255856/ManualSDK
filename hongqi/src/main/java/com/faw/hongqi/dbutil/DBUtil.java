package com.faw.hongqi.dbutil;

import android.content.Context;

import com.faw.hongqi.R;
import com.faw.hongqi.model.CategoryListModel;
import com.faw.hongqi.model.CategoryModel;
import com.faw.hongqi.model.CategoryModel_Table;
import com.faw.hongqi.model.HotWord;
import com.faw.hongqi.model.HotWord_Table;
import com.faw.hongqi.model.NewsListModel;
import com.faw.hongqi.model.NewsModel;
import com.faw.hongqi.model.NewsModel_Table;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.LogUtil;
import com.faw.hongqi.util.SharedpreferencesUtil;
import com.faw.hongqi.util.TestUtil;
import com.google.gson.Gson;
import com.liulishuo.filedownloader.util.FileDownloadUtils;
import com.raizlabs.android.dbflow.sql.language.Delete;
import com.raizlabs.android.dbflow.sql.language.Join;
import com.raizlabs.android.dbflow.sql.language.NameAlias;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.io.File;
import java.util.List;

public class DBUtil {

    public static void initData(final Context context, final String tag) {

        new Thread() {
            @Override
            public void run() {
                super.run();
//                    Delete.table(NewsModel.class);
//                    Delete.table(CategoryModel.class);
                Constant.initHotWord();
                if ("category".equals(tag)) {
                    //TODO 插入category
                    SQLite.delete(CategoryModel.class)
                            .where()
                            .async().execute();
                    insertCategory(context);
                } else if ("news".equals(tag)) {
                    //TODO 插入news
                    SQLite.delete(NewsModel.class)
                            .where()
                            .async().execute();
                    insertNews(context);

                } else {

                }


            }
        }.start();

    }

    /**
     * 获取w
     *
     * @return
     */
    private static NewsListModel getList(Context context) {
//        String json = TestUtil.readTextFileFromRawResourceId(context, R.raw.zy_news);
        String json = TestUtil.readTextFile(context, FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + "/news.json");
        LogUtil.logError("news json" + json);
        LogUtil.logError("++++++++++++++++" +  json.length());
        LogUtil.logError("path = " + FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + "/news.json");

        NewsListModel menuListModel = new Gson().fromJson(json, NewsListModel.class);
        if (menuListModel != null) {
            LogUtil.logError("数据长度" + menuListModel.getRECORDS().size());
            return menuListModel;
        }
        return null;
    }


    private static CategoryListModel getCategoryList(Context context) {
//        String json = TestUtil.readTextFileFromRawResourceId(context, R.raw.zy_category);

        String json = TestUtil.readTextFile(context, FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + "/category.json");
        LogUtil.logError("Category json" + json);
        LogUtil.logError("path = "+FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + "/category.json");
        CategoryListModel menuListModel = new Gson().fromJson(json, CategoryListModel.class);
        if (menuListModel != null) {
            LogUtil.logError("数据长度" + menuListModel.getRECORDS().size());
            return menuListModel;
        }
        return null;
    }

    private static void insertNews(Context context) {
        long startTime = System.currentTimeMillis();
        LogUtil.logError("开始入库news表");
        List<NewsModel> menuListModel = getList(context).getRECORDS();
        for (int i =0;i<menuListModel.size();i++){
            menuListModel.get(i).save();
        }
        LogUtil.logError("news表入库结束");
        LogUtil.logError("消耗了" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    private static void insertCategory(Context context) {
        long startTime = System.currentTimeMillis();
        LogUtil.logError("开始入库Category表");
        for (int i = 0;i<getCategoryList(context).getRECORDS().size();i++){

        }
        List<CategoryModel> menuListModel = getCategoryList(context).getRECORDS();
        for (int i =0;i<menuListModel.size();i++){
            menuListModel.get(i).save();
        }

        LogUtil.logError("Category表入库结束"+getCategoryList(context).getRECORDS());
        LogUtil.logError("消耗了" + (System.currentTimeMillis() - startTime) + "毫秒");
    }



    public static List<NewsModel> getNewsListById(Context context, String id) {
        LogUtil.logError("fast id = " + id);
//        SQLite.select()
//                .from(NewsModel.class)
//                .where(NewsModel_Table.id.eq(id))
//                .and(Constant.getCurrentIntProperty(context).eq(1))
//                .async().queryList(transactionListener);
        List<NewsModel> list = SQLite.select()
                .from(NewsModel.class)
                .where(NewsModel_Table.id.eq(id))
                .queryList();
        return list;
    }

    public static List<CategoryModel> getFastCategoryList() {
        int id = 0;
        if (Constant.CAR_NAME.equals("e115")){
            id = 17;
        }else if (Constant.CAR_NAME.equals("c229")){
            id = 1869;
        }else if (Constant.CAR_NAME.equals("c235")){
            id = 1869;
        }
//        SQLite.select()
//                .from(CategoryModel.class)
//                .where(CategoryModel_Table.parentid.eq(id))
////                .where()
//                .async().queryList(transactionListener);
        List<CategoryModel> list = SQLite.select()
                .from(CategoryModel.class)
                .where(CategoryModel_Table.parentid.eq(id))
                .queryList();
//        printData(list);
        return list;
    }

    public static List<CategoryModel> getManuaCategoryList() {
        int id = 0;
        if (Constant.CAR_NAME.equals("e115")){
            id = 1;
        }else if (Constant.CAR_NAME.equals("c229")){
            id = 1855;
        }
        else if (Constant.CAR_NAME.equals("c235")){
            id = 1855;
        }
        List<CategoryModel> list = SQLite.select()
                .from(CategoryModel.class)
                .where(CategoryModel_Table.parentid.eq(id))
                .queryList();
//        printData(list);
        return list;
    }

    public static List<NewsModel> getNewsListByCatId(Context context, int catid) {
        LogUtil.logError("fast catid = " + catid);
//        SQLite.select()
//                .from(NewsModel.class)
//                .where(NewsModel_Table.catid.eq(catid))
//                .and(Constant.getCurrentIntProperty(context).eq(1))
//                .async().queryList(transactionListener);
        List<NewsModel> list = SQLite.select()
                .from(NewsModel.class)
                .where(NewsModel_Table.catid.eq(catid))
                .and(Constant.getCurrentIntProperty(context).eq(1))
                .queryList();
//        printData(list);
        return list;
    }

    public static List<NewsModel> searchByWord(Context context, String word) {
//        SQLite.select()
//                .from(NewsModel.class)
//                .where(NewsModel_Table.title.like("%" + word + "%"))
//                .and(Constant.getCurrentIntProperty(context).eq(1))
//
//                .async().queryList(transactionListener);

        List<NewsModel> list = SQLite.select()
                .from(NewsModel.class)
                .where(NewsModel_Table.title.like("%" + word + "%"))
                .and(Constant.getCurrentIntProperty(context).eq(1))
                .queryList();
//        printData(list);
        return list;

        //        SQLite.select(NewsModel_Table.caid, CategoryModel_Table.catid)
//                .from(NewsModel.class)
//                .leftOuterJoin(CategoryModel.class)
//                .on(NewsModel_Table.caid.withTable().eq(CategoryModel_Table.catid.withTable())).where(CategoryModel_Table.parentid.eq(1855)).and(NewsModel_Table.title.like(word))
//                .async().queryList(transactionListener);
    }

    public static List<HotWord> getHotWordList(Context context) {
//        SQLite.select(HotWord_Table.word).distinct()
//                .from(HotWord.class)
//                .where()
//                .orderBy(HotWord_Table.id, false)
//                .limit(4)
//                .async().queryList(transactionListener);
        List<HotWord> list = SQLite.select(HotWord_Table.word).distinct()
                .from(HotWord.class)
                .where()
                .orderBy(HotWord_Table.id, false)
                .limit(4)
                .queryList();
//        printData(list);
        return list;
    }

//    public static NewsModel getTestModel(Context context) {
//        String json = TestUtil.readTextFileFromRawResourceId(context, R.raw.test);
//        NewsModel menuListModel = new Gson().fromJson(json, NewsModel.class);
//        if (menuListModel != null) {
//            return menuListModel;
//        }
//        return null;
//    }

    public static void insertHotWord(String word) {
        HotWord hotWord = new HotWord();
        hotWord.setWord(word);
        hotWord.save();
    }
}
