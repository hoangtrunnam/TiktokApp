package com.example.tiktokclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.R;
import com.example.tiktokclone.model.videoTiktok.Data;

import java.util.ArrayList;
import java.util.List;

public class VideoTiktokAdapter extends RecyclerView.Adapter<VideoTiktokAdapter.VideoTiktokHolder> {
    private ArrayList<Data> listVideoTiktok;
    private Context context;

    public VideoTiktokAdapter( Context context, ArrayList<Data> listVideoTiktok) {
        this.context = context;
        this.listVideoTiktok = listVideoTiktok;
    }

    public VideoTiktokAdapter(ArrayList<Data> listVideoTiktok) {
        this.listVideoTiktok = listVideoTiktok;
    }

    public void updateData(List<Data> data) {
        listVideoTiktok.clear();
        listVideoTiktok.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public VideoTiktokAdapter.VideoTiktokHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_home,parent, false);
        return new VideoTiktokAdapter.VideoTiktokHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoTiktokAdapter.VideoTiktokHolder holder, int position) {
        Data videoTiktok = listVideoTiktok.get(position);
        holder.userName.setText(videoTiktok.getUser().getFirst_name());
        holder.description.setText(videoTiktok.getDescription());
        holder.music.setText(videoTiktok.getMusic());
        holder.likeCount.setText(videoTiktok.getLikes_count() + "");
        holder.shareCount.setText(videoTiktok.getShares_count() + "");
        holder.commentCount.setText(videoTiktok.getComments_count() + "");
    }

    @Override
    public int getItemCount() {
        if(listVideoTiktok!=null && listVideoTiktok.size()>0) {
            return listVideoTiktok.size();
        } else {
            return 0;
        }
    }

    public class VideoTiktokHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView description;
        private TextView music;
        private TextView likeCount;
        private TextView commentCount;
        private TextView shareCount;


        public VideoTiktokHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            description = itemView.findViewById(R.id.description);
            music = itemView.findViewById(R.id.music);
            likeCount = itemView.findViewById(R.id.likeCount);
            commentCount = itemView.findViewById(R.id.commentCount);
            shareCount = itemView.findViewById(R.id.shareCount);
        }
    }
}
