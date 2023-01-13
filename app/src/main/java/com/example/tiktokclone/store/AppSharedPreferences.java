package com.example.tiktokclone.store;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSharedPreferences {
    private static final String MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES";
    private static final String ID_VIDEO = "ID_VIDEO";

    private Context mContext;

    public AppSharedPreferences(Context mContext) {
        this.mContext = mContext;
    }

    public void putStringValue(String key, String value) {
        SharedPreferences sharedPreferences =  mContext.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String GetStringValue(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARED_PREFERENCES,Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }

    public void logout() {
        SharedPreferences preferences = mContext.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear().apply();
    }

    public void putIntIdVideo(String key, int value) {
        SharedPreferences sharedPreferences =  mContext.getSharedPreferences(ID_VIDEO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getIntIdVideo(String key){
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(ID_VIDEO,Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, 0);
    }
}
