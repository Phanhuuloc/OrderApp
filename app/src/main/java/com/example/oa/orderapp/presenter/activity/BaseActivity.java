package com.example.oa.orderapp.presenter.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.oa.orderapp.OAApplication;
import com.example.oa.orderapp.presenter.di.components.DaggerUserComponent;
import com.example.oa.orderapp.presenter.di.components.UserComponent;
import com.example.oa.orderapp.presenter.di.modules.ActivityModule;

/**
 * Created by Phoenix on 5/25/17.
 */

public abstract class BaseActivity extends AppCompatActivity {
    UserComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = OAApplication.userComponent;
    }

}
