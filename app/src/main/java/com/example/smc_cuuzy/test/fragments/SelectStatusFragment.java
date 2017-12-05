package com.example.smc_cuuzy.test.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.smc_cuuzy.test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SelectStatusFragment extends Fragment{

    public SelectStatusFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmentgetActivity().requestWindowFeature(Window.FEATURE_NO_TITLE);
       // View c = inflater.inflate(R.layout.fragment_select_status, container, false);
        //Button b = (Button) c.findViewById(R.id.camera);

        return null;
    }


}
