package com.example.tiktokclone.view;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.R;
import com.example.tiktokclone.adapter.ItemAdapter;
import com.example.tiktokclone.adapter.VideoTiktokAdapter;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.userSuggest.Datum;

import com.example.tiktokclone.model.userSuggest.UserSuggest;
import com.example.tiktokclone.model.videoTiktok.Data;
import com.example.tiktokclone.model.videoTiktok.VideoTiktok;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OtherProfileActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    ItemAdapter mRecyclerViewAdapter;
    private ArrayList<Datum> listUserSuggest = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        new Runnable() {
            @Override
            public void run() {
                handlerGetSuggestUser();
            }
        }.run();
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
}
