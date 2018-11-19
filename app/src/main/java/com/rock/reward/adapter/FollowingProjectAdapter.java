package com.rock.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.reward.R;
import com.rock.reward.activity.ProjectDetailActivity;
import com.rock.reward.extras.HtmlParser;
import com.rock.reward.fragment.ProjectFollowingFragment;
import com.rock.reward.model.LatestProject;
import java.util.List;


/**
 * Created by rocku27 on 1/8/16.
 */
public class FollowingProjectAdapter extends RecyclerView.Adapter<FollowingProjectAdapter.ViewHolder>  {

    private Activity activity;
    private List<LatestProject> projects;
    private ProjectFollowingFragment projectFollowingFragment;
    private LayoutInflater inflater;
    private Context mContext;

    public FollowingProjectAdapter(List<LatestProject> items, Activity activity, ProjectFollowingFragment frg){
        mContext = activity.getApplicationContext();
        this.projects = items;
        this.activity = activity;
        this.projectFollowingFragment = frg;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_projects, parent, false);
        return new ViewHolder(view);
    }


    // Clean all elements of the recycler
    public void clear() {
        projects.clear();
        notifyDataSetChanged();
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String projectTitle = projects.get(position).getProjectTitle().length()>15?projects.get(position).getProjectTitle().substring(0,15)+"...":projects.get(position).getProjectTitle();
        holder.projectTitle.setText(projects.get(position).getProjectTitle());

        String Location = projects.get(position).getProjectCity()+", "+projects.get(position).getProjectCountry();

        String projectLocation = Location.length()>15?Location.substring(0,15)+"...":Location;

        holder.projectLocation.setText(Location);
        holder.projectAmount.setText(projects.get(position).getAmountWithCurrency());
        holder.projectRaisedAmount.setText("Raised of "+projects.get(position).getAmountGetWithCurrency());

        String CurrentString = HtmlParser.stripHtml(projects.get(position).getEndDate());
        Log.e("strpsss",CurrentString);

        String [] stringParts = CurrentString.split(" ");
        Log.e("strpsss",stringParts[0]);
        Log.e("strpsss",stringParts[1]);
        Log.e("strpsss",stringParts[2]);

        holder.daysLeft.setText(stringParts[0]);
        holder.daysLeftBottom.setText(stringParts[1]+" "+stringParts[2]);


        Glide.with(projectFollowingFragment)
                .load(projects.get(position).getProjectImageUrl())
                .crossFade()
                .into(holder.projectThumbnail);

        if(projects.get(position).getIsFollowed()){
            Glide.with(projectFollowingFragment)
                    .load("")
                    .placeholder(R.drawable.ic_favorite_black_36dp)
                    .into(holder.isFollow);
        }else{
            Glide.with(projectFollowingFragment)
                    .load("")
                    .placeholder(R.drawable.ic_fav)
                    .into(holder.isFollow);
        }

        holder.progressBar.setProgress(Integer.valueOf(projects.get(position).getPercentage().intValue()));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mContext, ProjectDetailActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("project_id",projects.get(position).getProjectId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView projectTitle;
        public final TextView projectLocation;
        public final TextView projectAmount;
        public final TextView projectRaisedAmount;
        public final ProgressBar progressBar;
        public final ImageView projectThumbnail;
        public final ImageView isFollow;
        public final TextView daysLeft;
        public final TextView daysLeftBottom;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            projectTitle = (TextView) view.findViewById(R.id.tv_project_title);
            progressBar = (ProgressBar) view.findViewById(R.id.pb_raised_amount);
            projectLocation = (TextView) view.findViewById(R.id.tv_location);
            projectAmount = (TextView) view.findViewById(R.id.tv_amount);
            projectRaisedAmount = (TextView) view.findViewById(R.id.tv_raised_amount);
            projectThumbnail = (ImageView) view.findViewById(R.id.project_thumbnail);
            daysLeft = (TextView)view.findViewById(R.id.days_left);
            daysLeftBottom = (TextView)view.findViewById(R.id.days_left_bottom);
            isFollow = (ImageView)view.findViewById(R.id.is_follow);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + projectRaisedAmount.getText() + "'";
        }
    }
}
