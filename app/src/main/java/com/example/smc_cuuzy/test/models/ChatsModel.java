package com.example.smc_cuuzy.test.models;

import java.io.Serializable;

/**
 * Created by Jaccuzzi on 15/03/2016.
 */
public class ChatsModel implements Serializable {

    private String date;
    private String message;
    private String username;
    private String newCount;
    private int picture;
    private int id;
    private int group;

    public ChatsModel(int picture, String username, String date, String message) {
        this.picture = picture;
        this.username = username;
        this.date = date;
        this.message = message;
    }

    public ChatsModel(int picture, String username, String date, String message, String count) {
        this.picture = picture;
        this.username = username;
        this.date = date;
        this.message = message;
        this.newCount = count;
        this.group = group;
    }

    public ChatsModel(int picture, String username, String date, String message, String count, int group) {
        this.picture = picture;
        this.username = username;
        this.date = date;
        this.message = message;
        this.newCount = count;
        this.group = group;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNewCount() {
        return newCount;
    }

    public void setNewCount(String newCount) {
        this.newCount = newCount;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public int getGroup() {
        return group;
    }
    public void setMessage(int group) {
        this.group = group;
    }
}
