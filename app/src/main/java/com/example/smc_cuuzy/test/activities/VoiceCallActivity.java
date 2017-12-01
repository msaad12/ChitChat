package com.example.smc_cuuzy.test.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;


public class VoiceCallActivity extends AppCompatActivity implements View.OnClickListener{
    public TextView userProfileName;
    public ImageView volume, chat, mute;
    public FloatingActionButton endCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice_call);
        initUI();
    }

    public void initUI(){
        endCall = (FloatingActionButton) findViewById(R.id.end);
        chat = (ImageView) findViewById(R.id.chat);
        endCall.getResources().getColor(R.color.red);
        endCall.setOnClickListener(this);
        volume.setOnClickListener(this);
        chat.setOnClickListener(this);
        mute.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.end:
                finish();
                break;
            case R.id.chat:
                Intent intent = new Intent(this, MessagingActivity.class);
                startActivity(intent);
                break;
            case R.id.mute:
                mute.setImageResource(R.drawable.ic_action_mic);
                break;
        }
    }

}
