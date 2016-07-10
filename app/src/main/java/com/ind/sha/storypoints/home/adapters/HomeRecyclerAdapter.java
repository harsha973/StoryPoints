package com.ind.sha.storypoints.home.adapters;

import android.view.ViewGroup;

import com.ind.sha.storypoints.R;
import com.ind.sha.storypoints.base.BaseActivity;
import com.ind.sha.storypoints.base.BaseRecyclerAdapter;
import com.ind.sha.storypoints.base.BaseRecyclerViewHolder;
import com.ind.sha.storypoints.home.models.StoryPointsModel;
import com.ind.sha.storypoints.home.viewholders.HomeTileViewHolder;

import java.util.ArrayList;

/**
 * Created by Sree on 7/10/2016.
 */
public class HomeRecyclerAdapter extends BaseRecyclerAdapter {

    private ArrayList<StoryPointsModel> mStoryPointsAL;

    public HomeRecyclerAdapter(BaseActivity context, ArrayList<StoryPointsModel> storyPointsAL)
    {
        super(context);
        mStoryPointsAL = storyPointsAL;
    }
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeTileViewHolder(mContext, parent, R.layout.recycler_item_storypoints);
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {

        ((HomeTileViewHolder)holder).bind(getItem(position));
    }

    @Override
    public int getItemCount() {
        return mStoryPointsAL.size();
    }

    private StoryPointsModel getItem(int position)
    {
       return mStoryPointsAL.get(position);
    }
}
