package com.example.smc_cuuzy.test.models;

import java.io.Serializable;

/**
 * Created by Jaccuzzi on 15/03/2016.
 */
public class CallsModel implements Serializable {

    private String date;
    private String username;
    private int picture, icon;
    private String incoming, outgoing;
    private int id;

    public CallsModel(int picture, String username, String date, String type, int icon) {
        this.picture = picture;
        this.username = username;
        this.date = date;
        this.incoming = type;
        this.icon = icon;
    }

    public CallsModel(int picture, String username, String date, int icon) {
        this.picture = picture;
        this.username = username;
        this.date = date;
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIncoming() {
        return incoming;
    }

    public void setIncoming(String incoming) {
        this.incoming = incoming;
    }

    public String getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(String outgoing) {
        this.outgoing = outgoing;
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

}
