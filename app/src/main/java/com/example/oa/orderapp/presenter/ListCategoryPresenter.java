package com.example.oa.orderapp.presenter;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.local.Category;
import com.example.oa.orderapp.domain.interactor.DefaultObserver;
import com.example.oa.orderapp.domain.interactor.GetCategoryListUC;
import com.example.oa.orderapp.presenter.view.ListCategoryView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 7/10/17.
 */

public class ListCategoryPresenter implements Presenter{
    private final GetCategoryListUC getCategoryListUC;
    private ListCategoryView view;

    @Inject
    public ListCategoryPresenter(GetCategoryListUC getCategoryListUC) {
        this.getCategoryListUC = getCategoryListUC;
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
        getCategoryListUC.execute(new ListCategoryObserver(),new GetCategoryListUC.Param(uid));
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
