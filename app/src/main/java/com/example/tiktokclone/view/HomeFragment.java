package com.example.tiktokclone.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.tiktokclone.R;
import com.example.tiktokclone.adapter.VideoTiktokAdapter;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.videoTiktok.Data;
import com.example.tiktokclone.model.videoTiktok.VideoTiktok;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private  ArrayList<Data> dataVideo = new ArrayList<>();
    private VideoTiktokAdapter videoTiktokAdapter;
    private RecyclerView recyclerView;

    private VideoView videoView;
    private MediaController mediaController;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private VideoTiktokAdapter getAdapter() {
        if(videoTiktokAdapter == null) {
            videoTiktokAdapter = new VideoTiktokAdapter(getContext(),new ArrayList<>());
        }
        return videoTiktokAdapter;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        new Runnable() {
            @Override
            public void run() {
                handleGetListVideo();
            }
        }.run();

    }


    private void handleGetListVideo() {
        ApiService.apiService.getListVideo("for-you", 1).enqueue(new Callback<VideoTiktok>() {
            @Override
            public void onResponse(Call<VideoTiktok> call, Response<VideoTiktok> response) {
                VideoTiktok videoTiktok = response.body();
                if (videoTiktok !=null && videoTiktok.getData().size() > 0) {
                    for (int i=1;i<videoTiktok.getData().size(); i++){
                        dataVideo.add(new Data(
                                videoTiktok.getData().get(i).getId(),
                                videoTiktok.getData().get(i).getUser_id(),
                                videoTiktok.getData().get(i).getThumb_url(),
                                videoTiktok.getData().get(i).getFile_url(),
                                videoTiktok.getData().get(i).getDescription(),
                                videoTiktok.getData().get(i).getMusic(),
                                videoTiktok.getData().get(i).isIs_liked(),
                                videoTiktok.getData().get(i).getLikes_count(),
                                videoTiktok.getData().get(i).getComments_count(),
                                videoTiktok.getData().get(i).getShares_count(),
                                videoTiktok.getData().get(i).getViews_count(),
                                videoTiktok.getData().get(i).getUser()
                        ));
                    }
//                    videoTiktokAdapter = new VideoTiktokAdapter(getContext(), dataVideo);
//                    videoTiktokAdapter.notifyDataSetChanged();
                    getAdapter().updateData(dataVideo);
                }
            }

            @Override
            public void onFailure(Call<VideoTiktok> call, Throwable t) {
                Toast.makeText(getActivity(), "call api false", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rcListVideo);
        recyclerView.setAdapter(getAdapter());
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        return view;
    }

}