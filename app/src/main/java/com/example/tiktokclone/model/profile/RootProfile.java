package com.example.tiktokclone.model.profile;

public class RootProfile {
    private Data data;

    public RootProfile() {
    }

    public RootProfile(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
