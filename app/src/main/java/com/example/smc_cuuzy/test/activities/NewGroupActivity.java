package com.example.smc_cuuzy.test.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.adapters.UsersAdapter;
import com.example.smc_cuuzy.test.models.UsersModel;

import java.util.ArrayList;
import java.util.List;


public class NewGroupActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView title, participants;
    private LinearLayout back, nextLayout;
    public RecyclerView mGroupParticipants;
    public List<UsersModel> mUsersModel;
    public UsersAdapter mUsersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        initUI();
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Re-enter transition is executed when returning to this activity
            Slide slideTransition = new Slide();
            slideTransition.setSlideEdge(Gravity.START);
            slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
            getWindow().setReenterTransition(slideTransition);
            getWindow().setExitTransition(slideTransition);
        }
    }

    private void initUI(){
        title = (TextView) findViewById(R.id.title);
        participants = (TextView) findViewById(R.id.participants);
        back = (LinearLayout) findViewById(R.id.btnLeft);

        mGroupParticipants = (RecyclerView) findViewById(R.id.participantList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mUsersModel = new ArrayList<UsersModel>();
        mUsersAdapter= new UsersAdapter(this, mUsersModel);
        mGroupParticipants.setLayoutManager(layoutManager);
        mUsersAdapter.notifyItemInserted(mUsersModel.size()-1);
        mGroupParticipants.setAdapter(mUsersAdapter);
        getParcitipants();

        title.setText("New group");
        participants.setText("Add participants");
        back.setOnClickListener(this);
    }

    // This is a simple method to add items to our recyclerview
    private void getParcitipants() {
        UsersModel model = new UsersModel(R.drawable.image1, "Haider ", "always active");
        UsersModel model2 = new UsersModel(R.drawable.image2, "Ali ", "always active");
        UsersModel model3 = new UsersModel(R.drawable.image3, "Shaoor ", "always active");
        UsersModel model4 = new UsersModel(R.drawable.image4, "Munir ", "always active");
        UsersModel model5 = new UsersModel(R.drawable.image1, "Ghufran ", "always active");
        UsersModel model6 = new UsersModel(R.drawable.image2, "Ahmad ", "always active");
        UsersModel model7 = new UsersModel(R.drawable.image3, "Muhammad Saad ", "always active");
        UsersModel model8 = new UsersModel(R.drawable.image4, "Tariq ", "always active");
        UsersModel model9 = new UsersModel(R.drawable.image1, "Muaz ", "always active");
        UsersModel model10 = new UsersModel(R.drawable.image2, "Maqbool ", "always active");
        UsersModel model11 = new UsersModel(R.drawable.image3, "Haseeb ", "always active");
        UsersModel model12 = new UsersModel(R.drawable.image4, "Ahmed ", "always active");
        mUsersModel.add(model);
        mUsersModel.add(model2);
        mUsersModel.add(model3);
        mUsersModel.add(model4);
        mUsersModel.add(model5);
        mUsersModel.add(model6);
        mUsersModel.add(model7);
        mUsersModel.add(model8);
        mUsersModel.add(model9);
        mUsersModel.add(model10);
        mUsersModel.add(model11);
        mUsersModel.add(model12);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        case R.id.btnLeft:
            finish();
            break;
        }

    }
}
