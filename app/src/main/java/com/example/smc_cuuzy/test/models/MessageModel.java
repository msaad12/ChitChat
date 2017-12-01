package com.example.smc_cuuzy.test.models;

/**
 * Created by Cuuzy on 12/3/2016.
 */

public class MessageModel {

    public static final int TYPE_MESSAGE = 0;
    public static final int TYPE_LOG = 1;
    public int conversationID;
    private int ownerID;
    private String message;
    private String Date;
    private String holderFullName;
    private String holderImage;
    private String holderUsername;

    private int mType;
    private String mMessage;

    public MessageModel() {}

    public int getType() {
        return mType;
    };

    public String getMessage() {
        return mMessage;
    };

    public int getConversationID() {
        return conversationID;
    }

    public void setConversationID(int conversationID) {
        this.conversationID = conversationID;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }


    public static class Builder {
        private final int mType;
        private String mMessage;

        public Builder(int type) {
            mType = type;
        }

        public Builder message(String message) {
            mMessage = message;
            return this;
        }

        public MessageModel build() {
            MessageModel message = new MessageModel();
            message.mType = mType;
            message.mMessage = mMessage;
            return message;
        }
    }
}