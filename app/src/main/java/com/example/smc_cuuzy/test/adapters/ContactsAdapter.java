package com.example.smc_cuuzy.test.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.activities.GroupMessagingActivity;
import com.example.smc_cuuzy.test.activities.MessagingActivity;
import com.example.smc_cuuzy.test.activities.UserProfileActivity;
import com.example.smc_cuuzy.test.constant.Constant;
import com.example.smc_cuuzy.test.models.ContactsModel;
import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private static final int TYPE_FOOTER = 2;
    private static final int TYPE_CONTENT = 2;
    private static final int TYPE_BOTTOM = 3;
    private List<ContactsModel> mContactsModel;
    private Activity mActivity;
    private LayoutInflater mInflater;
    public Context mContext;
    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private SparseBooleanArray selectedItems;

    public ContactsAdapter(Activity mActivity, List<ContactsModel> dataset)

    {
        super();
        this.mActivity = mActivity;
        mInflater = LayoutInflater.from(mActivity);
        this.mContactsModel = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View view = mInflater.inflate(R.layout.contacts_header_item, parent, false);
            return new HeaderHolder(view);
        } else if(viewType == TYPE_FOOTER) {
            View view = mInflater.inflate(R.layout.contact_bottom_item, parent, false);
            return new BottomHolder(view);
        }else if(viewType == TYPE_ITEM) {
            View view = mInflater.inflate(R.layout.contacts_item, parent, false);
            return new ContentHolder(view);
        }
        return null;
    }

    private ContactsModel getItem (int position) {
        return mContactsModel.get(position);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof HeaderHolder) {
            HeaderHolder headerHolder = (HeaderHolder) viewHolder;

        }else if (viewHolder instanceof ContentHolder) {
            final ContactsModel item = getItem (position - 1);
            ContentHolder contentHolder = (ContentHolder) viewHolder;

            contentHolder.picture.setImageResource(item.getPicture());
            contentHolder.username.setText(item.getUsername());

            if (item.getMobile() != null) {
                contentHolder.mobile.setText(item.getMobile());
            } else {
                contentHolder.mobile.setVisibility(View.GONE);
            }
            contentHolder.message.setText(item.getAbout());

            if (item.getInvite() != 0) {
                contentHolder.invite.setText(item.getInvite());
                contentHolder.inviteLayout.setVisibility(View.VISIBLE);
            } else {
                contentHolder.invite.setText("");
                contentHolder.inviteLayout.setVisibility(View.GONE);
            }
        } else if (viewHolder instanceof BottomHolder) {
            BottomHolder bottomHolder = (BottomHolder) viewHolder;

        }

    }
    //    need to override this method
    @Override
    public int getItemViewType (int position) {
        if(isPositionHeader (position)) {
            return TYPE_HEADER;
        } else if(isPositionFooter (position)) {
            return TYPE_FOOTER;
        }
        return TYPE_ITEM;
    }

    private boolean isPositionHeader (int position) {
        return position == 0;
    }

    private boolean isPositionFooter (int position) {
        return position == mContactsModel.size () - 1;
    }

    @Override
    public int getItemCount () {
        return mContactsModel.size ();
    }

    private class HeaderHolder extends RecyclerView.ViewHolder {
        AdView mAdView;

        HeaderHolder(View itemView) {
            super(itemView);
            mAdView = (AdView) itemView.findViewById(R.id.adView);
        }
    }
    private class ContentHolder extends RecyclerView.ViewHolder{

        LinearLayout inviteLayout;
        public ImageView picture;
        TextView username, mobile, message, invite;
        LinearLayout itemRoot;
        LinearLayout chat;

        ContentHolder(View itemView) {
            super(itemView);
            picture = (ImageView) itemView.findViewById(R.id.picture);
            username = (TextView) itemView.findViewById(R.id.username);
            mobile = (TextView) itemView.findViewById(R.id.mobile);
            invite = (TextView) itemView.findViewById(R.id.invite);
            itemRoot = (LinearLayout) itemView.findViewById(R.id.list_item);
            inviteLayout = (LinearLayout) itemView.findViewById(R.id.inviteLayout);
            message = (TextView) itemView.findViewById(R.id.message);
            chat = (LinearLayout) itemView.findViewById(R.id.chat);
        }

        void setOnClickListener(View.OnClickListener listener) {
            itemView.setOnClickListener(listener);
            picture.setOnClickListener(listener);
            chat.setOnClickListener(listener);
        }

    }
    private class BottomHolder extends RecyclerView.ViewHolder {
        BottomHolder(View itemView) {
            super(itemView);
        }
    }
}