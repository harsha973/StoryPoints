package com.ind.sha.storypoints.home.fragments;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ind.sha.storypoints.R;
import com.ind.sha.storypoints.base.BaseActivity;
import com.ind.sha.storypoints.base.BaseFragment;
import com.ind.sha.storypoints.home.adapters.HomeRecyclerAdapter;
import com.ind.sha.storypoints.home.models.StoryPointsModel;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Home Fragment
 */
public class HomeFragment extends BaseFragment {

    public static String TAG = HomeFragment.class.getSimpleName();
    private TextView mStoryPointTV;

    public static HomeFragment newInstance() {

        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mStoryPointTV = (TextView) view.findViewById(R.id.tv_story_point);
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.main_recycler);

//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager staggeredGridLayoutManager = new GridLayoutManager(getActivity(), 12);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        HomeRecyclerAdapter recyclerAdapter = new HomeRecyclerAdapter((BaseActivity)getActivity(), this, prepareData());
        recyclerView.setAdapter(recyclerAdapter);

        staggeredGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int mod = position % 6;

                if(position < 8)
                    return 3;
                else if(position < 11)
                    return 4;
                else if(position < 13)
                    return 6;
                else
                    return 12;
            }
        });

    }

    private ArrayList<StoryPointsModel> prepareData()
    {
        ArrayList<StoryPointsModel> storyPointsAL = new ArrayList<>();

        String storyPoints[] = getResources().getStringArray(R.array.storypoints);
        int colors[] = getResources().getIntArray(R.array.storypoints_tile_bg);

        for (int index = 0 ; index < storyPoints.length; index++)
        {
            StoryPointsModel storyPointsModel = new StoryPointsModel();
            storyPointsModel.setPoints(storyPoints[index]);
            storyPointsModel.setColorRes(colors [index]);

            storyPointsAL.add(storyPointsModel);
        }

        return storyPointsAL;
    }

//    public void showStoryPointView(StoryPointsModel storyPointsModel)
//    {
//        TextView storyPointTV = (TextView)view.findViewById(R.id.tv_story_point);
//        storyPointTV.setText(mStoryPointModel.getPoints());
//        storyPointTV.setBackgroundColor(mStoryPointModel.getColorRes());
//
//        storyPointTV.setOnClickListener(this);
//        view.setOnClickListener(this);
//    }
}
