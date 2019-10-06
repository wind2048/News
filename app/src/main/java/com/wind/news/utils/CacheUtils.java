package com.wind.news.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.wind.news.GuideActivity;
import com.wind.news.MainActivity;

/**
 * 缓存软件的一些参数和数据
 */
public class CacheUtils {
    public static boolean getBoolean(Context context, String  key) {
        SharedPreferences sp=context.getSharedPreferences("cache",Context.MODE_PRIVATE);
        return  sp.getBoolean(key,false);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp=context.getSharedPreferences("cache",Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }
}
