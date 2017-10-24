package com.example.oa.orderapp.domain.interactor;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.remote.RestApi;
import com.example.oa.orderapp.data.request.BillRequest;
import com.example.oa.orderapp.domain.executor.PostExecutionThread;
import com.example.oa.orderapp.domain.executor.ThreadExecutor;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by Phoenix on 8/20/17.
 */

public class BillRequestPresenterUC extends UseCase<ListCategoryCache, BillRequestPresenterUC.Param> {
    private final RestApi restApi;

    @Inject
    BillRequestPresenterUC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<ListCategoryCache> buildUseCaseObservable(Param param) {
        Preconditions.checkNotNull(param);
        return restApi.sendBillReq(param.request, param.pid);

    }

    public static class Param {
        private final String pid;
        private final BillRequest request;

        public Param(String pid, BillRequest request) {
            this.pid = pid;
            this.request = request;
        }
    }
}
