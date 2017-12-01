package com.example.smc_cuuzy.test.models;

public class AboutModel {

    public AboutModel(String title) {
        this.title = title;
    }

    private String title, text;

    public AboutModel(String title, String text) {
        this.title = title;
        this.text = text;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubText() {
        return text;
    }

    public void setSubText(String text) {
        this.text = text;
    }

}