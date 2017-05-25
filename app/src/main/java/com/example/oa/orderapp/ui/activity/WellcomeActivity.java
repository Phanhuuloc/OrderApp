package com.example.oa.orderapp.ui.activity;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.oa.orderapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WellcomeActivity extends BaseActivity {


    @BindView(R.id.wcLogo)
    ImageView wcLogo;
    @BindView(R.id.wcSearchview)
    SearchView wcSearchview;
    @BindView(R.id.gridview)
    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        ButterKnife.bind(this);

        initialize();
    }

    private void initialize() {

    }
}
