package com.faw.hongqi.bean;

public class Over_Bean {
    String name;
    String image_o;
    String image_u;
    boolean isup;
    String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isIsup() {
        return isup;
    }

    public void setIsup(boolean isup) {
        this.isup = isup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_o() {
        return image_o;
    }

    public void setImage_o(String image_o) {
        this.image_o = image_o;
    }

    public String getImage_u() {
        return image_u;
    }

    public void setImage_u(String image_u) {
        this.image_u = image_u;
    }

    @Override
    public String toString() {
        return "Over_Bean{" +
                "name='" + name + '\'' +
                ", image_o='" + image_o + '\'' +
                ", image_u='" + image_u + '\'' +
                ", isup=" + isup +
                ", info='" + info + '\'' +
                '}';
    }
}
