package com.example.oa.orderapp.presenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.presenter.di.HasComponent;
import com.example.oa.orderapp.presenter.di.components.UserComponent;
import com.example.oa.orderapp.presenter.fragment.ListCategoryFragment;
import com.example.oa.orderapp.presenter.fragment.ListItemFragment;
import com.example.oa.orderapp.presenter.fragment.RecyclerViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.oa.orderapp.presenter.fragment.RecyclerViewFragment.KEY_LAYOUT_MANAGER;
import static com.example.oa.orderapp.presenter.fragment.RecyclerViewFragment.TYPE_HORIZONTAL_LIST;
import static com.example.oa.orderapp.presenter.fragment.RecyclerViewFragment.TYPE_VERTICAL_LIST;

/**
 * Created by Phoenix on 7/10/17.
 */

public class MenuActivity extends BaseActivity implements HasComponent<UserComponent> {

    @BindView(R.id.list_item_fragment)
    FrameLayout sampleContentFragment;
    @BindView(R.id.list_category_fragment)
    FrameLayout categoryContentFragment;
    @BindView(R.id.sample_main_layout)
    RelativeLayout sampleMainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initializeComponent();

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            Bundle b1 = new Bundle();
            b1.putInt(KEY_LAYOUT_MANAGER, TYPE_VERTICAL_LIST);
            RecyclerViewFragment fragment1 = new ListItemFragment();
            fragment1.setArguments(b1);
            transaction.replace(R.id.list_item_fragment, fragment1);

            Bundle b2 = new Bundle();
            b2.putInt(KEY_LAYOUT_MANAGER, TYPE_HORIZONTAL_LIST);
            RecyclerViewFragment fragment2 = new ListCategoryFragment();
            fragment2.setArguments(b2);
            transaction.replace(R.id.list_category_fragment, fragment2);

            transaction.commit();
        }
        initialize();
    }

    private void initialize() {

    }

    @Override
    public UserComponent getComponent() {
        return component;
    }

    public static void start(BaseActivity activity) {
        Intent i = new Intent(activity,MenuActivity.class);
        activity.startActivity(i);
    }
}
