package com.example.smc_cuuzy.test.activities;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.adapters.MediaImagesAdapter;
import com.example.smc_cuuzy.test.adapters.MessagingUsersAdapter;
import com.example.smc_cuuzy.test.models.UsersModel;
import com.example.smc_cuuzy.test.views.HeaderView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserProfileActivity extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{
    public Intent mIntent;
    @Bind(R.id.toolbar_header_view)
    protected HeaderView toolbarHeaderView;

    @Bind(R.id.appbar)
    protected AppBarLayout appBarLayout;

    @Bind(R.id.toolbar)
    protected Toolbar toolbar;

    private boolean isHideToolbarView = false;
    public RecyclerView mImagesList;
    private boolean sender = true;
    public List<UsersModel> mUsersModel;
    public MediaImagesAdapter mMediaImagesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        ButterKnife.bind(this);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        initUi();
    }

    //Method and views initializer
    private void initUi() {
        appBarLayout.addOnOffsetChangedListener(this);

        mImagesList = (RecyclerView) findViewById(R.id.imagesList);

        LinearLayoutManager layoutManagerHorizontal = new LinearLayoutManager(this);
        layoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager layoutManagerVertical = new LinearLayoutManager(this);
        layoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);

        mUsersModel = new ArrayList<UsersModel>();
        mMediaImagesAdapter = new MediaImagesAdapter(this, mUsersModel);
        mImagesList.setLayoutManager(layoutManagerHorizontal);
        mImagesList.setHasFixedSize(true);
        mMediaImagesAdapter.notifyDataSetChanged();
        mImagesList.setAdapter(mMediaImagesAdapter);
        prepareImages();
    }

    //Method to switch the toolbar with an animations when user scoll up and down
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        if (percentage == 1f && isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.VISIBLE);
            isHideToolbarView = !isHideToolbarView;
            toolbarHeaderView.bindTo("Cindy Carter", "online");

        } else if (percentage < 1f && !isHideToolbarView) {
            toolbarHeaderView.setVisibility(View.GONE);
            isHideToolbarView = !isHideToolbarView;
        }
    }

    // This is a simple method to add images to media shared by common users
    private void prepareImages() {
        UsersModel model = new UsersModel(R.drawable.image1);
        UsersModel model2 = new UsersModel(R.drawable.image2);
        UsersModel model3 = new UsersModel(R.drawable.image3);
        UsersModel model4 = new UsersModel(R.drawable.image7);
        UsersModel model5 = new UsersModel(R.drawable.image5);
        UsersModel model6 = new UsersModel(R.drawable.image6);
        UsersModel model7 = new UsersModel(R.drawable.image8);
        UsersModel model8 = new UsersModel(R.drawable.image9);
        mUsersModel.add(model);
        mUsersModel.add(model2);
        mUsersModel.add(model3);
        mUsersModel.add(model4);
        mUsersModel.add(model5);
        mUsersModel.add(model6);
        mUsersModel.add(model7);
        mUsersModel.add(model8);
    }
}
