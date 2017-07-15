package com.example.oa.orderapp.presenter.view;

import com.example.oa.orderapp.data.local.Category;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/10/17.
 */

public interface ListCategoryView {
    void showListCategory(RealmList<Category> items);
}
