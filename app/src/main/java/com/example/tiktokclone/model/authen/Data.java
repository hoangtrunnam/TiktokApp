package com.example.tiktokclone.model.authen;

public class Data {
    private int id;
    private String first_name;
    private String last_name;
    private String nickname;
    private String avatar;
    private String gender;
    private String bio;
    private String email;
    private String social_id;
    private String social_type;
    private String social_email;
    private boolean tick;
    private String date_of_birth;
    private int followings_count;
    private int followers_count;
    private int likes_count;
    private String website_url;
    private String facebook_url;
    private String youtube_url;
    private String twitter_url;
    private String instagram_url;
    private String email_verified_at;
    private String created_at;
    private String updated_at;

    public Data() {
    }

    public Data(int id, String first_name, String last_name, String nickname, String avatar, String gender, String bio, String email, String social_id, String social_type, String social_email, boolean tick, String date_of_birth, int followings_count, int followers_count, int likes_count, String website_url, String facebook_url, String youtube_url, String twitter_url, String instagram_url, String email_verified_at, String created_at, String updated_at) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.avatar = avatar;
        this.gender = gender;
        this.bio = bio;
        this.email = email;
        this.social_id = social_id;
        this.social_type = social_type;
        this.social_email = social_email;
        this.tick = tick;
        this.date_of_birth = date_of_birth;
        this.followings_count = followings_count;
        this.followers_count = followers_count;
        this.likes_count = likes_count;
        this.website_url = website_url;
        this.facebook_url = facebook_url;
        this.youtube_url = youtube_url;
        this.twitter_url = twitter_url;
        this.instagram_url = instagram_url;
        this.email_verified_at = email_verified_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocial_id() {
        return social_id;
    }

    public void setSocial_id(String social_id) {
        this.social_id = social_id;
    }

    public String getSocial_type() {
        return social_type;
    }

    public void setSocial_type(String social_type) {
        this.social_type = social_type;
    }

    public String getSocial_email() {
        return social_email;
    }

    public void setSocial_email(String social_email) {
        this.social_email = social_email;
    }

    public boolean isTick() {
        return tick;
    }

    public void setTick(boolean tick) {
        this.tick = tick;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
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

    public String getEmail_verified_at() {
        return email_verified_at;
    }

    public void setEmail_verified_at(String email_verified_at) {
        this.email_verified_at = email_verified_at;
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


}
