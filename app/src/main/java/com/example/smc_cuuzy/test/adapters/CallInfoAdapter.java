package com.example.smc_cuuzy.test.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.models.CallInfoModel;
import com.example.smc_cuuzy.test.models.SettingsModel;
import com.example.smc_cuuzy.test.widgets.MaterialRippleLayout;

import java.util.List;

/**
 * Created by Jacuzzy on 01/06/2016.
 */

public class CallInfoAdapter extends RecyclerView.Adapter<CallInfoAdapter.ViewHolder>{

    private List<CallInfoModel> mCallInfoModel;
    private Activity mActivity;
    private LayoutInflater mInflater;
    public Context mContext;

    public CallInfoAdapter(Activity mActivity, List<CallInfoModel> dataset) {
        super();
        this.mActivity = mActivity;
        mInflater = LayoutInflater.from(mActivity);
        this.mCallInfoModel = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.call_info_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        int red = mActivity.getResources().getColor(R.color.blue);
        int green = mActivity.getResources().getColor(R.color.colorAccent);
        int color = mActivity.getResources().getColor(R.color.teal);
        CallInfoModel item = mCallInfoModel.get(position);
        viewHolder.title.setText(item.getTypeText());
        viewHolder.date.setText(item.getDate());

        if (item.getType() != null) {
            viewHolder.icon.setImageResource(R.drawable.call_received);
            viewHolder.icon.setColorFilter(red);
        }else {
            viewHolder.icon.setImageResource(R.drawable.call_made);
            viewHolder.icon.setColorFilter(green);
        }

    }

    @Override
    public int getItemCount() {
        return mCallInfoModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title, date;
        public ImageView icon;

        public ViewHolder(View v) {
            super(v);
            date = (TextView) v.findViewById(R.id.date);
            title = (TextView) v.findViewById(R.id.text);
            icon = (ImageView) v.findViewById(R.id.icon);
        }
    }
}