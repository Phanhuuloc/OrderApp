package com.example.oa.orderapp.presenter.view;

import com.example.oa.orderapp.data.local.Provider;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/27/17.
 */

public interface ListProviderView {
    void renderNetData(RealmList<Provider> items);
}