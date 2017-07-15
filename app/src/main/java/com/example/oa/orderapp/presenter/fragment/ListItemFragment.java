package com.example.oa.orderapp.presenter.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.orderapp.data.local.Menu;
import com.example.oa.orderapp.presenter.ListMenuPresenter;
import com.example.oa.orderapp.presenter.adapter.CustomAdapter;
import com.example.oa.orderapp.presenter.view.ListMenuView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/10/17.
 */

public class ListItemFragment extends RecyclerViewFragment<Menu> implements ListMenuView{
    @Inject
    ListMenuPresenter presenter;

    public ListItemFragment() {
        mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        // Initialize dataset, this data would usually come from a local content provider or
//        // remote server.
//        mCurrentLayoutManagerType = getArguments().getInt(KEY_LAYOUT_MANAGER);
//        this.getComponent(UserComponent.class).inject(this);
//        presenter.setView(this);
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void renderNetData(RealmList<Menu> items) {
//        mAdapter.setItems(items);
    }

    @Override
    void initData() {
        mAdapter.setType(CustomAdapter.TYPE_LIST_MON);
//        mAdapter = new CustomAdapter<Menu>();
//        mRecyclerView.setAdapter(mAdapter);
//        String id = "43b042c1-87c7-4ad9-b159-78cffe952990";
//        presenter.getListMenu(id);

        initDummyData();
    }

    private void initDummyData() {
        mDataset = new RealmList();
        for (int i = 0; i < 50; i++) {
            mDataset.add(new Menu("Hoa don so "+i));
        }

        mAdapter.setItems(mDataset);
    }
}
