package com.example.tiktokclone.model.commentRes;

public class CommentRes {
    private Data data;

    public CommentRes() {
    }

    public CommentRes(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
