package com.rock.reward.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.reward.R;
import com.rock.reward.model.TeamMember;

import java.util.List;

/**
 * Created by rocku27 on 10/8/16.
 */
public class TeamMemberListAdapter extends RecyclerView.Adapter<TeamMemberListAdapter .ViewHolder>{

    private Activity activity;
    private List<TeamMember> members;

    public TeamMemberListAdapter(List<TeamMember> items, Activity activity){
        this.members=items;
        this.activity=activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_team_members, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TeamMemberListAdapter.ViewHolder holder, int position) {
        holder.userName.setText(members.get(position).getUserName());
        holder.dateAdded.setText(members.get(position).getMemberRole());

        Glide.with(activity)
                .load(members.get(position).getUserImage())
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView userName;
        public final TextView dateAdded;
        public final ImageView userImage;

        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            userImage = (ImageView)itemView.findViewById(R.id.user_image);
            userName = (TextView)itemView.findViewById(R.id.user_name_s);
            dateAdded = (TextView)itemView.findViewById(R.id.date_added);
        }
    }
}
