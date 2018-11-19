package com.rock.reward.adapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.reward.R;
import com.rock.reward.activity.ProfileActivity;
import com.rock.reward.model.Follower;
import com.rock.reward.volleyWebservice.Constants;

import java.util.List;


/**
 * Created by rocku27 on 10/8/16.
 */
public class FollowerListAdapterMain extends RecyclerView.Adapter<FollowerListAdapterMain .ViewHolder> {

    private Activity activity;
    private List<Follower> followers;
    private Context mContext;


    public FollowerListAdapterMain(List<Follower> items, Activity activity){
        this.activity = activity;
        this.followers = items;
        this.mContext = activity.getApplicationContext();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_followers_main, parent, false);
        return new ViewHolder(view);
    }

    // Clean all elements of the recycler
    public void clear() {
        followers.clear();
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.followerName.setText(followers.get(position).getUserName()+" "+followers.get(position).getLastName());
        holder.date.setText(followers.get(position).getProjectFollowDate());

        Glide.with(activity)
                .load(followers.get(position).getUserImage())
                .crossFade()
                .override(200, 200)
                .into(holder.followerImage);

        if(followers.get(position).getUserId()!=null && !followers.get(position).getUserId().isEmpty()){
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(mContext, ProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Constants.USER_ID,followers.get(position).getUserId());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return followers.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        public final ImageView followerImage;
        public final TextView followerName;
        public final TextView date;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            followerImage = (ImageView) itemView.findViewById(R.id.follower_image);
            followerName = (TextView)itemView.findViewById(R.id.follower_name);
            date = (TextView)itemView.findViewById(R.id.date);
        }
    }
}
