package com.example.tiktokclone.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tiktokclone.R;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.authen.SignUp;
import com.example.tiktokclone.model.authen.SignUpReponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    private EditText emailSignUp, passWordSignUp, rePassWordSignUp;
    private Button btnSignUp;
    private TextView btnBackLogin, tvHeader;
    private ImageButton btnGoBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        init();
    }
    private void init() {
        tvHeader = findViewById(R.id.tvTitle);
        emailSignUp = findViewById(R.id.signup_username);
        passWordSignUp = findViewById(R.id.signup_password);
        rePassWordSignUp = findViewById(R.id.signup_repassword);
        btnSignUp = findViewById(R.id.btn_signup);
        btnBackLogin = findViewById(R.id.link_login);
        tvHeader.setText("Đăng ký");
        btnGoBack = findViewById(R.id.icBack);
        btnGoBack.setOnClickListener(view -> {
            finish();
        });
        btnSignUp.setOnClickListener(view -> {
            SignUp signUp = new SignUp("email", emailSignUp.getText().toString(),rePassWordSignUp.getText().toString());
            ApiService.apiService.handleSignUp(signUp).enqueue(new Callback<SignUpReponse>() {
                @Override
                public void onResponse(Call<SignUpReponse> call, Response<SignUpReponse> response) {
                    SignUpReponse signUpReponse = response.body();
                    if (signUpReponse != null) {
                        Toast.makeText(SignUpActivity.this, "Đăng kí tài khoản thành công, quay lại đăng nhập", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Đã có lỗi xảy ra", Toast.LENGTH_LONG).show();
                    }
                }
                @Override
                public void onFailure(Call<SignUpReponse> call, Throwable t) {
                    Log.d("Exception", "onFailure: " + t.getMessage());
                }
            });
        });
        btnBackLogin.setOnClickListener(view -> {
            finish();
        });
    }
}
