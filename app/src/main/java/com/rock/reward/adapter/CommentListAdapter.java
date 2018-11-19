package com.rock.reward.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.reward.R;
import com.rock.reward.activity.projectDashboard.DashboardCommentActivity;
import com.rock.reward.model.Comment;

import java.util.List;

/**
 * Created by rocku27 on 10/8/16.
 */
public class CommentListAdapter extends RecyclerView.Adapter<CommentListAdapter .ViewHolder> {
    private Activity activity;
    private List<Comment> comments;
    private String activityName;
    private Context mContext;

    public CommentListAdapter(List<Comment> items, Activity activity){
        this.comments=items;
        this.activity=activity;
        this.mContext = activity.getApplicationContext();
        activityName = activity.getClass().getSimpleName();
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_comments, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.userName.setText(comments.get(position).getUserName());
        holder.commentText.setText(comments.get(position).getComments());
        holder.commentDuration.setText(comments.get(position).getDateAdded());

        Glide.with(activity)
                .load(comments.get(position).getUserImage())
                .override(200, 200)
                .centerCrop()
                .into(holder.userImage);

        if(activityName.equals("DashboardCommentActivity")){

            holder.actionMenu.setVisibility(View.VISIBLE);
            holder.actionMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PopupMenu popup = new PopupMenu(activity, holder.actionMenu);

                    popup.getMenuInflater()
                            .inflate(R.menu.comment_action_menu, popup.getMenu());

                    Menu popupMenu = popup.getMenu();

                    if(comments.get(position).getStatus().equals("1")){
                        popupMenu.findItem(R.id.approve).setEnabled(false);
                    }else if(comments.get(position).getStatus().equals("2")){
                        popupMenu.findItem(R.id.decline).setEnabled(false);
                    }else if(comments.get(position).getStatus().equals("3")){
                        popupMenu.findItem(R.id.spam).setEnabled(false);
                    }

                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        public boolean onMenuItemClick(MenuItem item) {

                            switch (item.getItemId()){
                                case R.id.approve:
                                    ((DashboardCommentActivity)activity).commentAction(comments.get(position).getCommentId(),"approved","",comments.get(position).getComments());
                                        break;

                                case R.id.delete:
                                    ((DashboardCommentActivity)activity).commentAction(comments.get(position).getCommentId(),"delete","",comments.get(position).getComments());
                                    break;

                                case R.id.spam:
                                    ((DashboardCommentActivity)activity).commentAction(comments.get(position).getCommentId(),"spam","",comments.get(position).getComments());
                                    break;

                                case R.id.decline:
                                    ((DashboardCommentActivity)activity).commentAction(comments.get(position).getCommentId(),"decline","",comments.get(position).getComments());
                                    break;
                            }
                            return true;
                        }
                    });
                    popup.show(); //showing popup menu
                }
            });
//            holder.commentStatus.setBackgroundResource(R.drawable.tags_rounded_corners);
//            GradientDrawable drawable = (GradientDrawable)  holder.commentStatus.getBackground();
//            drawable.setColor(Color.parseColor("#"));
        }
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    // Clean all elements of the recycler
    public void clear() {
        comments.clear();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView userName;
        public final TextView commentText;
        public final TextView commentDuration;

        public final ImageView userImage;
        public final ImageView actionMenu;

        public final TextView commentStatus;


        public final View mView;

        public ViewHolder(View itemView) {
            super(itemView);
            mView=itemView;
            userName = (TextView)itemView.findViewById(R.id.team_member_text);
            commentText = (TextView)itemView.findViewById(R.id.user_name_s);
            commentDuration = (TextView)itemView.findViewById(R.id.comment_time);
            userImage = (ImageView) itemView.findViewById(R.id.user_image);
            actionMenu = (ImageView) itemView.findViewById(R.id.action_menu);

            commentStatus = (TextView)itemView.findViewById(R.id.comment_status);

        }
    }
}
