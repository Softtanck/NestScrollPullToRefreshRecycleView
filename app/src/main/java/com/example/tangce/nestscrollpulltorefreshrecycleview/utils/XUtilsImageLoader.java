package com.example.tangce.nestscrollpulltorefreshrecycleview.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
//import com.nostra13.universalimageloader.core.DisplayImageOptions;
//import com.nostra13.universalimageloader.core.ImageLoader;
//import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 图片助手
 *
 * @author 健
 */
public class XUtilsImageLoader {
    private static XUtilsImageLoader mImageLoader;
    
    private static final String IMG_URL="http://120.27.27.99:10001/csh-interface";
//    private static Picasso picasso;

    /**
     * @param context
     * @param resid   0为默认图片
     */
    private XUtilsImageLoader(Context context, int resid) {
//        picasso = Picasso.with(context);
//        picasso.setDebugging(true);
    }

    private XUtilsImageLoader(Context context) {
    }
//
//
//    public static XUtilsImageLoader getInstance(Context con, int id) {
//        if (null == mImageLoader) {
//            synchronized (XUtilsImageLoader.class) {
//                if (null == mImageLoader)
//                    mImageLoader = new XUtilsImageLoader(con, id);
//            }
//        }
//        return mImageLoader;
//    }


    /**
     * @param context
     * @return
     */
    public static void getxUtilsImageLoader(Context context, int resid, ImageView imageView, String uri) {
        if (null == uri) {
            imageView.setImageResource(resid);
            return;
        }
        Picasso.with(context).load(IMG_URL + uri)
                .placeholder(resid)
                .error(resid)
                .config(Bitmap.Config.RGB_565)
                .into(imageView);
    }

    /**
     * @param context
     * @return
     */
    public static void getxUtilsImageLoaderNoData(Context context, int resid, ImageView imageView, String uri) {
        if (null == uri) {
            return;
        }
        Picasso.with(context).load(uri)
                .placeholder(resid)
                .error(resid)
                .config(Bitmap.Config.RGB_565)
                .into(imageView);
    }

    /**
     * @param context
     * @return
     */
    public static void getxUtilsImageLoader(Context context, int resid, int errorid, ImageView imageView, String uri) {
        if (null == uri) {
            imageView.setImageResource(errorid);
            return;
        }
        Picasso.with(context).load(IMG_URL + uri)
                .placeholder(resid)
                .error(errorid)
                .config(Bitmap.Config.RGB_565)
                .into(imageView);
    }


    /**
     * @param context
     * @return
     */
    public static void getHomeAdvImg(Context context, int resid, ImageView imageView, String uri) {
        if (null == uri) {
            imageView.setImageResource(resid);
            return;
        }
        Picasso.with(context).load(IMG_URL + uri).error(resid).config(Bitmap.Config.RGB_565).fit().tag(context).into(imageView);
    }

//    public static void getShopImg(Context context, int resid, ImageView imageView, String uri) {
//        if (null == uri) {
//            imageView.setImageResource(resid);
//            return;
//        }
//        Glide.with(context)
//                .load(IMG_URL + uri)
//                .error(resid)
//                .crossFade()
//                .into(imageView);
//    }

}
