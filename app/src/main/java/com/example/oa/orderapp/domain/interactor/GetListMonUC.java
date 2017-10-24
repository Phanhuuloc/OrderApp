package com.example.oa.orderapp.domain.interactor;

import com.example.oa.orderapp.data.cache.ListMenuCache;
import com.example.oa.orderapp.data.remote.RestApi;
import com.example.oa.orderapp.domain.executor.PostExecutionThread;
import com.example.oa.orderapp.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/28/17.
 */

public class GetListMonUC extends UseCase<ListMenuCache, GetListMonUC.Param> {
    private final RestApi restApi;

    @Inject
    GetListMonUC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<ListMenuCache> buildUseCaseObservable(Param param) {
        Preconditions.checkNotNull(param);
        return restApi.getListMon(param.cid);
    }

    public static class Param {
        public final String cid;

        public Param(String cid) {
            this.cid = cid;
        }
    }
}
