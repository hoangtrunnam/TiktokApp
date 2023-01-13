package com.example.tiktokclone.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tiktokclone.R;
import com.example.tiktokclone.adapter.MailBoxAdapter;
import com.example.tiktokclone.adapter.SearchUserAdapter;
import com.example.tiktokclone.api.ApiService;
import com.example.tiktokclone.model.MailBox;
import com.example.tiktokclone.model.SearchUser;
import com.example.tiktokclone.model.authen.Login;
import com.example.tiktokclone.model.authen.UserLogin;
import com.example.tiktokclone.store.DataLocalManager;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FriendFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FriendFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private RecyclerView rvItems;
    private String mParam2;
    private TextView name;
    private TextView description;
    private CircleImageView image;
    public FriendFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FriendFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FriendFragment newInstance(String param1, String param2) {
        FriendFragment fragment = new FriendFragment();
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


//        btnLogin = getActivity().findViewById(R.id.btnLogin);

//        btnLogin.setOnClickListener(view -> {clickCallApi();});
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friend, container, false);
        Login userLogin = DataLocalManager.getUser();
        image = (CircleImageView)view.findViewById(R.id.image_search);
        description = (TextView)view.findViewById(R.id.description_search);
        name = (TextView)view.findViewById(R.id.name_search);
        rvItems = (RecyclerView)view.findViewById(R.id.friend_search_fragment);
        super.onCreate(savedInstanceState);
            List<SearchUser> people = new ArrayList<>();
            people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
            people.add(new SearchUser("Hai", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));
        people.add(new SearchUser("Long", "Bạn đang chơi trò chơi rất hay","person"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rvItems.setLayoutManager(layoutManager);
            rvItems.setHasFixedSize(true);
            rvItems.setAdapter(new SearchUserAdapter(getActivity(),people));
        return view;

    }
}


