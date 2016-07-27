package com.ind.sha.storypoints.startup.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ind.sha.storypoints.R;
import com.ind.sha.storypoints.base.BaseFragment;

/**
 * Created by Sree on 7/27/2016.
 */
public class LoginFragment extends BaseFragment {

    public static final String TAG = LoginFragment.class.getSimpleName();

    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
