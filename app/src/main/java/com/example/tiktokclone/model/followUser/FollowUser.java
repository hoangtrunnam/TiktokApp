package com.example.tiktokclone.model.followUser;

public class FollowUser {
    private Data data;

    public FollowUser() {
    }

    public FollowUser(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
