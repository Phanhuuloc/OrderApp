package com.example.oa.orderapp.presenter.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.ODObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Phoenix on 5/29/17.
 */

public class ProviderItemAdapter extends RecyclerView.Adapter {

    private List<ODObject> items = new ArrayList<>();

    private static final int TYPE_ITEM = 0;
    private final Activity mActivity;

    public ProviderItemAdapter(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater mInflater = LayoutInflater.from(mActivity);
        RecyclerView.ViewHolder viewHolder;
        if (viewType == TYPE_ITEM) {
            View view = mInflater.inflate(R.layout.menu_item, parent, false);
            viewHolder = new ImageViewHolder(view);
        } else {
            View view = mInflater.inflate(R.layout.menu_item, parent, false);
            viewHolder = new ImageViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ImageViewHolder) {
            ImageViewHolder viewHolder = (ImageViewHolder) holder;
//            viewHolder.data = items.get(position);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
