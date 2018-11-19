package com.rock.reward.adapter.user_dashboard;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rock.reward.R;
import com.rock.reward.fragment.user_dashboard.MyFundingFragment;
import com.rock.reward.model.MyDonations;

import java.util.List;

/**
 * Created by rocku27 on 13/9/16.
 */
public class MyDonationListAdapter extends RecyclerView.Adapter<MyDonationListAdapter.ViewHolder> {

    private List<MyDonations> donation;
    private Activity activities;
    private MyFundingFragment fragment;
    private Context mContext;


    public MyDonationListAdapter(List<MyDonations> donations, FragmentActivity activity, MyFundingFragment myFundingFragment) {
        donation = donations;
        activities = activity;
        mContext = activity.getApplicationContext();
        fragment = myFundingFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_my_funding, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyDonationListAdapter.ViewHolder holder, final int position) {
        holder.projectTitle.setText(donation.get(position).getProjectTitle());
        holder.amount.setText(donation.get(position).getAmount());
        holder.date.setText(donation.get(position).getTransactionDateTime());
        holder.status.setText(donation.get(position).getProjectStatus());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return donation.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView projectTitle;
        public final TextView amount;
        public final TextView date;
        public final TextView status;
        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;
            projectTitle = (TextView) mView.findViewById(R.id.project_title);
            amount = (TextView) mView.findViewById(R.id.amount);
            date = (TextView) mView.findViewById(R.id.date);
            status = (TextView) mView.findViewById(R.id.status);
        }
    }
}
