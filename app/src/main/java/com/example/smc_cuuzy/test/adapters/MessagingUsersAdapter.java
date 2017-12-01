package com.example.smc_cuuzy.test.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.constant.Constant;
import com.example.smc_cuuzy.test.models.ChatsModel;
import com.example.smc_cuuzy.test.models.UsersModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

public class MessagingUsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<UsersModel> mUsersModel;
    private Activity mActivity;
    private LayoutInflater mInflater;
    public Context mContext;

    public MessagingUsersAdapter(Activity mActivity, List<UsersModel> dataset) {
        super();
        this.mActivity = mActivity;
        mInflater = LayoutInflater.from(mActivity);
        this.mUsersModel = dataset;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        return new ContentViewHolder(mInflater.inflate(R.layout.group_users_item, parent, false));
    }

    @Override
    public void onBindViewHolder (RecyclerView.ViewHolder holder, final int position) {
        ContentViewHolder contentHolder = (ContentViewHolder) holder;

        UsersModel item = mUsersModel.get(position);
        contentHolder.picture.setImageResource(item.getPicture());
    }

    @Override
    public int getItemCount() {
        return mUsersModel.size();
    }

    private class ContentViewHolder extends RecyclerView.ViewHolder{

        public ImageView picture;

        ContentViewHolder(View v) {
            super(v);
            picture = (ImageView) v.findViewById(R.id.picture);
        }
    }
}