package com.example.smc_cuuzy.test.helpers;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.widget.ImageView;

import com.example.smc_cuuzy.test.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import static com.example.smc_cuuzy.test.helpers.Main.Toast;

/**
 * Created by Jacuzzy on 15/03/2016.
 */
public class ImageHelper {

    public static void saveImage(Context mContext, Bitmap bitmap) {
        File loc = new File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                mContext.getString(R.string.app_name) + " Photos");

        loc.mkdirs();
        Random generator = new Random();
        int num = 1000000;
        num = generator.nextInt(num);
        String fname = R.string.app_name + num + ".jpg";
        File file = new File(loc, fname);
        if (file.exists())
            file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
            Toast(mContext, "Image saved in " + mContext.getString(R.string.app_name) + " Images");
        } catch (Exception e) {
            e.printStackTrace();
            Toast(mContext, mContext.getString(R.string.save_fail));
        }
    }

    public static Uri getBitmapUri(ImageView imageView) {
        // Extract Bitmap from ImageView drawable
        Drawable drawable = imageView.getDrawable();
        Bitmap bmp = null;
        if (drawable instanceof BitmapDrawable){
            bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        } else {
            return null;
        }
        // Store image to default external storage directory
        Uri bmpUri = null;
        try {
            File file =  new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DOWNLOADS), "share_image_" + System.currentTimeMillis() + ".png");
            file.getParentFile().mkdirs();
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
    }

    public static void setImageAsWallpaper(Context mContext, Bitmap bitmap) {
        try {
            WallpaperManager wm = WallpaperManager.getInstance(mContext);

            wm.setBitmap(bitmap);
            Toast(mContext, mContext.getString(R.string.set_wallpaper));
        } catch (Exception e) {
            e.printStackTrace();
            Toast(mContext, e.getMessage());
        }
    }
}
