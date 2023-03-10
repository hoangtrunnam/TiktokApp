package com.example.tiktokclone.view;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tiktokclone.R;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.profile.RootProfile;
import com.example.tiktokclone.store.DataLocalManager;
import com.example.tiktokclone.view.updateProfile.UpdateProfileMain;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnNavigationLogin;
    private TextView nickName;
    private TextView followingCount;
    private TextView followedCount;
    private TextView likeCount;
    private CircleImageView avatar;
    private Button btnUpdateProfile;
    private ImageView btnAddPeople;
    private ImageView iconCoin;
    private ImageView btnMenu, iconQr;
    public ProfileFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile,container, false);
        btnNavigationLogin = (Button)view.findViewById(R.id.btnNavigateLogin);
        btnUpdateProfile = (Button)view.findViewById(R.id.btnUpdateProfile);
        nickName = view.findViewById(R.id.tennguoidung);
        followingCount = view.findViewById(R.id.dangollow);
        followedCount = view.findViewById(R.id.follower);
        likeCount = view.findViewById(R.id.thich);
        avatar = (CircleImageView)view.findViewById(R.id.avatar);
        btnAddPeople = view.findViewById(R.id.iconAddPeople);
        btnMenu = view.findViewById(R.id.iconMenu);
        iconCoin = view.findViewById(R.id.iconCoin);
        iconQr = view.findViewById(R.id.iconQr);

        btnUpdateProfile.setVisibility(View.GONE);
        btnAddPeople.setVisibility(View.GONE);
        btnMenu.setVisibility(View.GONE);
        iconCoin.setVisibility(View.GONE);
        iconQr.setVisibility(View.GONE);

        Login userLogin = DataLocalManager.getUser();
        if (userLogin != null) {
            btnNavigationLogin.setVisibility(View.GONE);
            btnUpdateProfile.setVisibility(View.VISIBLE);
            btnAddPeople.setVisibility(View.VISIBLE);
            btnMenu.setVisibility(View.VISIBLE);
            iconCoin.setVisibility(View.VISIBLE);
            iconQr.setVisibility(View.VISIBLE);

            new Runnable() {
                @Override
                public void run() {
                    handleGetCurrentuser(userLogin);
                }
            }.run();



            btnMenu.setOnClickListener(view2 -> {
                showDialog();
            });


//            nickName.setText("@" + userLogin.getData().getNickname());
//            followingCount.setText(userLogin.getData().getFollowings_count() + ""); //maybe null
//            followedCount.setText(userLogin.getData().getFollowers_count() + ""); //maybe null
//            likeCount.setText(userLogin.getData().getLikes_count() + "");
//            Glide.with(getActivity())
//                    .load(userLogin.getData().getAvatar())
//                    .into(avatar);

            btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getActivity(), UpdateProfileMain.class);
                    startActivity(i);
                }
            });
        }

        btnNavigationLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.putExtra("tagIconBack", "true");
                startActivity(intent);
            }
        });

        return view;
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet);

        LinearLayoutCompat btnLogout = dialog.findViewById(R.id.logout);

        btnLogout.setOnClickListener(view -> {
            dialog.hide();
            DataLocalManager.loggedOut();
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            intent.putExtra("tagIconBack", "false");
            startActivity(intent);
        });

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable((Color.TRANSPARENT)));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAni;
        dialog.getWindow().setGravity(Gravity.BOTTOM);

    }

    public void handleGetCurrentuser(Login userLogin) {
        ApiService.apiService.getCurrentUser("Bearer "+ userLogin.getMeta().getToken()).enqueue(new Callback<RootProfile>() {
            @Override
            public void onResponse(Call<RootProfile> call, Response<RootProfile> response) {
                RootProfile profile = response.body();
                if (profile != null) {
                    nickName.setText("@" + profile.getData().getNickname());
                    followingCount.setText(profile.getData().getFollowings_count() + ""); //maybe null
                    followedCount.setText(profile.getData().getFollowers_count() + ""); //maybe null
                    likeCount.setText(profile.getData().getLikes_count() + "");
                    Glide.with(getActivity())
                            .load(profile.getData().getAvatar())
                            .into(avatar);
                } else {
                    Toast.makeText(getActivity(), "C?? l???i x???y ra, vui l??ng th??? l???i", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RootProfile> call, Throwable t) {
                Toast.makeText(getActivity(), "Connetion error", Toast.LENGTH_SHORT).show();
            }
        });

    }


}