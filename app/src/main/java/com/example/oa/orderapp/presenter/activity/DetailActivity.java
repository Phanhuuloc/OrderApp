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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends BaseActivity {

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

    public static void start(Context context) {
        Intent i = new Intent(context, DetailActivity.class);
        context.startActivity(i);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    @OnClick({R.id.btn_navigate, R.id.btn_pre_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_navigate:
                break;
            case R.id.btn_pre_order:
                OrderActivity.start(this);
                break;
        }
    }
}
