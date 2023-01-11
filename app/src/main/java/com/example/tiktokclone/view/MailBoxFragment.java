package com.example.tiktokclone.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.tiktokclone.MainActivity;
import com.example.tiktokclone.R;
import com.example.tiktokclone.adapter.MailBoxAdapter;
import com.example.tiktokclone.model.MailBox;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.store.DataLocalManager;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MailBoxFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MailBoxFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //model mailBox

    private CircleImageView image;
    private CircleImageView image1;
    private CircleImageView image2;
    private CircleImageView image3;
    private CircleImageView image4;
    private TextView label;
    private TextView label1;
    private TextView label2;
    private TextView labelmessage;
    private TextView description;
    private RecyclerView rvItems;
    private TextView date;
    private Button button;

    //TODO something
    public MailBoxFragment()
    {


    }




    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MailBoxFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MailBoxFragment newInstance(String param1, String param2) {
        MailBoxFragment fragment = new MailBoxFragment();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mail_box, container, false);
        Login userLogin = DataLocalManager.getUser();
        image = (CircleImageView)view.findViewById(R.id.circleimagemailbox);
        label1 = (TextView) view.findViewById(R.id.labelmailbox1);
        label2 = (TextView) view.findViewById(R.id.labelmailbox2);
        labelmessage = (TextView) view.findViewById(R.id.idmailbox);
        image1 = (CircleImageView)view.findViewById(R.id.imagemailbox1);
        image2 = (CircleImageView)view.findViewById(R.id.imagemailbox2);
        image3 = (CircleImageView)view.findViewById(R.id.imagemailbox3);
        image4 = (CircleImageView)view.findViewById(R.id.imagemailbox4);
        button = (Button) view.findViewById(R.id.btnNavigateLogin2);
        date = (TextView)view.findViewById(R.id.datemailbox);
        description = (TextView)view.findViewById(R.id.descriptionmailbox);
        image1.setVisibility(View.GONE);
        image2.setVisibility(View.GONE);
        image3.setVisibility(View.GONE);
        image4.setVisibility(View.GONE);
        label1.setVisibility(View.GONE);
        label2.setVisibility(View.GONE);
        button.setVisibility(View.GONE);


        if (userLogin != null) {

            super.onCreate(savedInstanceState);

            List<MailBox> people = new ArrayList<>();
            people.add(new MailBox("Long", "Bạn đang chơi trò chơi rất hay","person","20/01/2023"));
            people.add(new MailBox("My", "Nay có đi làm không","message","21/01/2023"));
            people.add(new MailBox("Duong", "Đồ án này được A không","new_video","22/01/2023"));
            people.add(new MailBox("Duyen", "Thầy nay thông lúc mấy giờ","reply","23/01/2023"));
            people.add(new MailBox("Long", "Bạn đang chơi trò chơi rất hay","person","20/01/2023"));
            people.add(new MailBox("My", "Nay có đi làm không","message","21/01/2023"));
            people.add(new MailBox("Duong", "Đồ án này được A không","new_video","22/01/2023"));
            people.add(new MailBox("Duyen", "Thầy nay thông lúc mấy giờ","reply","23/01/2023"));
            people.add(new MailBox("Long", "Bạn đang chơi trò chơi rất hay","person","20/01/2023"));
            people.add(new MailBox("My", "Nay có đi làm không","message","21/01/2023"));
            people.add(new MailBox("Duong", "Đồ án này được A không","new_video","22/01/2023"));
            people.add(new MailBox("Duyen", "Thầy nay thông lúc mấy giờ","reply","23/01/2023"));
            people.add(new MailBox("Long", "Bạn đang chơi trò chơi rất hay","person","20/01/2023"));
            people.add(new MailBox("My", "Nay có đi làm không","message","21/01/2023"));
            people.add(new MailBox("Duong", "Đồ án này được A không","new_video","22/01/2023"));
            people.add(new MailBox("Duyen", "Thầy nay thông lúc mấy giờ","reply","23/01/2023"));
            people.add(new MailBox("Long", "Bạn đang chơi trò chơi rất hay","person","20/01/2023"));
            people.add(new MailBox("My", "Nay có đi làm không","message","21/01/2023"));
            people.add(new MailBox("Duong", "Đồ án này được A không","new_video","22/01/2023"));
            people.add(new MailBox("Duyen", "Thầy nay thông lúc mấy giờ","reply","23/01/2023"));
            people.add(new MailBox("Long", "Bạn đang chơi trò chơi rất hay","person","20/01/2023"));
            people.add(new MailBox("My", "Nay có đi làm không","message","21/01/2023"));
            people.add(new MailBox("Duong", "Đồ án này được A không","new_video","22/01/2023"));
            people.add(new MailBox("Duyen", "Thầy nay thông lúc mấy giờ","reply","23/01/2023"));

            rvItems = (RecyclerView)view.findViewById(R.id.mailbox_fragment);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rvItems.setLayoutManager(layoutManager);
            rvItems.setHasFixedSize(true);
            rvItems.setAdapter(new MailBoxAdapter(getActivity(),people));
            labelmessage.setVisibility(View.VISIBLE);
        }
        else{
            image1.setVisibility(View.VISIBLE);
            image2.setVisibility(View.VISIBLE);
            image3.setVisibility(View.VISIBLE);
            image4.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            label1.setVisibility(View.VISIBLE);
            label2.setVisibility(View.VISIBLE);
            labelmessage.setVisibility(View.GONE);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getActivity(), LoginActivity.class);
                    startActivity(i);
                }
            });
        }
        return view;

    }
}