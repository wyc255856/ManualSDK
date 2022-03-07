package com.faw.hongqi.model;


import java.io.Serializable;

public class HotWord extends BaseModel implements Serializable {
    private int id;
    private String word;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
