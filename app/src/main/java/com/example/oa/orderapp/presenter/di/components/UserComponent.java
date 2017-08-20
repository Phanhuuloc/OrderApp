package com.example.oa.orderapp.presenter.di.components;


import com.example.oa.orderapp.presenter.activity.BaseActivity;
import com.example.oa.orderapp.presenter.activity.MenuActivity;
import com.example.oa.orderapp.presenter.activity.ProviderDetailActivity;
import com.example.oa.orderapp.presenter.di.PerActivity;
import com.example.oa.orderapp.presenter.di.modules.ActivityModule;
import com.example.oa.orderapp.presenter.di.modules.AppModule;
import com.example.oa.orderapp.presenter.fragment.CategoryFragment;
import com.example.oa.orderapp.presenter.fragment.ListCategoryFragment;
import com.example.oa.orderapp.presenter.fragment.ListItemFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class,
        modules = {ActivityModule.class, AppModule.class})
public interface UserComponent extends ActivityComponent {
    void inject(CategoryFragment providerActivity);

    void inject(ProviderDetailActivity detailActivity);

    void inject(ListItemFragment listItemFragment);

    void inject(ListCategoryFragment listCategoryFragment);

    void inject(MenuActivity menuActivity);
//  void inject(UserListFragment userListFragment);
//  void inject(UserDetailsFragment userDetailsFragment);
}
