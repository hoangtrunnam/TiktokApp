package com.example.tiktokclone.adapter;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tiktokclone.R;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.videoTiktok.Data;
import com.example.tiktokclone.model.videoLiked.VideoLiked;
import com.example.tiktokclone.store.DataLocalManager;
import com.example.tiktokclone.view.CommentActivity;
import com.example.tiktokclone.view.LoginActivity;
import com.example.tiktokclone.view.OtherProfileActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideoTiktokAdapter extends RecyclerView.Adapter<VideoTiktokAdapter.VideoTiktokHolder> {
    private ArrayList<Data> listVideoTiktok;
    private Context context;

//    public VideoTiktokAdapter( Context context, ArrayList<Data> listVideoTiktok) {
//        this.context = context;
//        this.listVideoTiktok = listVideoTiktok;
//    }

    public VideoTiktokAdapter(Context context,ArrayList<Data> listVideoTiktok) {
        this.context = context;
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

        Uri uri = Uri.parse(videoTiktok.getFile_url());
        holder.videoView.setVideoURI(uri);
        holder.videoView.start();
        MediaController mediaController = new MediaController(context);
        mediaController.setAnchorView(holder.videoView);
        holder.videoView.setMediaController(mediaController);



//        holder.videoView.setVideoPath("C:\\Users\\Admin\\AndroidStudioProjects\\TiktokClone\\app\\src\\main\\res\\raw\\videotest.mp4");
//        MediaController mediaController = new MediaController(context);
//        mediaController.setAnchorView(holder.videoView);
//        holder.videoView.setMediaController(mediaController);

//        Uri uri = Uri.parse("https://v16-webapp.tiktok.com/bd9532bc0bbaf3a4c2059550f2eabe8a/63bbee5b/video/tos/useast2a/tos-useast2a-pve-0037c001-aiso/o4CKzhoGISxQqYBFUA2vMnfDp2aBzhN2BgANYW/?a=1988&ch=0&cr=0&dr=0&lr=tiktok&cd=0%7C0%7C1%7C0&cv=1&br=4092&bt=2046&cs=0&ds=3&ft=hatGN2BHjVQ9wV_u9Dhd.5AUkX4gTsU9pmaOjLYqEeC&mime_type=video_mp4&qs=0&rc=PGlmNzY8NDQ0ZTo8ZGk2OkBpM2Z0ZDQ6ZmVmaDMzZjgzM0AxMGBjL2E0Ni4xYTEwNjFgYSNhaDU2cjQwbG9gLS1kL2Nzcw%3D%3D&l=20230109043657C20F05D88B6D14012C26&btag=80000");
//        holder.videoView.setVideoURI(uri);
//        holder.videoView.start();
//        MediaController mediaController = new MediaController(context);
//        mediaController.setAnchorView(holder.videoView);
//        holder.videoView.setMediaController(mediaController);

        holder.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        if (videoTiktok.getUser().getAvatar().equals("https://files.fullstack.edu.vn/f8-tiktok/") || videoTiktok.getUser().getAvatar() == null) {
            holder.avatar.setImageResource(R.drawable.persion_icon);
            Log.i("nopeeee", "ko co icon");
        } else {
//            Uri uriImage = Uri.parse(videoTiktok.getUser().getAvatar());
//            holder.avatar.setImageURI(uriImage);
            Log.i("oceeee", "co icon");
            Glide.with(context)
                    .load(videoTiktok.getUser().getAvatar())
                    .into(holder.avatar);
        }

        // bat su kien click avatar
        holder.avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, OtherProfileActivity.class);
                Bundle extras = new Bundle();
                extras.putString("nickNameOtherProfile", videoTiktok.getUser().getNickname());
                extras.putString("idUser", videoTiktok.getUser_id() + "");
                intent.putExtras(extras);
                context.startActivity(intent);
            }
        });

        Login userLogin = DataLocalManager.getUser(); // get token
        // bat su kien like
            holder.like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (userLogin != null) {
                        ApiService.apiService.likeAVideo("Bearer "+ userLogin.getMeta().getToken(), videoTiktok.getId()).enqueue(new Callback<VideoLiked>() {
                            @Override
                            public void onResponse(Call<VideoLiked> call, Response<VideoLiked> response) {
                                VideoLiked videoLiked = response.body();
                                if (videoLiked != null){
                                    holder.like.setImageResource(R.drawable.heart_like_love_icon_red);
                                    holder.likeCount.setText(videoLiked.getData().getLikes_count() + "");
                                } else {
                                    Toast.makeText(context, "Có lỗi xảy ra, vui lòng thử lại", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<VideoLiked> call, Throwable t) {

                            }
                        });
                    } else {
                        Toast.makeText(context, "Vui lòng đăng nhập", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        holder.comment.setOnClickListener(view -> {
            DataLocalManager.SetIdVideo(videoTiktok.getId());
            Intent intent = new Intent(context, CommentActivity.class);
            intent.putExtra("uuid", videoTiktok.getUuid());
            context.startActivity(intent);
        });


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
        private VideoView videoView;
        private CircleImageView avatar;
        private ImageView like;
        private ImageView comment;


        public VideoTiktokHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.userName);
            description = itemView.findViewById(R.id.description);
            music = itemView.findViewById(R.id.music);
            likeCount = itemView.findViewById(R.id.likeCount);
            commentCount = itemView.findViewById(R.id.commentCount);
            shareCount = itemView.findViewById(R.id.shareCount);
            avatar = itemView.findViewById(R.id.circleImageView);
            videoView = (VideoView) itemView.findViewById(R.id.videoId);
            like = itemView.findViewById(R.id.likeVideo);
            comment = itemView.findViewById(R.id.iconComment);

        }
    }
    private void showDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_comment);




        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAni;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }
}
