package com.example.tiktokclone.model.otherProfile;

import java.util.ArrayList;

public class Data {
    public int id;
    public String first_name;
    public String last_name;
    public String nickname;
    public String avatar;
    public String bio;
    public boolean tick;
    public boolean is_followed;
    public int followings_count;
    public int followers_count;
    public int likes_count;
    public String website_url;
    public String facebook_url;
    public String youtube_url;
    public String twitter_url;
    public String instagram_url;
    public String created_at;
    public String updated_at;
    public ArrayList<Video> videos;

    public Data() {
    }

    public Data(int id, String first_name, String last_name, String nickname, String avatar, String bio, boolean tick, boolean is_followed, int followings_count, int followers_count, int likes_count, String website_url, String facebook_url, String youtube_url, String twitter_url, String instagram_url, String created_at, String updated_at, ArrayList<Video> videos) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.avatar = avatar;
        this.bio = bio;
        this.tick = tick;
        this.is_followed = is_followed;
        this.followings_count = followings_count;
        this.followers_count = followers_count;
        this.likes_count = likes_count;
        this.website_url = website_url;
        this.facebook_url = facebook_url;
        this.youtube_url = youtube_url;
        this.twitter_url = twitter_url;
        this.instagram_url = instagram_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.videos = videos;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isTick() {
        return tick;
    }

    public void setTick(boolean tick) {
        this.tick = tick;
    }

    public boolean isIs_followed() {
        return is_followed;
    }

    public void setIs_followed(boolean is_followed) {
        this.is_followed = is_followed;
    }

    public int getFollowings_count() {
        return followings_count;
    }

    public void setFollowings_count(int followings_count) {
        this.followings_count = followings_count;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public void setWebsite_url(String website_url) {
        this.website_url = website_url;
    }

    public String getFacebook_url() {
        return facebook_url;
    }

    public void setFacebook_url(String facebook_url) {
        this.facebook_url = facebook_url;
    }

    public String getYoutube_url() {
        return youtube_url;
    }

    public void setYoutube_url(String youtube_url) {
        this.youtube_url = youtube_url;
    }

    public String getTwitter_url() {
        return twitter_url;
    }

    public void setTwitter_url(String twitter_url) {
        this.twitter_url = twitter_url;
    }

    public String getInstagram_url() {
        return instagram_url;
    }

    public void setInstagram_url(String instagram_url) {
        this.instagram_url = instagram_url;
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

    public ArrayList<Video> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<Video> videos) {
        this.videos = videos;
    }
}
