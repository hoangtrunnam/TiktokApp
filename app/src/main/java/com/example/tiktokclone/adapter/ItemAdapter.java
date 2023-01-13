package com.example.tiktokclone.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tiktokclone.MainActivity;
import com.example.tiktokclone.R;
import com.example.tiktokclone.SplashActivity;
import com.example.tiktokclone.model.userSuggest.Datum;
import com.example.tiktokclone.view.OtherProfileActivity;
import com.example.tiktokclone.view.ProfileSuggestActivity;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.RecyclerViewHolder> {
    private ArrayList<Datum> listUser;
    private Context context;
//    private static String avatarDefault = "https://scontent.fhan14-1.fna.fbcdn.net/v/t1.6435-9/157638615_1338336546559301_2943023811761417595_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=5b7eaf&_nc_ohc=mXP35ZQO74QAX_YLbdh&_nc_ht=scontent.fhan14-1.fna&oh=00_AfAEcHGyrlgIbxK7moE6pmyBRTh4ZjE4-BMk5mHMn6E4MA&oe=63E843E0";
    private static String avatarDefault = "https://scontent.fhan14-2.fna.fbcdn.net/v/t1.6435-9/65785076_2072178706416755_2216963269522882560_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=174925&_nc_ohc=qxyZaMfuSEcAX8tgeBD&_nc_ht=scontent.fhan14-2.fna&oh=00_AfBPJEN1r4_EqVKlBJloKQMUqI6p_lZU56jwnF3iZ_1yIQ&oe=63E86278";

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
//        Glide.with(context)
//                .load(userSuggest.getAvatar())
//                .into(holder.avatar);

        if (userSuggest.getAvatar().equals("https://files.fullstack.edu.vn/f8-tiktok/") ||userSuggest.getAvatar().equals("")) {
            Glide.with(context)
                    .load(avatarDefault)
                    .into(holder.avatar);
        } else {
            Glide.with(context)
                    .load(userSuggest.getAvatar())
                    .into(holder.avatar);
        }

        holder.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("TAGaa", "onClick: " + userSuggest.getNickname());
                openNewActivity();
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this.context, ProfileSuggestActivity.class);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return listUser.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;
        private TextView count_follower;
        private CircleImageView avatar;
        private Button btn_follow;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.user_username);
            count_follower = itemView.findViewById(R.id.user_count_follower);
            avatar = itemView.findViewById(R.id.profile_avatar);
            btn_follow = itemView.findViewById(R.id.user_btn_follow);
        }
    }
}
