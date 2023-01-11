package com.example.tiktokclone.model.userSuggest;

public class PopularVideo{
    public int id;
    public String uuid;
    public int user_id;
    public String type;
    public String thumb_url;
    public String file_url;
    public String music;
    public String description;
    public boolean is_liked;
    public int likes_count;
    public int comments_count;
    public int shares_count;
    public int views_count;
    public String published_at;
    public String created_at;
    public String updated_at;
    public Meta meta;

    public PopularVideo() {
    }

    public PopularVideo(int id, String uuid, int user_id, String type, String thumb_url, String file_url, String music, String description, boolean is_liked, int likes_count, int comments_count, int shares_count, int views_count, String published_at, String created_at, String updated_at, Meta meta) {
        this.id = id;
        this.uuid = uuid;
        this.user_id = user_id;
        this.type = type;
        this.thumb_url = thumb_url;
        this.file_url = file_url;
        this.music = music;
        this.description = description;
        this.is_liked = is_liked;
        this.likes_count = likes_count;
        this.comments_count = comments_count;
        this.shares_count = shares_count;
        this.views_count = views_count;
        this.published_at = published_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.meta = meta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIs_liked() {
        return is_liked;
    }

    public void setIs_liked(boolean is_liked) {
        this.is_liked = is_liked;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getShares_count() {
        return shares_count;
    }

    public void setShares_count(int shares_count) {
        this.shares_count = shares_count;
    }

    public int getViews_count() {
        return views_count;
    }

    public void setViews_count(int views_count) {
        this.views_count = views_count;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
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

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
