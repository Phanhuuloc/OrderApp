package com.example.oa.orderapp.domain.interactor;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.local.Value;
import com.example.oa.orderapp.data.remote.RestApi;
import com.example.oa.orderapp.data.request.BillRequest;
import com.example.oa.orderapp.domain.executor.PostExecutionThread;
import com.example.oa.orderapp.domain.executor.ThreadExecutor;
import com.google.gson.Gson;

import java.util.ArrayList;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;

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

        Gson gson = new Gson();
        String req = gson.toJson(param.request);
        return restApi.sendBillReq(param.providerId, param.request.getType(),param.request.getPrice());
//        RequestBody body =
//                RequestBody.create(MediaType.parse("application/json"), param.request.toString());
//        return restApi.sendBillReq(param.request);

    }

    public static class Param {
        private final String providerId;
        private final BillRequest request;

        public Param(String providerId, BillRequest request) {
            this.providerId = providerId;
            this.request = request;
        }
    }
}
