package com.example.oa.orderapp.presenter.fragment;

import android.support.v4.app.Fragment;

import com.example.oa.orderapp.presenter.di.HasComponent;

/**
 * Created by Phoenix on 5/25/17.
 */

public abstract class BaseFragment extends Fragment {

    /**
     * Gets a component for dependency injection by its type.
     */
    @SuppressWarnings("unchecked")
    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
