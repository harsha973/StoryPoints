package com.ind.sha.storypoints.home.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ind.sha.storypoints.R;
import com.ind.sha.storypoints.base.BaseFragment;
import com.ind.sha.storypoints.home.models.StoryPointsModel;
import com.ind.sha.storypoints.utils.Constants;

/**
 * Created by Sree on 7/10/2016.
 */
public class StoryPointPopupFragment extends BaseFragment implements View.OnClickListener{

    private  StoryPointsModel mStoryPointModel;

    public static String TAG = StoryPointPopupFragment.class.getSimpleName();

    public static StoryPointPopupFragment newInstance(StoryPointsModel storyPointModel, String transitionName) {

        Bundle args = new Bundle();
        args.putParcelable(Constants.KEY_STORY_POINT_MODEL, storyPointModel);
        args.putString(Constants.KEY_TRANSITION_NAME, transitionName);
        StoryPointPopupFragment fragment = new StoryPointPopupFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments() != null ? getArguments() : savedInstanceState;

        mStoryPointModel = bundle.getParcelable(Constants.KEY_STORY_POINT_MODEL);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view  =  inflater.inflate(R.layout.fragment_story_point_popup, container, false);

        String transitionName = getArguments().getString(Constants.KEY_TRANSITION_NAME);
        TextView storyPointTV = (TextView)view.findViewById(R.id.tv_story_point);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            storyPointTV.setTransitionName(transitionName);
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView storyPointTV = (TextView)view.findViewById(R.id.tv_story_point);
        storyPointTV.setText(mStoryPointModel.getPoints());
        storyPointTV.setBackgroundColor(mStoryPointModel.getColorRes());

        storyPointTV.setOnClickListener(this);
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.tv_story_point:
                break;
            default:
                getFragmentManager().popBackStack();
                break;
        }
    }
}
