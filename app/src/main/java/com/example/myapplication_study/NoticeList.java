package com.example.myapplication_study;

public class NoticeList {

    String writ_num, writ_title;

    public NoticeList() {
    }

    public NoticeList(String writ_num, String writ_title) {
        this.writ_num = writ_num;
        this.writ_title = writ_title;
    }

    public String getWrit_num() {
        return writ_num;
    }

    public void setWrit_num(String writ_num) {
        this.writ_num = writ_num;
    }

    public String getWrit_title() {
        return writ_title;
    }

    public void setWrit_title(String writ_title) {
        this.writ_title = writ_title;
    }
}
