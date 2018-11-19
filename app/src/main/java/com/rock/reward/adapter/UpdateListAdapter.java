package com.rock.reward.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rock.reward.R;
import com.rock.reward.extras.HtmlParser;
import com.rock.reward.model.Update;

import java.util.List;

/**
 * Created by rocku27 on 10/8/16.
 */
public class UpdateListAdapter extends RecyclerView.Adapter<UpdateListAdapter .ViewHolder> {
    private Activity activity;
    private List<Update> updates;

    public UpdateListAdapter(List<Update> items, Activity activity){
        this.activity=activity;
        this.updates=items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_updates, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.e("class name",activity.getClass().getSimpleName().toString());

        if(activity.getClass().getSimpleName().equals("DashboardUpdateActivity")){
            holder.updates.setText(HtmlParser.stripHtml(updates.get(position).getUpdates()));
        }else{
            String htmlText = HtmlParser.stripHtml(updates.get(position).getUpdates());
            String updateText = htmlText.length()>150?htmlText.substring(0,150)+"...":htmlText;
            holder.updates.setText(updateText);
        }

        holder.userName.setText(updates.get(position).getUserName()+" "+updates.get(position).getLastName());
        holder.dateAdded.setText(updates.get(position).getDateAdded());
    }

    @Override
    public int getItemCount() {
        return updates.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        updates.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView updates;
        public final TextView userName;
        public final TextView dateAdded;

        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            updates = (TextView)itemView.findViewById(R.id.updates);
            userName = (TextView)itemView.findViewById(R.id.user_name_s);
            dateAdded = (TextView)itemView.findViewById(R.id.date_added);
        }
    }
}
