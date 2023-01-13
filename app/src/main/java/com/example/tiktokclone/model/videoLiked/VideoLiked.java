package com.example.tiktokclone.model.videoLiked;

import java.util.ArrayList;

public class VideoLiked {
    private Data data;
    private Meta meta;

    public VideoLiked() {
    }

    public VideoLiked(Data data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
