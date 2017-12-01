package com.example.smc_cuuzy.test.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.models.UsersModel;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<UsersModel> mUsersModel;
    private Activity mActivity;
    private LayoutInflater mInflater;

    public UsersAdapter(Activity mActivity, List<UsersModel> dataset) {
        super();
        this.mUsersModel = dataset;
        this.mActivity = mActivity;
        this.mInflater = LayoutInflater.from(mActivity);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContentHolder(mInflater.inflate(R.layout.users_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            UsersModel item = mUsersModel.get(position);
            ContentHolder contentHolder = (ContentHolder) viewHolder;

            contentHolder.picture.setImageResource(item.getPicture());
            contentHolder.username.setText(item.getUsername());
            contentHolder.about.setText(item.getAbout());

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount () {
        return mUsersModel.size ();
    }

    private class ContentHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView picture;
        TextView username, about;
        LinearLayout select;

        ContentHolder(View v) {
            super(v);
            picture = (ImageView) v.findViewById(R.id.picture);
            username = (TextView) v.findViewById(R.id.username);
            about = (TextView) v.findViewById(R.id.about);
            select = (LinearLayout) v.findViewById(R.id.select);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            UsersModel item = mUsersModel.get(this.getLayoutPosition() - 1);
            switch (v.getId()) {
                default:
                break;
            }
        }
    }
}