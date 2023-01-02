package com.example.tiktokclone.api;

import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.authen.UserLogin;
import com.example.tiktokclone.model.videoTiktok.VideoTiktok;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
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

}
