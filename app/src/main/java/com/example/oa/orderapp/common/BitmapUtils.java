package com.example.oa.orderapp.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/**
 * Created by Phoenix on 8/20/17.
 */

public class BitmapUtils {

    public static BitmapDescriptor getBitmapDescriptor(Context context, int id){
        Bitmap bitmap = getBitmapFromVectorDrawable(context, id);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    private static Bitmap getBitmapFromVectorDrawable(Context context, int id){
        Drawable drawable = ContextCompat.getDrawable(context, id);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(),
                drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }
//    fun getBitmapDescriptor(context: Context, id: Int): BitmapDescriptor {
//        val bitmap = getBitmapFromVectorDrawable(context, id);
//        return BitmapDescriptorFactory.fromBitmap(bitmap)
//    }
//
//    fun getBitmapFromVectorDrawable(context: Context, drawableId: Int): Bitmap {
//        var drawable = ContextCompat.getDrawable(context, drawableId)
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            drawable = DrawableCompat.wrap(drawable).mutate()
//        }
//
//        val bitmap = Bitmap.createBitmap(drawable.intrinsicWidth,
//                drawable.intrinsicHeight, Bitmap.Config.ARGB_8888)
//        val canvas = Canvas(bitmap)
//        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight())
//        drawable.draw(canvas)
//
//        return bitmap
//    }
}
