package com.example.tiktokclone.view;

import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tiktokclone.R;
import com.example.tiktokclone.adapter.ItemAdapter;
import com.example.tiktokclone.adapter.VideoTiktokAdapter;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.followUser.FollowUser;
import com.example.tiktokclone.model.otherProfile.OtherProfile;
import com.example.tiktokclone.model.userSuggest.Datum;

import com.example.tiktokclone.model.userSuggest.UserSuggest;
import com.example.tiktokclone.model.videoTiktok.Data;
import com.example.tiktokclone.model.videoTiktok.VideoTiktok;
import com.example.tiktokclone.store.DataLocalManager;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherProfileActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ItemAdapter mRecyclerViewAdapter;
    private ArrayList<Datum> listUserSuggest = new ArrayList<>();
    private CircleImageView avatar;
    private TextView nickName;
    private TextView following;
    private TextView follower;
    private TextView likeCount;
    private Button btnFollow,btnFollowXml;
    private TextView tvHeader;
    private ImageButton btnGoBack;
    private static String avatarDefault = "https://files.fullstack.edu.vn/f8-tiktok/users/11/630266fd71515.jpg";
    private boolean isFollow;
    private boolean trickFollow = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String nickName = extras.getString("nickNameOtherProfile");
        String nicknameApi = "@" + nickName;
        int idUser = Integer.parseInt(extras.getString("idUser"));


        tvHeader = findViewById(R.id.tvTitle);
        tvHeader.setText("Đăng nhập");
        btnGoBack = findViewById(R.id.icBack);
        btnGoBack.setOnClickListener(view -> {
            finish();
        });



        new Runnable() {
            @Override
            public void run() {
                handlerGetSuggestUser();
                handlerGetProfileByNickName(nicknameApi);
            }
        }.run();

        btnFollow = findViewById(R.id.profile_btnFollow);



        btnFollow.setOnClickListener(view -> {
            Login userLogin = DataLocalManager.getUser();
            if (userLogin != null) {
                if (!isFollow && trickFollow) {
                ApiService.apiService.followUser("Bearer "+ userLogin.getMeta().getToken(),idUser).enqueue(new Callback<FollowUser>() {
                    @SuppressLint("ResourceAsColor")
                    @Override
                    public void onResponse(Call<FollowUser> call, Response<FollowUser> response) {
                        FollowUser followUser = response.body();
                        if (followUser != null) {
                            btnFollow.setText("Unfollow");
                            btnFollow.setTextColor(R.color.black);
                            btnFollow.setBackgroundResource(R.color.white);
                            trickFollow = false;
                        } else {
                            Toast.makeText(OtherProfileActivity.this, "call api false", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<FollowUser> call, Throwable t) {
                        Toast.makeText(OtherProfileActivity.this, "connect err", Toast.LENGTH_SHORT).show();
                        Log.d("Exception", "onFailure: " + t.getMessage());
                    }
                });

                } else if (!trickFollow) {
                    ApiService.apiService.unFollowUser("Bearer "+ userLogin.getMeta().getToken(),idUser).enqueue(new Callback<FollowUser>() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onResponse(Call<FollowUser> call, Response<FollowUser> response) {
                            FollowUser followUser = response.body();
                            if (followUser != null) {
                                btnFollow.setText("Follow");
                                btnFollow.setTextColor(R.color.white);
                                btnFollow.setBackgroundResource(R.color.red_tiktok);
                                trickFollow = true;
                            } else {
                                Toast.makeText(OtherProfileActivity.this, "call api false", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<FollowUser> call, Throwable t) {
                            Toast.makeText(OtherProfileActivity.this, "connect err", Toast.LENGTH_SHORT).show();
                            Log.d("Exception", "onFailure: " + t.getMessage());
                        }
                    });

                }
            }

        });


    }

    private void handlerGetSuggestUser() {
        ApiService.apiService.getSuggestUser(1,10).enqueue(new Callback<UserSuggest>() {
            @Override
            public void onResponse(Call<UserSuggest> call, Response<UserSuggest> response) {
                UserSuggest userSuggest = response.body();
                if (userSuggest !=null && userSuggest.getData().size() > 0) {
                    mRecyclerView = (RecyclerView) findViewById(R.id.custom_refresh_recycler_view);
                    for (int i=0;i<userSuggest.getData().size(); i++){
                        listUserSuggest.add(new Datum(
                                userSuggest.getData().get(i).getId(),
                                userSuggest.getData().get(i).getFirst_name(),
                                userSuggest.getData().get(i).getLast_name(),
                                userSuggest.getData().get(i).getNickname(),
                                userSuggest.getData().get(i).getAvatar(),
                                userSuggest.getData().get(i).isTick(),
                                userSuggest.getData().get(i).isIs_followed(),
                                userSuggest.getData().get(i).getFollowings_count(),
                                userSuggest.getData().get(i).getFollowers_count(),
                                userSuggest.getData().get(i).getLikes_count(),
                                userSuggest.getData().get(i).getWebsite_url(),
                                userSuggest.getData().get(i).getFacebook_url(),
                                userSuggest.getData().get(i).getYoutube_url(),
                                userSuggest.getData().get(i).getTwitter_url(),
                                userSuggest.getData().get(i).getInstagram_url(),
                                userSuggest.getData().get(i).getCreated_at(),
                                userSuggest.getData().get(i).getUpdated_at(),
                                userSuggest.getData().get(i).getPopular_video()
                        ));
                    }
                    mRecyclerViewAdapter = new ItemAdapter(listUserSuggest,OtherProfileActivity.this);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setAdapter(mRecyclerViewAdapter);
                }
            }

            @Override
            public void onFailure(Call<UserSuggest> call, Throwable t) {

            }
        });
    }

    private void handlerGetProfileByNickName(String nicknameApi) {

        avatar = findViewById(R.id.profile_avatar);
        nickName = findViewById(R.id.profile_tennguoidung);
        following = findViewById(R.id.profile_dangollow);
        follower = findViewById(R.id.profile_follower);
        likeCount = findViewById(R.id.profile_thich);
        btnFollowXml = findViewById(R.id.profile_btnFollow);

        ApiService.apiService.getProfileUserByNickName(nicknameApi).enqueue(new Callback<OtherProfile>() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onResponse(Call<OtherProfile> call, Response<OtherProfile> response) {
                OtherProfile otherProfile = response.body();
                if(otherProfile != null) {
                    Glide.with(OtherProfileActivity.this)
                            .load(otherProfile.getData().getAvatar())
                            .into(avatar);
                    nickName.setText("@" + otherProfile.getData().getNickname());
                    following.setText(otherProfile.getData().getFollowings_count() + "");
                    follower.setText(otherProfile.getData().getFollowers_count() + "");
                    likeCount.setText(otherProfile.getData().getLikes_count() + "");
                    isFollow = otherProfile.getData().isIs_followed();

//                    Toast.makeText(OtherProfileActivity.this, "isFollow dddd" + isFollow, Toast.LENGTH_SHORT).show();

//                    if(isFollow) {
//                        btnFollowXml.setText("unFollow");
////                        btnFollow.setTextColor(R.color.black);
//                        btnFollowXml.setBackgroundResource(R.color.white);
//                    } else {
//                        btnFollowXml.setText("Follow");
////                        btnFollow.setTextColor(R.color.white);
//                        btnFollowXml.setBackgroundResource(R.color.teal_200);
//                    }
                }
            }

            @Override
            public void onFailure(Call<OtherProfile> call, Throwable t) {

            }
        });
    }
}
