package com.example.helloretrofit.Entity;

/**
 * Created by Administrator on 2017/3/8.
 */
public class News {
    /**
     * ctime : 2017-03-03 11:07
     * title : 台湾通缉犯遭警方盘查谎报身份 母亲：你别演了
     * description : 搜狐社会
     * picUrl :
     * url : http://news.sohu.com/20170303/n482240919.shtml
     */

    private String ctime;
    private String title;
    private String description;
    private String picUrl;
    private String url;

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
