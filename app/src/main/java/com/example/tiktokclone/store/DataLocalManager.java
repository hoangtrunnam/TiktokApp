package com.example.tiktokclone.store;

import android.content.Context;

import com.example.tiktokclone.model.authen.Login;
import com.google.gson.Gson;

public class DataLocalManager {
    private static final String OBJECT_USER = "OBJECT_USER";
    private static final String ID_Video = "ID_Video";

    private static DataLocalManager instance;
    private AppSharedPreferences appSharedPreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.appSharedPreferences = new AppSharedPreferences(context);
    }
    public static DataLocalManager getInstance() {
        if (instance == null){
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void SetUser(Login loginUser) {
        Gson gson = new Gson();
        String stringJsonUser = gson.toJson(loginUser);
        DataLocalManager.getInstance().appSharedPreferences.putStringValue(OBJECT_USER, stringJsonUser);

    }

    public static Login getUser() {
        String stringJsonUser = DataLocalManager.getInstance().appSharedPreferences.GetStringValue(OBJECT_USER);
        Gson gson = new Gson();
        Login loginUser = gson.fromJson(stringJsonUser, Login.class);
        return loginUser;
    }

    public static void loggedOut() {
        DataLocalManager.getInstance().appSharedPreferences.logout();
    }

    public static void SetIdVideo(int idVideo) {
        DataLocalManager.getInstance().appSharedPreferences.putIntIdVideo(ID_Video, idVideo);

    }

    public static int getIdVideo() {
        int idVideo = DataLocalManager.getInstance().appSharedPreferences.getIntIdVideo(ID_Video);
        return idVideo;
    }
}
