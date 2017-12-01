package com.example.smc_cuuzy.test.models;

import java.io.Serializable;

/**
 * Created by Jaccuzzi on 15/03/2016.
 */

public class UsersModel implements Serializable {

    public UsersModel(int picture) {
        this.picture = picture;
    }

    private String about;
    private String username;
    private int picture;
    private int id;

    public UsersModel(int picture, String username, String about) {
        this.picture = picture;
        this.username = username;
        this.about = about;
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

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
