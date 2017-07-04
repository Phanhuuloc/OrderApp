package com.example.oa.orderapp.domain.interactor;

import com.example.oa.orderapp.data.cache.ListProviderCache;
import com.example.oa.orderapp.data.remote.RestApi;
import com.example.oa.orderapp.domain.executor.PostExecutionThread;
import com.example.oa.orderapp.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/28/17.
 */

public class GetProviderListUC extends UseCase<ListProviderCache, Void>{

    private final RestApi restApi;

    @Inject
    GetProviderListUC(ThreadExecutor threadExecutor,
                      PostExecutionThread postExecutionThread,
                      RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<ListProviderCache> buildUseCaseObservable(Void aVoid) {
        return restApi.getListProvider();
    }
}
