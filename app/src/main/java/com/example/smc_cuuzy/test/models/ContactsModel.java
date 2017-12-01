package com.example.smc_cuuzy.test.models;

import java.io.Serializable;

/**
 * Created by Jaccuzzi on 15/03/2016.
 */
public class ContactsModel implements Serializable {

    public ContactsModel(int picture, String username, String about, String mobile) {
        this.picture = picture;
        this.username = username;
        this.mobile = mobile;
        this.about = about;
    }

    public ContactsModel(int picture, String username, String message, int invite) {
        this.picture = picture;
        this.username = username;
        this.invite = invite;
        this.about = message;
    }

    public ContactsModel(int picture, String username, String message) {
        this.picture = picture;
        this.username = username;
        this.about = message;
    }

    private int invite;
    private String mobile;
    private String about;
    private String username;
    private int picture;
    private int id;
    boolean selected;

    public boolean isSelected() {
        return selected;
    }
    public void setSelected(boolean selected) {
        this.selected = selected;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getInvite() {
        return invite;
    }

    public void setInvite(int invite) {
        this.invite = invite;
    }

    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
}
