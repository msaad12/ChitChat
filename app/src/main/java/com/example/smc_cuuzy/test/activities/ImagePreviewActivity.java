package com.example.smc_cuuzy.test.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.smc_cuuzy.test.R;


public class ImagePreviewActivity extends AppCompatActivity {
    private ImageView image;
    int picture = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_preview);
        initialUI();

    }

    private void initialUI() {

        image = (ImageView) findViewById(R.id.imageView);
    }

}
