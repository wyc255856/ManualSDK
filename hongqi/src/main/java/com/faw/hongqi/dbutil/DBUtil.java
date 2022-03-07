package com.faw.hongqi.dbutil;

import android.content.Context;
import android.text.TextUtils;

import com.faw.hongqi.model.CategoryListModel;
import com.faw.hongqi.model.CategoryModel;
import com.faw.hongqi.model.NewsListModel;
import com.faw.hongqi.model.NewsModel;
import com.faw.hongqi.util.Constant;
import com.faw.hongqi.util.LogUtil;

import com.faw.hongqi.util.TestUtil;
import com.google.gson.Gson;
import com.liulishuo.filedownloader.util.FileDownloadUtils;


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class DBUtil {
    private static DBUtil instance = new DBUtil();
    public  List<NewsModel> newsList = new ArrayList<>();
    public  List<CategoryModel> categoryList = new ArrayList<>();

    private DBUtil() {
    }

    public static DBUtil getInstance() {
        return instance;
    }

    public void initData(final Context context) {


        Constant.initHotWord();

        newsList = getList(context);
        categoryList = getCategoryList(context);

    }

    //new
    private static List<NewsModel> getList(Context context) {
        String json = TestUtil.readTextFile(context, FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + "/news.json");
        LogUtil.logError("news json" + json);
        LogUtil.logError("++++++++++++++++" + json.length());
        LogUtil.logError("path = " + FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + "/news.json");

        NewsListModel menuListModel = new Gson().fromJson(json, NewsListModel.class);
        if (menuListModel != null) {
            LogUtil.logError("数据长度" + menuListModel.getRECORDS().size());
            return menuListModel.getRECORDS();
        }
        return null;
    }

    //categroy
    private static List<CategoryModel> getCategoryList(Context context) {
        String json = TestUtil.readTextFile(context, FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + "/category.json");
        LogUtil.logError("Category json" + json);
        LogUtil.logError("path = " + FileDownloadUtils.getDefaultSaveRootPath() + File.separator + "horizon"
                + File.separator + "MyFolder" + "/category.json");
        CategoryListModel menuListModel = new Gson().fromJson(json, CategoryListModel.class);
        if (menuListModel != null) {
            LogUtil.logError("数据长度" + menuListModel.getRECORDS().size());
            return menuListModel.getRECORDS();
        }
        return null;
    }

    public NewsModel getNewsListById(String id) {
        LogUtil.logError("fast id = " + id);
        NewsModel newsModel = null;
        for (int i = 0; i < newsList.size(); i++) {
            newsModel = newsList.get(i);
            if (id.equals(newsModel.getId())) {
                break;
            }
        }
        return newsModel;
    }

    public List<CategoryModel> getFastCategoryList(Context context) {
        int id = 0;
        if (Constant.CAR_NAME.equals("e115")) {
            id = 17;
        } else if (Constant.CAR_NAME.equals("c229")) {
            id = 1869;
        } else if (Constant.CAR_NAME.equals("c235")) {
            id = 1869;
        }
        List<CategoryModel> resultList = new ArrayList<>();
        LogUtil.logError("categoryModel 1 = " + categoryList.size());
        for (int i = 0; i < categoryList.size(); i++) {
            CategoryModel categoryModel = categoryList.get(i);
            if (id == categoryModel.getParentid()) {
                resultList.add(categoryModel);
            }
        }
        Collections.sort(resultList);
        return resultList;

    }

    public List<CategoryModel> getManuaCategoryList(Context context) {
        int id = 0;
        if (Constant.CAR_NAME.equals("e115")) {
            id = 1;
        } else if (Constant.CAR_NAME.equals("c229")) {
            id = 1855;
        } else if (Constant.CAR_NAME.equals("c235")) {
            id = 1855;
        }
        List<CategoryModel> resultList = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            CategoryModel categoryModel = categoryList.get(i);
            if (id == categoryModel.getParentid()) {
                resultList.add(categoryModel);
            }


        }
        Collections.sort(resultList);
        return resultList;
//        SQLite.select()
//                .from(CategoryModel.class)
//                .where(CategoryModel_Table.parentid.eq(1855))
////                .where()
//
//                .async().queryList(transactionListener);
    }


    public CategoryModel getCatgoryByCatid(String catid) {
        CategoryModel categoryModel = null;
        for (int i = 0; i < categoryList.size(); i++) {
            categoryModel = categoryList.get(i);
            if (catid.equals(categoryModel.getCatid())) {
                break;
            }
        }
        return categoryModel;

    }

    public List<NewsModel> getNewsListByCatId(Context context, String catid) {

        List<NewsModel> resultList = new ArrayList<>();
        for (int i = 0; i < newsList.size(); i++) {
            NewsModel newsModel = newsList.get(i);
            LogUtil.logError(" catid = " + catid + "     item catid = " + newsModel.getCatid());
            LogUtil.logError("#######" + (isCurrentModel(context, newsModel)));
            if (catid.equals(newsModel.getCatid()) && isCurrentModel(context, newsModel)) {
                resultList.add(newsModel);
            }
//                if (catid.equals(newsModel.getCatid())) {
//                    resultList.add(newsModel);
//                }

        }
        return resultList;
    }

    private boolean isCurrentModel(Context context, NewsModel newsModel) {

        int code = -1;
        if (Constant.getCurrentIntProperty(context).equals("sdss")) {
            code = newsModel.getSdss();
        } else if (Constant.getCurrentIntProperty(context).equals("sdhh")) {
            code = newsModel.getSdhh();
        } else if (Constant.getCurrentIntProperty(context).equals("sdzg")) {
            code = newsModel.getSdzg();
        } else if (Constant.getCurrentIntProperty(context).equals("zdss")) {
            code = newsModel.getZdss();
        } else if (Constant.getCurrentIntProperty(context).equals("zdhh")) {
            code = newsModel.getZdhh();
        } else if (Constant.getCurrentIntProperty(context).equals("zdzg")) {
            code = newsModel.getZdzg();
        } else if (Constant.getCurrentIntProperty(context).equals("zdqj")) {
            code = newsModel.getZdqj();
        }
        return code == 1;
    }
//    private String getName(IntProperty intProperty){
//        if(intProperty!=null){
//return intProperty.getNameAlias().getName();
//        }else {
//            return "";
//        }
//    }

    public List<NewsModel> searchByWord(Context context, String word) {
//        SQLite.select()
//                .from(NewsModel.class)
//                .where(NewsModel_Table.title.like("%" + word + "%"))
//                .and(Constant.getCurrentIntProperty(context).eq(1))
//                .async().queryList(transactionListener);
        List<NewsModel> resultList = new ArrayList<>();
        if (TextUtils.isEmpty(word)) {
            return resultList;
        }
        for (int i = 0; i < newsList.size(); i++) {
            NewsModel newsModel = newsList.get(i);
            if (newsModel.getTitle().contains(word) && isCurrentModel(context, newsModel)) {
                resultList.add(newsModel);
            }
//                if (newsModel.getTitle().contains(word)) {
//                    resultList.add(newsModel);
//                }

        }
        HashMap<String, String> hashMap = new HashMap<>();
        List<NewsModel> newResultList = new ArrayList<>();
        for (NewsModel newsModel : resultList) {
            String title = newsModel.getTitle();
            if (hashMap.containsKey(title)) {

            } else {
                hashMap.put(title, "");
                newResultList.add(newsModel);
            }

        }

        return newResultList;

    }

//    public static void getHotWordList(Context context, TransactionListener transactionListener) {
//        SQLite.select()
//                .from(HotWord.class)
//                .where()
//                .orderBy(HotWord_Table.id, false)
//                .limit(4)
//                .async().queryList(transactionListener);
//    }
//
//    public static void insertHotWord(final Context mContext, final String word) {
//
//        DBUtil.getHotWordList(mContext, new TransactionListener() {
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
//                List<HotWord> list = new ArrayList<>();
//                if (result != null)
//                    list = (List<HotWord>) result;
//
//
//                for (final HotWord hotWord : list) {
//                    if (hotWord.getWord().equals(word)) {
//                        hotWord.delete();
//                    }
//                }
//                HotWord hotWord = new HotWord();
//                hotWord.setWord(word);
//                hotWord.save();
//                return false;
//            }
//        });
//
//    }
}
