package com.example.oa.orderapp.presenter.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.orderapp.data.local.Category;
import com.example.oa.orderapp.presenter.ListCategoryPresenter;
import com.example.oa.orderapp.presenter.activity.ProviderActivity;
import com.example.oa.orderapp.presenter.adapter.CustomAdapter;
import com.example.oa.orderapp.presenter.di.components.UserComponent;
import com.example.oa.orderapp.presenter.view.ListCategoryView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/10/17.
 */

public class ListCategoryFragment extends RecyclerViewFragment implements ListCategoryView {
    @Inject
    ListCategoryPresenter presenter;
    private String providerId;

    public ListCategoryFragment() {
        mCurrentLayoutManagerType = TYPE_HORIZONTAL_LIST;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize dataset, this data would usually come from a local content provider or
        // remote server.
        providerId = getArguments().getString(ProviderActivity.ID);

        this.getComponent(UserComponent.class).inject(this);
        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    void initData() {
        mAdapter.setType(CustomAdapter.TYPE_LIST_CATEGORY);
//        mAdapter = new CustomAdapter<Category>();
//        mRecyclerView.setAdapter(mAdapter);
        presenter.getListCategory(providerId);
        initDummyData();
    }

    private void initDummyData() {
        mDataset = new RealmList();
        for (int i = 0; i < 50; i++) {
            mDataset.add(new Category("#"+i));
        }

        mAdapter.setItems(mDataset);
    }

    @Override
    public void showListCategory(RealmList<Category> items) {
        mAdapter.setItems(items);
    }
}
