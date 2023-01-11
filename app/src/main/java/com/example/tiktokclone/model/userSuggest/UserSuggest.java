package com.example.tiktokclone.model.userSuggest;

import java.util.ArrayList;
    public class UserSuggest{
        public ArrayList<Datum> data;
        public Meta meta;

        public UserSuggest() {
        }

        public UserSuggest(ArrayList<Datum> data, Meta meta) {
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

