package com.example.oa.orderapp.presenter.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.orderapp.OAApplication;
import com.example.oa.orderapp.data.local.Mon;
import com.example.oa.orderapp.presenter.ListMonPresenter;
import com.example.oa.orderapp.presenter.activity.ProviderActivity;
import com.example.oa.orderapp.presenter.adapter.CustomAdapter;
import com.example.oa.orderapp.presenter.view.ListMonView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/10/17.
 */
public class ListMonFragment extends RecyclerViewFragment<Mon> implements ListMonView {
    @Inject
    ListMonPresenter presenter;
    private String providerId;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            callback = (Callback<Mon>) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement Callback<Value>");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
        providerId = getArguments().getString(ProviderActivity.ID);
        OAApplication.userComponent.inject(this);
        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void renderNetData(RealmList<Mon> items) {
        mAdapter.setItems(items);
    }

    @Override
    void initData() {
        mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
        mAdapter.setCallback(callback);
        mAdapter.setType(CustomAdapter.TYPE_LIST_MON);
        presenter.getListMon("bf6fe58a-93da-4892-b5b8-86d24e23a44a");
    }


}
