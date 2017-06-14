package com.example.oa.orderapp.data.remote;

import com.example.oa.orderapp.data.local.Result;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import javax.inject.Inject;



/**
 * Created by Phoenix on 6/14/17.
 */

class EntityJsonMapper {
    private final Gson gson;

    @Inject
    public EntityJsonMapper(Gson gson) {
        this.gson = gson;
    }

    public Result transformResult(String response) throws JsonSyntaxException {
        final Type resultType = new TypeToken<Result>() {
        }.getType();
        return this.gson.fromJson(response, resultType);
    }

}
