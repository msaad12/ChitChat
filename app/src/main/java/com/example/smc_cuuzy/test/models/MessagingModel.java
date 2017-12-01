package com.example.smc_cuuzy.test.models;

/**
 * Created by madhur on 17/01/15.
 */
public class MessagingModel {

    private String message;
    private boolean sender = true;
    private MessageStatus messageStatus;
    private String date;

    public MessagingModel(String message, String date) {
        this.message = message;
        this.date = date;
    }

    public String getTime() {
        return date;
    }

    public void setTime(String date) {
        this.date = date;
    }

    public void setMessageText(String message) {
        this.message = message;
    }

    public void setUserType(boolean userType) {
        this.sender = userType;
    }

    public void setMessageStatus(MessageStatus messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getMessageText() {

        return message;
    }

    public boolean getUserType() {
        return sender;
    }

    public MessageStatus getMessageStatus() {
        return messageStatus;
    }
}
