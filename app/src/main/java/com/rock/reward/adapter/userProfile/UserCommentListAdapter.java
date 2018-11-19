package com.rock.reward.adapter.userProfile;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.reward.R;
import com.rock.reward.fragment.userProfile.UserCommentsFragment;
import com.rock.reward.model.MyComment;

import java.util.List;


/**
 * Created by rocku27 on 22/9/16.
 */

public class UserCommentListAdapter extends RecyclerView.Adapter<UserCommentListAdapter.ViewHolder> {

    private List<MyComment> comments;
    private Activity activities;
    private UserCommentsFragment fragment;
    private Context mContext;



    public UserCommentListAdapter(List<MyComment> commentsData, Activity activity, UserCommentsFragment myCommentFragment) {
        comments = commentsData;
        activities = activity;
        fragment = myCommentFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_my_comments, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.projectTitle.setText(comments.get(position).getProjectTitle());
        holder.comment.setText(comments.get(position).getComments());
        holder.date.setText(comments.get(position).getCommentDate());

        if(comments.get(position).getProjectImageUrl()!=null && comments.get(position).getProjectImageUrl()!=""){
            Glide.with(activities)
                    .load(comments.get(position).getProjectImageUrl())
                    .crossFade()
                    .into(holder.projectImage);
        }

    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView projectImage;
        public final TextView projectTitle;
        public final TextView comment;
        public final TextView date;
        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            projectTitle = (TextView) mView.findViewById(R.id.project_title);
            comment = (TextView) mView.findViewById(R.id.comment);
            date = (TextView) mView.findViewById(R.id.date);
            projectImage = (ImageView) mView.findViewById(R.id.project_image);
        }
    }
}
