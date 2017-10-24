package com.example.oa.orderapp.domain.interactor;

import com.example.oa.orderapp.data.cache.ListCategoryCache;
import com.example.oa.orderapp.data.remote.RestApi;
import com.example.oa.orderapp.domain.executor.PostExecutionThread;
import com.example.oa.orderapp.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by Phoenix on 7/10/17.
 */

public class GetCategoryListUC extends UseCase<ListCategoryCache, GetCategoryListUC.Param> {
    private  final RestApi restApi;

    @Inject
    GetCategoryListUC(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread, RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<ListCategoryCache> buildUseCaseObservable(GetCategoryListUC.Param param) {
        Preconditions.checkNotNull(param);
        return restApi.getListCategory(param.uid);

    }

    public static class Param {
        private final String uid;

        public Param(String uid) {
            this.uid = uid;
        }
    }
}
