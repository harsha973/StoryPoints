package com.ind.sha.storypoints.home.viewholders;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ind.sha.storypoints.R;
import com.ind.sha.storypoints.base.BaseRecyclerViewHolder;
import com.ind.sha.storypoints.home.models.StoryPointsModel;

/**
 * Created by Sree on 7/10/2016.
 */
public class HomeTileViewHolder extends BaseRecyclerViewHolder {

    private TextView mStoryPointTV;

    public HomeTileViewHolder(Context context, ViewGroup parent, int layoutResID) {
        super(context, parent, layoutResID);
        mStoryPointTV = (TextView)itemView.findViewById(R.id.tv_story_point);
    }

    public void bind(StoryPointsModel item)
    {
        itemView.setBackgroundColor(item.getColorRes());
        mStoryPointTV.setText(item.getPoints());
    }
}
