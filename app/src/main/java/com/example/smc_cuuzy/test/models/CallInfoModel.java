package com.example.smc_cuuzy.test.models;

public class CallInfoModel {
    private String date;
    private String typeText, type;
    private int icon;
    private int id;

    public CallInfoModel(String type, String typeText, String date) {
        this.type = type;
        this.typeText = typeText;
        this.date = date;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public int getIcon() {
        return icon;
    }

    public void setPicture(int icon) {
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}