package com.example.tiktokclone.api;

import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.authen.SignUp;
import com.example.tiktokclone.model.authen.SignUpReponse;
import com.example.tiktokclone.model.authen.UserLogin;

import com.example.tiktokclone.model.followUser.FollowUser;
import com.example.tiktokclone.model.otherProfile.OtherProfile;
import com.example.tiktokclone.model.profile.RootProfile;
import com.example.tiktokclone.model.userSuggest.UserSuggest;

import com.example.tiktokclone.model.videoLiked.VideoLiked;
import com.example.tiktokclone.model.videoTiktok.VideoTiktok;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {


    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://tiktok.fullstack.edu.vn/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService.class);

    @GET("api/videos")
    Call<VideoTiktok> getListVideo(@Query("type") String type, @Query("page") int page);

    @POST("api/auth/login")
    Call<Login> handleLogin(@Body UserLogin userLogin);


    @POST("api/auth/register")
    Call<SignUpReponse> handleSignUp(@Body SignUp signUp);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("api/auth/me")
    Call<RootProfile> getCurrentUser(@Header("Authorization") String authorization);

//    @Multipart
    @FormUrlEncoded
    @POST("api/auth/me?_method=PATCH")
    Call<RootProfile> updateProfile(@Header("Authorization") String authorization, @FieldMap Map<String,String> params);

    @GET("api/users/suggested")
    Call<UserSuggest> getSuggestUser(@Query("page") int page, @Query("per_page") int per_page);

    @GET("api/users/{nickName}")
    Call<OtherProfile> getProfileUserByNickName(@Path("nickName") String nickName);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("api/users/{idUser}/follow")  
    Call<FollowUser> followUser(@Header("Authorization") String authorization, @Path("idUser") int idUser);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("api/users/{idUser}/follow")
    Call<FollowUser> unFollowUser(@Header("Authorization") String authorization, @Path("idUser") int idUser);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("api/users/{idVideo}/follow")
    Call<VideoLiked> likeAVideo(@Header("Authorization") String authorization, @Path("idVideo") int idVideo);

}
