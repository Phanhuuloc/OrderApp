package com.example.oa.orderapp.presenter.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.local.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;

/**
 * Created by Phoenix on 5/29/17.
 */

public class ProviderItemAdapter extends BaseRecyclerAdapter {

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
        Provider provider = (Provider) items.get(position);
        if (holder instanceof ImageViewHolder) {
            ImageViewHolder viewHolder = (ImageViewHolder) holder;
            viewHolder.setData(provider);
            viewHolder.itemTitle.setText(provider.getName());
            viewHolder.itemDescription.setText(provider.getDescription());
            viewHolder.itemAddress.setText(provider.getAddress());
            viewHolder.itemTime.setText(provider.getOpenHour());
            viewHolder.itemStart.setText(provider.getStar());
//            viewHolder.data = items.get(position);
        } else {

        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(RealmList<Provider> items) {
        this.items = items;
        notifyDataSetChanged();
    }

}
