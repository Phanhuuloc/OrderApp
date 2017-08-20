package com.example.oa.orderapp.presenter;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.request.BillRequest;
import com.example.oa.orderapp.domain.interactor.BillRequestPresenterUC;
import com.example.oa.orderapp.domain.interactor.DefaultObserver;
import com.example.oa.orderapp.domain.interactor.GetListCategoryListUC;
import com.example.oa.orderapp.presenter.view.BillRequestView;
import com.example.oa.orderapp.presenter.view.ListCategoryView;

/**
 * Created by Phoenix on 8/20/17.
 */

public class BillRequestPresenter {
    private final BillRequestPresenterUC billRequestPresenterUC;
    private BillRequestView view;

    public BillRequestPresenter(BillRequestPresenterUC billRequestPresenterUC) {
        this.billRequestPresenterUC = billRequestPresenterUC;
    }

    public void sendBillReq(BillRequest billRequest) {
        billRequestPresenterUC.execute(new BillRequestObserver(),new BillRequestPresenterUC.Param(billRequest));
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
