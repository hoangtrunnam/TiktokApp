package com.example.tiktokclone.view;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.R;
import com.example.tiktokclone.adapter.CommentAdapter;
import com.example.tiktokclone.adapter.ItemAdapter;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.comment.Comment;
import com.example.tiktokclone.model.comment.Datum;
import com.example.tiktokclone.store.DataLocalManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity {

    private RecyclerView commentRecyclerView;
    private ArrayList<Datum> listComment = new ArrayList<>();
    private CommentAdapter commentAdapter;
    private ImageView close;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_comment);
        close = findViewById(R.id.closeCmt);
        close.setOnClickListener(view -> {
            finish();
        });
        new Runnable() {
            @Override
            public void run() {
                handleGetListComment();
            }


        }.run();
    }

    private void handleGetListComment() {
        Login userLogin = DataLocalManager.getUser();
        int idVideo = DataLocalManager.getIdVideo();
        if (userLogin != null && idVideo != 0) {
            ApiService.apiService.getListComment("Bearer " + userLogin.getMeta().getToken(), idVideo).enqueue(new Callback<Comment>() {
                @Override
                public void onResponse(Call<Comment> call, Response<Comment> response) {
                    Comment comment = response.body();
                    if (comment != null && comment.getData().size() > 0) {
                        commentRecyclerView = (RecyclerView) findViewById(R.id.cmtRecycle);
                        for (int i = 0; i < comment.getData().size(); i++) {
                            listComment.add(new Datum(
                                    comment.getData().get(i).getId(),
                                    comment.getData().get(i).getComment(),
                                    comment.getData().get(i).getLikes_count(),
                                    comment.getData().get(i).isIs_liked(),
                                    comment.getData().get(i).getCreated_at(),
                                    comment.getData().get(i).getUpdated_at(),
                                    comment.getData().get(i).getUser()
                            ));

                        }
                        commentAdapter = new CommentAdapter(CommentActivity.this,listComment);
                        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

                        commentRecyclerView.setLayoutManager(layoutManager);
                        commentRecyclerView.setAdapter(commentAdapter);
                    }
                }

                @Override
                public void onFailure(Call<Comment> call, Throwable t) {

                }
            });

        }
    }
}
