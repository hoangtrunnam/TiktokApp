package com.example.tiktokclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tiktokclone.R;
import com.example.tiktokclone.model.comment.Datum;
import com.example.tiktokclone.model.videoTiktok.Data;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder>{

    private ArrayList<Datum> listCmt;
    private Context context;

    public CommentAdapter(Context context,ArrayList<Datum> listCmt) {
        this.context = context;
        this.listCmt = listCmt;
    }

    public void updateData(List<Datum> data) {
        listCmt.clear();
        listCmt.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommentAdapter.CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcomment,parent, false);
        return new CommentAdapter.CommentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.CommentHolder holder, int position) {
        Datum cmtTikTok = listCmt.get(position);
        holder.userName.setText(cmtTikTok.getUser().getFirst_name() + cmtTikTok.getUser().getLast_name());
        holder.comment.setText(cmtTikTok.getComment());
        holder.dateCreated.setText(cmtTikTok.getCreated_at());
        Glide.with(context)
                .load(cmtTikTok.getUser().getAvatar())
                .into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        if(listCmt!=null && listCmt.size()>0) {
            return listCmt.size();
        } else {
            return 0;
        }
    }

    public class CommentHolder extends RecyclerView.ViewHolder {
        private CircleImageView avatar;
        private TextView userName;
        private TextView comment;
        private TextView dateCreated;

        public CommentHolder(@NonNull View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.imageCmt);
            userName = itemView.findViewById(R.id.userNameComment);
            comment = itemView.findViewById(R.id.titleCmt);
            dateCreated = itemView.findViewById(R.id.dateCreated);
        }
    }
}
