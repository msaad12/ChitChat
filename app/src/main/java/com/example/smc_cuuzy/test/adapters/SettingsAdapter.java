package com.example.smc_cuuzy.test.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.models.SettingsModel;

import java.util.List;

/**
 * Created by Jacuzzy on 01/06/2016.
 */

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.ViewHolder>{

    private List<SettingsModel> mSettingsModel;
    private Activity mActivity;
    private LayoutInflater mInflater;
    public Context mContext;

    public SettingsAdapter(Activity mActivity, List<SettingsModel> dataset) {
        super();
        this.mActivity = mActivity;
        mInflater = LayoutInflater.from(mActivity);
        this.mSettingsModel = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.settings_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        int color = mActivity.getResources().getColor(R.color.colorPrimaryLight);
        SettingsModel item = mSettingsModel.get(position);
        viewHolder.title.setText(item.getTitle());
        viewHolder.icon.setImageResource(item.getIcon());

        viewHolder.icon.setColorFilter(color);
    }

    @Override
    public int getItemCount() {
        return mSettingsModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title;
        public ImageView icon;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.text);
            icon = (ImageView) v.findViewById(R.id.icon);
        }
    }
}