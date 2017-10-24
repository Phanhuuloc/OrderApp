package com.example.oa.orderapp.presenter;

import com.example.oa.orderapp.data.request.BillRequest;
import com.example.oa.orderapp.domain.interactor.BillRequestPresenterUC;
import com.example.oa.orderapp.domain.interactor.DefaultObserver;
import com.example.oa.orderapp.presenter.view.BillRequestView;

import javax.inject.Inject;

/**
 * Created by Phoenix on 8/20/17.
 */

public class BillRequestPresenter {
    private final BillRequestPresenterUC billRequestPresenterUC;
    private BillRequestView view;

    @Inject
    public BillRequestPresenter(BillRequestPresenterUC billRequestPresenterUC) {
        this.billRequestPresenterUC = billRequestPresenterUC;
    }

    public void sendBillReq(String providerId, BillRequest billRequest) {
        billRequestPresenterUC.execute(new BillRequestObserver(),new BillRequestPresenterUC.Param(billRequest));
    }

    public void setView(BillRequestView view) {
        this.view = view;
    }

    private class BillRequestObserver extends DefaultObserver {

        @Override
        public void onNext(Object o) {
            view.notifyView();
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
}
