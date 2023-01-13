package com.example.tiktokclone.view;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiktokclone.R;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.store.DataLocalManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewVideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewVideoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewVideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewVideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewVideoFragment newInstance(String param1, String param2) {
        NewVideoFragment fragment = new NewVideoFragment();
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
                handleUpcoming();
            }
        }.run();



    }

    private void handleUpcoming() {
        Login userLogin = DataLocalManager.getUser();

        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        if (userLogin != null){
            alertDialog.setTitle("chào "+ userLogin.getData().getNickname().toString());
        } else {
            alertDialog.setTitle("TikTok xin chào bạn");
        }

        alertDialog.setMessage("Tính năng hiện đang được phát triển, mời bạn quay lại sau tết âm ^^");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Đóng",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_video, container, false);
    }
}