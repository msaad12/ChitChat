package com.example.smc_cuuzy.test.adapters;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.helpers.Session;
import com.example.smc_cuuzy.test.models.MessageUserType;
import com.example.smc_cuuzy.test.models.MessagingModel;

import java.util.List;

public class MessagingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int DIRECTION_INCOMING = 0;
    private static final int DIRECTION_OUTGOING = 1;
    private List<MessagingModel> mMessages;
    private Activity mActivity;


    public MessagingAdapter(Activity mActivity, List<MessagingModel> mMessages) {
        this.mMessages = mMessages;
        this.mActivity = mActivity;

    }

    private boolean isSender(int position) {
        MessagingModel messagesItem = mMessages.get(position);
        messagesItem.getUserType();
        return true;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == DIRECTION_OUTGOING) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.chat_bubble_right, parent, false);
            return new MessagesViewHolder(v);
        } else if(viewType == DIRECTION_INCOMING) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.chat_bubble_left, parent, false);
            return new MessagesViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MessagingModel messagesItem = mMessages.get(position);
        MessagesViewHolder mMessagesViewHolder = (MessagesViewHolder) holder;
        if(messagesItem.getMessageText() != null) {
            mMessagesViewHolder.message.setVisibility(View.VISIBLE);
            mMessagesViewHolder.message.setText(messagesItem.getMessageText());
        }else {
            mMessagesViewHolder.message.setVisibility(View.GONE);
        }
        mMessagesViewHolder.date.setText(messagesItem.getTime());

    }

    @Override
    public int getItemCount() {
        if (mMessages != null) {
            return mMessages.size();
        } else {
            return 0;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setMessages(List<MessagingModel> messageItems) {
        this.mMessages = messageItems;
        notifyDataSetChanged();
    }

    public List<MessagingModel> getMessages() {
        return this.mMessages;
    }


    private class MessagesViewHolder extends RecyclerView.ViewHolder{
        TextView date;
        TextView message;

        MessagesViewHolder(View v) {
            super(v);
            message = (TextView) v.findViewById(R.id.message_text);
            date = (TextView) v.findViewById(R.id.date);

        }
    }

}

