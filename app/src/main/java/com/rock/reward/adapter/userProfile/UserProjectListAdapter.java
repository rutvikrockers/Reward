package com.rock.reward.adapter.userProfile;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.reward.R;
import com.rock.reward.fragment.userProfile.UserCreatedCampaignsFragment;
import com.rock.reward.model.Project;

import java.util.List;


/**
 * Created by rocku27 on 22/9/16.
 */

public class UserProjectListAdapter  extends RecyclerView.Adapter<UserProjectListAdapter.ViewHolder>  {

    private List<Project> projects;
    private Activity activities;
    private UserCreatedCampaignsFragment myProjectList;
    private Context mContext;


    public UserProjectListAdapter(List<Project> projectsData, FragmentActivity activity, UserCreatedCampaignsFragment myProjectList) {
        projects = projectsData;
        activities = activity;
        mContext = activity.getApplicationContext();
        myProjectList = myProjectList;
    }



    @Override
    public UserProjectListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_my_projects, parent, false);
        return new UserProjectListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.projectTitle.setText(projects.get(position).getProjectTitle());

        String amountGet = "Raised: "+projects.get(position).getAmountGetWithCurrency();
        final SpannableStringBuilder sb = new SpannableStringBuilder(amountGet);
        final StyleSpan bss = new StyleSpan(android.graphics.Typeface.BOLD);
        sb.setSpan(bss,7,amountGet.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        holder.amountRaised.setText(sb);

        String amount = "Goal: "+projects.get(position).getAmountWithCurrency();
        final SpannableStringBuilder sbamt = new SpannableStringBuilder(amount);
        final StyleSpan bssamt = new StyleSpan(android.graphics.Typeface.BOLD);
        sbamt.setSpan(bssamt,5,amount.length(),Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        holder.amount.setText(sbamt);

        holder.status.setText(projects.get(position).getProjectStatus().toUpperCase());

        holder.status.setBackgroundResource(R.drawable.tags_rounded_corners);
        GradientDrawable drawable = (GradientDrawable)  holder.status.getBackground();
        drawable.setColor(Color.parseColor("#"+projects.get(position).getStatusColor()));

        Log.e("project image",projects.get(position).getProjectImageUrl());

        if(projects.get(position).getProjectImageUrl()!=null && projects.get(position).getProjectImageUrl()!=""){
            Glide.with(activities)
                    .load(projects.get(position).getProjectImageUrl())
                    .crossFade()
                    .into(holder.projectImage);
        }

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent= new Intent(mContext, ProjectDashboardActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                intent.putExtra("project_id",projects.get(position).getProjectId());
//                mContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView projectImage;
        public final TextView projectTitle;
        public final TextView amount;
        public final TextView amountRaised;
        public final TextView status;
        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            projectTitle = (TextView) mView.findViewById(R.id.project_title);
            amount = (TextView) mView.findViewById(R.id.project_title);
            amountRaised = (TextView) mView.findViewById(R.id.amount_raised);
            status = (TextView) mView.findViewById(R.id.status);
            projectImage = (ImageView) mView.findViewById(R.id.project_image);
        }
    }
}
