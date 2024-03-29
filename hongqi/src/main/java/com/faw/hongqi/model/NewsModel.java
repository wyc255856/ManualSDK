package com.faw.hongqi.model;
/**
 * Copyright 2019 aTool.org
 */

import com.faw.hongqi.dbutil.CarDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;


/**
 * Auto-generated: 2019-11-20 17:21:52
 *
 * @author aTool.org (i@aTool.org)
 * @website http://www.atool9.com/json2javabean.php
 */
@Table(database = CarDatabase.class)
public class NewsModel extends BaseModel implements Serializable {

    @PrimaryKey(autoincrement = true)
    private int newsid;
    @Column
    private String id;

    @Column
    private int catid;
    @Column
    private String title;
    @Column
    private String style;
    @Column
    private String thumb;
    @Column
    private String keywords;
    @Column
    private String description;
    @Column
    private String content;
    @Column
    private String url;
    @Column
    private int listorder;
    @Column
    private int status;
    @Column
    private int islink;
    @Column
    private String username;
    @Column
    private int inputtime;
    @Column
    private int updatetime;
    @Column
    private String head_image;
    @Column
    private String image;
    @Column
    private String image1;
    @Column
    private String image2;
    @Column
    private String image3;
    @Column
    private String image4;
    @Column
    private int template;
    @Column
    private String video;
    @Column
    private int template1;

    public int getTemplate1() {
        return template1;
    }

    @Column
    private int template2;
    @Column
    private int template3;
    @Column
    private int template4;
    @Column
    private String video1;
    @Column
    private String video2;
    @Column
    private String video3;
    @Column
    private String video4;
    @Column
    private String content1_app;
    @Column
    private String content2_app;
    @Column
    private String content3_app;
    @Column
    private String content4_app;
    @Column
    private String content5_app;
    @Column
    private String content6_app;
    @Column
    private String content7_app;
    @Column
    private String content8_app;
    @Column
    private String content9_app;
    @Column
    private String content10_app;
    @Column
    private String content1;
    @Column
    private String content2;
    @Column
    private String content3;
    @Column
    private String content4;
    @Column
    private String image5;
    @Column
    private String image6;
    @Column
    private String image7;
    @Column
    private String image8;
    @Column
    private String image9;
    @Column
    private String image10;
    @Column
    private String content5;
    @Column
    private String content6;
    @Column
    private String content7;
    @Column
    private String content8;
    @Column
    private String content9;
    @Column
    private String content10;
    @Column
    private String video5;
    @Column
    private String video6;
    @Column
    private String video7;
    @Column
    private String video8;
    @Column
    private String video9;
    @Column
    private String video10;
    @Column
    private int template5;
    @Column
    private int template6;
    @Column
    private int template7;
    @Column
    private int template8;
    @Column
    private int template9;
    @Column
    private int template10;
    @Column
    private int sdss;
    @Column
    private int sdhh;
    @Column
    private int sdzg;
    @Column
    private int zdss;
    @Column
    private int zdhh;
    @Column
    private int zdzg;
    @Column
    private int zdqj;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNewsid() {
        return newsid;
    }
    public int getCatid() {
        return catid;
    }

    public void setCatid(int catid) {
        this.catid = catid;
    }
    public String getHead_image() {
        return head_image;
    }

    public void setHead_image(String head_image) {
        this.head_image = head_image;
    }

    public void setNewsid(int newsid) {
        this.newsid = newsid;
    }

    public String getContent1_app() {
        return content1_app;
    }

    public void setContent1_app(String content1_app) {
        this.content1_app = content1_app;
    }

    public String getContent2_app() {
        return content2_app;
    }

    public void setContent2_app(String content2_app) {
        this.content2_app = content2_app;
    }

    public String getContent3_app() {
        return content3_app;
    }

    public void setContent3_app(String content3_app) {
        this.content3_app = content3_app;
    }

    public String getContent4_app() {
        return content4_app;
    }

    public void setContent4_app(String content4_app) {
        this.content4_app = content4_app;
    }

    public String getContent5_app() {
        return content5_app;
    }

    public void setContent5_app(String content5_app) {
        this.content5_app = content5_app;
    }

    public String getContent6_app() {
        return content6_app;
    }

    public void setContent6_app(String content6_app) {
        this.content6_app = content6_app;
    }

    public String getContent7_app() {
        return content7_app;
    }

    public void setContent7_app(String content7_app) {
        this.content7_app = content7_app;
    }

    public String getContent8_app() {
        return content8_app;
    }

    public void setContent8_app(String content8_app) {
        this.content8_app = content8_app;
    }

    public String getContent9_app() {
        return content9_app;
    }

    public void setContent9_app(String content9_app) {
        this.content9_app = content9_app;
    }

    public String getContent10_app() {
        return content10_app;
    }

    public void setContent10_app(String content10_app) {
        this.content10_app = content10_app;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setStyle(String style) {
        this.style = style;
    }
    public String getStyle() {
        return style;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    public String getThumb() {
        return thumb;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
    public String getKeywords() {
        return keywords;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setListorder(int listorder) {
        this.listorder = listorder;
    }
    public int getListorder() {
        return listorder;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public int getStatus() {
        return status;
    }

    public void setIslink(int islink) {
        this.islink = islink;
    }
    public int getIslink() {
        return islink;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setInputtime(int inputtime) {
        this.inputtime = inputtime;
    }
    public int getInputtime() {
        return inputtime;
    }

    public void setUpdatetime(int updatetime) {
        this.updatetime = updatetime;
    }
    public int getUpdatetime() {
        return updatetime;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }
    public String getImage1() {
        return image1;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }
    public String getImage2() {
        return image2;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }
    public String getImage3() {
        return image3;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }
    public String getImage4() {
        return image4;
    }

    public void setTemplate(int template) {
        this.template = template;
    }
    public int getTemplate() {
        return template;
    }

    public void setVideo(String video) {
        this.video = video;
    }
    public String getVideo() {
        return video;
    }

    public void setTemplate1(int template1) {
        this.template1 = template1;
    }

    public void setTemplate2(int template2) {
        this.template2 = template2;
    }
    public int getTemplate2() {
        return template2;
    }

    public void setTemplate3(int template3) {
        this.template3 = template3;
    }
    public int getTemplate3() {
        return template3;
    }

    public void setTemplate4(int template4) {
        this.template4 = template4;
    }
    public int getTemplate4() {
        return template4;
    }

    public void setVideo1(String video1) {
        this.video1 = video1;
    }
    public String getVideo1() {
        return video1;
    }

    public void setVideo2(String video2) {
        this.video2 = video2;
    }
    public String getVideo2() {
        return video2;
    }

    public void setVideo3(String video3) {
        this.video3 = video3;
    }
    public String getVideo3() {
        return video3;
    }

    public void setVideo4(String video4) {
        this.video4 = video4;
    }
    public String getVideo4() {
        return video4;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }
    public String getContent1() {
        return content1;
    }

    public void setContent2(String content2) {
        this.content2 = content2;
    }
    public String getContent2() {
        return content2;
    }

    public void setContent3(String content3) {
        this.content3 = content3;
    }
    public String getContent3() {
        return content3;
    }

    public void setContent4(String content4) {
        this.content4 = content4;
    }
    public String getContent4() {
        return content4;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }
    public String getImage5() {
        return image5;
    }

    public void setImage6(String image6) {
        this.image6 = image6;
    }
    public String getImage6() {
        return image6;
    }

    public void setImage7(String image7) {
        this.image7 = image7;
    }
    public String getImage7() {
        return image7;
    }

    public void setImage8(String image8) {
        this.image8 = image8;
    }
    public String getImage8() {
        return image8;
    }

    public void setImage9(String image9) {
        this.image9 = image9;
    }
    public String getImage9() {
        return image9;
    }

    public void setImage10(String image10) {
        this.image10 = image10;
    }
    public String getImage10() {
        return image10;
    }

    public void setContent5(String content5) {
        this.content5 = content5;
    }
    public String getContent5() {
        return content5;
    }

    public void setContent6(String content6) {
        this.content6 = content6;
    }
    public String getContent6() {
        return content6;
    }

    public void setContent7(String content7) {
        this.content7 = content7;
    }
    public String getContent7() {
        return content7;
    }

    public void setContent8(String content8) {
        this.content8 = content8;
    }
    public String getContent8() {
        return content8;
    }

    public void setContent9(String content9) {
        this.content9 = content9;
    }
    public String getContent9() {
        return content9;
    }

    public void setContent10(String content10) {
        this.content10 = content10;
    }
    public String getContent10() {
        return content10;
    }

    public void setVideo5(String video5) {
        this.video5 = video5;
    }
    public String getVideo5() {
        return video5;
    }

    public void setVideo6(String video6) {
        this.video6 = video6;
    }
    public String getVideo6() {
        return video6;
    }

    public void setVideo7(String video7) {
        this.video7 = video7;
    }
    public String getVideo7() {
        return video7;
    }

    public void setVideo8(String video8) {
        this.video8 = video8;
    }
    public String getVideo8() {
        return video8;
    }

    public void setVideo9(String video9) {
        this.video9 = video9;
    }
    public String getVideo9() {
        return video9;
    }

    public void setVideo10(String video10) {
        this.video10 = video10;
    }
    public String getVideo10() {
        return video10;
    }

    public void setTemplate5(int template5) {
        this.template5 = template5;
    }
    public int getTemplate5() {
        return template5;
    }

    public void setTemplate6(int template6) {
        this.template6 = template6;
    }
    public int getTemplate6() {
        return template6;
    }

    public void setTemplate7(int template7) {
        this.template7 = template7;
    }
    public int getTemplate7() {
        return template7;
    }

    public void setTemplate8(int template8) {
        this.template8 = template8;
    }
    public int getTemplate8() {
        return template8;
    }

    public void setTemplate9(int template9) {
        this.template9 = template9;
    }
    public int getTemplate9() {
        return template9;
    }

    public void setTemplate10(int template10) {
        this.template10 = template10;
    }
    public int getTemplate10() {
        return template10;
    }

    public void setSdss(int sdss) {
        this.sdss = sdss;
    }
    public int getSdss() {
        return sdss;
    }

    public void setSdhh(int sdhh) {
        this.sdhh = sdhh;
    }
    public int getSdhh() {
        return sdhh;
    }

    public void setSdzg(int sdzg) {
        this.sdzg = sdzg;
    }
    public int getSdzg() {
        return sdzg;
    }

    public void setZdss(int zdss) {
        this.zdss = zdss;
    }
    public int getZdss() {
        return zdss;
    }

    public void setZdhh(int zdhh) {
        this.zdhh = zdhh;
    }
    public int getZdhh() {
        return zdhh;
    }

    public void setZdzg(int zdzg) {
        this.zdzg = zdzg;
    }
    public int getZdzg() {
        return zdzg;
    }

    public void setZdqj(int zdqj) {
        this.zdqj = zdqj;
    }
    public int getZdqj() {
        return zdqj;
    }

    @Override
    public String toString() {
        return "NewsModel{" +
                "newsid=" + newsid +
                ", id='" + id + '\'' +
                ", catid=" + catid +
                ", title='" + title + '\'' +
                ", style='" + style + '\'' +
                ", thumb='" + thumb + '\'' +
                ", keywords='" + keywords + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", url='" + url + '\'' +
                ", listorder=" + listorder +
                ", status=" + status +
                ", islink=" + islink +
                ", username='" + username + '\'' +
                ", inputtime=" + inputtime +
                ", updatetime=" + updatetime +
                ", head_image='" + head_image + '\'' +
                ", image='" + image + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                ", image4='" + image4 + '\'' +
                ", template=" + template +
                ", video='" + video + '\'' +
                ", template1=" + template1 +
                ", template2=" + template2 +
                ", template3=" + template3 +
                ", template4=" + template4 +
                ", video1='" + video1 + '\'' +
                ", video2='" + video2 + '\'' +
                ", video3='" + video3 + '\'' +
                ", video4='" + video4 + '\'' +
                ", content1_app='" + content1_app + '\'' +
                ", content2_app='" + content2_app + '\'' +
                ", content3_app='" + content3_app + '\'' +
                ", content4_app='" + content4_app + '\'' +
                ", content5_app='" + content5_app + '\'' +
                ", content6_app='" + content6_app + '\'' +
                ", content7_app='" + content7_app + '\'' +
                ", content8_app='" + content8_app + '\'' +
                ", content9_app='" + content9_app + '\'' +
                ", content10_app='" + content10_app + '\'' +
                ", content1='" + content1 + '\'' +
                ", content2='" + content2 + '\'' +
                ", content3='" + content3 + '\'' +
                ", content4='" + content4 + '\'' +
                ", image5='" + image5 + '\'' +
                ", image6='" + image6 + '\'' +
                ", image7='" + image7 + '\'' +
                ", image8='" + image8 + '\'' +
                ", image9='" + image9 + '\'' +
                ", image10='" + image10 + '\'' +
                ", content5='" + content5 + '\'' +
                ", content6='" + content6 + '\'' +
                ", content7='" + content7 + '\'' +
                ", content8='" + content8 + '\'' +
                ", content9='" + content9 + '\'' +
                ", content10='" + content10 + '\'' +
                ", video5='" + video5 + '\'' +
                ", video6='" + video6 + '\'' +
                ", video7='" + video7 + '\'' +
                ", video8='" + video8 + '\'' +
                ", video9='" + video9 + '\'' +
                ", video10='" + video10 + '\'' +
                ", template5=" + template5 +
                ", template6=" + template6 +
                ", template7=" + template7 +
                ", template8=" + template8 +
                ", template9=" + template9 +
                ", template10=" + template10 +
                ", sdss=" + sdss +
                ", sdhh=" + sdhh +
                ", sdzg=" + sdzg +
                ", zdss=" + zdss +
                ", zdhh=" + zdhh +
                ", zdzg=" + zdzg +
                ", zdqj=" + zdqj +
                '}';
    }
}