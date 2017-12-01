package com.example.smc_cuuzy.test.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.models.AboutModel;

import java.util.List;

/**
 * Created by Jacuzzy on 01/06/2016.
 */

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder>{

    private List<AboutModel> mAboutModel;
    private Activity mActivity;
    private LayoutInflater mInflater;
    public Context mContext;

    public AboutAdapter(Activity mActivity, List<AboutModel> dataset) {
        super();
        this.mActivity = mActivity;
        mInflater = LayoutInflater.from(mActivity);
        this.mAboutModel = dataset;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.status_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        AboutModel item = mAboutModel.get(position);
        viewHolder.title.setText(item.getTitle());
        if (item.getSubText() !=null){
            viewHolder.text.setText(item.getSubText());
            viewHolder.text.setVisibility(View.VISIBLE);
        }else {
            viewHolder.text.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mAboutModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title,text;

        public ViewHolder(View v) {
            super(v);
            title = (TextView) v.findViewById(R.id.text);
            text = (TextView) v.findViewById(R.id.text2);
        }
    }
}