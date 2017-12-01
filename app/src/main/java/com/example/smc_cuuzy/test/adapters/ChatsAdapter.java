package com.example.smc_cuuzy.test.adapters;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.activities.GroupMessagingActivity;
import com.example.smc_cuuzy.test.activities.MessagingActivity;
import com.example.smc_cuuzy.test.activities.ProfilePreviewActivity;
import com.example.smc_cuuzy.test.activities.UserProfileActivity;
import com.example.smc_cuuzy.test.activities.UserProfileActivity$$ViewBinder;
import com.example.smc_cuuzy.test.constant.Constant;
import com.example.smc_cuuzy.test.models.ChatsModel;
import com.example.smc_cuuzy.test.widgets.MaterialRippleLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

public class ChatsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<ChatsModel> mChatsModel;
    private Activity mActivity;
    Intent mIntent;

    public ChatsAdapter(Activity mActivity, List<ChatsModel> dataset) {
        super();
        this.mChatsModel = dataset;
        this.mActivity = mActivity;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.ad_view, parent, false);
            return new HeaderViewHolder (v);
        } else if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.chats_item, parent, false);
            return new ContentViewHolder (v);
        }
        return null;
    }

    private ChatsModel getItem (int position) {
        return mChatsModel.get (position);
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof HeaderViewHolder) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            if (Constant.SHOW_ADS) {
                headerHolder.mAdView.setVisibility(View.VISIBLE);
                AdRequest adRequest = new AdRequest.Builder().build();
                headerHolder.mAdView.loadAd(adRequest);
            } else {
                headerHolder.mAdView.setVisibility(View.GONE);
            }
        }else if (holder instanceof ContentViewHolder) {
            ContentViewHolder contentHolder = (ContentViewHolder) holder;
            ChatsModel item  = getItem (position - 1);

            int black = mActivity.getResources().getColor(R.color.secondary_text);
            int green = mActivity.getResources().getColor(R.color.colorAccent);
            contentHolder.username.setText(item.getUsername());
            contentHolder.date.setText(item.getDate());
            contentHolder.message.setText(item.getMessage());
            if (item.getNewCount() != null) {
                contentHolder.count.setText(item.getNewCount());
                contentHolder.count.setVisibility(View.VISIBLE);
                contentHolder.date.setTextColor(green);
            }else {
                contentHolder.count.setVisibility(View.GONE);
                contentHolder.date.setTextColor(black);
            }
            contentHolder.picture.setImageResource(item.getPicture());
        }
    }

    @Override
    public int getItemViewType (int position) {
        if(isPositionHeader (position)) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader (int position) {
        return position == 0;
    }


    @Override
    public int getItemCount () {
        return mChatsModel.size ();
    }


    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        AdView mAdView;

        HeaderViewHolder(View itemView) {
            super(itemView);
            mAdView = (AdView) itemView.findViewById(R.id.adView);
        }
    }
    private class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView picture;
        TextView username, date, message, count;
        LinearLayout chat;

        ContentViewHolder(View v) {
            super(v);
            picture = (ImageView) v.findViewById(R.id.picture);
            username = (TextView) v.findViewById(R.id.username);
            date = (TextView) v.findViewById(R.id.date);
            message = (TextView) v.findViewById(R.id.message);
            count = (TextView) v.findViewById(R.id.newMessage);
            chat = (LinearLayout) v.findViewById(R.id.chat);
            v.setOnClickListener(this);
            picture.setOnClickListener(this);
            chat.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            ChatsModel item = mChatsModel.get(this.getLayoutPosition() - 1);
            switch (v.getId()) {
                case R.id.picture:
                    Intent profileIntent = new Intent(mActivity, ProfilePreviewActivity.class);
                    mActivity.startActivity(profileIntent);
                    break;
                case R.id.chat:
                    if (item.getGroup() == 2){
                        Intent intent = new Intent(mActivity, GroupMessagingActivity.class);
                        intent.putExtra("group", item.getGroup());
                        mActivity.startActivity(intent);
                    }else {
                        Intent intent = new Intent(mActivity, MessagingActivity.class);
                        mActivity.startActivity(intent);
                    }
                    break;
            }
        }
    }

}