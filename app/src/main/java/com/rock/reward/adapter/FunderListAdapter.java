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
import com.rock.reward.model.Funder;
import com.rock.reward.volleyWebservice.Constants;

import java.util.List;

/**
 * Created by rocku27 on 10/8/16.
 */
public class FunderListAdapter extends RecyclerView.Adapter<FunderListAdapter.ViewHolder> {

    private Activity activity;
    private List<Funder> funders;
    private String activityName;
    private Context mContext;

    public FunderListAdapter(List<Funder> funders,Activity activity){
        this.activity=activity;
        this.funders=funders;
        activityName = activity.getClass().getSimpleName();
        mContext = activity.getApplicationContext();
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_funders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.funderName.setText(funders.get(position).getFunderName());
        holder.funderAmount.setText(funders.get(position).getAmountWithCurrency());

        Glide.with(activity)
                .load(funders.get(position).getUserImage())
              //  .placeholder(R.drawable.tw_icon)
                .crossFade()
                .into(holder.funderImage);

//        Glide.with(activity.getApplicationContext())
//                .load(funders.get(position).getUserImage())
//                .asBitmap()
//                .centerCrop()
//                .into(new BitmapImageViewTarget(holder.funderImage) {
//                    @Override
//                    protected void setResource(Bitmap resource) {
//                        RoundedBitmapDrawable circularBitmapDrawable =
//                                RoundedBitmapDrawableFactory.create(activity.getApplicationContext().getResources(), resource);
//                        circularBitmapDrawable.setCircular(true);
//                        holder.funderImage.setImageDrawable(circularBitmapDrawable);
//                    }
//        });
        if(funders.get(position).getDonorId()!=null && !funders.get(position).getDonorId().isEmpty()){
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent= new Intent(mContext, ProfileActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra(Constants.USER_ID,funders.get(position).getDonorId());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    // Clean all elements of the recycler
    public void clear() {
        funders.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return funders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView funderImage;
        public final TextView funderAmount;
        public final TextView funderName;
        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            funderImage = (ImageView) itemView.findViewById(R.id.user_image);
            funderAmount = (TextView) itemView.findViewById(R.id.followers);
            funderName = (TextView) itemView.findViewById(R.id.user_name);
        }
    }
}
