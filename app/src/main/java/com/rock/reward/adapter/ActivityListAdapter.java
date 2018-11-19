package com.rock.reward.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rock.reward.R;
import com.rock.reward.fragment.MyActivityFragment;
import com.rock.reward.model.UserActivity;

import java.util.List;

/**
 * Created by rocku27 on 24/8/16.
 */
public class ActivityListAdapter extends RecyclerView.Adapter<ActivityListAdapter.ViewHolder> {

    private Activity activity;
    private List<UserActivity> userActivities;
    private MyActivityFragment myActivityFragment;
    private LayoutInflater inflater;

    public ActivityListAdapter(List<UserActivity> activities, Activity activity, MyActivityFragment myActivityFragment) {
        this.userActivities = activities;
        this.activity = activity;
        this.myActivityFragment = myActivityFragment;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_my_activities, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ActivityListAdapter.ViewHolder holder, int position) {
//        holder.activityText.setText(userActivities.get(position).getActionDetail());

        String activityText = userActivities.get(position).getActionDetail();
        String userName = userActivities.get(position).getUserName();
        String projectName = userActivities.get(position).getProjectTitle();

//        SpannableStringBuilder builder = new SpannableStringBuilder();
//
//        SpannableString redSpannable= new SpannableString(userName);
//        redSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, redSpannable.length(), 0);
//        builder.append(redSpannable);
//
//        SpannableString redProjectSpannable= new SpannableString(projectName);
//        redProjectSpannable.setSpan(new ForegroundColorSpan(Color.RED), 0, redSpannable.length(), 0);
//        builder.append(redSpannable);


        activityText = activityText.replace("###@###project###@###","<font color=\"#ce243f\">"+projectName+"</font>");
        activityText = activityText.replace("###@###user###@###", "<font color=\"#ce243f\">"+userName+"</font>");
        Log.e("activityText",activityText);

        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(activityText,Html.FROM_HTML_MODE_LEGACY);
            holder.activityText.setText(result);
        } else {
            result = Html.fromHtml(activityText);
            holder.activityText.setText(result);
        }



        holder.date.setText(userActivities.get(position).getDatetime());
    }

    @Override
    public int getItemCount() {
        return userActivities.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView activityText;
        public final TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            activityText = (TextView) mView.findViewById(R.id.activity_text);
            date = (TextView) mView.findViewById(R.id.date);
        }
    }
}
