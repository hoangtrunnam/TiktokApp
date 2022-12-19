package com.example.tiktokclone.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.R;
import com.example.tiktokclone.model.video;

import java.util.ArrayList;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {
    private ArrayList<video> listVideo;
    private Context context;


    public VideoAdapter(Context context, ArrayList<video> listVideo) {
        this.listVideo = listVideo;
        this.context = context;
    }
    @NonNull
    @Override
    public VideoAdapter.VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home,parent, false);
        return new VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoAdapter.VideoHolder holder, int position) {
        video video = listVideo.get(position);
        holder.userName.setText(video.getUserName());
        holder.description.setText(video.getDescription());
        holder.music.setText(video.getMusic());
    }

    @Override
    public int getItemCount() {
        if(listVideo!=null && listVideo.size()>0) {
            return listVideo.size();
        } else {
            Log.i("aaaaaaa", "getItemCount: chay vao day");
            return 0;
        }
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView description;
        private TextView music;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            description = itemView.findViewById(R.id.description);
            music = itemView.findViewById(R.id.music);
        }
    }
}
