package com.example.tiktokclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.videoTiktok.VideoTiktok;
import com.example.tiktokclone.view.FriendFragment;
import com.example.tiktokclone.view.HomeFragment;
import com.example.tiktokclone.view.MailBoxFragment;
import com.example.tiktokclone.view.NewVideoFragment;
import com.example.tiktokclone.view.ProfileFragment;
import com.example.tiktokclone.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button btnCallApi;

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
        if (Build.VERSION.SDK_INT >= 19) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }


        btnCallApi = findViewById(R.id.btn_call_api);
        btnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCallApi();
                Toast.makeText(MainActivity.this, "vao man home", Toast.LENGTH_LONG).show();
            }

            private void clickCallApi() {
                Toast.makeText(MainActivity.this, "vao man home neeeee", Toast.LENGTH_LONG).show();
                ApiService.apiService.getListVideo("for-you", 1).enqueue(new Callback<VideoTiktok>() {
                    @Override
                    public void onResponse(Call<VideoTiktok> call, Response<VideoTiktok> response) {
                        Log.d("log res:", "onResponse() returned: " + response);
                        VideoTiktok videoTiktok = response.body();
                        if (videoTiktok !=null && videoTiktok.getData().size() > 0) {
                            Toast.makeText(MainActivity.this, videoTiktok.getMeta().getPagination().getLinks().getNext(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<VideoTiktok> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "call api false", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.white));




        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home :
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.friend:
                    replaceFragment(new FriendFragment());
                    break;
                case R.id.newVideo:
                    replaceFragment(new NewVideoFragment());
                    break;
                case R.id.mailBox:
                    replaceFragment(new MailBoxFragment());
                    break;
                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;
            }

            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
    public static void setWindowFlag(MainActivity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }

}