package com.example.smc_cuuzy.test.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;

import com.example.smc_cuuzy.test.R;


public class DeleteAccountActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText countryCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_account);

        //Method to setup our ActionBar
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        initUI();
    }

    private void initUI() {
        countryCode = (EditText) findViewById(R.id.code);
    }


}
