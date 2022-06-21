package com.faw.hongqi.model;

import java.io.Serializable;
import java.util.List;

public class VersionUpdateModel extends BaseModel implements Serializable {
    private String car_name;
    private String category_url;
    private String news_url;
    private String zip_url;
    private String version;
    private String game_web_url;
    private String trim_web_url;
    private List<TypeList> type_list;

    public List<TypeList> getType_list() {
        return type_list;
    }

    public void setType_list(List<TypeList> type_list) {
        this.type_list = type_list;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getCategory_url() {
        return category_url;
    }

    public void setCategory_url(String category_url) {
        this.category_url = category_url;
    }

    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }

    public String getZip_url() {
        return zip_url;
    }

    public void setZip_url(String zip_url) {
        this.zip_url = zip_url;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGame_web_url() {
        return game_web_url;
    }

    public void setGame_web_url(String game_web_url) {
        this.game_web_url = game_web_url;
    }

    public String getTrim_web_url() {
        return trim_web_url;
    }

    public void setTrim_web_url(String trim_web_url) {
        this.trim_web_url = trim_web_url;
    }



    public class TypeList implements Serializable{
        private String content_id;
        private String content_desc;

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getContent_desc() {
            return content_desc;
        }

        public void setContent_desc(String content_desc) {
            this.content_desc = content_desc;
        }

        @Override
        public String toString() {
            return "TypeList{" +
                    "content_id='" + content_id + '\'' +
                    ", content_desc='" + content_desc + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "VersionUpdateModel{" +
                "car_name='" + car_name + '\'' +
                ", category_url='" + category_url + '\'' +
                ", news_url='" + news_url + '\'' +
                ", zip_url='" + zip_url + '\'' +
                ", version='" + version + '\'' +
                ", game_web_url='" + game_web_url + '\'' +
                ", trim_web_url='" + trim_web_url + '\'' +
                ", type_list=" + type_list +
                '}';
    }
}

