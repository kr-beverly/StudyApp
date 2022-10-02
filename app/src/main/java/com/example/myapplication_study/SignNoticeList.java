package com.example.myapplication_study;

public class SignNoticeList {
    String writ_num;
    String writ_title, writ_content, writ_date;

    public SignNoticeList() {
    }

    public SignNoticeList(String writ_num, String writ_title, String writ_content, String writ_date) {
        this.writ_num = writ_num;
        this.writ_title = writ_title;
        this.writ_content = writ_content;
        this.writ_date = writ_date;
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

    public String getWrit_content() {
        return writ_content;
    }

    public void setWrit_content(String writ_content) {
        this.writ_content = writ_content;
    }

    public String getWrit_date() {
        return writ_date;
    }

    public void setWrit_date(String writ_date) {
        this.writ_date = writ_date;
    }
}
