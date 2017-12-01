package com.example.smc_cuuzy.test.helpers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Jacuzzi on 17/03/2016.
 */
public class Session {
    private static SharedPreferences getPref(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    private static SharedPreferences mSharedPreferences;

    public static boolean setToken(String token, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("token", token);
        return editor.commit();
    }

    public static String getToken(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("token", null);
    }

    public static boolean setUserName(String username, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("username", username);
        return editor.commit();
    }

    public static String getUserName(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("username", null);
    }

    public static boolean setUserPicture(String picture, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("picture", picture);
        return editor.commit();
    }

    public static String getUserPicture(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("picture", null);
    }

    public static boolean getSharedPref(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("data", 0);
        return mSharedPreferences.getBoolean("sentTokenToServer", false);
    }

    public static boolean setSharedPref(boolean DataChanged, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("data", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean("sentTokenToServer", DataChanged);
        return editor.commit();
    }

    public static boolean setSharedPrefToken(String DataChanged, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("data", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("fcmToken", DataChanged);
        return editor.commit();
    }

    public static String getSharedPrefToken(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("data", 0);
        return mSharedPreferences.getString("fcmToken", null);
    }

    public static boolean setWallpaper(String wallpaper, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("wallpaper", wallpaper);
        return editor.commit();
    }

    public static String getWallpaper(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("wallpaper", null);
    }


    public static void logOut(Context mContext) {
        setID(0, mContext);
        setToken(null, mContext);
    }

    public static boolean setUserCover(String cover, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("cover", cover);
        return editor.commit();
    }

    public static String getUserCover(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("cover", null);
    }

    public static boolean setName(String name, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("name", name);
        return editor.commit();
    }

    public static String getName(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("name", null);
    }

    public static boolean setEmail(String email, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("email", email);
        return editor.commit();
    }

    public static String getEmail(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("email", null);
    }

    public static boolean setOwnerName(String ownerName, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("ownerName", ownerName);
        return editor.commit();
    }

    public static String getOwnerName(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getString("ownerName", null);
    }

    public static boolean setID(int ID, Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt("id", ID);
        return editor.commit();
    }

    public static int getID(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        return mSharedPreferences.getInt("id", 0);
    }

    public static void saveString(Context context, String key, String value) {
        getPref(context).edit().putString(key, value).apply();
    }

    public static String getString(Context context, String key, String defValue) {
        return getPref(context).getString(key, defValue);
    }

    public static void removeString(Context context, String key) {
        getPref(context).edit().remove(key).apply();
    }


    public static SharedPreferences.Editor editSharedPref(Context mContext) {
        mSharedPreferences = mContext.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        return editor;
    }

}
