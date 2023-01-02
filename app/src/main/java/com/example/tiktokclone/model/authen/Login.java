package com.example.tiktokclone.model.authen;

public class Login {
    private Data data;
    private Meta meta;

    public Login() {
    }

    public Login(Data data, Meta meta) {
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
