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
import com.example.tiktokclone.view.HomeFragment;

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
        holder.circleimagemailbox.setImageResource(R.drawable.message);
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

