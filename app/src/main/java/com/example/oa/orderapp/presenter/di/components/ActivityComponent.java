package com.example.oa.orderapp.presenter.di.components;

import android.app.Activity;


import com.example.oa.orderapp.presenter.di.PerActivity;
import com.example.oa.orderapp.presenter.di.modules.ActivityModule;

import dagger.Component;


@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
interface ActivityComponent {
  //Exposed to sub-graphs.
  Activity activity();
}
