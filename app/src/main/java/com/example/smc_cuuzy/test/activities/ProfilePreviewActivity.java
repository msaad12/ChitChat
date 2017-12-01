package com.example.smc_cuuzy.test.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.models.CallsModel;
import com.example.smc_cuuzy.test.views.RippleView;

public class ProfilePreviewActivity extends Activity implements View.OnClickListener{
    public CallsModel user;
    public TextView userProfileName, addToChat;
    public LinearLayout actionProfileArea;
    public ImageView userProfilePicture, viewProfile, chatMe, voiceCallMe, videoCallMe;
    public int userID = 0;
    public int picture;
    public Intent mIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_preview);

        initUI();

    }

    private void initUI() {
        userProfileName = (TextView) findViewById(R.id.username);
        chatMe = (ImageView) findViewById(R.id.chat);
        voiceCallMe = (ImageView) findViewById(R.id.call);
        videoCallMe = (ImageView) findViewById(R.id.video);
        viewProfile = (ImageView) findViewById(R.id.info);
        userProfilePicture = (ImageView) findViewById(R.id.userProfilePicture);
        actionProfileArea = (LinearLayout) findViewById(R.id.actionProfileArea);

        userProfileName.setText(R.string.med_name);
        userProfilePicture.setOnClickListener(this);
        chatMe.setOnClickListener(this);
        voiceCallMe.setOnClickListener(this);
        viewProfile.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.userProfilePicture:
                mIntent = new Intent(this, ImagePreviewActivity.class);
                startActivity(mIntent);
                break;
            case R.id.chat:
                mIntent = new Intent(this, MessagingActivity.class);
                startActivity(mIntent);
                break;
            case R.id.call:
                mIntent = new Intent(this, VoiceCallActivity.class);
                startActivity(mIntent);
                break;
        }
    }
}