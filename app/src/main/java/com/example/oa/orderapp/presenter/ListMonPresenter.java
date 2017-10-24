package com.example.oa.orderapp.presenter;

import com.example.oa.orderapp.data.cache.ListMenuCache;
import com.example.oa.orderapp.data.local.Mon;
import com.example.oa.orderapp.domain.interactor.DefaultObserver;
import com.example.oa.orderapp.domain.interactor.GetListMonUC;
import com.example.oa.orderapp.presenter.view.ListMonView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/28/17.
 */

public class ListMonPresenter implements Presenter {
    private final GetListMonUC getListMonUC;
    private ListMonView monView;

    @Inject
    public ListMonPresenter(GetListMonUC getListMonUC) {
        this.getListMonUC = getListMonUC;
    }

    public void setView(ListMonView view) {
        this.monView = view;
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

    public void getListMon(String id) {
        getListMonUC.execute(new ListMenuObserver(),new GetListMonUC.Param(id));
    }

    private class ListMenuObserver extends DefaultObserver<ListMenuCache> {
        @Override
        public void onNext(ListMenuCache listMenuCache) {
            ListMonPresenter.this.showMenuList(listMenuCache.getItems());
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

    private void showMenuList(RealmList<Mon> items) {
        monView.renderNetData(items);
    }
}
