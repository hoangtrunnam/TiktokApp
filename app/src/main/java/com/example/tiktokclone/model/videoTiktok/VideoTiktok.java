package com.example.tiktokclone.model.videoTiktok;

import java.util.ArrayList;

public class VideoTiktok {
    private ArrayList<Data> data;
    private Meta meta;

    public VideoTiktok() {
    }

    public VideoTiktok(ArrayList<Data> data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public ArrayList<Data> getData() {
        return data;
    }

    public void setData(ArrayList<Data> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
