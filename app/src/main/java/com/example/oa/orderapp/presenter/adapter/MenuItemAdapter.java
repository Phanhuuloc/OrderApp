package com.example.oa.orderapp.presenter.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.orderapp.R;

/**
 * Created by Phoenix on 5/29/17.
 */

public class MenuItemAdapter extends RecyclerView.Adapter {

    private static final int TYPE_ITEM = 0;
    private final Activity mActivity;

    public MenuItemAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mActivity);
        if (viewType == TYPE_ITEM) {
            View view = mInflater.inflate(R.layout.menu_item, parent, false);
            return new ImageViewHolder(view);
        } else {
            View view = mInflater.inflate(R.layout.menu_item, parent, false);
            return new ImageViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
