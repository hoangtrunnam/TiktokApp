package com.example.tiktokclone.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tiktokclone.R;
import com.example.tiktokclone.model.userSuggest.Datum;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.RecyclerViewHolder> {
    private ArrayList<Datum> listUser;
    private Context context;

    public ItemAdapter() {
    }

    public ItemAdapter(ArrayList<Datum> listUser, Context context) {
        this.listUser = listUser;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_user_sample,parent, false);
        return new ItemAdapter.RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Datum userSuggest =  listUser.get(position);
        holder.userName.setText(userSuggest.getNickname());
        holder.count_follower.setText(userSuggest.getFollowers_count()+"");
        Glide.with(context)
                .load(userSuggest.getAvatar())
                .into(holder.avatar);
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView count_follower;
        private CircleImageView avatar;
        private ImageButton btn_clear;
        private Button btn_follow;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_username);
            count_follower = itemView.findViewById(R.id.user_count_follower);
            avatar = itemView.findViewById(R.id.profile_avatar);
            btn_clear = itemView.findViewById(R.id.profile_btn_clear);
            btn_follow = itemView.findViewById(R.id.user_btn_follow);
        }
    }
}
