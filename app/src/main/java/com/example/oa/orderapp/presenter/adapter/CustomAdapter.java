/*
* Copyright (C) 2014 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.oa.orderapp.presenter.adapter;

//import com.example.android.common.logger.Log;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.local.Category;
import com.example.oa.orderapp.data.local.Mon;
import com.example.oa.orderapp.presenter.fragment.RecyclerViewFragment;
import com.michaelmuenzer.android.scrollablennumberpicker.ScrollableNumberPicker;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmObject;

/**
 * Provide views to RecyclerView with data from items.
 */
public class CustomAdapter<T extends RealmObject> extends RecyclerView.Adapter {
    private static final String TAG = "CustomAdapter";
    public static final int TYPE_LIST_MON = 0;
    public static final int TYPE_LIST_CATEGORY = 1;
    public static final int TYPE_LIST_PURCHASE = 3;

    private List<T> items = new ArrayList<>();
    private int type;
    private RecyclerViewFragment.Callback<Mon> callback;

    public void setType(int type) {
        this.type = type;
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view.
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        if (TYPE_LIST_MON == type) {
            View v = inflater.inflate(R.layout.mon_item, viewGroup, false);
            return new MonViewHolder(v);
        } else if (TYPE_LIST_CATEGORY == type) {
            View v = inflater.inflate(R.layout.category_item, viewGroup, false);
            return new CategoryViewHolder(v);
        } else if (TYPE_LIST_PURCHASE == type) {
            View v = inflater.inflate(R.layout.bill_mon_item, viewGroup, false);
            return new BillItemViewHolder(v);
        } else {
            return null;
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        if (holder instanceof CustomAdapter.MonViewHolder) {
            MonViewHolder viewHolder = (MonViewHolder) holder;
            Mon data = (Mon) items.get(position);
            viewHolder.itemName.setText(data.getName());
            viewHolder.itemPrice.setText("" + data.getPrice());
            viewHolder.itemOrder.setOnClickListener(v -> {
                viewHolder.itemOrder.setVisibility(View.GONE);
                viewHolder.itemUnOrder.setVisibility(View.VISIBLE);
                callback.onMenuItemClick(data, false);
            });
            viewHolder.itemUnOrder.setOnClickListener(v -> {
                viewHolder.itemUnOrder.setVisibility(View.GONE);
                viewHolder.itemOrder.setVisibility(View.VISIBLE);
                callback.onMenuItemClick(data, true);
            });
        } else if (TYPE_LIST_CATEGORY == type) {
            CategoryViewHolder viewHolder = (CategoryViewHolder) holder;
            Category data = (Category) items.get(position);
            viewHolder.itemName.setText(data.getName());
        } else if (TYPE_LIST_PURCHASE == type) {
            BillItemViewHolder viewHolder = (BillItemViewHolder) holder;
            Mon data = (Mon) items.get(position);
            viewHolder.itemName.setText(data.getName());
            viewHolder.picker.setMinValue(1);
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setCallback(RecyclerViewFragment.Callback<Mon> callback) {
        this.callback = callback;
    }

    public static class MonViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView itemImg;
        @BindView(R.id.item_name)
        TextView itemName;
        @BindView(R.id.item_price)
        TextView itemPrice;
        @BindView(R.id.item_order)
        Button itemOrder;
        @BindView(R.id.item_un_order)
        Button itemUnOrder;


        public MonViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            v.setOnClickListener(v1 -> Log.d(TAG, "Element " + getAdapterPosition() + " clicked."));
        }
    }

    public static class BillItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView itemImg;
        @BindView(R.id.item_name)
        TextView itemName;
        @BindView(R.id.item_price)
        TextView itemPrice;
        @BindView(R.id.number_picker_horizontal)
        ScrollableNumberPicker picker;
//        @BindView(R.id.item_add)
//        Button itemAdd;
//        @BindView(R.id.item_count)
//        Button itemCount;
//        @BindView(R.id.item_sub)
//        Button itemSub;

        public BillItemViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView itemImg;
        @BindView(R.id.item_name)
        TextView itemName;

        public CategoryViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            // Define click listener for the MenuViewHolder's View.
            v.setOnClickListener(v1 -> Log.d(TAG, "Element " + getAdapterPosition() + " clicked."));
        }
    }

}