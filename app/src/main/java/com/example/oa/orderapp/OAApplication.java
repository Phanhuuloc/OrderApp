package com.example.oa.orderapp;

import android.app.Application;

import com.example.oa.orderapp.common.AppConstants;
import com.example.oa.orderapp.data.RealmSharedModule;
import com.example.oa.orderapp.presenter.di.components.ApplicationComponent;
import com.example.oa.orderapp.presenter.di.components.DaggerApplicationComponent;
import com.example.oa.orderapp.presenter.di.modules.ApplicationModule;
import com.example.oa.orderapp.presenter.di.modules.NetModule;
import com.facebook.stetho.Stetho;
import com.squareup.leakcanary.LeakCanary;
import com.uphyca.stetho_realm.RealmInspectorModulesProvider;

import java.util.Locale;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Android Main Application
 */
public class OAApplication extends Application implements AppConstants {

    public static OAApplication instance = null;
    public static String LANGUAGE_DEVICE = "";
    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (instance == null) {
            instance = this;
        }
        LANGUAGE_DEVICE = Locale.getDefault().getLanguage();
        initializeRealmDb();
        initializeStetho();
        initializeInjector();

    }

    private void initializeStetho() {
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build());
    }

    private void initializeRealmDb() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .modules(Realm.getDefaultModule(), new RealmSharedModule())
                .schemaVersion(DB_VERSION)
                .deleteRealmIfMigrationNeeded()
//                .migration(new Migration())
//                .rxFactory(new QuarkRxFactory())
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        Realm realm = Realm.getInstance(realmConfiguration);
//        InitRealmDB(realm);
//        initRealmDB.initDB();
//        if (realm != null) {
//            realm.close();
//        }
    }


    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .netModule(new NetModule("http://192.168.1.10:8040/"))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }
}
