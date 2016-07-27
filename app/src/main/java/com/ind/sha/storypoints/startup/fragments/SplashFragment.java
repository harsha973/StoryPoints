package com.ind.sha.storypoints.startup.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ind.sha.storypoints.R;
import com.ind.sha.storypoints.base.BaseActivity;
import com.ind.sha.storypoints.base.BaseFragment;
import com.ind.sha.storypoints.utils.FragmentManagerUtils;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sree on 7/27/2016.
 */
public class SplashFragment extends BaseFragment {

    public static final String TAG = SplashFragment.class.getSimpleName();

    public static SplashFragment newInstance() {

        Bundle args = new Bundle();

        SplashFragment fragment = new SplashFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        TimerTask timertask = new TimerTask() {
            @Override
            public void run() {
                FragmentManagerUtils.replaceFragment(
                        (BaseActivity)getActivity(),
                        LoginFragment.newInstance(),
                        LoginFragment.TAG,
                        FragmentManagerUtils.Animation.SLIDE_IN_RIGHT);
            }
        };

        Timer timer = new Timer();
        timer.schedule(timertask, 1000);
    }
}
