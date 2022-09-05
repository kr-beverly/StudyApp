package com.example.myapplication_study;

public class ManagerUsermanList {

    String name;
    String user_id;
    String user_pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }


    public ManagerUsermanList(String name, String user_id, String user_pass) {
        this.name = name;
        this.user_id = user_id;
        this.user_pass = user_pass;
    }
}
