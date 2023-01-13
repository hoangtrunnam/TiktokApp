package com.example.tiktokclone.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tiktokclone.R;
import com.example.tiktokclone.model.MailBox;
import com.example.tiktokclone.model.SearchUser;
import com.example.tiktokclone.view.FriendFragment;
import com.example.tiktokclone.view.HomeFragment;
import com.example.tiktokclone.view.MailBoxFragment;
import com.example.tiktokclone.view.NewVideoFragment;
import com.example.tiktokclone.view.ProfileFragment;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SearchUserAdapter extends RecyclerView.Adapter<SearchUserAdapter.DataViewHolder> {

    private List<SearchUser> people;
    private Context context;

    public SearchUserAdapter(Context context, List<SearchUser> people) {
        this.context = context;
        this.people = people;
    }

    @Override
    public int getItemCount() {
        return people == null ? 0 : people.size();
    }

    @Override
    public SearchUserAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_user, parent, false);
        return new DataViewHolder(itemView);
    }





    @Override
    public void onBindViewHolder(SearchUserAdapter.DataViewHolder holder, int position) {
        String name = people.get(position).getName();
        holder.name_search.setText(name);
        String description = people.get(position).getDescription();
        holder.description_search.setText(description);
        String image = people.get(position).getImage();
        holder.image_search.setImageResource(R.drawable.taylor);

        switch (position){
            case 0:
                holder.image_search.setImageResource(R.drawable.taylor);
                break;
            case 1:
                holder.image_search.setImageResource(R.drawable.theweeknd);
                break;
            case 2:
                holder.image_search.setImageResource(R.drawable.ariana);
                break;
            case 3:
                holder.image_search.setImageResource(R.drawable.carrdi);
                break;
            case 4:
                holder.image_search.setImageResource(R.drawable.adele);
                break;
            case 5:
                holder.image_search.setImageResource(R.drawable.sam);
                break;
            case 6:
                holder.image_search.setImageResource(R.drawable.tom);
                break;
            case 7:
                holder.image_search.setImageResource(R.drawable.harry);
                break;
            case 8:
                holder.image_search.setImageResource(R.drawable.nicky);
                break;
            case 9:
                holder.image_search.setImageResource(R.drawable.doja);
                break;
            case 10:
                holder.image_search.setImageResource(R.drawable.taylor);
                break;
            case 11:
                holder.image_search.setImageResource(R.drawable.theweeknd);
                break;
            case 12:
                holder.image_search.setImageResource(R.drawable.ariana);
                break;
            case 13:
                holder.image_search.setImageResource(R.drawable.carrdi);
                break;
            case 14:
                holder.image_search.setImageResource(R.drawable.adele);
                break;
            case 15:
                holder.image_search.setImageResource(R.drawable.sam);
                break;
            case 16:
                holder.image_search.setImageResource(R.drawable.tom);
                break;
            case 17:
                holder.image_search.setImageResource(R.drawable.harry);
                break;
            case 18:
                holder.image_search.setImageResource(R.drawable.nicky);
                break;
            case 19:
                holder.image_search.setImageResource(R.drawable.doja);
                break;
            case 20:
                holder.image_search.setImageResource(R.drawable.taylor);
                break;
            case 21:
                holder.image_search.setImageResource(R.drawable.theweeknd);
                break;
            case 22:
                holder.image_search.setImageResource(R.drawable.ariana);
                break;
            case 23:
                holder.image_search.setImageResource(R.drawable.carrdi);
                break;
            case 24:
                holder.image_search.setImageResource(R.drawable.adele);
                break;
            case 25:
                holder.image_search.setImageResource(R.drawable.sam);
                break;
            default:
                holder.image_search.setImageResource(R.drawable.friend_icon);
        }
    }
    /**
     * Data ViewHolder class.
     */
    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView name_search;
        private TextView description_search;
        private CircleImageView image_search;

        public DataViewHolder(View itemView) {
            super(itemView);
            name_search = (TextView) itemView.findViewById(R.id.name_search);
            description_search = (TextView) itemView.findViewById(R.id.description_search);
            image_search = (CircleImageView) itemView.findViewById(R.id.image_search);
        }
    }
}

