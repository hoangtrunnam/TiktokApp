package com.example.tiktokclone.model.videoLiked;

import com.google.gson.annotations.SerializedName;

public class Video {
    @SerializedName("dataformat")
    private String dataFormat;
    private int rotate;
    private int resolution_x;
    private int resolution_y;
    private String fourcc;
    private String fourcc_lookup;
    private Double frame_rate;

    public Video() {
    }

    public String getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(String dataFormat) {
        this.dataFormat = dataFormat;
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

    public Double getFrame_rate() {
        return frame_rate;
    }

    public void setFrame_rate(Double frame_rate) {
        this.frame_rate = frame_rate;
    }
}
