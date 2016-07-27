package com.ind.sha.storypoints.startup;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ind.sha.storypoints.R;
import com.ind.sha.storypoints.base.BaseActivity;
import com.ind.sha.storypoints.startup.fragments.SplashFragment;
import com.ind.sha.storypoints.utils.FragmentManagerUtils;

/**
 * Created by Sree on 7/27/2016.
 */
public class StartupActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_generic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManagerUtils.addFragment(this, SplashFragment.newInstance(),
                SplashFragment.TAG , FragmentManagerUtils.Animation.NONE);

    }

}
