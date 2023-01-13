package com.example.tiktokclone.model.videoLiked;

public class MetaData {
    private int file_size;
    private String file_format;
    private String mime_type;
    private String playtime_string;
    private double playtime_seconds;
    private double bitrate;
    private Video video;

    public MetaData() {
    }

    public int getFile_size() {
        return file_size;
    }

    public void setFile_size(int file_size) {
        this.file_size = file_size;
    }

    public String getFile_format() {
        return file_format;
    }

    public void setFile_format(String file_format) {
        this.file_format = file_format;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public String getPlaytime_string() {
        return playtime_string;
    }

    public void setPlaytime_string(String playtime_string) {
        this.playtime_string = playtime_string;
    }

    public double getPlaytime_seconds() {
        return playtime_seconds;
    }

    public void setPlaytime_seconds(double playtime_seconds) {
        this.playtime_seconds = playtime_seconds;
    }

    public double getBitrate() {
        return bitrate;
    }

    public void setBitrate(double bitrate) {
        this.bitrate = bitrate;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }
}
