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
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.local.Category;
import com.example.oa.orderapp.data.local.Menu;

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

    private List<T> items = new ArrayList<>();
    private int type;

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
            return new ItemViewHolder(v);
        } else if (TYPE_LIST_CATEGORY == type) {
            View v = inflater.inflate(R.layout.category_item, viewGroup, false);
            return new CategoryViewHolder(v);
        }else {
            return null;
        }
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Log.d(TAG, "Element " + position + " set.");

        if (holder instanceof CustomAdapter.ItemViewHolder) {
            ItemViewHolder viewHolder = (ItemViewHolder) holder;
            Menu data = (Menu) items.get(position);
            viewHolder.itemName.setText(data.getName());
//            viewHolder.itemPrice.setText(data.getPrice());
        } else if (TYPE_LIST_CATEGORY == type) {
            CategoryViewHolder viewHolder = (CategoryViewHolder) holder;
            Category data = (Category) items.get(position);
            viewHolder.itemName.setText(data.getName());
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }

    /**
     * Provide a reference to the type of views that you are using (custom MenuViewHolder)
     */
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView itemImg;
        @BindView(R.id.item_name)
        TextView itemName;
        @BindView(R.id.item_price)
        TextView itemPrice;

        public ItemViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            // Define click listener for the MenuViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
        }
    }

    /**
     * Provide a reference to the type of views that you are using (custom MenuViewHolder)
     */
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_img)
        ImageView itemImg;
        @BindView(R.id.item_name)
        TextView itemName;
//        @BindView(R.id.item_price)
//        TextView itemPrice;

        public CategoryViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

            // Define click listener for the MenuViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
                }
            });
        }
    }

}