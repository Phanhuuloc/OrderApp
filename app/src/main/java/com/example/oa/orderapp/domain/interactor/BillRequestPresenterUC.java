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

        String request=new Gson().toJson(param.request);

        //Here the json data is add to a hash map with key data
        Map<String,String> params = new HashMap();
        params.put("data", request);
        return restApi.sendBillReq(/*"application/json; charset=utf-8",*/ param.request);
//        RequestBody body =
//                RequestBody.create(MediaType.parse("application/json"), param.request.toString());
//        return restApi.sendBillReq(param.request);
//        HttpHeaders requestHeaders = new HttpHeaders();
//        requestHeaders.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//
//        // Create a new RestTemplate instance
//        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());

//        String url = "192.168.1.8:8800/bill";
//        try {
//            // Make the network request
//            Log.d(TAG, url);
//            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,
//                    new HttpEntity<>(requestHeaders), String.class);
//            return Observable.just(response);
//        } catch (HttpClientErrorException e) {
//            Log.e(TAG, e.getLocalizedMessage(), e);
//            return new Message(0, e.getStatusText(), e.getLocalizedMessage());
//        } catch (ResourceAccessException e) {
//            Log.e(TAG, e.getLocalizedMessage(), e);
//            return new Message(0, e.getClass().getSimpleName(), e.getLocalizedMessage());
//        }
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
