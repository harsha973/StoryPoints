package com.ind.sha.storypoints.base;

import android.support.v7.widget.RecyclerView;

/**
 * Created by Sree on 7/10/2016.
 */
public abstract class BaseRecyclerAdapter extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    protected BaseActivity mContext;
    protected BaseRecyclerAdapter(BaseActivity context)
    {
        mContext = context;
    }
}
