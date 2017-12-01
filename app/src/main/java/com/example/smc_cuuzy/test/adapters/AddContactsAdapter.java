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
import com.example.smc_cuuzy.test.models.ContactsModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AddContactsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 1;
    private static final int TYPE_BOTTOM = 2;
    private List<ContactsModel> mContactsModel;
    private Activity mActivity;
    private LayoutInflater mInflater;
    public Context mContext;

    public AddContactsAdapter(Activity mActivity, List<ContactsModel> dataset) {
        super();
        this.mActivity = mActivity;
        mInflater = LayoutInflater.from(mActivity);
        this.mContactsModel = dataset;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else {
            return TYPE_BOTTOM;
        }
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {

            View view = mInflater.inflate(R.layout.add_contacts_header_item, parent, false);
            BottomHolder holder = new BottomHolder(view);
            return holder;
        } else {
            View view = mInflater.inflate(R.layout.add_contacts_item, parent, false);
            HeaderHolder holder = new HeaderHolder(view);
            return holder;
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        if (viewHolder instanceof HeaderHolder) {
            ContactsModel item = mContactsModel.get(position);
            HeaderHolder headerHolder = (HeaderHolder) viewHolder;

            Picasso.with(mActivity.getApplicationContext())
                    .load(item.getPicture())
                    .error(R.drawable.user)
                    .into(headerHolder.picture);
            headerHolder.username.setText(item.getUsername());

            headerHolder.status.setText(item.getAbout());

        } else if (viewHolder instanceof BottomHolder) {
            BottomHolder bottomHolder = (BottomHolder) viewHolder;
            int color = mActivity.getResources().getColor(R.color.colorPrimaryDark);
            bottomHolder.searchIcon.setColorFilter(color);
            bottomHolder.cancel.setColorFilter(color);
        }
    }

    @Override
    public int getItemCount() {
        return mContactsModel.size();
    }

    public class HeaderHolder extends RecyclerView.ViewHolder {

        public ImageView picture;
        public TextView username, status;

        public HeaderHolder(View v) {
            super(v);
            picture = (ImageView) v.findViewById(R.id.picture);
            username = (TextView) v.findViewById(R.id.username);
            status = (TextView) v.findViewById(R.id.status);
        }
    }
    public class BottomHolder extends RecyclerView.ViewHolder {
        public ImageView searchIcon, cancel;

        public BottomHolder(View itemView) {
            super(itemView);
            searchIcon = (ImageView) itemView.findViewById(R.id.searchIcon);
            cancel = (ImageView) itemView.findViewById(R.id.cancel);
        }
    }
}