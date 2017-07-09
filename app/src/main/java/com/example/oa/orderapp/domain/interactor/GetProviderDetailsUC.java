package com.example.oa.orderapp.domain.interactor;

import com.example.oa.orderapp.data.cache.ListMenuCache;
import com.example.oa.orderapp.data.cache.ListProviderCache;
import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.data.remote.RestApi;
import com.example.oa.orderapp.domain.executor.PostExecutionThread;
import com.example.oa.orderapp.domain.executor.ThreadExecutor;

import javax.inject.Inject;

import dagger.internal.Preconditions;
import io.reactivex.Observable;

/**
 * Created by Phoenix on 6/28/17.
 */

public class GetProviderDetailsUC extends UseCase<Provider, GetProviderDetailsUC.Param>{

    private final RestApi restApi;

    @Inject
    GetProviderDetailsUC(ThreadExecutor threadExecutor,
                         PostExecutionThread postExecutionThread,
                         RestApi restApi) {
        super(threadExecutor, postExecutionThread);
        this.restApi = restApi;
    }

    @Override
    Observable<Provider> buildUseCaseObservable(GetProviderDetailsUC.Param param) {
        Preconditions.checkNotNull(param);
        return restApi.getProvider(param.uid);
    }

    public static class Param {
        private final String uid;

        public Param(String uid) {
            this.uid = uid;
        }
    }
}
