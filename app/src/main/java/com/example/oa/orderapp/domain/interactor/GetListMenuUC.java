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

public class GetListMenuUC extends UseCase<ListMenuCache, GetListMenuUC.Param> {
    private final RestApi restApi;

    @Inject
    GetListMenuUC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<ListMenuCache> buildUseCaseObservable(Param param) {
        Preconditions.checkNotNull(param);
        return restApi.getListMenu(param.name);
    }

    public static class Param {
        public final String name;

        public Param(String name) {
            this.name = name;
        }
    }
}
