package com.example.oa.orderapp.presenter.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.oa.orderapp.data.ODObject;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Phoenix on 7/9/17.
 */

public class BaseRecyclerAdapter<T extends RealmObject> extends RecyclerView.Adapter {
    protected RealmList<T> items = new RealmList<T>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
