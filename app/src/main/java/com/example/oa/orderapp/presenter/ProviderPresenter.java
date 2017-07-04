package com.example.oa.orderapp.presenter;

import com.example.oa.orderapp.data.cache.ListProviderCache;
import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.domain.interactor.DefaultObserver;
import com.example.oa.orderapp.domain.interactor.GetProviderListUC;
import com.example.oa.orderapp.presenter.view.ListProviderView;

import javax.inject.Inject;

import io.realm.RealmList;

/**
 * Created by Phoenix on 6/27/17.
 */

public class ProviderPresenter implements Presenter{
    private final GetProviderListUC getProviderListUC;
    private ListProviderView view;

    @Inject
    public ProviderPresenter(GetProviderListUC getProviderListUC) {
        this.getProviderListUC = getProviderListUC;
    }

    public void setView(ListProviderView view) {
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

    public void getListProvider() {
        getProviderListUC.execute(new ListProviderObserver(),null);
    }

    private class ListProviderObserver extends DefaultObserver<ListProviderCache> {
        @Override
        public void onNext(ListProviderCache listProviderCache) {
            ProviderPresenter.this.showProviders(listProviderCache.getItems());
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

    private void showProviders(RealmList<Provider> items) {
        view.renderNetData(items);
    }
}
