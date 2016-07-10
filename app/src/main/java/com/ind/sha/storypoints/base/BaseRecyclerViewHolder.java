package com.ind.sha.storypoints.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by sreepolavarapu on 16/06/16.
 */
public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {

    protected BaseActivity mContext;

    public BaseRecyclerViewHolder(BaseActivity context, ViewGroup parent, int layoutResID) {
        super(LayoutInflater.from(context).inflate(layoutResID, parent, false));
        mContext = context;
    }
}
