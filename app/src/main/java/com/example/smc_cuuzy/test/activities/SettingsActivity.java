package com.example.smc_cuuzy.test.activities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.adapters.SettingsAdapter;
import com.example.smc_cuuzy.test.helpers.ClickListener;
import com.example.smc_cuuzy.test.helpers.DividerItemDecoration;
import com.example.smc_cuuzy.test.helpers.RecyclerItemClickListener;
import com.example.smc_cuuzy.test.models.SettingsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener{
    public RecyclerView mSettingsList;
    public View mView;
    private Toolbar toolbar;
    public List<SettingsModel> mSettingsModel;
    public SettingsAdapter mSettingsAdapter;
    public ImageView profilePic;
    Context context;
    Activity mActivity;
    Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        initUI();
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        // Re-enter transition is executed when returning to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);
      }
    }

    //Method and views initializer
    public void initUI(){

        mSettingsList = (RecyclerView) findViewById(R.id.settingsList);
        profilePic = (ImageView) findViewById(R.id.picture);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mSettingsModel = new ArrayList<>();
        mSettingsAdapter = new SettingsAdapter(this, mSettingsModel);
        mSettingsList.setLayoutManager(layoutManager);
        mSettingsList.setAdapter(mSettingsAdapter);


        prepareItems();

        //Method to setup our ActionBar
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Picasso.with(getApplicationContext())
                .load(R.drawable.image4)
                .error(R.drawable.image4)
                .into(profilePic);
        profilePic.setOnClickListener(this);
    }

    //Add items to our recyclerview
    private void prepareItems() {
        mSettingsModel.add(new SettingsModel(R.drawable.ic_key_variant, R.string.account,
        SettingsModel.SETTINGS_ACCOUNT));
        mSettingsModel.add(new SettingsModel(R.drawable.ic_action_chat, R.string.chats,
        SettingsModel.DRAWER_ITEM_TAG_GIT_HUB));
        mSettingsModel.add(new SettingsModel(R.drawable.ic_action_notification, R.string.notif,
        SettingsModel.DRAWER_ITEM_TAG_LEFT_MENUS));
        mSettingsModel.add(new SettingsModel(R.drawable.ic_chart_donut, R.string.data,
        SettingsModel.DRAWER_ITEM_TAG_LINKED_IN));
        mSettingsModel.add(new SettingsModel(R.drawable.ic_account_multiple, R.string.contacts,
        SettingsModel.DRAWER_ITEM_TAG_GIT_HUB));
        mSettingsModel.add(new SettingsModel(R.drawable.ic_help, R.string.help,
                SettingsModel.DRAWER_ITEM_TAG_LINKED_IN));
        mSettingsAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {

    }
}
