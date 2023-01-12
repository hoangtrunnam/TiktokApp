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
import com.example.tiktokclone.view.FriendFragment;
import com.example.tiktokclone.view.HomeFragment;
import com.example.tiktokclone.view.MailBoxFragment;
import com.example.tiktokclone.view.NewVideoFragment;
import com.example.tiktokclone.view.ProfileFragment;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MailBoxAdapter extends RecyclerView.Adapter<MailBoxAdapter.DataViewHolder> {

    private List<MailBox> people;
    private Context context;

    public MailBoxAdapter(Context context, List<MailBox> people) {
        this.context = context;
        this.people = people;
    }

    @Override
    public int getItemCount() {
        return people == null ? 0 : people.size();
    }

    @Override
    public MailBoxAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
            itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message, parent, false);
            return new DataViewHolder(itemView);
    }





    @Override
    public void onBindViewHolder(MailBoxAdapter.DataViewHolder holder, int position) {
        String label = people.get(position).getLabel();
        holder.labelmailbox.setText(label);
        String description = people.get(position).getDescription();
        holder.descriptionmailbox.setText(description);
        String date = people.get(position).getDate();
        holder.datemailbox.setText(date);
        String image = people.get(position).getImage();

        switch (position){
            case 0:
                holder.circleimagemailbox.setImageResource(R.drawable.taylor);
                break;
            case 1:
                holder.circleimagemailbox.setImageResource(R.drawable.theweeknd);
                break;
            case 2:
                holder.circleimagemailbox.setImageResource(R.drawable.ariana);
                break;
            case 3:
                holder.circleimagemailbox.setImageResource(R.drawable.carrdi);
                break;
            case 4:
                holder.circleimagemailbox.setImageResource(R.drawable.adele);
                break;
            case 5:
                holder.circleimagemailbox.setImageResource(R.drawable.sam);
                break;
            case 6:
                holder.circleimagemailbox.setImageResource(R.drawable.tom);
                break;
            case 7:
                holder.circleimagemailbox.setImageResource(R.drawable.harry);
                break;
            case 8:
                holder.circleimagemailbox.setImageResource(R.drawable.nicky);
                break;
            case 9:
                holder.circleimagemailbox.setImageResource(R.drawable.doja);
                break;
            case 10:
                holder.circleimagemailbox.setImageResource(R.drawable.taylor);
                break;
            case 11:
                holder.circleimagemailbox.setImageResource(R.drawable.theweeknd);
                break;
            case 12:
                holder.circleimagemailbox.setImageResource(R.drawable.ariana);
                break;
            case 13:
                holder.circleimagemailbox.setImageResource(R.drawable.carrdi);
                break;
            case 14:
                holder.circleimagemailbox.setImageResource(R.drawable.adele);
                break;
            case 15:
                holder.circleimagemailbox.setImageResource(R.drawable.sam);
                break;
            case 16:
                holder.circleimagemailbox.setImageResource(R.drawable.tom);
                break;
            case 17:
                holder.circleimagemailbox.setImageResource(R.drawable.harry);
                break;
            case 18:
                holder.circleimagemailbox.setImageResource(R.drawable.nicky);
                break;
            case 19:
                holder.circleimagemailbox.setImageResource(R.drawable.doja);
                break;
            case 20:
                holder.circleimagemailbox.setImageResource(R.drawable.taylor);
                break;
            case 21:
                holder.circleimagemailbox.setImageResource(R.drawable.theweeknd);
                break;
            case 22:
                holder.circleimagemailbox.setImageResource(R.drawable.ariana);
                break;
            case 23:
                holder.circleimagemailbox.setImageResource(R.drawable.carrdi);
                break;
            case 24:
                holder.circleimagemailbox.setImageResource(R.drawable.adele);
                break;
            case 25:
                holder.circleimagemailbox.setImageResource(R.drawable.sam);
                break;
            default:
                holder.circleimagemailbox.setImageResource(R.drawable.friend_icon);
        }
    }

    /**
     * Data ViewHolder class.
     */
    public static class DataViewHolder extends RecyclerView.ViewHolder {

        private TextView labelmailbox;
        private TextView descriptionmailbox;
        private TextView datemailbox;
        private CircleImageView circleimagemailbox;

        public DataViewHolder(View itemView) {
            super(itemView);
            labelmailbox = (TextView) itemView.findViewById(R.id.labelmailbox);
            descriptionmailbox = (TextView) itemView.findViewById(R.id.descriptionmailbox);
            datemailbox = (TextView) itemView.findViewById(R.id.datemailbox);
            circleimagemailbox = (CircleImageView) itemView.findViewById(R.id.circleimagemailbox);
        }
    }
}

