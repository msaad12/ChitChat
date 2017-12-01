package com.example.smc_cuuzy.test.helpers;

import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.smc_cuuzy.test.R;
import com.example.smc_cuuzy.test.constant.Constant;
import com.squareup.picasso.Picasso;


/**
 * Created by Jacuzzy on 15/03/2016.
 */
public class Main {

    private static final String first_uppercase_key = "first_upper_letter";
    public static final String TAG = "Tag";
    public Context mContext;
    private static NotificationManager manager;
    private static SharedPreferences mSharedPreferences;
    private static SharedPreferences userPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    private static final String NAME = "Message";

    public static Drawable getDrawable(Context context, int id) {
        if (isAndroid5()) {
            return ContextCompat.getDrawable(context, id);
        } else {
            return context.getResources().getDrawable(id);
        }
    }

    /**
     * method to check the android version
     *
     * @return
     */
    private static boolean isAndroid5() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;
    }

    static void Toast(Context mContext, String Message) {
        // create a LinearLayout and Views
        LinearLayout ToastLayout = new LinearLayout(mContext);
        ToastLayout.setBackgroundColor(Color.BLACK);
        ToastLayout.setGravity(Gravity.CENTER);

        TextView message = new TextView(mContext);
        // set the color and size
        message.setTextColor(Color.RED);
        message.setTextSize(17);
        message.setPadding(10, 10, 10, 10);
        message.setGravity(Gravity.BOTTOM);

        // set the text and the icon you want to show in  Toast
        message.setText(Message);
        ImageView alertIcon = new ImageView(mContext);

        // get the image resource
        alertIcon.setPadding(5, 5, 5, 5);

        // add the View TextView and icon in layout
        ToastLayout.addView(message);
        ToastLayout.addView(alertIcon);
        Toast toast = new Toast(mContext);
        toast.setDuration(Toast.LENGTH_SHORT);
        // Set The layout as Toast View
        toast.setView(ToastLayout);
        //here i set the position of toast
        toast.setGravity(Gravity.BOTTOM, 0, 5);
        //show the toast
        toast.show();
    }

    public static void Mess(String Message) {
        Log.e(NAME, Message);
    }

    public static int getColor(Context context, int id) {
        if (isAndroid5()) {
            return ContextCompat.getColor(context, id);
        } else {
            return context.getResources().getColor(id);
        }
    }

    public static String getName(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("username", null);
    }

    public static String getProfilePic(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("picture", null);
    }

    public static void LogCat(String Message) {
        if (Constant.DEBUGGING_MODE)
            Log.e(Constant.TAG, Message);
    }

    public static boolean checkPermission(Activity activity, String permission) {
        int result = ContextCompat.checkSelfPermission(activity, permission);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    public static void showNotification(
        Context mContext, Intent resultIntent, String title, String text, int id) {
        PendingIntent resultPendingIntent = PendingIntent.getActivity(mContext, 0,
                resultIntent, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder mNotifyBuilder;
        NotificationManager mNotificationManager;

        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotifyBuilder = new NotificationCompat.Builder(mContext)
                .setContentTitle(title)
                .setContentText(text)

                .setSmallIcon(R.mipmap.ic_launcher);

        mNotifyBuilder.setContentIntent(resultPendingIntent);

        int defaults = 0;
        defaults = defaults | Notification.DEFAULT_LIGHTS;
        defaults = defaults | Notification.DEFAULT_VIBRATE;
        defaults = defaults | Notification.DEFAULT_SOUND;

        mNotifyBuilder.setDefaults(defaults);
        mNotifyBuilder.setAutoCancel(true);

        mNotificationManager.notify(id, mNotifyBuilder.build());
    }

    /**
     * method to show notification
     *
     * @param mContext
     * @param resultIntent
     * @param title
     * @param text
     * @param id
     */
    public static void showNotification(final Context mContext, Intent resultIntent, String title, String text, int id, final String Avatar) {
        // final RemoteViews rv = new RemoteViews(mContext.getPackageName(), R.layout.activity_main);
        //  rv.setImageViewBitmap();
        PendingIntent resultPendingIntent = PendingIntent.getActivity(mContext, 0,
                resultIntent, PendingIntent.FLAG_ONE_SHOT);


        final NotificationCompat.Builder mNotifyBuilder;
        NotificationManager mNotificationManager;
        mNotificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

        mNotifyBuilder = new NotificationCompat.Builder(mContext)
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.mipmap.ic_launcher);
        mNotifyBuilder.setContentIntent(resultPendingIntent);
        mNotifyBuilder.setPriority(Notification.PRIORITY_HIGH);
        if (isAndroid5()) mNotifyBuilder.setVibrate(new long[0]);
        com.squareup.picasso.Target target = new com.squareup.picasso.Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                mNotifyBuilder.setLargeIcon(bitmap);
            }

            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                Main.L("errorDrawable" + errorDrawable);

            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {

                Main.L("placeHolderDrawable" + placeHolderDrawable);
            }
        };

        if (Avatar != null) {
            Main.L("djjd" + Avatar);

            try {

                Picasso.with(mContext)
                        .load(Avatar)
                        .transform(new CropCircleTransformation())
                        .placeholder(R.drawable.user)
                        .error(R.drawable.user)
                        .into(target);
            } catch (Exception e) {
                Main.L("d5d" + e.getMessage());
            }

        } else {
            final int color = mContext.getResources().getColor(R.color.colorAccent);
            String c = String.valueOf(title.charAt(0));
            TextDrawable drawable = TextDrawable.builder()
                    .buildRound(c, color);
            Bitmap mBitmap = drawableToBitmap(drawable);
            mNotifyBuilder.setLargeIcon(mBitmap);
        }

        int defaults = 0;
        defaults = defaults | Notification.DEFAULT_LIGHTS;
        defaults = defaults | Notification.DEFAULT_VIBRATE;
        defaults = defaults | Notification.DEFAULT_SOUND;

        mNotifyBuilder.setDefaults(defaults);
        mNotifyBuilder.setAutoCancel(true);

        mNotificationManager.notify(id, mNotifyBuilder.build());
    }


    /***
     * method to cancel a specific notification
     *
     * @param context
     * @param index
     */
    public static void cancel(Context context, int index) {
        getManager(context);
        manager.cancel(index);
    }


    /**
     * method to get manager for notification
     *
     * @param context
     */
    private static void getManager(Context context) {
        if (manager == null) {
            manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        }
    }

    /**
     * method to check if there is a connection
     *
     * @param context
     * @return
     */
    public static boolean isNetworkAvailable(Context context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.getState() == NetworkInfo.State.CONNECTED) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private static Bitmap drawableToBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        //Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, IMAGE_WIDTH, IMAGE_HEIGHT, true);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    public static void LaunchActivity(Activity mContext, Class mActivity) {
        Intent mIntent = new Intent(mContext, mActivity);
        mContext.startActivity(mIntent);
    }

    //set  first Upper letter
    public static boolean firstUpperLetterIsEnabled(Context context) {
        return userPreference(context).getBoolean(first_uppercase_key, true);
    }

    public static void L(String Message) {
        Log.e(TAG, Message);
    }
}
