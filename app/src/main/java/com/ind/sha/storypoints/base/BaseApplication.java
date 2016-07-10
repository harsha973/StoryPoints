package com.ind.sha.storypoints.base;

import android.app.Application;

import com.ind.sha.storypoints.BuildConfig;
import com.ind.sha.storypoints.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by Sree on 7/10/2016.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().
                setDefaultFontPath(BuildConfig.DEFAULT_FONT).
                setFontAttrId(R.attr.fontPath).build());

    }
}
