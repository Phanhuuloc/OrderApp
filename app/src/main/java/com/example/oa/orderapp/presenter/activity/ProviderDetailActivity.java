package com.example.oa.orderapp.presenter.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.presenter.ProviderDetailsPresenter;
import com.example.oa.orderapp.presenter.view.ProviderDetailView;

import org.parceler.Parcels;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProviderDetailActivity extends BaseActivity implements ProviderDetailView {

    public static final String DATA = "provider_data";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.btn_navigate)
    Button btnNavigate;
    @BindView(R.id.btn_pre_order)
    Button btnPreOrder;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Inject
    ProviderDetailsPresenter presenter;
    Provider provider;

    public static void start(Context context, Bundle b) {
        Intent i = new Intent(context, ProviderDetailActivity.class);
        i.putExtras(b);
        context.startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initialize();

    }

    private void initialize() {
        initData();
        initializeComponent();
        initializeInjector();
    }

    private void initData() {
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            provider = Parcels.unwrap(bundle.getParcelable(DATA));
        }

        if (provider != null)
            renderNetData(provider);
    }

    private void initializeInjector() {
        component.inject(this);
        presenter.setView(this);
        presenter.getProviderDetail(provider.getUuid());
    }


    @OnClick({R.id.btn_navigate, R.id.btn_pre_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_navigate:
                break;
            case R.id.btn_pre_order:
                MenuActivity.start(this);
                break;
        }
    }

    @Override
    public void renderNetData(Provider item) {
        textView.setText(item.getName());
    }
}
