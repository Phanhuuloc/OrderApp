package com.example.oa.orderapp.presenter.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.orderapp.data.local.Category;
import com.example.oa.orderapp.presenter.MenuCategoryPresenter;
import com.example.oa.orderapp.presenter.adapter.CustomAdapter;
import com.example.oa.orderapp.presenter.di.components.UserComponent;
import com.example.oa.orderapp.presenter.view.ListCategoryView;

import java.util.ArrayList;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/10/17.
 */

public class ListCategoryFragment extends RecyclerViewFragment implements ListCategoryView {
    @Inject
    MenuCategoryPresenter presenter;

    public ListCategoryFragment() {
        mCurrentLayoutManagerType = TYPE_HORIZONTAL_LIST;
    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // Initialize dataset, this data would usually come from a local content provider or
//        // remote server.
//        mCurrentLayoutManagerType = getArguments().getInt(KEY_LAYOUT_MANAGER);
//
//        this.getComponent(UserComponent.class).inject(this);
//        presenter.setView(this);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    void initData() {
        mAdapter.setType(CustomAdapter.TYPE_LIST_CATEGORY);
//        mAdapter = new CustomAdapter<Category>();
//        mRecyclerView.setAdapter(mAdapter);
//        String id = "18f7b229-692b-4c53-b8e7-812149b82c40";
//        presenter.getListCategory(id);
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
