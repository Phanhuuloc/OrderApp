package com.example.oa.orderapp.presenter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.local.Category;
import com.example.oa.orderapp.data.local.Value;
import com.example.oa.orderapp.data.request.BillRequest;
import com.example.oa.orderapp.presenter.BillRequestPresenter;
import com.example.oa.orderapp.presenter.adapter.CustomAdapter;
import com.example.oa.orderapp.presenter.di.HasComponent;
import com.example.oa.orderapp.presenter.di.components.UserComponent;
import com.example.oa.orderapp.presenter.fragment.ListCategoryFragment;
import com.example.oa.orderapp.presenter.fragment.ListItemFragment;
import com.example.oa.orderapp.presenter.fragment.RecyclerViewFragment;
import com.example.oa.orderapp.presenter.view.BillRequestView;
import com.example.oa.orderapp.presenter.view.CustomBadgeShape;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import berlin.volders.badger.BadgeShape;
import berlin.volders.badger.Badger;
import berlin.volders.badger.CountBadge;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmList;
import io.realm.RealmModel;

import static com.example.oa.orderapp.presenter.adapter.CustomAdapter.TYPE_LIST_PURCHASE;

/**
 * Created by Phoenix on 7/10/17.
 */

public class MenuActivity extends BaseActivity implements HasComponent<UserComponent>,
        RecyclerViewFragment.Callback, BillRequestView {

    @BindView(R.id.list_item_fragment)
    FrameLayout sampleContentFragment;
    @BindView(R.id.list_category_fragment)
    FrameLayout categoryContentFragment;
    @BindView(R.id.sample_main_layout)
    RelativeLayout sampleMainLayout;

    CustomAdapter<Value> adapter;

    List purchaseList = new ArrayList();

    CountBadge.Factory ovalFactory;
    CountBadge.Factory squareFactory;
    CountBadge.Factory circleFactory;
    private CountBadge badgeDrawable;

    @Inject
    BillRequestPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_list);
        ButterKnife.bind(this);
        initialize();
    }

    private void initialize() {
        initializeComponent();
        component.inject(this);
        presenter.setView(this);
        initGUI();
        initBadge();
    }

    private void initBadge() {
        ovalFactory = new CountBadge.Factory(this, BadgeShape.oval(1f, 2f, Gravity.BOTTOM));
        squareFactory = new CountBadge.Factory(this, BadgeShape.square(1f, Gravity.NO_GRAVITY, .5f));
        circleFactory = new CountBadge.Factory(new CustomBadgeShape(this, .5f, Gravity.END | Gravity.TOP),
                getResources().getColor(R.color.orange),getResources().getColor(R.color.green));
    }

    // Menu icons are inflated just as they were with actionbar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        badgeDrawable = Badger.sett(menu.findItem(R.id.miPurchase), circleFactory);

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
        mTitle.setText("Menu");


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
        if(purchaseList.isEmpty()) return;
        adapter = new CustomAdapter<Value>();
        adapter.setType(TYPE_LIST_PURCHASE);

        new MaterialDialog.Builder(this)
                .title(R.string.add_item_title)
                // second parameter is an optional layout manager. Must be a LinearLayoutManager or GridLayoutManager.
                .adapter(adapter, null)
                .positiveText(R.string.accept)
                .positiveFocus(true)
                .onPositive((dialog, which) -> {
                    BillRequest billRequest = BillRequest.from(purchaseList);
                    presenter.sendBillReq(billRequest);
                })
                .show();

        adapter.setItems(purchaseList);
    }

    @Override
    public void onMenuItemClick(Object item, boolean isSelected) {
        if (isSelected) {
            selectItem(item);
        } else {
            unSelectItem(item);
        }

        badgeDrawable.setCount(purchaseList.size());
    }

    private void unSelectItem(Object item) {
        if (item instanceof Value) {
            RealmModel value = (RealmModel) item;
            purchaseList.add(value);
        } else if (item instanceof Category) {

        }
    }

    private void selectItem(Object item) {
        if (item instanceof Value) {
            RealmModel value = (RealmModel) item;
            purchaseList.remove(value);
        } else if (item instanceof Category) {

        }
    }

    @Override
    public void notifyView() {

    }
}
