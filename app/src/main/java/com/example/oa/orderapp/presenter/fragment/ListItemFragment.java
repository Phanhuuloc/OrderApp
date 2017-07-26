package com.example.oa.orderapp.presenter.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.orderapp.data.local.Value;
import com.example.oa.orderapp.presenter.ListMenuPresenter;
import com.example.oa.orderapp.presenter.activity.ProviderActivity;
import com.example.oa.orderapp.presenter.adapter.CustomAdapter;
import com.example.oa.orderapp.presenter.di.components.UserComponent;
import com.example.oa.orderapp.presenter.view.ListMenuView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/10/17.
 */

public class ListItemFragment extends RecyclerViewFragment<Value> implements ListMenuView{
    @Inject
    ListMenuPresenter presenter;
    private String providerId;

    public ListItemFragment() {
        mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
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
    public void renderNetData(RealmList<Value> items) {
        mAdapter.setItems(items);
    }

    @Override
    void initData() {
        mAdapter.setType(CustomAdapter.TYPE_LIST_MON);
//        mAdapter = new CustomAdapter<Menu>();
//        mRecyclerView.setAdapter(mAdapter);
//        String id = "3818f7c2-f14b-4c97-b064-1cc85f1121c6";
        presenter.getListMenu(providerId);

        initDummyData();
    }

    private void initDummyData() {
        mDataset = new RealmList();
        for (int i = 0; i < 50; i++) {
            mDataset.add(new Value("Hoa don so "+i));
        }

        mAdapter.setItems(mDataset);
    }
}
