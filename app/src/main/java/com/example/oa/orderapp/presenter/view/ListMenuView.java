package com.example.oa.orderapp.presenter.view;

import com.example.oa.orderapp.data.local.Value;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/27/17.
 */

public interface ListMenuView {
    void renderNetData(RealmList<Value> items);
}
