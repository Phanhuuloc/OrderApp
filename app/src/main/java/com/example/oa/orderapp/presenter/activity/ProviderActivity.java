package com.example.oa.orderapp.presenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.presenter.ProviderPresenter;
import com.example.oa.orderapp.presenter.adapter.CustomPagerAdapter;
import com.example.oa.orderapp.presenter.di.HasComponent;
import com.example.oa.orderapp.presenter.di.components.UserComponent;
import com.example.oa.orderapp.presenter.fragment.CategoryFragment;
import com.example.oa.orderapp.presenter.view.ListProviderView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;

public class ProviderActivity extends BaseActivity implements HasComponent<UserComponent> {

    public static final String ID = "id";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    android.support.design.widget.TabLayout tabs;

    private CustomPagerAdapter pagerAdapter;
    private int countTab = 3;

    public static void start(Context context) {
        Intent i = new Intent(context, ProviderActivity.class);
        context.startActivity(i);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        initializeComponent();
        initialize();
    }

    private void initialize() {
        initToolBar();
        initViewpager();
        initData();
    }

    private void initData() {

    }

    private void initViewpager() {
        pagerAdapter = new CustomPagerAdapter(this, getSupportFragmentManager());
        tabs.setupWithViewPager(viewPager);

        if (viewPager != null) {
            setupViewPager();
        }
        viewPager.setOffscreenPageLimit(countTab);
        tabs.setupWithViewPager(viewPager);
        setupTabTitle();
    }

    private void setupTabTitle() {

    }

    private void setupViewPager() {
        for (int i=0;i<countTab;i++) {

            Bundle bundle = new Bundle();
//            bundle.putString(GalleryFragment.FILE, value);
            Fragment fragment = Fragment.instantiate(this, CategoryFragment.class.getName(), bundle);
            pagerAdapter.addFragment(fragment);
        }
        viewPager.setAdapter(pagerAdapter);
    }

    private void initToolBar() {
        // Sets the Toolbar to act as the ActionBar for this Activity window.
        // Make sure the toolbar exists in the activity and is not null
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setTitle(R.string.app_menu_title);
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public UserComponent getComponent() {
        return component;
    }
}
