package com.example.tiktokclone.api;

import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.authen.SignUp;
import com.example.tiktokclone.model.authen.SignUpReponse;
import com.example.tiktokclone.model.authen.UserLogin;
import com.example.tiktokclone.model.profile.RootProfile;
import com.example.tiktokclone.model.videoTiktok.VideoTiktok;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://tiktok.fullstack.edu.vn/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("api/videos")
    Call<VideoTiktok> getListVideo(@Query("type") String type, @Query("page") int page);

    @POST("api/auth/login")
    Call<Login> handleLogin(@Body UserLogin userLogin);

    @POST("api/auth/register")
    Call<SignUpReponse> handleSignUp(@Body SignUp signUp);

    @GET("api/auth/me")
    Call<RootProfile> getCurrentUser(@Header("Authorization") String authorization);

    @POST("api/auth/me?_method=PATCH")
    Call<RootProfile> updateProfile(@Header("Authorization") String authorization, @Body RequestBody body);

}
