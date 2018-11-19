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
import com.rock.reward.model.Funder;

import java.util.List;

/**
 * Created by rocku27 on 10/8/16.
 */
public class FunderListAdapterMain extends RecyclerView.Adapter<FunderListAdapterMain.ViewHolder> {

    private Activity activity;
    private List<Funder> funders;

    public FunderListAdapterMain(List<Funder> funders,Activity activity){
        this.activity=activity;
        this.funders=funders;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_funders_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.funderName.setText(funders.get(position).getFunderName());
        holder.date.setText(funders.get(position).getTransactionDateTime());
        if(funders.get(position).getComment()!=null && !funders.get(position).getComment().isEmpty()){
            holder.funderComment.setText(funders.get(position).getComment());
        }else{
            holder.funderComment.setVisibility(View.GONE);
        }
        holder.funderAmount.setText(funders.get(position).getAmountWithCurrency());

        Glide.with(activity)
                .load(funders.get(position).getUserImage())
                .crossFade()
                .into(holder.funderImage);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
        public final TextView funderComment;
        public final TextView date;

        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            funderImage = (ImageView) itemView.findViewById(R.id.user_image);
            funderAmount = (TextView) itemView.findViewById(R.id.followers);
            funderName = (TextView) itemView.findViewById(R.id.user_name);
            funderComment = (TextView) itemView.findViewById(R.id.comment);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }
}
