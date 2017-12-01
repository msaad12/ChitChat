package com.example.smc_cuuzy.test.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.adapters.CallInfoAdapter;
import com.example.smc_cuuzy.test.models.CallInfoModel;

import java.util.ArrayList;
import java.util.List;


public class CallInfoActivity extends AppCompatActivity {

    public RecyclerView mCallsList;
    public View mView;
    public List<CallInfoModel> mCallInfoModel;
    public CallInfoAdapter mCallInfoAdapter;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_info);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.call_info);

        initUI();
    }

    //Method to add menu items to the toolbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.call_info_menu, menu);
        return true;
    }

    //Method and views initializer
    public void initUI() {
        mCallsList = (RecyclerView) findViewById(R.id.callInfoList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mCallInfoModel = new ArrayList<CallInfoModel>();
        mCallInfoAdapter = new CallInfoAdapter(this, mCallInfoModel);
        mCallsList.setLayoutManager(layoutManager);
        mCallsList.setAdapter(mCallInfoAdapter);
        prepareItems();

    }

    //Method to add items to the recyclerview
    private void prepareItems() {
        mCallInfoModel.add(new CallInfoModel("incoming", "0333 1122456", "Nov30, 17:20"));
        mCallInfoModel.add(new CallInfoModel("incoming", "0333 1122456", "Nov30, 17:16"));
        mCallInfoModel.add(new CallInfoModel("incoming", "0333 1122456", "Nov30, 17:12"));
        mCallInfoModel.add(new CallInfoModel("incoming", "0333 1122456", "Nov30, 17:10"));
    }
}
