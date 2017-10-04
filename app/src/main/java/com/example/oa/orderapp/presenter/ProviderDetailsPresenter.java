package com.example.oa.orderapp.presenter;

import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.domain.interactor.DefaultObserver;
import com.example.oa.orderapp.domain.interactor.GetProviderDetailsUC;
import com.example.oa.orderapp.presenter.view.ProviderDetailView;

import javax.inject.Inject;

/**
 * Created by Phoenix on 6/27/17.
 */

public class ProviderDetailsPresenter implements Presenter {
    private final GetProviderDetailsUC getProviderDetailsUC;
    private ProviderDetailView view;

    @Inject
    public ProviderDetailsPresenter(GetProviderDetailsUC getProviderDetailsUC) {
        this.getProviderDetailsUC = getProviderDetailsUC;
    }

    public void setView(ProviderDetailView view) {
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

    public void getProviderDetail(String uid) {
        getProviderDetailsUC.execute(new ProviderObserver(),new GetProviderDetailsUC.Param(uid));
    }

    private class ProviderObserver extends DefaultObserver<Provider> {
        @Override
        public void onNext(Provider provider) {
            ProviderDetailsPresenter.this.showProviders(provider);
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

    private void showProviders(Provider items) {
        view.renderData(items);
    }
}
