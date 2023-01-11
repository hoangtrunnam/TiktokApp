package com.example.tiktokclone.model.userSuggest;

public class Video{
    public String dataformat;
    public int rotate;
    public int resolution_x;
    public int resolution_y;
    public String fourcc;
    public String fourcc_lookup;
    public int frame_rate;

    public Video() {
    }

    public Video(String dataformat, int rotate, int resolution_x, int resolution_y, String fourcc, String fourcc_lookup, int frame_rate) {
        this.dataformat = dataformat;
        this.rotate = rotate;
        this.resolution_x = resolution_x;
        this.resolution_y = resolution_y;
        this.fourcc = fourcc;
        this.fourcc_lookup = fourcc_lookup;
        this.frame_rate = frame_rate;
    }

    public String getDataformat() {
        return dataformat;
    }

    public void setDataformat(String dataformat) {
        this.dataformat = dataformat;
    }

    public int getRotate() {
        return rotate;
    }

    public void setRotate(int rotate) {
        this.rotate = rotate;
    }

    public int getResolution_x() {
        return resolution_x;
    }

    public void setResolution_x(int resolution_x) {
        this.resolution_x = resolution_x;
    }

    public int getResolution_y() {
        return resolution_y;
    }

    public void setResolution_y(int resolution_y) {
        this.resolution_y = resolution_y;
    }

    public String getFourcc() {
        return fourcc;
    }

    public void setFourcc(String fourcc) {
        this.fourcc = fourcc;
    }

    public String getFourcc_lookup() {
        return fourcc_lookup;
    }

    public void setFourcc_lookup(String fourcc_lookup) {
        this.fourcc_lookup = fourcc_lookup;
    }

    public int getFrame_rate() {
        return frame_rate;
    }

    public void setFrame_rate(int frame_rate) {
        this.frame_rate = frame_rate;
    }
}
