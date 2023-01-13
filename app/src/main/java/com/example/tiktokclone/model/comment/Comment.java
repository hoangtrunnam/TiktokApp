package com.example.tiktokclone.model.comment;

import java.util.ArrayList;

public class Comment {
    private ArrayList<Datum> data;
    private Meta meta;

    public Comment() {
    }

    public Comment(ArrayList<Datum> data, Meta meta) {
        this.data = data;
        this.meta = meta;
    }

    public ArrayList<Datum> getData() {
        return data;
    }

    public void setData(ArrayList<Datum> data) {
        this.data = data;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
