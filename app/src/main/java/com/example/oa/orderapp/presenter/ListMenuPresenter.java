package com.example.oa.orderapp.presenter;

import com.example.oa.orderapp.data.cache.ListMenuCache;
import com.example.oa.orderapp.data.local.Value;
import com.example.oa.orderapp.domain.interactor.DefaultObserver;
import com.example.oa.orderapp.domain.interactor.GetListMenuUC;
import com.example.oa.orderapp.presenter.view.ListMenuView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/28/17.
 */

public class ListMenuPresenter implements Presenter {
    private final GetListMenuUC getListMenuUC;
    private ListMenuView view;

    @Inject
    public ListMenuPresenter(GetListMenuUC getListMenuUC) {
        this.getListMenuUC = getListMenuUC;
    }

    public void setView(ListMenuView view) {
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

    public void getListMenu(String id) {
        getListMenuUC.execute(new ListMenuObserver(),new GetListMenuUC.Param(id));
    }

    private class ListMenuObserver extends DefaultObserver<ListMenuCache> {
        @Override
        public void onNext(ListMenuCache listMenuCache) {
            ListMenuPresenter.this.showMenuList(listMenuCache.getItems());
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

    private void showMenuList(RealmList<Value> items) {
        view.renderNetData(items);
    }
}
