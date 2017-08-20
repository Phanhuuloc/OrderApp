package com.example.oa.orderapp.presenter;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.local.Category;
import com.example.oa.orderapp.domain.interactor.DefaultObserver;
import com.example.oa.orderapp.domain.interactor.GetListCategoryListUC;
import com.example.oa.orderapp.presenter.view.ListCategoryView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/10/17.
 */

public class ListCategoryPresenter implements Presenter{
    private final GetListCategoryListUC getListCategoryListUC;
    private ListCategoryView view;

    @Inject
    public ListCategoryPresenter(GetListCategoryListUC getListCategoryListUC) {
        this.getListCategoryListUC = getListCategoryListUC;
    }

    public void setView(ListCategoryView view) {
        this.view = view;
    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void destroy() {

    }

    public void getListCategory(String uid) {
        getListCategoryListUC.execute(new ListCategoryObserver(),new GetListCategoryListUC.Param(uid));
    }

    private class ListCategoryObserver extends DefaultObserver<ListCategoryCache> {
        @Override
        public void onNext(ListCategoryCache listCategoryCache) {
            ListCategoryPresenter.this.showListCategory(listCategoryCache.getItems());
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError(Throwable exception) {
            super.onError(exception);
        }
    }

    private void showListCategory(RealmList<Category> items) {
        view.showListCategory(items);
    }
}