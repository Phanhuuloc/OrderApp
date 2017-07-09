package com.example.oa.orderapp.presenter.view;

import com.example.oa.orderapp.data.local.Provider;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/9/17.
 */

public interface ProviderDetailView {
    void renderNetData(Provider items);
}
