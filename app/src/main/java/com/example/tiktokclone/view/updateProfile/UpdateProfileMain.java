package com.example.tiktokclone.view.updateProfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tiktokclone.R;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.store.DataLocalManager;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpdateProfileMain extends AppCompatActivity {
    private TextView tvHeader, userName, userId, linkUrlTiktok, bio, insUrl,ytUrl, twitterUrl;
    private ImageButton btnGoBack;
    private CircleImageView avatar;
    private LinearLayoutCompat btnEditName, btnEditID, btnEditBio, btnEditIns, btnEditYT, btnEditTwitter;

    private String userNameFromLocal,userIdFromLocal, linkUrlTiktokFromLocal,bioFromLocal,insUrlFromLocal,ytUrlFromLocal, twitterUrlFromLocal;
    private static final String desId = "TikTok ID chỉ có thể bao gồm chữ cái, chữ số, dấu gạch dưới và dấu chấm. khi thay đổi TikTok ID. liên kết hồ sơ của bản cũng sẽ thay đổi. Bạn có thể thay đổi TikTok ID của mình một lần trong 30 ngày";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile_main);
        init();
    }
    private void init() {
        // find id:
        tvHeader = findViewById(R.id.tvTitle);
        btnGoBack = findViewById(R.id.icBack);
        btnEditName = findViewById(R.id.editName);
        btnEditID = findViewById(R.id.editTiTokID);
        btnEditBio = findViewById(R.id.editBio);
        btnEditIns = findViewById(R.id.editIns);
        btnEditYT = findViewById(R.id.editYouTube);
        btnEditTwitter = findViewById(R.id.editTwitter);

        avatar = findViewById(R.id.avatar);
        userName = findViewById(R.id.userName);
        userId = findViewById(R.id.userId);
        linkUrlTiktok = findViewById(R.id.linkUrlMyTiktok);
        bio = findViewById(R.id.bio);
        insUrl = findViewById(R.id.insUrl);
        ytUrl = findViewById(R.id.ytUrl);
        twitterUrl = findViewById(R.id.twitterUrl);
        //
        tvHeader.setText("Sửa hồ sơ");
        btnGoBack.setOnClickListener(view -> {
            finish();
        });

        handleGetProfileLocal();

        btnEditName.setOnClickListener(view -> {
            handleClickView(btnEditName, "Tên", userNameFromLocal,"bạn chỉ có thể thay đổi biệt danh 7 ngày một lần");
        });

        btnEditID.setOnClickListener(view -> {
            handleClickView(btnEditID, "TikTok ID", userIdFromLocal,desId);
        });

        btnEditBio.setOnClickListener(view -> {
            handleClickView(btnEditBio, "Tiểu sử", bioFromLocal,"");
        });

        btnEditIns.setOnClickListener(view -> {
            handleClickView(btnEditIns, "Instagram", insUrlFromLocal,"Nhập nick name instagram của bạn để cập nhật thay đổi");
        });

        btnEditYT.setOnClickListener(view -> {
            handleClickView(btnEditYT, "YouTube", ytUrlFromLocal, "Nhập liên kết Youtube của bạn để đồng bộ hoá với TikTok");
        });
        btnEditTwitter.setOnClickListener(view -> {
            handleClickView(btnEditTwitter, "Twitter", ytUrlFromLocal, "Nhập liên kết Twitter của bạn để đồng bộ hoá với TikTok");
        });

    }

    private void handleClickView (LinearLayoutCompat btnType, String header, String hint, String des) {
        Intent intent = new Intent(this, EditProfile.class);
        intent.putExtra("header", header);
        intent.putExtra("text", hint);
        intent.putExtra("des",des);
        startActivity(intent);
    }



    private void handleGetProfileLocal() {
        Login userLogin = DataLocalManager.getUser();

        if (userLogin != null) {
            userNameFromLocal = userLogin.getData().getFirst_name();
            userIdFromLocal = userLogin.getData().getNickname();
            linkUrlTiktokFromLocal = userLogin.getData().getNickname();
            bioFromLocal = userLogin.getData().getBio();
            insUrlFromLocal = userLogin.getData().getInstagram_url();
            ytUrlFromLocal = userLogin.getData().getYoutube_url();
            twitterUrlFromLocal = userLogin.getData().getTwitter_url();

            userName.setText(userNameFromLocal);
            userId.setText(userIdFromLocal);
            linkUrlTiktok.setText("TikTok.com/@" + linkUrlTiktokFromLocal);
            if (bioFromLocal.equals("")) {
                bio.setText("Thêm tiểu sử");
            } else {
                bio.setText(bioFromLocal);
            }
            if (insUrlFromLocal.equals("")) {
                insUrl.setText("Thêm Instagram");
            } else {
                insUrl.setText(insUrlFromLocal);
            }
            if (ytUrlFromLocal.equals("")) {
                ytUrl.setText("Thêm YouTube");
            } else {
                ytUrl.setText(ytUrlFromLocal);
            }

            if (twitterUrlFromLocal.equals("")) {
                twitterUrl.setText("Thêm Twitter");
            } else {
                twitterUrl.setText(twitterUrlFromLocal);
            }

            Glide.with(this)
                    .load(userLogin.getData().getAvatar())
                    .into(avatar);

        }
    }
}