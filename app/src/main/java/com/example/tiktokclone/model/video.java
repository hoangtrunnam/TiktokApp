package com.example.tiktokclone.model;

public class video {
    private String userName;
    private String description;
    private String music;

    public video(String userName, String description, String music) {
        this.userName = userName;
        this.description = description;
        this.music = music;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public video() {

    }

}
