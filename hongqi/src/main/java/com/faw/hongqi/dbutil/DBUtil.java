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
import com.raizlabs.android.dbflow.runtime.TransactionManager;
import com.raizlabs.android.dbflow.runtime.transaction.BaseTransaction;
import com.raizlabs.android.dbflow.runtime.transaction.TransactionListener;
import com.raizlabs.android.dbflow.runtime.transaction.process.ProcessModelInfo;
import com.raizlabs.android.dbflow.runtime.transaction.process.SaveModelTransaction;
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
        TransactionManager.getInstance().addTransaction(new SaveModelTransaction<>(ProcessModelInfo.withModels(getList(context).getRECORDS())));
        LogUtil.logError("news表入库结束");
        LogUtil.logError("消耗了" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    private static void insertCategory(Context context) {
        long startTime = System.currentTimeMillis();
        LogUtil.logError("开始入库Category表");
        TransactionManager.getInstance().addTransaction(new SaveModelTransaction<>(ProcessModelInfo.withModels(getCategoryList(context).getRECORDS())));
        LogUtil.logError("Category表入库结束");
        LogUtil.logError("消耗了" + (System.currentTimeMillis() - startTime) + "毫秒");
    }

    public static void getAllNews(TransactionListener transactionListener) {
        SQLite.select()
                .from(NewsModel.class)
                .where()
                .async().queryList(transactionListener);
    }

    public static void getNewsListById(Context context, String id, TransactionListener transactionListener) {
        LogUtil.logError("fast id = " + id);
        SQLite.select()
                .from(NewsModel.class)

                .where(NewsModel_Table.id.eq(id))
                .and(Constant.getCurrentIntProperty(context).eq(1))

                .async().queryList(transactionListener);
    }

    public static void getFastCategoryList(TransactionListener transactionListener) {
        int id = 0;
        if (Constant.CAR_NAME.equals("e115")){
            id = 17;
        }else if (Constant.CAR_NAME.equals("c229")){
            id = 1869;
        }
        SQLite.select()
                .from(CategoryModel.class)
                .where(CategoryModel_Table.parentid.eq(id))
//                .where()
                .async().queryList(transactionListener);
    }

    public static void getManuaCategoryList(TransactionListener transactionListener) {
        int id = 0;
        if (Constant.CAR_NAME.equals("e115")){
            id = 1;
        }else if (Constant.CAR_NAME.equals("c229")){
            id = 1855;
        }
        SQLite.select()
                .from(CategoryModel.class)
                .where(CategoryModel_Table.parentid.eq(id))
//                .where()
                .async().queryList(transactionListener);
    }

    public static void getNewsListByCatId(Context context, int catid, TransactionListener transactionListener) {
        LogUtil.logError("fast catid = " + catid);
        SQLite.select()
                .from(NewsModel.class)
                .where(NewsModel_Table.catid.eq(catid))
//                .where()
                .and(Constant.getCurrentIntProperty(context).eq(1))

                .async().queryList(transactionListener);
    }

    public static void searchByWord(Context context, String word, TransactionListener transactionListener) {
        SQLite.select()
                .from(NewsModel.class)
                .where(NewsModel_Table.title.like("%" + word + "%"))
                .and(Constant.getCurrentIntProperty(context).eq(1))

                .async().queryList(transactionListener);



        //        SQLite.select(NewsModel_Table.caid, CategoryModel_Table.catid)
//                .from(NewsModel.class)
//                .leftOuterJoin(CategoryModel.class)
//                .on(NewsModel_Table.caid.withTable().eq(CategoryModel_Table.catid.withTable())).where(CategoryModel_Table.parentid.eq(1855)).and(NewsModel_Table.title.like(word))
//                .async().queryList(transactionListener);
    }

    public static void getHotWordList(Context context, TransactionListener transactionListener) {
        SQLite.select()
                .from(HotWord.class)
                .where()
                .orderBy(HotWord_Table.id, false)
                .limit(4)
                .async().queryList(transactionListener);
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
