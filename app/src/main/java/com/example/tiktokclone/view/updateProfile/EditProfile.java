package com.example.tiktokclone.view.updateProfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiktokclone.R;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.profile.RootProfile;
import com.example.tiktokclone.store.DataLocalManager;
import com.example.tiktokclone.view.LoginActivity;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditProfile extends AppCompatActivity {
    private TextView tvHeader, tvHeaderRight, descriptionForField;
    private EditText editFieldProfile;
    private ImageButton btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        init();
    }
    private void init() {
        Intent prevIntent = getIntent();
        String txtHeader = prevIntent.getStringExtra("header");
        String hint = prevIntent.getStringExtra("text");
        String des = prevIntent.getStringExtra("des");

        tvHeader = findViewById(R.id.tvTitle);
        tvHeaderRight = findViewById(R.id.tvTitleRight);
        editFieldProfile = findViewById(R.id.editFieldProfile);
        descriptionForField = findViewById(R.id.descriptionForField);
        tvHeader.setText(txtHeader);
        editFieldProfile.setText(hint);
        descriptionForField.setText(des);
        tvHeaderRight.setText("save");
        btnGoBack = findViewById(R.id.icBack);
        btnGoBack.setOnClickListener(view -> {
            finish();
        });


        tvHeaderRight.setOnClickListener(view -> {
            String key = "";
            if (txtHeader.equals("Tên")) {
                key = "first_name";
            } else if (txtHeader.equals("TikTok ID")){
                key = "last_name";
            } else if (txtHeader.equals("Tiểu sử")) {
                key = "bio";
            } else if (txtHeader.equals("Instagram")) {
                key = "instagram_url";
            } else if (txtHeader.equals("YouTube")) {
                key = "youtube_url";
            } else if (txtHeader.equals("Twitter")) {
                key = "twitter_url";
            }
            Toast.makeText(this, "key "+ key, Toast.LENGTH_SHORT).show();
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart(key, editFieldProfile.getText().toString())
                    .build();
            Login userLogin = DataLocalManager.getUser();
            ApiService.apiService.updateProfile(userLogin.getMeta().getToken(),requestBody).enqueue(new Callback<RootProfile>() {
                @Override
                public void onResponse(Call<RootProfile> call, Response<RootProfile> response) {
                    RootProfile profileUpdated = response.body();
                    // set lai store
                    if (profileUpdated != null) {
                        Toast.makeText(EditProfile.this, "Update data thanh cong", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(EditProfile.this, "có lỗi xảy ra, vui lòng thử lại", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<RootProfile> call, Throwable t) {
                    Toast.makeText(EditProfile.this, "Connect error", Toast.LENGTH_SHORT).show();
                }
            });
        });



    }

    protected void onDestroy() {
        super.onDestroy();
        // clear text focus
    }
}