package com.example.oa.orderapp.presenter.di.components;


import com.example.oa.orderapp.presenter.activity.MenuActivity;
import com.example.oa.orderapp.presenter.activity.ProviderDetailActivity;
import com.example.oa.orderapp.presenter.di.modules.AppModule;
import com.example.oa.orderapp.presenter.di.modules.DataModule;
import com.example.oa.orderapp.presenter.di.modules.NetModule;
import com.example.oa.orderapp.presenter.fragment.CategoryFragment;
import com.example.oa.orderapp.presenter.fragment.ListCategoryFragment;
import com.example.oa.orderapp.presenter.fragment.ListItemFragment;

import javax.inject.Singleton;

import dagger.Component;


@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {AppModule.class, NetModule.class, DataModule.class})
public interface UserComponent {

//    Context context();
//
//    Activity activity();
//
//    ThreadExecutor threadExecutor();
//
//    PostExecutionThread postExecutionThread();
//
//    Cache cache();
//
//    Retrofit retrofit();
//
//    RetrofitServices retrofitServices();
//
//    Gson gson();
//
//    OkHttpClient okHttpClient();
//
//    Realm realm();
//
//    SharedPreferences sharePref();
//
//    SharedPreferences.Editor editor();
//
//    RestApi restapi();

    void inject(CategoryFragment providerActivity);

    void inject(ProviderDetailActivity detailActivity);

    void inject(ListItemFragment listItemFragment);

    void inject(ListCategoryFragment listCategoryFragment);

    void inject(MenuActivity menuActivity);

}
