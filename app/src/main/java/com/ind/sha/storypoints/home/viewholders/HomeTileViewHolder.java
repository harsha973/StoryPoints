package com.ind.sha.storypoints.home.viewholders;

import android.content.Context;
import android.os.Build;
import android.transition.TransitionInflater;
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

import java.util.Random;

/**
 * Created by Sree on 7/10/2016.
 */
public class HomeTileViewHolder extends BaseRecyclerViewHolder {

    private TextView mStoryPointTV;
    private HomeFragment mHomeFragment;
    final String transitionName;

    public HomeTileViewHolder(BaseActivity context, HomeFragment homeFragment, ViewGroup parent, int layoutResID) {
        super(context, parent, layoutResID);
        mHomeFragment = homeFragment;
        mStoryPointTV = (TextView)itemView.findViewById(R.id.tv_story_point);

        transitionName = mContext.getString(R.string.transaction_name_home) + new Random(100).nextInt();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
//            mHomeFragment.setSharedElementReturnTransition(TransitionInflater.from(mContext).inflateTransition(R.transition. change_text_transformation));
//            mHomeFragment.setExitTransition(TransitionInflater.from(mContext).inflateTransition(android.R.transition.explode));
            itemView.setTransitionName(transitionName);
        }
    }

    public void bind(final StoryPointsModel item)
    {
        itemView.setBackgroundColor(item.getColorRes());
        mStoryPointTV.setText(item.getPoints());
//
//        final String transitionName = mContext.getString(R.string.transaction_name_home) + new Random(100).nextInt();
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
//        {
////            mHomeFragment.setSharedElementReturnTransition(TransitionInflater.from(mContext).inflateTransition(R.transition. change_text_transformation));
////            mHomeFragment.setExitTransition(TransitionInflater.from(mContext).inflateTransition(android.R.transition.explode));
//
//            itemView.setTransitionName(transitionName);
//        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManagerUtils.addFragmentAndAddToBackStack(mContext,
                        StoryPointPopupFragment.newInstance(item, transitionName),
                        StoryPointPopupFragment.TAG,
                        FragmentManagerUtils.Animation.FADE_IN);
//                        itemView,
//                        transitionName);
            }
        });
    }
}
