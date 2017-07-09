package com.example.oa.orderapp.presenter.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.data.local.Provider;
import com.example.oa.orderapp.presenter.ProviderPresenter;
import com.example.oa.orderapp.presenter.adapter.ProviderItemAdapter;
import com.example.oa.orderapp.presenter.di.components.UserComponent;
import com.example.oa.orderapp.presenter.view.ListProviderView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.realm.RealmList;

public class CategoryFragment extends BaseFragment implements ListProviderView{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    Unbinder unbinder;

    @Inject
    ProviderPresenter presenter;
    private ProviderItemAdapter adapter;

    public CategoryFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getComponent(UserComponent.class).inject(this);
        presenter.setView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        unbinder = ButterKnife.bind(this, view);
        initialize();
        return view;
    }

    private void initialize() {
        initializeRecyclerView();
        initData();
    }

    private void initData() {
        presenter.getListProvider();
    }

    private void initializeRecyclerView() {
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        adapter = new ProviderItemAdapter(getActivity());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void renderNetData(RealmList<Provider> items) {
        adapter.setItems(items);
    }
}
