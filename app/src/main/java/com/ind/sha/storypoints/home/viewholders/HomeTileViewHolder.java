package com.ind.sha.storypoints.home.viewholders;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ind.sha.storypoints.R;
import com.ind.sha.storypoints.base.BaseActivity;
import com.ind.sha.storypoints.base.BaseRecyclerViewHolder;
import com.ind.sha.storypoints.home.fragments.HomeFragment;
import com.ind.sha.storypoints.home.fragments.StoryPointPopupFragment;
import com.ind.sha.storypoints.home.models.StoryPointsModel;
import com.ind.sha.storypoints.utils.FragmentManagerUtils;

/**
 * Created by Sree on 7/10/2016.
 */
public class HomeTileViewHolder extends BaseRecyclerViewHolder {

    private TextView mStoryPointTV;
    private HomeFragment mHomeFragment;

    public HomeTileViewHolder(BaseActivity context, HomeFragment homeFragment, ViewGroup parent, int layoutResID) {
        super(context, parent, layoutResID);
        mHomeFragment = homeFragment;
        mStoryPointTV = (TextView)itemView.findViewById(R.id.tv_story_point);
    }

    public void bind(final StoryPointsModel item)
    {
        itemView.setBackgroundColor(item.getColorRes());
        mStoryPointTV.setText(item.getPoints());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManagerUtils.replaceFragmentAndAddToBackStack(mContext,
                        StoryPointPopupFragment.newInstance(item),
                        StoryPointPopupFragment.TAG,
                        FragmentManagerUtils.Animation.ZOOM);
            }
        });
    }
}
