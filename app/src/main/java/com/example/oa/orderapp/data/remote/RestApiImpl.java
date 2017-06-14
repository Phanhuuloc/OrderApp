package com.example.oa.orderapp.data.remote;

import javax.inject.Inject;

/**
 * Created by Phoenix on 6/14/17.
 */

public class RestApiImpl implements RestApi {
    private final RetrofitServices r;
    private final EntityJsonMapper jsonMapper;
    private final ApiConnection apiConnection;

    @Inject
    public RestApiImpl(RetrofitServices retrofitServices, EntityJsonMapper jsonMapper, ApiConnection apiConnection) {
        this.r = retrofitServices;
        this.jsonMapper = jsonMapper;
        this.apiConnection = apiConnection;
    }

}
