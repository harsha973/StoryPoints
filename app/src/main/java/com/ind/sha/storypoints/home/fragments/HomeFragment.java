package com.ind.sha.storypoints.home.fragments;

import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.main_recycler);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        HomeRecyclerAdapter recyclerAdapter = new HomeRecyclerAdapter((BaseActivity)getActivity(), prepareData());
        recyclerView.setAdapter(recyclerAdapter);

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
}
