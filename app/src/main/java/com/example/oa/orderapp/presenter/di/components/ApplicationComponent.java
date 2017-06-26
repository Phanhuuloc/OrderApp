package com.example.oa.orderapp.presenter.di.components;

import android.content.Context;
import android.content.SharedPreferences;


import com.example.oa.orderapp.data.remote.RetrofitServices;
import com.example.oa.orderapp.domain.executor.PostExecutionThread;
import com.example.oa.orderapp.domain.executor.ThreadExecutor;
import com.example.oa.orderapp.presenter.activity.BaseActivity;
import com.example.oa.orderapp.presenter.di.modules.ApplicationModule;
import com.example.oa.orderapp.presenter.di.modules.DataModule;
import com.example.oa.orderapp.presenter.di.modules.NetModule;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;
import io.realm.Realm;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class, NetModule.class, DataModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity baseActivity);

    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    Cache cache();

    Retrofit retrofit();

    RetrofitServices retrofitServices();

    Gson gson();

    OkHttpClient okHttpClient();

    Realm realm();

    SharedPreferences sharePref();

    SharedPreferences.Editor editor();

}
