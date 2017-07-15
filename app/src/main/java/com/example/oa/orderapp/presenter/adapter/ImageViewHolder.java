package com.example.oa.orderapp.presenter.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.presenter.activity.ProviderDetailActivity;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Phoenix on 5/29/17.
 */

class ImageViewHolder extends RecyclerView.ViewHolder {
    Provider data;
    Context context;
    @BindView(R.id.item_title)
    TextView itemTitle;
    @BindView(R.id.item_address)
    TextView itemAddress;
    @BindView(R.id.item_description)
    TextView itemDescription;
    @BindView(R.id.item_time)
    TextView itemTime;
    @BindView(R.id.start)
    TextView itemStart;
    @BindView(R.id.item_content)
    LinearLayout itemContent;

    public ImageViewHolder(View view) {
        super(view);
        context = view.getContext();
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.item_content)
    public void onViewClicked() {
        Bundle b = new Bundle();
        b.putParcelable(ProviderDetailActivity.DATA, Parcels.wrap(data));
        ProviderDetailActivity.start(context, b);
    }

    public void setData(Provider data) {
        this.data = data;
    }
}
