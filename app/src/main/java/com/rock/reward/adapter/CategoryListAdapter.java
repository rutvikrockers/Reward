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
import com.rock.reward.fragment.CardBackFragment;
import com.rock.reward.model.Category;

import java.util.ArrayList;

/**
 * Created by rocku27 on 8/8/16.
 */
public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private Activity activity;
    private ArrayList<Category> categoryList;
    private CardBackFragment cardBackFragment;
    private LayoutInflater inflater;

    public CategoryListAdapter(ArrayList<Category> items, Activity activity, CardBackFragment frg) {
        this.categoryList = items;
        this.activity = activity;
        this.cardBackFragment = frg;
    }


    @Override
    public void onBindViewHolder(CategoryListAdapter.ViewHolder holder, final int position) {
        holder.categoryTitle.setText(categoryList.get(position).getProjectCategoryName());

        Glide.with(cardBackFragment)
                .load(categoryList.get(position).getCategoryImageUrl())
                .placeholder(R.drawable.tw_icon)
                .crossFade()
                .into(holder.categoryImage);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardBackFragment.onButtonPressed(categoryList.get(position).getProjectCategoryId(),categoryList.get(position).getProjectCategoryName(), Integer.parseInt(categoryList.get(position).getActive()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public long getItemId(int position) {
        return position;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_categories, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView categoryTitle;
        public final ImageView categoryImage;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            categoryTitle = (TextView) view.findViewById(R.id.category_name);
            categoryImage = (ImageView) view.findViewById(R.id.category_image);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
