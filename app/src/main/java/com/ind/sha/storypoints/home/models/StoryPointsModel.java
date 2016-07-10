package com.ind.sha.storypoints.home.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

/**
 * Created by Sree on 7/10/2016.
 */
public class StoryPointsModel implements Parcelable{

    private String mPoints;
    private @ColorRes int mColorRes;
    private @DrawableRes int mDrawableRes;

    public String getPoints() {
        return mPoints;
    }

    public void setPoints(String points) {
        this.mPoints = points;
    }

    public int getColorRes() {
        return mColorRes;
    }

    public void setColorRes(int colorRes) {
        this.mColorRes = colorRes;
    }

    public int getDrawableRes() {
        return mDrawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.mDrawableRes = drawableRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mPoints);
        dest.writeInt(this.mColorRes);
        dest.writeInt(this.mDrawableRes);
    }

    public StoryPointsModel() {
    }

    protected StoryPointsModel(Parcel in) {
        this.mPoints = in.readString();
        this.mColorRes = in.readInt();
        this.mDrawableRes = in.readInt();
    }

    public static final Creator<StoryPointsModel> CREATOR = new Creator<StoryPointsModel>() {
        @Override
        public StoryPointsModel createFromParcel(Parcel source) {
            return new StoryPointsModel(source);
        }

        @Override
        public StoryPointsModel[] newArray(int size) {
            return new StoryPointsModel[size];
        }
    };
}
