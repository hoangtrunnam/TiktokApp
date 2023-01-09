package com.example.tiktokclone.view;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tiktokclone.R;
import com.example.tiktokclone.SplashActivity;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.authen.UserLogin;
import com.example.tiktokclone.store.DataLocalManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText email, passWord;
    private Button btnLogin;
    private TextView btnNavigateSignUp,tvHeader;
    private ImageButton btnGoBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();
    }
    private void init(){
        tvHeader = findViewById(R.id.tvTitle);
        email = findViewById(R.id.login_email);
        passWord = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.btn_login);
        btnNavigateSignUp = findViewById(R.id.link_signup);
        tvHeader.setText("Đăng nhập");
        btnGoBack = findViewById(R.id.icBack);
        btnGoBack.setOnClickListener(view -> {
            finish();
        });
        btnLogin.setOnClickListener(view -> {
            UserLogin userLogin = new UserLogin(email.getText().toString(), passWord.getText().toString());
            ApiService.apiService.handleLogin(userLogin).enqueue(new Callback<Login>() {
                @Override
                public void onResponse(Call<Login> call, Response<Login> response) {
                    Login loginUser = response.body();
                    if (loginUser != null) {
                        Toast.makeText(LoginActivity.this, "login success", Toast.LENGTH_SHORT).show();
                        DataLocalManager.SetUser(loginUser);
                    } else {
                        Toast.makeText(LoginActivity.this, "login false", Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onFailure(Call<Login> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Connect error", Toast.LENGTH_SHORT).show();
                }
            });
        });
        btnNavigateSignUp.setOnClickListener(view -> {
            Intent i = new Intent(this, SignUpActivity.class);
            startActivity(i);
        });
    }

}
