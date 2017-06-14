package com.example.oa.orderapp.presenter.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;

import com.example.oa.orderapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomeActivity extends BaseActivity {


    @BindView(R.id.wcLogo)
    ImageView wcLogo;
    @BindView(R.id.wcSearchview)
    SearchView wcSearchview;
    @BindView(R.id.wcButton1)
    Button wcButton1;
    @BindView(R.id.wcButton2)
    Button wcButton2;
    @BindView(R.id.wcButton3)
    Button wcButton3;
    @BindView(R.id.wcButton4)
    Button wcButton4;
    @BindView(R.id.wcButton5)
    Button wcButton5;
    @BindView(R.id.wcButton6)
    Button wcButton6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        ButterKnife.bind(this);

    }

    private void onServicesClick() {
        ProviderActivity.start(this);
    }

    @OnClick({R.id.wcButton1, R.id.wcButton2, R.id.wcButton3, R.id.wcButton4, R.id.wcButton5, R.id.wcButton6})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.wcButton1:
                onServicesClick();
                break;
            case R.id.wcButton2:
                onServicesClick();
                break;
            case R.id.wcButton3:
                onServicesClick();
                break;
            case R.id.wcButton4:
                onServicesClick();
                break;
            case R.id.wcButton5:
                onServicesClick();
                break;
            case R.id.wcButton6:
                onServicesClick();
                break;
        }
    }
}
