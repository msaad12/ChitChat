package com.example.smc_cuuzy.test.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.activities.CallInfoActivity;
import com.example.smc_cuuzy.test.activities.VoiceCallActivity;
import com.example.smc_cuuzy.test.activities.ProfilePreviewActivity;
import com.example.smc_cuuzy.test.constant.Constant;
import com.example.smc_cuuzy.test.models.CallsModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

public class CallsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    private List<CallsModel> mCallsModel;
    private Activity mActivity;
    private LayoutInflater mInflater;
    public Context mContext;

    public CallsAdapter(Activity mActivity, List<CallsModel> dataset) {
        super();
        this.mActivity = mActivity;
        this.mCallsModel = dataset;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        if(viewType == TYPE_HEADER) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.ad_view, parent, false);
            return new HeaderViewHolder (v);
        } else if(viewType == TYPE_ITEM) {
            View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.calls_item, parent, false);
            return new ContentViewHolder (v);
        }
        return null;
    }

    private CallsModel getItem (int position) {
        return mCallsModel.get (position);
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
            CallsModel item  = getItem (position - 1);

            int blue = mActivity.getResources().getColor(R.color.blue);
            int green = mActivity.getResources().getColor(R.color.colorAccent);
            int primaryColor = mActivity.getResources().getColor(R.color.teal);
            contentHolder.picture.setImageResource(item.getPicture());
            contentHolder.username.setText(item.getUsername());
            contentHolder.date.setText(item.getDate());
            contentHolder.iconCall.setImageResource(item.getIcon());

            if (item.getIncoming() != null){
                contentHolder.iconCallType.setImageResource(R.drawable.call_received);
                contentHolder.iconCallType.setColorFilter(blue);
            }else {
                contentHolder.iconCallType.setImageResource(R.drawable.call_made);
                contentHolder.iconCallType.setColorFilter(green);
            }
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
        return mCallsModel.size();
    }


    private class HeaderViewHolder extends RecyclerView.ViewHolder {
        AdView mAdView;

        HeaderViewHolder(View itemView) {
            super(itemView);
            mAdView = (AdView) itemView.findViewById(R.id.adView);
        }
    }

    private class ContentViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView picture, iconCall, iconCallType;
        TextView username, date;
        LinearLayout call,callInfo;

        ContentViewHolder(View v) {
            super(v);
            call = (LinearLayout) v.findViewById(R.id.call);
            callInfo = (LinearLayout) v.findViewById(R.id.callInfo);
            picture = (ImageView) v.findViewById(R.id.picture);
            iconCall = (ImageView) v.findViewById(R.id.callIcon);
            iconCallType = (ImageView) v.findViewById(R.id.iconCallType);
            username = (TextView) v.findViewById(R.id.username);
            date = (TextView) v.findViewById(R.id.date);

            picture.setOnClickListener(this);
            callInfo.setOnClickListener(this);
            call.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            CallsModel item = mCallsModel.get(this.getLayoutPosition());
            switch (v.getId()) {
                case R.id.picture:
                    Intent photo = new Intent(mActivity, ProfilePreviewActivity.class);
                    mActivity.startActivity(photo);
                    break;
                case R.id.callInfo:
                    Intent callInfo = new Intent(mActivity, CallInfoActivity.class);
                    mActivity.startActivity(callInfo);
                    break;
                case R.id.call:
                    Intent call = new Intent(mActivity, VoiceCallActivity.class);
                    mActivity.startActivity(call);
                    break;
            }
        }
    }

}