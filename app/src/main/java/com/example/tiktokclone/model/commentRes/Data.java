package com.example.tiktokclone.model.commentRes;

public class Data {
    private int id;
    private String comment;
    private int likes_count;
    private boolean is_liked;
    private String created_at;
    private String updated_at;
    private User user;

    public Data() {
    }

    public Data(int id, String comment, int likes_count, boolean is_liked, String created_at, String updated_at, User user) {
        this.id = id;
        this.comment = comment;
        this.likes_count = likes_count;
        this.is_liked = is_liked;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public boolean isIs_liked() {
        return is_liked;
    }

    public void setIs_liked(boolean is_liked) {
        this.is_liked = is_liked;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
