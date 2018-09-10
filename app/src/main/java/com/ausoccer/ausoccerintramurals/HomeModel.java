package com.ausoccer.ausoccerintramurals;

/**
 * Created by Kevin Daniel on 8/12/2018.
 */

public class HomeModel {
    String title;
    String url;
    String uid;
    Long time;

    public HomeModel() {

    }

    public HomeModel(String title, String url, String uid, Long time) {
        this.title = title;
        this.url = url;
        this.uid = uid;
        this.time = time;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
