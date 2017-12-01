package com.example.smc_cuuzy.test.helpers.progress;

import android.content.Context;

import com.example.smc_cuuzy.test.R;


/**
 * Created by Jacuzzy on 15/03/2016.
 */
public class LoginProgressDialog {
    static android.app.ProgressDialog pDialog;
    public static void showDialog(Context mContext) {
        pDialog = new android.app.ProgressDialog(mContext);
        pDialog.setIndeterminate(true);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    public static void hideDialog() {
        if (pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

}
