package com.example.oa.orderapp.presenter.di.modules;

import com.example.oa.orderapp.OAApplication;
import com.example.oa.orderapp.common.Debug;
import com.example.oa.orderapp.data.remote.RestApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Dagger module that provides user related collaborators.
 */
@Module
public class NetModule {
    int CONNECTION_TIMEOUT = 10;
    int WRITE_TIMEOUT = 10;
    int READ_TIMEOUT = 30;

    String mBaseUrl;

    public NetModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }


    @Provides
    @Singleton
    Cache provideHttpCache(OAApplication application) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
//            .registerTypeAdapter(stringToken, RealmStringListTypeAdapter.INSTANCE)
//            .registerTypeAdapter(intToken, RealmIntListTypeAdapter.INSTANCE)
//            .registerTypeAdapter(accountToken, RealmAccountDeserialize.INSTANCE)
//            .registerTypeAdapter(brandToken, RealmBrandDeserialize.INSTANCE)
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setLenient()
                .create();

    }

    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
// set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

// add logging as last interceptor
        client.addInterceptor(logging);  // <-- this is the important line!
//    client.addInterceptor(new LoggingInterceptor.Builder()
//                    .loggable(BuildConfig.DEBUG)
//                    .setLevel(Level.BASIC)
//                    .log(Platform.INFO)
//                    .request("Request")
//                    .response("Response")
//                    .addHeader("version", BuildConfig.VERSION_NAME);
        client.cache(cache);
        client.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                // bug: HTTP FAILED: java.io.IOException: unexpected end of stream on okhttp3.Address
                // References : https://github.com/square/okhttp/issues/2738
                .retryOnConnectionFailure(true);
//            .addInterceptor(new LanguageParamInterceptor())
//            .addInterceptor(new NetworkStatusInterceptor(context))
//            .addInterceptor(new AutoLoginInterceptor(context));

        if (Debug.ENABLE) {
//      client.addNetworkInterceptor(new LoggingInterceptor().setLevel(LoggingInterceptor.Level.BODY))
//              .addNetworkInterceptor(new StethoInterceptor());
        }
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        client.cookieJar(new JavaNetCookieJar(cookieManager));

        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;

    }

    @Provides
    @Singleton
    RestApi provideRetrofitServices(Retrofit retrofit) {
        return retrofit.create(RestApi.class);
    }

}
