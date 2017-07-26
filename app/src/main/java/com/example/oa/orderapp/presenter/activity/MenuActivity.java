package com.example.oa.orderapp.presenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.local.Category;
import com.example.oa.orderapp.data.local.Value;
import com.example.oa.orderapp.presenter.adapter.CustomAdapter;
import com.example.oa.orderapp.presenter.di.HasComponent;
import com.example.oa.orderapp.presenter.di.components.UserComponent;
import com.example.oa.orderapp.presenter.fragment.ListCategoryFragment;
import com.example.oa.orderapp.presenter.fragment.ListItemFragment;
import com.example.oa.orderapp.presenter.fragment.RecyclerViewFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;

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

    CustomAdapter<Value> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        ButterKnife.bind(this);
        initializeComponent();
        initGUI();
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initGUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Get access to the custom title view
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        String id = getIntent().getStringExtra(ProviderActivity.ID);

        Bundle b1 = new Bundle();
        b1.putString(ProviderActivity.ID, id);
        RecyclerViewFragment fragment1 = new ListItemFragment();
        fragment1.setArguments(b1);
        transaction.replace(R.id.list_item_fragment, fragment1);

        Bundle b2 = new Bundle();
        b2.putString(ProviderActivity.ID, id);
        RecyclerViewFragment fragment2 = new ListCategoryFragment();
        fragment2.setArguments(b2);
        transaction.replace(R.id.list_category_fragment, fragment2);

        transaction.commit();
    }

    @Override
    public UserComponent getComponent() {
        return component;
    }

    public static void start(BaseActivity activity, String id) {
        Intent i = new Intent(activity, MenuActivity.class);
        i.putExtra(ProviderActivity.ID, id);
        activity.startActivity(i);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.miPurchase:
                showPurchaseList();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showPurchaseList() {
        adapter = new CustomAdapter<Value>();

        new MaterialDialog.Builder(this)
                .title(R.string.add_item_title)
                // second parameter is an optional layout manager. Must be a LinearLayoutManager or GridLayoutManager.
                .adapter(adapter, null)
                .show();

        initDummyData();
    }

    private void initDummyData() {
        RealmList mDataset = new RealmList();
        for (int i = 0; i < 50; i++) {
            mDataset.add(new Value("#"+i));
        }

        adapter.setItems(mDataset);

    }
}
