package com.faw.hongqi.model;


import java.util.List;

public class NewsListModel extends BaseModel {
    private List<NewsModel> RECORDS;

    public List<NewsModel> getRECORDS() {
        return RECORDS;
    }

    public void setRECORDS(List<NewsModel> RECORDS) {
        this.RECORDS = RECORDS;
    }
}
