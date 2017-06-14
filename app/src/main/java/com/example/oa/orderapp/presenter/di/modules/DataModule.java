package com.example.oa.orderapp.presenter.di.modules;

import android.content.SharedPreferences;

import com.example.oa.orderapp.AndroidApplication;
import com.example.oa.orderapp.common.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;

/**
 * Created by Phoenix on 6/14/17.
 */

@Module
public class DataModule implements AppConstants {
    public DataModule() {
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs(AndroidApplication app) {
        return app.getSharedPreferences(QUARK_SHARE_PREFERENCE, 0);
    }

    @Provides
    @Singleton
    SharedPreferences.Editor provideSharedPrefsEditor(SharedPreferences sharePref) {
        return sharePref.edit();
    }

    @Provides
    Realm provideRealm() {
        return Realm.getDefaultInstance();
    }

}
