package com.rock.reward.adapter.userProfile;

import android.app.Activity;
import android.content.Context;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.reward.R;
import com.rock.reward.fragment.userProfile.UserFollowersFragment;
import com.rock.reward.model.UserFollowers;

import java.util.List;

/**
 * Created by rocku27 on 22/9/16.
 */

public class UserFollowerListAdapter extends RecyclerView.Adapter<UserFollowerListAdapter.ViewHolder>   {
    private List<UserFollowers> followers;
    private Activity activities;
    private UserFollowersFragment fragment;
    private Context mContext;

    public UserFollowerListAdapter(List<UserFollowers> followersData, FragmentActivity activity, UserFollowersFragment userFollowers) {
        followers = followersData;
        activities = activity;
    //    mContext = activity.getApplicationContext();
        fragment = userFollowers;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_user_followings, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserFollowerListAdapter.ViewHolder holder, int position) {
        holder.userName.setText(followers.get(position).getFirstName()+" "+followers.get(position).getLastName());
        holder.date.setText(followers.get(position).getFollowDate());

        Glide.with(activities)
                .load(followers.get(position).getUserImageUrl())
                .crossFade()
                .into(holder.userImage);
    }

    @Override
    public int getItemCount() {
        return followers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView userName;
        private final TextView date;
        private final ImageView userImage;
        private final View mview;

        public ViewHolder(View itemView) {
            super(itemView);
            mview = itemView;
            userName = (TextView)mview.findViewById(R.id.user_name);
            date = (TextView)mview.findViewById(R.id.date);
            userImage = (ImageView) mview.findViewById(R.id.user_image);

        }
    }
}
