package com.example.tiktokclone.controller;

import android.net.Uri;
import android.widget.VideoView;

import com.example.tiktokclone.model.videoTiktok.Data;

public class VideoController {

    // Instance variables
    private Data video;
    private VideoView videoView;

    public VideoController() {
    }

    public VideoController(Data video, VideoView videoView) {
        this.video = video;
        this.videoView = videoView;
    }

    public void playVideo(String videoPath) {
        Uri videoUri = Uri.parse(videoPath);
        videoView.setVideoURI(videoUri);
        videoView.start();
    }

    // Method to play video
    public void playVideo() {
        // Get the video file from the model
        Data DataVideo = new Data();
        String videoFile = DataVideo.getFile_url();


    }
    public void pauseVideo() {
        if (videoView.isPlaying()) {
            videoView.pause();
        }
    }

    public void stopVideo() {
        if (videoView.isPlaying()) {
            videoView.stopPlayback();
        }
    }

}