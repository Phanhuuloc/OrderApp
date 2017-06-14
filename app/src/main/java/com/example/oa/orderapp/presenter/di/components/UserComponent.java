package com.example.oa.orderapp.presenter.di.components;


import com.example.oa.orderapp.presenter.di.PerActivity;
import com.example.oa.orderapp.presenter.di.modules.ActivityModule;
import com.example.oa.orderapp.presenter.di.modules.UserModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, UserModule.class})
public interface UserComponent extends ActivityComponent {
//  void inject(UserListFragment userListFragment);
//  void inject(UserDetailsFragment userDetailsFragment);
}
